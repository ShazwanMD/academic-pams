package my.edu.umk.pams.academic.studyplan.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdFacultyImpl;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;


/**
 */
@Repository("acFacultyDao")
public class AdFacultyDaoImpl extends GenericDaoSupport<Long, AdFaculty> implements AdFacultyDao {

    public AdFacultyDaoImpl() {
        super(AdFacultyImpl.class);
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public AdFaculty findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdFaculty s where s.code = :code and  " +
                " s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdFaculty) query.uniqueResult();
    }

    @Override
    public List<AdFaculty> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdFaculty s where " +
                " s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdFaculty>) query.list();
    }

    @Override
    public List<AdFaculty> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdFaculty s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.name) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdFaculty>) query.list();
    }

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdFaculty s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.name) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }


    
    @Override
    public Integer countProgram(AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdProgram s where " +
                "s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countCourse(AdFaculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCourse s where " +
                "s.faculty = :faculty " +
                "and s.metadata.state = :state ");
        query.setEntity("faculty", faculty);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdFaculty s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    @Override
    public void addProgram(AdFaculty faculty, AdProgram program, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(faculty, "Faculty cannot be null");
        Validate.notNull(program, "program cannot be null");
        Session session = sessionFactory.getCurrentSession();
        program.setFaculty(faculty);

        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(AdMetaState.ACTIVE);
        program.setMetadata(metadata);
        session.save(program);
    }

    @Override
    public void updateProgram(AdFaculty faculty, AdProgram program, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        program.setFaculty(faculty);

        // prepare metadata
        AdMetadata metadata = program.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        program.setMetadata(metadata);
        session.update(program);
    }

    @Override
    public void removeProgram(AdFaculty faculty, AdProgram program, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(faculty, "Faculty cannot be null");
        Validate.notNull(program, "program cannot be null");
        Session session = sessionFactory.getCurrentSession();
        program.setFaculty(faculty);

        // prepare metadata
        AdMetadata metadata = program.getMetadata();
        metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setDeleterId(user.getId());
        metadata.setState(AdMetaState.INACTIVE);
        program.setMetadata(metadata);
        session.update(program);
    }

    @Override
    public void addCourse(AdFaculty faculty, AdCourse course, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(faculty, "Faculty cannot be null");
        Validate.notNull(course, "section cannot be null");
        Session session = sessionFactory.getCurrentSession();
        course.setFaculty(faculty);

        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(AdMetaState.ACTIVE);
        course.setMetadata(metadata);
        session.save(course);
    }

    @Override
    public void updateCourse(AdFaculty faculty, AdCourse course, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        course.setFaculty(faculty);

        // prepare metadata
        AdMetadata metadata = course.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        course.setMetadata(metadata);
        session.update(course);
    }

    @Override
    public void removeCourse(AdFaculty faculty, AdCourse course, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        course.setFaculty(faculty);

        // prepare metadata
        AdMetadata metadata = course.getMetadata();
        metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setDeleterId(user.getId());
        metadata.setState(AdMetaState.INACTIVE);
        course.setMetadata(metadata);
        session.update(course);
    }

}
