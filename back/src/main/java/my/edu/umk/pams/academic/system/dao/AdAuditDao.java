package my.edu.umk.pams.academic.system.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.system.model.AdAudit;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface AdAuditDao extends GenericDao<Long, AdAudit> {

    List<AdAudit> find(String filter, Integer offset, Integer limit);

    Integer count(String filter);
}
