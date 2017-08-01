package my.edu.umk.pams.academic.planner.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.planner.model.*;

import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author PAMS
 */
@Repository("curriculumDao")
public class AdCurriculumDaoImpl extends GenericDaoSupport<Long, AdCurriculum> implements AdCurriculumDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdCurriculumDaoImpl.class);

    public AdCurriculumDaoImpl() {
        super(AdCurriculumImpl.class);
    }

    @Override
    public AdCurriculum findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCurriculum s where " +
                "s.code = :code " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdCurriculum) query.uniqueResult();
    }

    @Override
    public AdCurriculum findLatestByProgram(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCurriculum s where " +
                "s.program = :program " +
                "and max(s.ordinal) " +
                "and s.metadata.state = :state");
        query.setEntity("program", program);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdCurriculum) query.uniqueResult();
    }

    @Override
    public AdSubject findSubjectById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (AdSubject) session.get(AdSubjectImpl.class, id);
    }

    @Override
    public AdSubject findSubjects() {
        Session session = sessionFactory.getCurrentSession();
        return (AdSubject) session.get(AdSubjectImpl.class, session);

    }

    @Override
    public AdSubject findSubject(AdCurriculum curriculum, AdSubjectType subjectType, Integer ordinal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSubject s where " +
                "s.curriculum = :curriculum " +
                "and s.subjectType = :subjectType " +
                "and s.ordinal = :ordinal " +
                "and s.metadata.state = :state");
        query.setEntity("curriculum", curriculum);
        query.setInteger("subjectType", subjectType.ordinal());
        query.setInteger("ordinal", ordinal);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (AdSubject) query.uniqueResult();
    }

    @Override
    public List<AdCurriculum> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCurriculum s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.program.code) like upper(:filter))" +
                "and s.metadata.state = :state");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdCurriculum>) query.list();
    }

    @Override
    public List<AdCurriculum> find(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCurriculum s where " +
                "s.program = :program " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("program", program);
        query.setCacheable(true);
        return (List<AdCurriculum>) query.list();
    }


    @Override
    public List<AdCurriculum> find(AdProgram program, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCurriculum s where " +
                "s.program = :program " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("program", program);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdCurriculum>) query.list();
    }
    
    @Override
    public List<AdSubject> find(AdProgram program, AdSubjectType subjectType) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCurriculum s where " +
                "s.program = :program " +
                "s.program = :program " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("program", program);
        query.setInteger("subjectType", subjectType.ordinal());
        return (List<AdSubject>) query.list();
    }

    @Override
    public List<AdSubject> findSubjects(AdCurriculum curriculum) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSubject s where " +
                "s.curriculum = :curriculum " +
                "and s.metadata.state = :state " +
                "order by s.course.code asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("curriculum", curriculum);
        query.setCacheable(true);
        return (List<AdSubject>) query.list();
    }

    @Override
    public List<AdSubject> findSubjects(AdSubjectType subjectType, AdCurriculum curriculum) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSubject s where " +
                "s.curriculum = :curriculum " +
                "and s.subjectType = :subjectType " +
                "and s.metadata.state = :state " +
                "order by s.course.code asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setInteger("subjectType", subjectType.ordinal());
        query.setEntity("curriculum", curriculum);
        query.setCacheable(true);
        return (List<AdSubject>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCurriculum s where " +
                "upper(s.code) like :filter " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCurriculum s where " +
                "s.program = :program " +
                "and s.metadata.state = :state ");
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countSubject(AdCurriculum curriculum) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdSubject s where " +
                "s.curriculum = :curriculum " +
                "and s.metadata.state = :state ");
        query.setEntity("curriculum", curriculum);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdCurriculum s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }


    @Override
    public boolean isSubjectExists(AdCourse course, AdCurriculum curriculum) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdSubject s where " +
                "s.course = :course " +
                "and s.curriculum = :curriculum " +
                "and s.metadata.state = :state ");
        query.setEntity("course", course);
        query.setEntity("curriculum", curriculum);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasCurriculum(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdCurriculum s where " +
                "s.program = :program " +
                "and s.metadata.state = :state ");
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasSubjects(AdCurriculum curriculum) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdSubject s where " +
                "s.curriculum = :curriculum " +
                "and s.metadata.state = :state ");
        query.setEntity("curriculum", curriculum);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    public void addSubject(AdCurriculum curriculum, AdSubject subject, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(curriculum, "Curriculum cannot be null");
        Validate.notNull(subject, "Subject cannot be null");
        Session session = sessionFactory.getCurrentSession();
        subject.setCurriculum(curriculum);

        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(AdMetaState.ACTIVE);
        subject.setMetadata(metadata);
        session.save(subject);
    }
    
    @Override
	public void addSingleSubject(AdCurriculum curriculum, AdSubject subject, AdUser currentUser) {
    	Validate.notNull(currentUser, "User cannot be null");
        Validate.notNull(curriculum, "Curriculum cannot be null");
        Validate.notNull(subject, "Subject cannot be null");
        Session session = sessionFactory.getCurrentSession();
        subject.setCurriculum(curriculum);
        
        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(currentUser.getId());
        metadata.setState(AdMetaState.ACTIVE);
        subject.setMetadata(metadata);
        session.save(subject);
		
	}

	@Override
	public void addBundleSubject(AdCurriculum curriculum, AdSubject subject, AdUser currentUser) {
		
		Validate.notNull(currentUser, "User cannot be null");
        Validate.notNull(curriculum, "Curriculum cannot be null");
        Validate.notNull(subject, "Subject cannot be null");
        Session session = sessionFactory.getCurrentSession();
        subject.setCurriculum(curriculum);
        
        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(currentUser.getId());
        metadata.setState(AdMetaState.ACTIVE);
        subject.setMetadata(metadata);
        session.save(subject);
		
	}


    public void updateSubject(AdCurriculum curriculum, AdSubject subject, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        subject.setCurriculum(curriculum);

        // prepare metadata
        AdMetadata metadata = subject.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        subject.setMetadata(metadata);
        session.update(subject);
    }

    public void deleteSubject(AdCurriculum curriculum, AdSubject subject, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        session.delete(subject);
    }

    @Override
    public void addSubjectPart(AdBundleSubject subject, AdBundleSubjectPart part, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(subject, "Subject cannot be null");
        Validate.notNull(part, "Part cannot be null");
        Session session = sessionFactory.getCurrentSession();
        part.setBundle(subject);

        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(AdMetaState.ACTIVE);
        part.setMetadata(metadata);
        session.save(part);
    }

    @Override
    public void deleteSubjectPart(AdBundleSubject subject, AdBundleSubjectPart part, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        session.delete(part);
    }

	
}
