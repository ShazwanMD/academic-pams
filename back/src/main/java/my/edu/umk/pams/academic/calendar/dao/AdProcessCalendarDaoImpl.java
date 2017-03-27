package my.edu.umk.pams.academic.calendar.dao;

import my.edu.umk.pams.academic.calendar.model.AdProcessCalendar;
import my.edu.umk.pams.academic.calendar.model.AdProcessCalendarImpl;
import my.edu.umk.pams.academic.calendar.model.AdProcessCalendarType;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PAMS
 */
@Repository("adProcessCalendarDao")
public class AdProcessCalendarDaoImpl extends GenericDaoSupport<Long, AdProcessCalendar> implements AdProcessCalendarDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdProcessCalendarDaoImpl.class);

    public AdProcessCalendarDaoImpl() {
        super(AdProcessCalendarImpl.class);
    }

    // =============================================================================
    // FINDER
    // =============================================================================


    @Override
    public AdProcessCalendar findByProcessTypeSessionAndCampus(AdProcessCalendarType processType, AdAcademicSession academicSession, AdStudyCenter studyCenter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdProcessCalendar p where " +
                "p.processType = :processType " +
                "and p.session = :academicSession " +
                "and p.studyCenter = :studyCenter " +
                "and p.metadata.state = :state");
        query.setInteger("processType", processType.ordinal());
        query.setEntity("studyCenter", studyCenter);
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return ((AdProcessCalendar) query.uniqueResult());
    }

    @Override
    public List<AdProcessCalendar> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdProcessCalendar p where " +
                "p.metadata.state = :state " +
                "order by p.id");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdProcessCalendar>) query.list();
    }

    @Override
    public List<AdProcessCalendar> find(AdAcademicSession academicSession, AdStudyCenter studyCenter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdProcessCalendar p where " +
                "p.session = :academicSession " +
                "and p.studyCenter = :studyCenter " +
                "and p.metadata.state = :state " +
                "order by p.id");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("studyCenter", studyCenter);
        query.setEntity("academicSession", academicSession);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdProcessCalendar>) query.list();
    }

    @Override
    public boolean isExist(AdProcessCalendarType processType, AdAcademicSession academicSession, AdStudyCenter studyCenter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(b) from AdProcessCalendar b where " +
                "b.studyCenter =:studyCenter " +
                "AND b.session  = :academicSession " +
                "and b.processType = :processType");
        query.setEntity("studyCenter", studyCenter);
        query.setEntity("academicSession", academicSession);
        query.setInteger("processType", processType.ordinal());
        return ((Long) query.uniqueResult()).intValue() > 0;
    }
}
