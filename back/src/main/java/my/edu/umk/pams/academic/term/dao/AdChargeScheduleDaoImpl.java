package my.edu.umk.pams.academic.term.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.term.model.AdChargeSchedule;
import my.edu.umk.pams.academic.term.model.AdChargeScheduleImpl;
import my.edu.umk.pams.academic.planner.model.AdAcademicPeriod;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;



/**
 * @author PAMS
 */
@Repository("acChargeScheduleDao")
public class AdChargeScheduleDaoImpl extends GenericDaoSupport<Long, AdChargeSchedule> implements AdChargeScheduleDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdChargeScheduleDaoImpl.class);

    public AdChargeScheduleDaoImpl() {
        super(AdChargeScheduleImpl.class);
    }

    @Override
    public AdChargeSchedule findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select sa from AdChargeSchedule sa where " +
                "sa.code = :code and  " +
                "sa.metadata.state = :state");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (AdChargeSchedule) query.uniqueResult();
    }

    @Override
    public AdChargeSchedule find(AdAcademicPeriod period, AdCohort cohort, AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select sa from AdChargeSchedule sa where " +
                "sa.period = :period " +
                "and sa.cohort = :cohort " +
                "and sa.program = :program " +
                "and sa.metadata.state = :state");
        query.setInteger("period", period.ordinal());
        query.setEntity("cohort", cohort);
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (AdChargeSchedule) query.uniqueResult();
    }

    @Override
    public List<AdChargeSchedule> find(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select sa from AdChargeSchedule sa where " +
                "sa.program = :program " +
                "and sa.metadata.state = :state");
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdChargeSchedule>) query.list();
    }

    @Override
    public List<AdChargeSchedule> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select sa from AdChargeSchedule sa where " +
                "(upper(sa.code) like upper(:filter) " +
                "or upper(sa.program.code) like upper(:filter)" +
                "or upper(sa.program.title) like upper(:filter)" +
                "or upper(sa.cohort.code) like upper(:filter) " +
                "or upper(sa.cohort.description) like upper(:filter)) " +
                "and sa.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdChargeSchedule>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(sa) from AdChargeSchedule sa where " +
                "(upper(sa.code) like upper(:filter) " +
                "or upper(sa.program.code) like upper(:filter)" +
                "or upper(sa.program.title) like upper(:filter)" +
                "or upper(sa.cohort.code) like upper(:filter) " +
                "or upper(sa.cohort.description) like upper(:filter)) " +
                "and sa.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(sa) from AdChargeSchedule sa where " +
                "sa.program = :program " +
                "and sa.metadata.state = :state");
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return ((Long) query.uniqueResult()).intValue();
    }
}
