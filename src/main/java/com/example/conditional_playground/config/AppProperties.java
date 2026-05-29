package com.example.conditional_playground.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "myapp")
public class AppProperties {

    private String appName = "MyApplication";
    private String version = "1.0.0";
    private Integer maxUsers = 100;

    private Jwt jwt = new Jwt();        // ← declared as field
    private Audit audit = new Audit();  // ← declared as field

    // getters and setters for appName, version, maxUsers

    public Jwt getJwt() { return jwt; }
    public void setJwt(Jwt jwt) { this.jwt = jwt; }

    public Audit getAudit() { return audit; }
    public void setAudit(Audit audit) { this.audit = audit; }

    static class Jwt{

        public String secret = "Set Hard Things";
        public Long expiry = 860000L;
        private List<String> publicEndpoints = List.of(
                "/api/auth/**",
                "/v3/api-docs/**",
                "/swagger-ui/**"
        );

        public List<String> getPublicEndpoints() { return publicEndpoints; }
        public void setPublicEndpoints(List<String> publicEndpoints) {
            this.publicEndpoints = publicEndpoints;
        }
        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public Long getExpiry() {
            return expiry;
        }

        public void setExpiry(Long expiry) {
            this.expiry = expiry;
        }

    }

    static class Audit {
        public boolean enabled = true;
        public String table = "audit_log";

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getTable() {
            return table;
        }

        public void setTable(String table) {
            this.table = table;
        }


    }

}
