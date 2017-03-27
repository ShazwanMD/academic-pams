package my.edu.umk.pams.academic.security.integration.jwt;

import my.edu.umk.pams.academic.identity.dao.AdGroupDao;
import my.edu.umk.pams.academic.identity.dao.AdUserDao;
import my.edu.umk.pams.academic.identity.model.AdGroup;
import my.edu.umk.pams.academic.identity.model.AdPrincipalRole;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.security.integration.jwt.exception.JwtTokenExpiredException;
import my.edu.umk.pams.academic.security.integration.jwt.exception.JwtTokenMalformedException;
import my.edu.umk.pams.academic.security.integration.jwt.handler.JwtHandler;
import my.edu.umk.pams.academic.security.integration.jwt.vo.JwtUser;
import my.edu.umk.pams.academic.security.integration.jwt.vo.JwtUserDetails;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/30/14
 */
@Service("jwtUserDetailService")
public class JwtUserDetailService implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(JwtUserDetailService.class);

    @Autowired
    protected SessionFactory sessionFactory;

    @Autowired
    private AdUserDao userDao;

    @Autowired
    private AdGroupDao groupDao;

    @Autowired
    private JwtHandler jwtHandler;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException, DataAccessException {
        JwtUser parsedUser = jwtHandler.parseToken(token);

        if (parsedUser == null) {
            throw new JwtTokenMalformedException("JWT token is not valid");
        } else if (parsedUser.getExpirationDate().getTime() < System.currentTimeMillis()) {
            throw new JwtTokenExpiredException("JWT token is expired");
        }

        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(parsedUser.getRole());

        LOG.debug("userId: " + parsedUser.getUserId());
        LOG.debug("username: " + parsedUser.getUsername());
        return new JwtUserDetails(token, parsedUser.getUsername(), "N/A", authorityList, parsedUser.getUserId());
    }

    private Set<GrantedAuthority> loadGrantedAuthoritiesFor(AdUser user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (AdPrincipalRole role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().name()));
        }

        Set<AdGroup> groups = groupDao.findEffectiveAsNative(user);
        for (AdGroup group : groups) {
            for (AdPrincipalRole role : group.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().name()));
            }
        }

        LOG.info("load auth for user with id = {}, username = {}", user.getId(), user.getUsername());
        return grantedAuthorities;
    }
}
