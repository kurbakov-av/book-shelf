package com.example.bookshelf.config.tenant;

import com.example.bookshelf.repository.TenantRepository;
import com.example.bookshelf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class TenantInterceptor extends HandlerInterceptorAdapter {

    private final UserService userService;

    private final TenantRepository tenantRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = userService.getCurrentUser().getUsername();
        tenantRepository.findByName(username)
                .ifPresent(tenant -> TenantContext.setTenant(tenant.getSchema()));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        TenantContext.clear();
    }
}
