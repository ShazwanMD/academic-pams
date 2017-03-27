package my.edu.umk.pams.academic.security.event;

import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.identity.model.AdPrincipal;
import my.edu.umk.pams.academic.security.integration.AdPermission;
import org.springframework.context.ApplicationEvent;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public class AccessEvent extends ApplicationEvent {

    private AdMetaObject object;
    private AdMetaObject parent;
    private AdPermission permission;
    private AdPrincipal principal;
    private Command command = Command.GRANT;

    public enum Command {GRANT, REVOKE, INHERIT}

    public AccessEvent(AdMetaObject object, AdPrincipal principal, AdPermission permission) {
        super(object);
        this.object = object;
        this.principal = principal;
        this.permission = permission;
    }

    public AccessEvent(AdMetaObject object, AdPrincipal principal, AdPermission permission, Command command) {
        super(object);
        this.object = object;
        this.principal = principal;
        this.permission = permission;
        this.command = command;
    }

    public AccessEvent(AdMetaObject parent, AdMetaObject object) {
        super(object);
        this.object = object;
        this.parent = parent;
        this.command = Command.INHERIT;
    }

    public AdMetaObject getObject() {
        return object;
    }

    public AdMetaObject getParent() {
        return parent;
    }

    public AdPermission getPermission() {
        return permission;
    }

    public void setPermission(AdPermission permission) {
        this.permission = permission;
    }

    public AdPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(AdPrincipal principal) {
        this.principal = principal;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
