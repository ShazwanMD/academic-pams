package my.edu.umk.pams.academic.planner.dao;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdGradeCodeImpl;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author PAMS
 */
@Repository("acGradeCodeDao")
public class AdGradeCodeDaoImpl extends GenericDaoSupport<Long, AdGradeCode> implements AdGradeCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdGradeCodeDaoImpl.class);

    public AdGradeCodeDaoImpl() {
        super(AdGradeCodeImpl.class);
    }

    @Override
    public AdGradeCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradeCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdGradeCode) query.uniqueResult();
    }

    @Override
    public AdGradeCode findByScore(AdProgram program, BigDecimal score) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradeCode s where " +
                "s.maxScore >= :score " +
                "and s.minScore <= :score " +
                "and s.program = :program " +
                "and s.metadata.state = :state");
        query.setBigDecimal("score", score);
        query.setCacheable(true);
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdGradeCode) query.uniqueResult();
    }

    @Override
    public List<AdGradeCode> find(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradeCode s where " +
                "s.program = :program " +
                "and s.metadata.state = :state");
        query.setCacheable(true);
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (List<AdGradeCode>) query.list();
    }
}
