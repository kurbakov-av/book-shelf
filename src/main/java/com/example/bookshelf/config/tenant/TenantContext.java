package com.example.bookshelf.config.tenant;

public class TenantContext {

    private static final ThreadLocal<String> CURRENT = new ThreadLocal<>();

    public static void setTenant(String tenant) {
        CURRENT.set(tenant);
    }

    public static String getCurrent() {
        return CURRENT.get();
    }

    public static void clear() {
        CURRENT.remove();
    }
}
