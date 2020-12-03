package com.example.bookshelf.service;

import com.example.bookshelf.domain.app.Tenant;
import com.example.bookshelf.domain.app.User;
import com.example.bookshelf.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    private final DataSource dataSource;

    @Override
    @Transactional
    public void initEnvironment(User user) {
        Tenant tenant = new Tenant();
        tenant.setName(user.getUsername());
        tenant.setSchema(user.getUsername());
        tenantRepository.saveAndFlush(tenant);

        Flyway flyway = Flyway.configure()
                .locations("db/migration/tenants")
                .dataSource(dataSource)
                .schemas(tenant.getSchema())
                .load();

        flyway.migrate();
    }
}
