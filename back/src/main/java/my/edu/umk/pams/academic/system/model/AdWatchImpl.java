package my.edu.umk.pams.academic.system.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author canang.technologies
 * @since 7/26/14
 */
@Entity(name = "AdWatch")
@Table(name = "AD_WTCH")
public class AdWatchImpl implements AdWatch {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_WTCH")
    @SequenceGenerator(name = "SQ_AD_WTCH", sequenceName = "SQ_AD_WTCH", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "OBJECT_ID", nullable = false)
    private Long objectId;

    @NotNull
    @Column(name = "OBJECT_CLASS", nullable = false)
    private String objectClass;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Embedded
    private AdMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getObjectClass() {
        return objectClass;
    }

    public void setObjectClass(String objectClass) {
        this.objectClass = objectClass;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public AdMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }
}
