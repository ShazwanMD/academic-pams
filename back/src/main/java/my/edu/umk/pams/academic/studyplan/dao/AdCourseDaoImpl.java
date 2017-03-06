package my.edu.umk.pams.academic.studyplan.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.studyplan.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PAMS
 */
@Repository("acCourseDao")
public class AdCourseDaoImpl extends GenericDaoSupport<Long, AdCourse> implements AdCourseDao {

    public AdCourseDaoImpl() {
        super(AdCourseImpl.class);
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public AdCourse findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCourse s where " +
                "s.code = :code " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdCourse) query.uniqueResult();
    }

    @Override
    public AdCourse findByCodeAndFaculty(String code, AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCourse s where " +
                "s.code = :code " +
                "and s.faculty = :faculty " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setEntity("faculty", faculty);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdCourse) query.uniqueResult();
    }

    @Override
    public List<AdCourse> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCourse s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.title) like upper(:filter)) " +
                "and s.metadata.state = :state " +
                "order by s.code asc");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdCourse>) query.list();
    }

    @Override
    public List<AdCourse> find(AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCourse s where " +
                "s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("faculty", faculty);
        query.setCacheable(true);
        return (List<AdCourse>) query.list();
    }

    @Override
    public List<AdCourse> find(String filter, AdFaculty faculty, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCourse s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.title) like upper(:filter)) " +
                "and s.metadata.state = :state " +
                "and s.faculty = :faculty " +
                "order by s.code asc");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("faculty", faculty);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdCourse>) query.list();
    }

    @Override
    public List<AdCourse> findAvailable(AdAcademicSession academicSession, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct s.offering from AcSection s where " +
                "s.session = :academicSession " +
                "and s.metadata.state = :state " +
                "order by s.code asc");
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdCourse>) query.list();
    }


    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCourse s where " +
                "s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCourse s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.title) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCourse s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.title) like upper(:filter)) " +
                "and s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCourse s where " +
                "s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s.course) from AcOffering s where " +
                "s.program = :program " +
                "and s.metadata.state = :state ");
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code, AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdCourse s where " +
                "s.code = :code " +
                "and s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
