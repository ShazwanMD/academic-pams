package my.edu.umk.pams.academic.term.model;

import my.edu.umk.pams.academic.core.AdFlowdata;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicSessionImpl;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author PAMS
 */
@Entity(name = "AdEnrollmentApplication")
@Table(name = "AD_ENMT_APLN")
public class AdEnrollmentApplicationImpl implements AdEnrollmentApplication {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_ENMT_APLN")
    @SequenceGenerator(name = "SQ_AD_ENMT_APLN", sequenceName = "SQ_AD_ENMT_APLN", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "REFERENCE_NO", nullable = false)
    private String referenceNo;

    @Column(name = "SOURCE_NO")
    private String sourceNo;

    @Column(name = "AUDIT_NO")
    private String auditNo;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "APPLICATION_TYPE")
    private AdEnrollmentApplicationType type = AdEnrollmentApplicationType.PRA;

    @Column(name = "REMOVE_COMMENT")
    private String removeComment;

    @Column(name = "CANCEL_COMMENT")
    private String cancelComment;

    @ManyToOne(targetEntity = AdStudentImpl.class)
    @JoinColumn(name = "STUDENT_ID")
    private AdStudent student;

    @ManyToOne(targetEntity = AdAdmissionImpl.class)
    @JoinColumn(name = "ADMISSION_ID")
    private AdAdmission admission;

    @ManyToOne(targetEntity = AdAcademicSessionImpl.class)
    @JoinColumn(name = "SESSION_ID")
    private AdAcademicSession session;

    @OneToMany(targetEntity = AdEnrollmentApplicationItemImpl.class, mappedBy = "application", fetch = FetchType.LAZY)
    private List<AdEnrollmentApplicationItem> items;

    @Embedded
    private AdMetadata metadata;

    @Embedded
    private AdFlowdata flowdata;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getReferenceNo() {
        return referenceNo;
    }

    @Override
    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    @Override
    public String getSourceNo() {
        return sourceNo;
    }

    @Override
    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo;
    }

    @Override
    public String getAuditNo() {
        return auditNo;
    }

    @Override
    public void setAuditNo(String auditNo) {
        this.auditNo = auditNo;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getRemoveComment() {
        return removeComment;
    }

    @Override
    public void setRemoveComment(String removeComment) {
        this.removeComment = removeComment;
    }

    @Override
    public String getCancelComment() {
        return cancelComment;
    }

    @Override
    public void setCancelComment(String cancelComment) {
        this.cancelComment = cancelComment;
    }

    @Override
    public AdEnrollmentApplicationType getType() {
        return type;
    }

    @Override
    public void setType(AdEnrollmentApplicationType type) {
        this.type = type;
    }

    @Override
    public AdAcademicSession getSession() {
        return session;
    }

    @Override
    public void setSession(AdAcademicSession session) {
        this.session = session;
    }

    @Override
    public AdStudent getStudent() {
        return student;
    }

    @Override
    public void setStudent(AdStudent student) {
        this.student = student;
    }

    @Override
    public AdAdmission getAdmission() {
        return admission;
    }

    @Override
    public void setAdmission(AdAdmission admission) {
        this.admission = admission;
    }

    @Override
    public List<AdEnrollmentApplicationItem> getItems() {
        return items;
    }

    @Override
    public void setItems(List<AdEnrollmentApplicationItem> items) {
        this.items = items;
    }

    @Override
    public AdMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdEnrollmentApplication.class;
    }

    @Override
    public AdFlowdata getFlowdata() {
        return flowdata;
    }

    @Override
    public void setFlowdata(AdFlowdata flowdata) {
        this.flowdata = flowdata;
    }
}
