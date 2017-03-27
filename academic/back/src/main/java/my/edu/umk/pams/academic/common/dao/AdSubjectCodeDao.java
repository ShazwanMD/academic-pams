package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdSubjectCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdSubjectCodeDao extends GenericDao<Long, AdSubjectCode> {

    AdSubjectCode findByCode(String code);

    List<AdSubjectCode> find(String filter, Integer offset, Integer limit);

    Integer count(String filter);

    boolean isExists(String code);
}
