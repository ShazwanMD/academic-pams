package my.edu.umk.pams.academic.planner.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdFaculty extends AdMetaObject {

    String getCode();

    void setCode(String code);
    
    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    List<AdProgram> getPrograms();

    void setPrograms(List<AdProgram> programs);

    List<AdCourse> getCourses();

    void setCourses(List<AdCourse> courses);
}
