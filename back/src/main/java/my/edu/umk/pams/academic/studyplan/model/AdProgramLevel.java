package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * DIPLOMA
 * FOUNDATION
 * DEGREE
 * MASTER
 * PHD
 * OTHERS
 *
 * @author PAMS
 */
public interface AdProgramLevel extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

}
