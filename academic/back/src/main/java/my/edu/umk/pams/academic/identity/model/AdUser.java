package my.edu.umk.pams.academic.identity.model;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface AdUser extends AdPrincipal {

    String DEFAULT_PASSWORD = "abc123";

    String getUsername();

    void setUsername(String username);

    String getRealName();

    void setRealName(String firstName);

    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    AdActor getActor();

    void setActor(AdActor actor);
}
