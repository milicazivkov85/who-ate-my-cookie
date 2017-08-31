package de.codecentric.eater.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Configuration
    public class DataSourcesConfiguration {

        @Bean
        @Primary
        @ConfigurationProperties(prefix = "spring.datasource")
        public DataSource sweetsDataSource() {
            return new org.apache.tomcat.jdbc.pool.DataSource();
        }

        @Bean
        @ConfigurationProperties(prefix = "auth.datasource")
        public DataSource authDataSource() {
            return new org.apache.tomcat.jdbc.pool.DataSource();
        }
    }

    @Autowired
    @Qualifier(value = "authDataSource")
    private DataSource authDataSource;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("cookie-eater-rest")
                .tokenStore(tokenStore());
    }

    public TokenStore tokenStore() {
        return new JdbcTokenStore(authDataSource);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").anonymous()
                .anyRequest().authenticated();
    }

}
