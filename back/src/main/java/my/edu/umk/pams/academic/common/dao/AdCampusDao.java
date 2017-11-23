package my.edu.umk.pams.academic.common.dao;

import java.util.List;

import my.edu.umk.pams.academic.common.model.AdCampus;
import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.planner.model.AdFaculty;

public interface AdCampusDao extends GenericDao<Long, AdCampus> {
	
    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdCampus findByCode(String code);
    
    AdCampus findByFacultyCode(AdFaculty facultyCode);

    List<AdCampus> find();

    List<AdCampus> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
  

}
