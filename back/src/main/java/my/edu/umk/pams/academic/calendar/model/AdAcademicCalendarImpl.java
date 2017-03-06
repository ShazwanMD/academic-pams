package my.edu.umk.pams.academic.calendar.model;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.model.AdStudyCenterImpl;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSessionImpl;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author PAMS
 */
@Entity(name = "AdAcademicCalendar")
@Table(name = "AD_ACDM_CLDR")
public class AdAcademicCalendarImpl implements AdAcademicCalendar {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_ACDM_CLDR")
    @SequenceGenerator(name = "SQ_AD_ACDM_CLDR", sequenceName = "SQ_AD_ACDM_CLDR", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "ACADEMIC_DATE")
    private Date academicDate;

    @Enumerated
    @NotNull
    @Column(name = "CALENDAR_TYPE")
    private AdAcademicCalendarType calendarType;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(targetEntity = AdStudyCenterImpl.class)
    @JoinColumn(name = "STUDY_CENTER_ID")
    private AdStudyCenter studyCenter;

    @ManyToOne(targetEntity = AdAcademicSessionImpl.class)
    @JoinColumn(name = "SESSION_ID")
    private AdAcademicSession session;

    @Embedded
    private AdMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getAcademicDate() {
        return academicDate;
    }

    @Override
    public void setAcademicDate(Date academicDate) {
        this.academicDate = academicDate;
    }

    @Override
    public AdAcademicCalendarType getCalendarType() {
        return calendarType;
    }

    @Override
    public void setCalendarType(AdAcademicCalendarType calendarType) {
        this.calendarType = calendarType;
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
    public AdAcademicSession getSession() {
        return session;
    }

    @Override
    public void setSession(AdAcademicSession session) {
        this.session = session;
    }

    public AdStudyCenter getStudyCenter() {
        return studyCenter;
    }

    public void setStudyCenter(AdStudyCenter studyCenter) {
        this.studyCenter = studyCenter;
    }

    public AdMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdAcademicCalendar.class;
    }
}
