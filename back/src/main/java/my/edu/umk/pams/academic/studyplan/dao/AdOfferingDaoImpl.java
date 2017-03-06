package my.edu.umk.pams.academic.studyplan.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.studyplan.model.*;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author PAMS
 */
@Repository("adOfferingDao")
public class AdOfferingDaoImpl extends GenericDaoSupport<Long, AdOffering> implements AdOfferingDao {

    public AdOfferingDaoImpl() {
        super(AdOfferingImpl.class);
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public AdOffering findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdOffering o where " +
                "o.code = :code " +
                "and o.metadata.state = :state");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdOffering) query.uniqueResult();
    }

    @Override
    public AdOffering findByCanonicalCode(String canonicalCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdOffering o where " +
                "o.canonicalCode = :canonicalCode " +
                "and o.metadata.state = :state");
        query.setString("canonicalCode", canonicalCode);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdOffering) query.uniqueResult();
    }

    @Override
    public AdOffering findByProgramAndCourse(AdProgram program, AdCourse course) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdOffering o where " +
                "o.program = :program " +
                "and o.course = :course " +
                "and o.metadata.state = :state");
        query.setEntity("program", program);
        query.setEntity("course", course);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdOffering) query.uniqueResult();
    }

    @Override
    public List<AdOffering> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdOffering o where " +
                "(upper(o.code) like upper(:filter) " +
                "or upper(o.program.code) like upper(:filter) " +
                "or upper(o.program.title) like upper(:filter) " +
                "or upper(o.course.code) like upper(:filter) " +
                "or upper(o.course.title) like upper(:filter)) " +
                "and o.metadata.state = :state " +
                "order by o.code asc");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdOffering>) query.list();
    }

    @Override
    public List<AdOffering> find(String filter, AdProgram program, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdOffering o where " +
                "(upper(o.code) like upper(:filter) " +
                "or upper(o.course.code) like upper(:filter) " +
                "or upper(o.course.title) like upper(:filter)) " +
                "and o.program = :program " +
                "and o.metadata.state = :state " +
                "order by o.code asc");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdOffering>) query.list();
    }

    @Override
    public List<AdOffering> find(String filter, AdAcademicSession academicSession, AdProgram program, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdOffering o where " +
                "(upper(o.code) like upper(:filter) " +
                "or upper(o.course.code) like upper(:filter) " +
                "or upper(o.course.title) like upper(:filter)) " +
                "and o.program = :program " +
                "and o.session = :academicSession " +
                "and o.metadata.state = :state " +
                "order by o.code asc");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("academicSession", academicSession);
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdOffering>) query.list();
    }

    @Override
    public List<AdOffering> find(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdOffering o where " +
                "o.program = :program " +
                "and o.metadata.state = :state");
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public List<AdOffering> find(AdProgram program, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdOffering o where " +
                "o.program = :program " +
                "and o.metadata.state = :state");
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<AdOffering> find(AdCourse course) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdOffering o where " +
                "o.course = :course " +
                "and o.metadata.state = :state");
        query.setEntity("course", course);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public List<AdOffering> find(AdAcademicSession academicSession) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdOffering o  join o.sections s where  " +
                "s.session = :academicSession " +
                "and o.metadata.state = :state");
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public AdAcademicSession find(AdAcademicSession academicSession, AdCourse course) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct s.session from AdOffering o  join o.sections s where  " +
                "s.session = :academicSession " +
                "and o.course = :course " +
                "and o.metadata.state = :state");
        query.setEntity("academicSession", academicSession);
        query.setEntity("course", course);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdAcademicSession) query.uniqueResult();
    }

    @Override
    public List<AdOffering> find(AdCourse course, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdOffering o where " +
                "o.course = :course " +
                "and o.metadata.state = :state");
        query.setEntity("course", course);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(o) from AdOffering o where " +
                "(upper(o.code) like upper(:filter) " +
                "or upper(o.program.code) like upper(:filter) " +
                "or upper(o.program.title) like upper(:filter) " +
                "or upper(o.course.code) like upper(:filter) " +
                "or upper(o.course.title) like upper(:filter)) " +
                "and o.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(o) from AdOffering o where " +
                "(upper(o.code) like upper(:filter) " +
                "or upper(o.course.code) like upper(:filter) " +
                "or upper(o.course.title) like upper(:filter)) " +
                "and o.program = :program " +
                "and o.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(o) from AdOffering o where " +
                "o.program = :program " +
                "and o.metadata.state = :state");
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdCourse course) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(o) from AdOffering o where " +
                "o.course = :course " +
                "and o.metadata.state = :state");
        query.setEntity("course", course);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countWithSection(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(o) from AdOffering o where " +
                "(upper(o.code) like upper(:filter) " +
                "or upper(o.program.code) like upper(:filter) " +
                "or upper(o.program.title) like upper(:filter) " +
                "or upper(o.course.code) like upper(:filter) " +
                "or upper(o.course.title) like upper(:filter)) " +
                "and o.sections.size > 0 " +
                "and o.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countWithSection(String filter, AdAcademicSession academicSession) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(o) from AdOffering o join o.sections s where " +
                "(upper(o.code) like upper(:filter) " +
                "or upper(o.program.code) like upper(:filter) " +
                "or upper(o.program.title) like upper(:filter) " +
                "or upper(o.course.code) like upper(:filter) " +
                "or upper(o.course.title) like upper(:filter)) " +
                "and o.sections.size > 0 " +
                "and s.session = :academicSession " +
                "and o.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("academicSession", academicSession);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(AdProgram program, AdCourse course) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdOffering s where " +
                "s.program = :program " +
                "and s.course = :course " +
                "and s.metadata.state = :state ");
        query.setEntity("program", program);
        query.setEntity("course", course);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String canonicalCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdOffering s where " +
                "s.canonicalCode = :canonicalCode " +
                "and s.metadata.state = :state ");
        query.setString("canonicalCode", canonicalCode);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    @Override
    public void addAssessment(AdOffering offering, AdAssessment assessment, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(offering, "Offering cannot be null");
        Validate.notNull(assessment, "assessment cannot be null");
        Session session = sessionFactory.getCurrentSession();
        assessment.setOffering(offering);

        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(AdMetaState.ACTIVE);
        assessment.setMetadata(metadata);
        session.save(assessment);
    }

    @Override
    public void updateAssessment(AdOffering offering, AdAssessment assessment, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        assessment.setOffering(offering);

        // prepare metadata
        AdMetadata metadata = assessment.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        assessment.setMetadata(metadata);
        session.update(assessment);
    }

    @Override
    public void deleteAssessment(AdOffering offering, AdAssessment assessment, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        session.delete(assessment);
    }
}
