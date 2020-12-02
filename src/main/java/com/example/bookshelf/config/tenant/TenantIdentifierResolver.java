package com.example.bookshelf.config.tenant;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    @Value("${multitenant.system.schema:app}")
    private String systemSchema;

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = TenantContext.getCurrent();
        if (tenant != null) {
            return tenant;
        }

        return systemSchema;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
