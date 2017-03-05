package my.edu.umk.pams.academic.security.integration;

import my.edu.umk.pams.academic.identity.dao.AdGroupDao;
import my.edu.umk.pams.academic.identity.dao.AdUserDao;
import my.edu.umk.pams.academic.identity.model.AdGroup;
import my.edu.umk.pams.academic.identity.model.AdPrincipalRole;
import my.edu.umk.pams.academic.identity.model.AdUser;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/30/14
 */
@Service("userDetailService")
@Transactional
public class AdUserDetailService implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(AdUserDetailService.class);

    @Autowired
    protected SessionFactory sessionFactory;

    @Autowired
    private AdUserDao userDao;

    @Autowired
    private AdGroupDao groupDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        AdUser user = userDao.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("No such user");
        LOG.debug("loading #{} {}", user.getId(), user.getUsername());
        return new AdUserDetails(user, loadGrantedAuthoritiesFor(user));
    }

    private Set<GrantedAuthority> loadGrantedAuthoritiesFor(AdUser user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        for (AdPrincipalRole role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().name()));
        }

        Set<AdGroup> groups = groupDao.findEffectiveAsNative(user);
        for (AdGroup group : groups) {
            for (AdPrincipalRole role : group.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().name()));
            }
        }

        LOG.info("load auth for #{}{}", user.getId(), user.getUsername());
        return grantedAuthorities;
    }
}
