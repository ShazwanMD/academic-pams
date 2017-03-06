package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

import java.util.Date;

/**
 * @author PAMS
 */
public interface AdAcademicSession extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

    boolean isOngoing();

    void setOngoing(boolean ongoing);

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getEndDate();

    void setEndDate(Date endDate);

    AdAcademicStatus getStatus();

    void setStatus(AdAcademicStatus status);

    AdAcademicSession getPrevious();

    void setPrevious(AdAcademicSession previous);

    AdAcademicSemester getSemester();

    void setSemester(AdAcademicSemester academicSemester);

    AdAcademicYear getYear();

    void setYear(AdAcademicYear academicYear);

    // transient
    public boolean isNew();

    public boolean isClosed();

    public boolean isStarted();

    public boolean isClosing();

    public boolean isStarting();

}
