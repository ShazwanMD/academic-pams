package my.edu.umk.pams.academic.studyplan.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdFacultyDao extends GenericDao<Long, AdFaculty> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdFaculty findByCode(String code);

    List<AdFaculty> find();

    List<AdFaculty> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    Integer countProgram(AdFaculty faculty);

    Integer countCourse(AdFaculty faculty);

    boolean isExists(String code);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    void addProgram(AdFaculty faculty, AdProgram program, AdUser user);

    void updateProgram(AdFaculty faculty, AdProgram program, AdUser user);

    void removeProgram(AdFaculty faculty, AdProgram program, AdUser user);

    void addCourse(AdFaculty faculty, AdCourse course, AdUser user);

    void updateCourse(AdFaculty faculty, AdCourse course, AdUser user);

    void removeCourse(AdFaculty faculty, AdCourse course, AdUser user);
}
