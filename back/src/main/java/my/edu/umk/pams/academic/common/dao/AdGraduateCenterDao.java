package my.edu.umk.pams.academic.common.dao;

import java.util.List;

import my.edu.umk.pams.academic.common.model.AdGraduateCenter;
import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.planner.model.AdFaculty;

public interface AdGraduateCenterDao extends GenericDao<Long, AdGraduateCenter> {

	
    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdGraduateCenter findByCode(String code);
    
    AdGraduateCenter findByFacultyCode(AdFaculty facultyCode);

    List<AdGraduateCenter> find();

    List<AdGraduateCenter> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
    
}
