package my.edu.umk.pams.academic.system.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.system.model.AdReferenceNo;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface AdReferenceNoDao extends GenericDao<Long, AdReferenceNo> {

    AdReferenceNo findByCode(String code);

    List<AdReferenceNo> find(String filter, Integer offset, Integer limit);

    Integer count(String filter);
}
