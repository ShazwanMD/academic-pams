package my.edu.umk.pams.academic.config;

import my.edu.umk.pams.academic.security.integration.AdAclPermissionEvaluator;
import my.edu.umk.pams.academic.security.integration.AdMutableAclService;
import my.edu.umk.pams.academic.security.integration.AdPermissionFactory;
import my.edu.umk.pams.academic.security.integration.AdSidRetrievalStrategy;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.security.acls.domain.*;
import org.springframework.security.acls.jdbc.BasicLookupStrategy;
import org.springframework.security.acls.jdbc.LookupStrategy;
import org.springframework.security.acls.model.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.sql.DataSource;

/**
 * @author canang technologies
 * @since 1/13/14
 */
@TestConfiguration
public class TestAccessConfig {

    @Bean
    public MutableAclService mutableAclService(DataSource dataSource, LookupStrategy lookupStrategy, AclCache cache) {
        return new AdMutableAclService(dataSource, lookupStrategy, cache);
    }

    @Bean
    public AclCache aclCache(Cache cache, PermissionGrantingStrategy permissionStrategy, AclAuthorizationStrategy authorizationStrategy) {
        return new SpringCacheBasedAclCache(cache, permissionStrategy, authorizationStrategy);
    }

    @Bean
    public AdAclPermissionEvaluator permissionEvaluator(AclService aclService, AdSidRetrievalStrategy sidRetrievalStrategy) {
        return new AdAclPermissionEvaluator(aclService, sidRetrievalStrategy);
    }

    @Bean
    public Cache cache(CacheManager cacheManager) {
        return cacheManager.getCache("aces");
    }

    @Bean
    public PermissionFactory permissionFactory() {
        return new AdPermissionFactory();
    }

    @Bean
    public LookupStrategy lookupStrategy(DataSource dataSource, AclCache aclCache, AclAuthorizationStrategy authorizationStrategy, PermissionGrantingStrategy permissionGrantingStrategy) {
        BasicLookupStrategy basicLookupStrategy = new BasicLookupStrategy(dataSource, aclCache, authorizationStrategy, permissionGrantingStrategy);
        basicLookupStrategy.setPermissionFactory(permissionFactory());
        return basicLookupStrategy;

    }

    @Bean
    public PermissionGrantingStrategy permissionGrantingStrategy() {
        return new DefaultPermissionGrantingStrategy(new ConsoleAuditLogger());
    }

    @Bean
    public AclAuthorizationStrategy aclAuthorizationStrategy(SidRetrievalStrategy sidRetrievalStrategy) {
        AclAuthorizationStrategyImpl aclAuthorizationStrategy = new AclAuthorizationStrategyImpl(
                new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"),
                new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"),
                new SimpleGrantedAuthority("ROLE_ADMINISTRATOR")
        );
        aclAuthorizationStrategy.setSidRetrievalStrategy(sidRetrievalStrategy);
        return aclAuthorizationStrategy;
    }

    @Bean
    public AdSidRetrievalStrategy sidRetrievalStrategy() {
        return new AdSidRetrievalStrategy();
    }
}
