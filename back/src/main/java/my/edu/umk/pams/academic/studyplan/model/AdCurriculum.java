package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdCurriculum extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getUpuCode();

    void setUpuCode(String upuCode);

    Integer getOrdinal();

    void setOrdinal(Integer ordinal);

    String getTitleMs();

    void setTitleMs(String englishTitle);

    String getTitleEn();

    void setTitleEn(String malayTitle);

    String getShortTitle();

    void setShortTitle(String shortTitle);

    Integer getPeriod();

    void setPeriod(Integer period);

    Integer getMaxPeriod();

    void setMaxPeriod(Integer maxPeriod);

    AdProgram getProgram();

    void setProgram(AdProgram program);

    List<AdCohort> getCohorts(); //pengambilan pelajar mengikut sem

    void setCohorts(List<AdCohort> cohorts);



    List<AdSubject> getSubjects();

    void setSubjects(List<AdSubject> subjects);


    // transient?

    Integer getCoreCredit(); // teras fakulti

    void setCoreCredit(Integer coreCredit);

    Integer getRequiredCredit(); // Teras program/pengkhususan

    void setRequiredCredit(Integer requiredCredit);

    Integer getElectiveCredit(); // elektif/Opsyen

    void setElectiveCredit(Integer electiveCredit);

    Integer getGeneralCredit(); //Umum Universiti

    void setGeneralCredit(Integer generalCredit);

    Integer getLanguageCredit(); // english

    void setLanguageCredit(Integer languageCredit);

    Integer getCurriculumCredit(); // kokurikulum

    void setCurriculumCredit(Integer curriculumCredit);

    Integer getOthersCredit(); // kredit2 lain

    void setOthersCredit(Integer othersCredit);

    Integer getTotalCredit(); // Jumlah semua

    void setTotalCredit(Integer totalCredit);

}
