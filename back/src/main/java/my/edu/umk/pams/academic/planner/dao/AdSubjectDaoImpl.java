package my.edu.umk.pams.academic.planner.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.planner.model.AdCurriculum;
import my.edu.umk.pams.academic.planner.model.AdSubject;
import my.edu.umk.pams.academic.planner.model.AdSubjectImpl;
import my.edu.umk.pams.academic.planner.model.AdSubjectType;

@Repository("adSubjectDao")
public class AdSubjectDaoImpl extends GenericDaoSupport<Long, AdSubject> implements AdSubjectDao {
 public AdSubjectDaoImpl() {
		super(AdSubjectImpl.class);
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
public AdSubject findSubjectsByCurriculum(AdCurriculum curriculum) {
	// TODO Auto-generated method stub
	return null;
}
}