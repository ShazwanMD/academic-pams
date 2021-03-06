package my.edu.umk.pams.academic.term.dao;

import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplicationImpl;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;

import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author AMS
 */
@Repository("adAdmissionApplicationDao")
public class AdAdmissionApplicationDaoImpl extends GenericDaoSupport<Long, AdAdmissionApplication>
        implements AdAdmissionApplicationDao {

    public AdAdmissionApplicationDaoImpl() {
        super(AdAdmissionApplicationImpl.class);
    }

    @Override
    public AdAdmissionApplication findByProgramAndStudent(AdProgram program, AdStudent student) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdAdmissionApplication o where " + "o.program = :program "
                + "and o.student = :student " + "and o.metadata.state = :state");
        query.setEntity("program", program);
        query.setEntity("student", student);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdAdmissionApplication) query.uniqueResult();
    }

    @Override
    public AdAdmissionApplication findByReferenceNo(String referenceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session
                .createQuery("select p from AdAdmissionApplication p " + "where p.referenceNo = :referenceNo ");
        query.setString("referenceNo", referenceNo);
        return (AdAdmissionApplication) query.uniqueResult();
    }

    @Override
    public List<AdAdmissionApplication> find(AdAcademicSession session) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession
                .createQuery("select p from AdAdmissionApplication p where " + "p.session = :session ");
        query.setEntity("session", session);
        return (List<AdAdmissionApplication>) query.list();
    }
    
    @Override
    public List<AdAdmissionApplication> find(AdStudent student) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession
                .createQuery("select p from AdAdmissionApplication p where " + "p.student = :student ");
        query.setEntity("student", student);
        return (List<AdAdmissionApplication>) query.list();
    }
    
    @Override
    public List<AdAdmissionApplication> find(AdStaff staff) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession
                .createQuery("select p from AdAdmissionApplication p where " + "p.advisor = :staff ");
        query.setEntity("staff", staff);
        return (List<AdAdmissionApplication>) query.list();
    }

    @Override
    public List<AdAdmissionApplication> find(AdAcademicSession session, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession
                .createQuery("select p from AdAdmissionApplication p where " + "p.session = :session ");
        query.setEntity("session", session);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdAdmissionApplication>) query.list();
    }

    @Override
    public List<AdAdmissionApplication> find(String filter, AdAcademicSession session, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery(
                "select p from AdAdmissionApplication p where " + "(upper(p.referenceNo) like upper(:filter) or "
                        + "upper(p.description) like upper(:filter)) " + "and p.session = :session ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdAdmissionApplication>) query.list();
    }

    @Override
    public List<AdAdmissionApplication> find(String filter, AdAcademicSession session, AdStudent student,
                                             Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from AdAdmissionApplication p where "
                + "(upper(p.referenceNo) like upper(:filter) or " + "upper(p.description) like upper(:filter)) "
                + "and p.session = :session " + "and p.student = :student");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setEntity("student", student);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdAdmissionApplication>) query.list();
    }

    @Override
    public List<AdAdmissionApplication> find(String filter, AdAcademicSession session, AdStaff advisor, Integer offset,
                                             Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from AdAdmissionApplication p where "
                + "(upper(p.referenceNo) like upper(:filter) or " + "upper(p.description) like upper(:filter)) "
                + "and p.session = :session " + "and p.advisor = :advisor");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setEntity("advisor", advisor);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdAdmissionApplication>) query.list();
    }

    @Override
    public List<AdAdmissionApplication> findByFlowState(AdFlowState flowState) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdAdmissionApplication p where " +
                "p.flowdata.state = :flowState " +
                "and p.metadata.state = :metaState");
        query.setInteger("flowState", flowState.ordinal());
        query.setInteger("metaState", AdMetaState.ACTIVE.ordinal());
        return (List<AdAdmissionApplication>) query.list();
    }

    @Override
    public List<AdAdmissionApplication> findByFlowStates(AdFlowState... flowStates) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdAdmissionApplication p where " +
                "p.flowdata.state in (:flowStates) " +
                "and p.metadata.state = :metaState");
        query.setParameterList("flowStates", flowStates);
        query.setInteger("metaState", AdMetaState.ACTIVE.ordinal());
        return (List<AdAdmissionApplication>) query.list();
    }

    @Override
    public Integer count(AdAcademicSession session) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession
                .createQuery("select count(p) from AdAdmissionApplication p " + "where p.session = :session");
        query.setEntity("session", session);
        return (Integer) query.uniqueResult();
    }

    @Override
    public Integer count(String filter, AdAcademicSession session) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from AdAdmissionApplication p " + "where "
                + "(upper(p.referenceNo) like upper(:filter) or " + "upper(p.description) like upper(:filter)) "
                + "and p.session = :session");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdAcademicSession session, AdStudent student) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from AdAdmissionApplication p " + "where "
                + "(upper(p.referenceNo) like upper(:filter) or " + "upper(p.description) like upper(:filter)) "
                + "and p.session = :session " + "and p.student = :student");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setEntity("student", student);
        return ((Long) query.uniqueResult()).intValue();
    }
    
    @Override
	public Integer count(AdAcademicSession session, AdStudent student) {
    	Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from AdAdmissionApplication p " + "where "
                + "p.session = :session " + "and p.student = :student");
        query.setEntity("session", session);
        query.setEntity("student", student);
        return ((Long) query.uniqueResult()).intValue();
	}

    @Override
    public Integer count(String filter, AdAcademicSession session, AdStaff staff) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from AdAdmissionApplication p " + "where "
                + "(upper(p.referenceNo) like upper(:filter) or " + "upper(p.description) like upper(:filter)) "
                + "and p.session = :session " + "and p.advisor = :advisor");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setEntity("advisor", staff);
        return ((Long) query.uniqueResult()).intValue();

    }

	//update admission application in advisory
	 public void updateAdmissionApplication(AdStudent student, AdAdmissionApplication application, AdAdmission admission, AdUser currentUser) {
	        Validate.notNull(currentUser, "User cannot be null");
	        Validate.notNull(application, "application cannot be null");
	        Validate.notNull(admission, "admission cannot be null");
	        Session session = sessionFactory.getCurrentSession();
	        application.setStudent(student);
	        
	        System.out.println("student update advisor: " + student.getName());
	        
	        // prepare metadata
	        AdMetadata metadata = application.getMetadata();
	        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
	        metadata.setModifierId(currentUser.getId());
	        application.setMetadata(metadata);
	        session.update(application);
	    }

	@Override
	public void updateAdmissionApplication(AdStudent student, AdAdmissionApplication application, AdUser currentUser) {
		 Validate.notNull(currentUser, "User cannot be null");
	        Validate.notNull(application, "application cannot be null");
	        Session session = sessionFactory.getCurrentSession();
	        application.setStudent(student);
	        
	        System.out.println("student update advisor: " + student);
	        

	        // prepare metadata
	        AdMetadata metadata = application.getMetadata();
	        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
	        metadata.setModifierId(currentUser.getId());
	        application.setMetadata(metadata);
	        session.update(application);
		
	}

	

}
