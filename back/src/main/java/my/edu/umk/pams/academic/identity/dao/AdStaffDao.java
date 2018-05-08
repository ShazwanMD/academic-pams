package my.edu.umk.pams.academic.identity.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStaffType;
import my.edu.umk.pams.academic.planner.model.AdFaculty;

import java.util.List;

/**
 * @author team canang
 * @since 6/6/2015.
 */
public interface AdStaffDao extends GenericDao<Long, AdStaff> {

    AdStaff findByStaffNo(String staffNo);
    
    AdStaff findByIdentityNo(String identityNo);

    AdStaff findByNricNo(String nricNo);

    AdStaff findByEmail(String email);

    AdStaff findByName(String name);

    List<AdStaff> find(AdStaffType type, Integer offset, Integer limit);

    Integer count(String filter);

    boolean isExists(String staffNo);

    boolean isEmailExists(String email);

	List<AdStaff> findAcademicStaffByFaculty(AdStaffType type, AdFaculty faculty, Integer offset, Integer limit);

}
