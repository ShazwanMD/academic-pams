package my.edu.umk.pams.academic.planner.model;


import my.edu.umk.pams.academic.common.model.AdCampus;
import my.edu.umk.pams.academic.common.model.AdGraduateCenter;
import my.edu.umk.pams.academic.core.AdMetaObject;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdFaculty extends AdMetaObject {

    String getCode();

    void setCode(String code);
    
    String getPrefix();

    void setPrefix(String prefix);
    
    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);
    
    AdFacultyStatus getStatus();

    void setStatus(AdFacultyStatus status);

    List<AdProgram> getPrograms();

    void setPrograms(List<AdProgram> programs);

    List<AdCourse> getCourses();

    void setCourses(List<AdCourse> courses);
    
    AdGraduateCenter getCenter();
    
    void setCenter(AdGraduateCenter center);
    
    AdCampus getCampus();
    
    void setCampus(AdCampus campus);
    
    
    
}
