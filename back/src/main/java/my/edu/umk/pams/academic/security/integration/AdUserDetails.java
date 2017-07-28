package my.edu.umk.pams.academic.security.integration;

import my.edu.umk.pams.academic.identity.model.AdUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public class AdUserDetails implements UserDetails {

    private AdUser user;
    private Set<GrantedAuthority> grantedAuthorities;

    public AdUserDetails() {
    }

    public AdUserDetails(AdUser user, Set<GrantedAuthority> grantedAuthorities) {
        this.user = user;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getName();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return user.isEnabled();
    }

    public void setUser(AdUser user) {
        this.user = user;
    }

    public AdUser getUser() {
        return user;
    }

    public String getRealName() {
        return user.getRealName();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public Long getId() {
        return user.getId();
    }
}
