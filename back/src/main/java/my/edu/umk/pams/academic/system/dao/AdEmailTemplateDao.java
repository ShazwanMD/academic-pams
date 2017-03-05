package my.edu.umk.pams.academic.system.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.system.model.AdEmailTemplate;

import java.util.List;

/**
 * @author canang technologies
 * @since 9/4/2016.
 */
public interface AdEmailTemplateDao extends GenericDao<Long, AdEmailTemplate> {

    AdEmailTemplate findByCode(String code);

    Integer count(String filter);

    List<AdEmailTemplate> find(String filter);

    List<AdEmailTemplate> find(String filter, Integer offset, Integer limit);
}
