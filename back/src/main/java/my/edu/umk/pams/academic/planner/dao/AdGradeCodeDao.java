package my.edu.umk.pams.academic.planner.dao;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.planner.model.AdProgram;

import java.math.BigDecimal;
import java.util.List;

/**
 * TODO: review by program
 * @author PAMS
 */
public interface AdGradeCodeDao extends GenericDao<Long, AdGradeCode> {

    AdGradeCode findByCode(String code);

    AdGradeCode findByScore(AdProgram program, BigDecimal percentage);

    List<AdGradeCode> find(AdProgram program);

}
