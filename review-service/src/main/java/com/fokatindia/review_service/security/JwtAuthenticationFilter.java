package com.fokatindia.review_service.security;



import com.fokatindia.review_service.service.PermissionClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter implements WebFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final PermissionClient permissionClient;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return chain.filter(exchange);
        }

        String token = authHeader.substring(7);

        if (!jwtTokenProvider.validateToken(token)) {
            return chain.filter(exchange);
        }

        Long userId = jwtTokenProvider.getUserId(token);
        String mobile = jwtTokenProvider.getMobileNumber(token);

        return permissionClient.getPermissions(userId)
                .defaultIfEmpty(List.of("ROLE_USER"))
                .flatMap(permissions -> {

                    List<SimpleGrantedAuthority> authorities =
                            permissions.stream()
                                    .map(SimpleGrantedAuthority::new)
                                    .toList();

                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(
                                    mobile,
                                    null,
                                    authorities
                            );

                    return chain.filter(exchange)
                            .contextWrite(
                                    ReactiveSecurityContextHolder.withAuthentication(auth)
                            );
                });
    }
}