package my.edu.umk.pams.academic.identity.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdStudent;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface AdStudentDao extends GenericDao<Long, AdStudent> {

    AdStudent findByStudentNo(String studentNo);

    List<AdStudent> find(String filter, Integer offset, Integer limit);

    Integer count(String filter);
}
