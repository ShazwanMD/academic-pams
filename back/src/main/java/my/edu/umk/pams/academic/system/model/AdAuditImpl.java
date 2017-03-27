package my.edu.umk.pams.academic.system.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author canang technologies
 * @since 3/8/14
 */
@Entity(name = "AdAudit")
@Table(name = "AD_AUDT")
public class AdAuditImpl implements AdAudit {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_AUDT")
    @SequenceGenerator(name = "SQ_AD_AUDT", sequenceName = "SQ_AD_AUDT", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "MESSAGE", nullable = false)
    private String message;

    //    @NotNull
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    //    @NotNull
    @Column(name = "OBJECT_ID", nullable = false)
    private Long objectId;

    @NotNull
    @Column(name = "CLASS_NAME", nullable = false)
    private String className;

    @Embedded
    private AdMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public AdMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdAudit.class;
    }
}
