package my.edu.umk.pams.academic.calendar.dao;

import my.edu.umk.pams.academic.calendar.model.AdAcademicCalendar;
import my.edu.umk.pams.academic.calendar.model.AdAcademicCalendarImpl;
import my.edu.umk.pams.academic.calendar.model.AdAcademicCalendarType;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author PAMS
 */
@Repository("adAcademicCalendarDao")
public class AdAcademicCalendarDaoImpl extends GenericDaoSupport<Long, AdAcademicCalendar> implements AdAcademicCalendarDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdAcademicCalendarDaoImpl.class);

    public AdAcademicCalendarDaoImpl() {
        super(AdAcademicCalendarImpl.class);
    }

    // =============================================================================
    // FINDER
    // =============================================================================

    @Override
    public AdAcademicCalendar find(Date date, AdAcademicSession academicSession, AdStudyCenter studyCenter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdAcademicCalendar p where " +
                "trunc(p.academicDate) =:academicDate " +
                "and p.session = :academicSession" +
                "and p.studyCenter = :studyCenter" +
                " and p.metadata.state = :state");
        query.setDate("academicDate", date);
        query.setEntity("studyCenter", studyCenter);
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return ((AdAcademicCalendar) query.uniqueResult());
    }

    @Override
    public List<AdAcademicCalendar> find(Date date) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdAcademicCalendar p where " +
                "p.academicDate =:academicDate ");
        query.setDate("academicDate", date);
        return (List<AdAcademicCalendar>) query.list();
    }

    @Override
    public List<AdAcademicCalendar> find(AdAcademicSession academicSession, AdStudyCenter studyCenter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdAcademicCalendar p where " +
                "p.studyCenter =:studyCenter " +
                "AND p.session = :academicSession");
        query.setEntity("studyCenter", studyCenter);
        query.setEntity("academicSession", academicSession);
        return (List<AdAcademicCalendar>) query.list();
    }

    @Override
    public List<AdAcademicCalendar> find(AdAcademicSession academicSession, AdStudyCenter studyCenter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdAcademicCalendar p where " +
                "p.studyCenter =:studyCenter " +
                "AND p.session = :academicSession");
        query.setEntity("studyCenter", studyCenter);
        query.setEntity("academicSession", academicSession);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdAcademicCalendar>) query.list();
    }

    @Override
    public List<AdAcademicCalendar> findByType(AdAcademicCalendarType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdAcademicCalendar p where " +
                "p.calendarType =:calendarType " +
                "and p.metadata.state =:state ");
        query.setInteger("calendarType", type.ordinal());
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (List<AdAcademicCalendar>) query.list();
    }


    @Override
    public List<AdAcademicCalendar> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select b from AdAcademicCalendar b where " +
                "b.metadata.state = :state " +
                "order by b.id");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (List<AdAcademicCalendar>) query.list();
    }

    @Override
    public List<AdAcademicCalendar> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select b from AdAcademicCalendar b where " +
                "b.metadata.state = :state " +
                "order by b.id");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdAcademicCalendar>) query.list();
    }

    // =============================================================================
    // HELPER
    // =============================================================================

    @Override
    public Integer countDate(AdAcademicCalendar academicDate) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Integer countWeekday(Date startDate, Date endDate, AdStudyCenter studyCenter) {
        // clear out our, minute, second
        // Calendar type : ACADEMIC_DAY
        Calendar startD = Calendar.getInstance();
        startD.setTime(startDate);
        startD.set(Calendar.HOUR, 0);
        startD.set(Calendar.MINUTE, 0);
        startD.set(Calendar.SECOND, 0);

        Calendar endD = Calendar.getInstance();
        endD.setTime(endDate);
        endD.set(Calendar.HOUR, 0);
        endD.set(Calendar.MINUTE, 0);
        endD.set(Calendar.SECOND, 0);

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(b) from AdAcademicCalendar b WHERE " +
                "b.academicDate between :startDate AND :endDate " +
                "AND b.calendarType = :calendarType " +
                "AND b.studyCenter = :studyCenter");
        query.setEntity("studyCenter", studyCenter);
        query.setCalendar("startDate", startD);
        query.setCalendar("endDate", endD);
        query.setInteger("calendarType", AdAcademicCalendarType.ACADEMIC_DAY.ordinal());

        return ((Long) query.uniqueResult()).intValue();

    }

    @Override
    public Integer countWeekend(Date startDate, Date endDate, AdStudyCenter studyCenter) {
        // clear out hour, minute, second
        // Calendar type : WEEKEND
        Calendar startD = Calendar.getInstance();
        startD.setTime(startDate);
        startD.set(Calendar.HOUR, 0);
        startD.set(Calendar.MINUTE, 0);
        startD.set(Calendar.SECOND, 0);

        Calendar endD = Calendar.getInstance();
        endD.setTime(endDate);
        endD.set(Calendar.HOUR, 0);
        endD.set(Calendar.MINUTE, 0);
        endD.set(Calendar.SECOND, 0);


        // NOTE: >=, <= startDate, endDate is inclusive
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(b) from AdAcademicCalendar b where " +
                "b.academicDate between :startDate and :endDate " +
                "and b.calendarType = :calendarType " +
                "and b.studyCenter = :studyCenter");
        query.setEntity("studyCenter", studyCenter);
        query.setCalendar("startDate", startD);
        query.setCalendar("endDate", endD);
        query.setInteger("calendarType", AdAcademicCalendarType.WEEKEND.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countHoliday(Date startDate, Date endDate, AdStudyCenter studyCenter) {

        Calendar startD = Calendar.getInstance();
        startD.setTime(startDate);
        startD.set(Calendar.HOUR, 0);
        startD.set(Calendar.MINUTE, 0);
        startD.set(Calendar.SECOND, 0);

        Calendar endD = Calendar.getInstance();
        endD.setTime(endDate);
        endD.set(Calendar.HOUR, 0);
        endD.set(Calendar.MINUTE, 0);
        endD.set(Calendar.SECOND, 0);


        // NOTE: >=, <= startDate, endDate is inclusive
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(b) from AdAcademicCalendar b where " +
                "b.academicDate between :startDate and :endDate " +
                "and b.calendarType = :calendarType " +
                "and b.studyCenter = :studyCenter");
        query.setEntity("studyCenter", studyCenter);
        query.setCalendar("startDate", startD);
        query.setCalendar("endDate", endD);
        query.setInteger("calendarType", AdAcademicCalendarType.HOLIDAY.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isWeekend(Date givenDate, AdStudyCenter studyCenter) {
//      public boolean isWeekend(Date givenDate) {

        Calendar currDate = new GregorianCalendar();
        currDate.setTime(givenDate);

        int dayOfWeek = currDate.get(Calendar.DAY_OF_WEEK);

        if (studyCenter.getCode().equals("J")) {
            return dayOfWeek == Calendar.FRIDAY || dayOfWeek == Calendar.SATURDAY;
        } else {
            return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
        }
    }

    @Override
    public boolean isAcademicDay(Date givenDate) {
        Calendar currDate = new GregorianCalendar();
        currDate.setTime(givenDate);
        int dayOfWeek = currDate.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY;
    }

    @Override
    public boolean isHoliday(Date givenDate, AdStudyCenter studyCenter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(b) from AdAcademicCalendar b where " +
                "trunc(b.academicDate) = trunc(:academicDate) " +
                "and b.calendarType = :calendarType " +
                "and b.studyCenter =:studyCenter");
        query.setEntity("studyCenter", studyCenter);
        query.setDate("academicDate", givenDate);
        query.setInteger("calendarType", AdAcademicCalendarType.HOLIDAY.ordinal());
        return 1 == ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExist(AdAcademicSession academicSession, AdStudyCenter studyCenter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(b) from AdAcademicCalendar b where " +
                "b.studyCenter =:studyCenter " +
                "AND b.session  = :academicSession ");
        query.setEntity("studyCenter", studyCenter);
        query.setEntity("academicSession", academicSession);
        return ((Long) query.uniqueResult()).intValue() > 0;
    }
}
