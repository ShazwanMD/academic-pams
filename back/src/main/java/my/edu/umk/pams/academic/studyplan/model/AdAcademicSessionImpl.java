package my.edu.umk.pams.academic.studyplan.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import java.util.Date;

/**
 * @author PAMS
 */
@Entity(name = "AdAcademicSession")
@Table(name = "AD_ACDM_SESN")
public class AdAcademicSessionImpl implements AdAcademicSession {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_ACDM_SESN")
    @SequenceGenerator(name = "SQ_AD_ACDM_SESN", sequenceName = "SQ_AD_ACDM_SESN", allocationSize = 1)
    private Long id;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "ONGOING", nullable = false)
    private boolean ongoing;

    @Column(name = "STATUS", nullable = false)
    private AdAcademicStatus status;

    @Column(name = "SEMESTER", nullable = false)
    private AdAcademicSemester semester;

    @ManyToOne(targetEntity = AdAcademicSessionImpl.class)
    @JoinColumn(name = "PREVIOUS_ID")
    private AdAcademicSession previous;

    @ManyToOne(targetEntity = AdAcademicYearImpl.class)
    @JoinColumn(name = "YEAR_ID")
    private AdAcademicYear year;

    @Embedded
    private AdMetadata metadata;

    public AdAcademicSessionImpl() {
        setStatus(AdAcademicStatus.NEW);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isOngoing() {
        return ongoing;
    }

    public void setOngoing(boolean ongoing) {
        this.ongoing = ongoing;
    }

    @Override
    public AdAcademicStatus getStatus() {
        return status;
    }

    public void setStatus(AdAcademicStatus status) {
        this.status = status;
    }

    public AdAcademicSession getPrevious() {
        return previous;
    }

    public void setPrevious(AdAcademicSession previous) {
        this.previous = previous;
    }

    public AdAcademicSemester getSemester() {
        return semester;
    }

    public void setSemester(AdAcademicSemester semester) {
        this.semester = semester;
    }

    public AdAcademicYear getYear() {
        return year;
    }

    public void setYear(AdAcademicYear year) {
        this.year = year;
    }

    public AdMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdAcademicSession.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdAcademicSessionImpl that = (AdAcademicSessionImpl) o;

        if (!code.equals(that.code)) return false;
        if (!id.equals(that.id)) return false;
        if (!semester.equals(that.semester)) return false;
        if (!year.equals(that.year)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + code.hashCode();
//        result = 31 * result + semester.hashCode();
//        result = 31 * result + year.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AdAcademicSessionImpl{" +
                "code='" + code + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", ongoing=" + ongoing +
                '}';
    }

    @Transient
    public boolean isNew() {
        return getStatus().equals(AdAcademicStatus.NEW);
    }

    @Transient
    public boolean isClosed() {
        return getStatus().equals(AdAcademicStatus.CLOSED);
    }

    @Transient
    public boolean isStarted() {
        return getStatus().equals(AdAcademicStatus.STARTED);
    }

    @Transient
    public boolean isClosing() {
        return getStatus().equals(AdAcademicStatus.CLOSING);
    }

    @Transient
    public boolean isStarting() {
        return getStatus().equals(AdAcademicStatus.STARTING);
    }
}

