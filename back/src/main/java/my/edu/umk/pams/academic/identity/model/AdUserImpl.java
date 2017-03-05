package my.edu.umk.pams.academic.identity.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static my.edu.umk.pams.academic.identity.model.AdPrincipalType.USER;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Entity(name = "InUser")
@Table(name = "AD_USER")
public class AdUserImpl extends AdPrincipalImpl implements AdUser {

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @Column(name = "REAL_NAME", nullable = false)
    private String realName;

    @NotNull
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @OneToOne(targetEntity = AdActorImpl.class)
    @JoinColumn(name = "ACTOR_ID", nullable = true)
    private AdActor actor;

    public AdUserImpl() {
        setPrincipalType(USER);
    }

    @Override
    public String getUsername() {
        return getName();
    }

    @Override
    public void setUsername(String username) {
        setName(username);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRealName() {
        return realName;
    }

    @Override
    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public AdActor getActor() {
        return actor;
    }

    @Override
    public void setActor(AdActor actor) {
        this.actor = actor;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdUser.class;
    }

}
