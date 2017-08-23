package my.edu.umk.pams.academic.term.model;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.model.AdStudyCenterImpl;
import my.edu.umk.pams.academic.core.AdFlowdata;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStaffImpl;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicSessionImpl;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramImpl;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author PAMS
 */
@Entity(name = "AdAdmissionApplication")
@Table(name = "AD_ADMN_APLN")
public class AdAdmissionApplicationImpl implements AdAdmissionApplication {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_ADMN_APLN")
    @SequenceGenerator(name = "SQ_AD_ADMN_APLN", sequenceName = "SQ_AD_ADMN_APLN", allocationSize = 1)
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

    @Column(name = "REMOVE_COMMENT")
    private String removeComment;

    @Column(name = "CANCEL_COMMENT")
    private String cancelComment;
    
    @Column(name = "ORDINAL")
    private Integer ordinal;

    @ManyToOne(targetEntity = AdStudentImpl.class)
    @JoinColumn(name = "STUDENT_ID" )
    private AdStudent student;

    @ManyToOne(targetEntity = AdStaffImpl.class)
    @JoinColumn(name = "ADVISOR_ID" , nullable = true)
    private AdStaff advisor;

    @ManyToOne(targetEntity = AdAcademicSessionImpl.class)
    @JoinColumn(name = "SESSION_ID")
    private AdAcademicSession session;

    @ManyToOne(targetEntity = AdProgramImpl.class)
    @JoinColumn(name = "PROGRAM_ID")
    private AdProgram program;

    @ManyToOne(targetEntity = AdStudyCenterImpl.class)
    @JoinColumn(name = "STUDY_CENTER_ID")
    private AdStudyCenter studyCenter;

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
    public Integer getOrdinal() {
        return ordinal;
    }

    @Override
    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
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
    public AdStaff getAdvisor() {
        return advisor;
    }

    @Override
    public void setAdvisor(AdStaff advisor) {
        this.advisor = advisor;
    }

    @Override
    public AdProgram getProgram() {
        return program;
    }

    @Override
    public void setProgram(AdProgram program) {
        this.program = program;
    }

    @Override
    public AdStudyCenter getStudyCenter() {
        return studyCenter;
    }

    @Override
    public void setStudyCenter(AdStudyCenter studyCenter) {
        this.studyCenter = studyCenter;
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
        return AdAdmissionApplication.class;
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
