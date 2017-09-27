package my.edu.umk.pams.academic.term.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.model.AdAdmissionImpl;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import org.apache.commons.lang.Validate;
import java.sql.Timestamp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PAMS
 */
@Repository("adAdmissionDao")
public class AdAdmissionDaoImpl extends GenericDaoSupport<Long, AdAdmission> implements AdAdmissionDao {

	public AdAdmissionDaoImpl() {
		super(AdAdmissionImpl.class);
	}

	@Override
	public AdAdmission findBySessionCohortAndStudent(AdAcademicSession academicSession, AdCohort cohort,
			AdStudent student) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select o from AdAdmission o where " + "o.session = :session "
				+ "and o.cohort = :cohort " + "and o.student = :student " + "and o.metadata.state = :state");
		query.setEntity("session", academicSession);
		query.setEntity("cohort", cohort);
		query.setEntity("student", student);
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		return (AdAdmission) query.setMaxResults(1).uniqueResult();
	}

	@Override
	public AdAdmission findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("select o from AdAdmission o where " + "o.id = :id " + "and o.metadata.state = :state");
		query.setLong("id", id);
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		return (AdAdmission) query.uniqueResult();
	}

	// ====================================================================================================
	// FINDER
	// ====================================================================================================
	@Override
	public List<AdAdmission> findByProgramAndStudent(AdProgram program, AdStudent student) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s from AdAdmission s where " + "s.program = :program "
				+ "and s.student = :student " + "and s.metadata.state = :state " + "order by s.session.code asc");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("program", program);
		query.setEntity("student", student);
		query.setCacheable(true);
		return (List<AdAdmission>) query.list();
	}

	@Override
	public List<AdAdmission> find(AdAcademicSession academicSession) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s from AdAdmission s where " + "s.session = :academicSession "
				+ "and s.metadata.state = :state " + "order by s.student.name asc");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("academicSession", academicSession);
		query.setCacheable(true);
		return (List<AdAdmission>) query.list();
	}

	@Override
	public List<AdAdmission> find(AdProgram program) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s from AdAdmission s where " + "s.program = :program "
				+ "and s.metadata.state = :state " + "order by s.student.name asc");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("program", program);
		query.setCacheable(true);
		return (List<AdAdmission>) query.list();
	}

	@Override
	public List<AdAdmission> find(AdStudent student) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s from AdAdmission s where " + "s.student = :student "
				+ "and s.metadata.state = :state " + "order by s.session.code desc");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("student", student);
		query.setCacheable(true);
		return (List<AdAdmission>) query.list();
	}

	@Override
	public List<AdAdmission> find(AdAcademicSession academicSession, AdStudent student) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"select s from AdAdmission s where " + "s.student = :student " + "and s.session = :academicSession "
						+ "and s.metadata.state = :state " + "order by s.session.code asc");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("student", student);
		query.setEntity("academicSession", academicSession);
		query.setCacheable(true);
		return (List<AdAdmission>) query.list();
	}

	@Override
	public List<AdAdmission> find(AdStudent student, Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s from AdAdmission s where " + "s.student = :student "
				+ "and s.metadata.state = :state " + "order by s.student.name asc");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("student", student);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		query.setCacheable(true);
		return (List<AdAdmission>) query.list();
	}

	@Override
	public List<AdAdmission> find(String filter, AdStudent student, Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s from AdAdmission s where " + "s.student = :student "
				+ "and (upper(s.program.code) like upper(:filter) " + "or upper(s.program.title) like upper(:filter)) "
				+ "and s.metadata.state = :state " + "order by s.student.name asc");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("student", student);
		query.setString("filter", WILDCARD + filter + WILDCARD);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		query.setCacheable(true);
		return (List<AdAdmission>) query.list();
	}

	@Override
	public List<AdAdmission> find(String filter, AdStudent student, AdAcademicSession academicSession, Integer offset,
			Integer limit) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s from AdAdmission s where " + "s.student = :student "
				+ "and (upper(s.program.code) like upper(:filter) " + "or upper(s.program.title) like upper(:filter)) "
				+ "and s.session = :academicSession " + "and s.metadata.state = :state "
				+ "order by s.student.name asc");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("student", student);
		query.setEntity("academicSession", academicSession);
		query.setString("filter", WILDCARD + filter + WILDCARD);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		query.setCacheable(true);
		return (List<AdAdmission>) query.list();
	}

	@Override
	public List<AdAdmission> find(AdProgram program, Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s from AdAdmission s where " + "s.program = :program "
				+ "and s.metadata.state = :state " + "order by s.student.name asc");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("program", program);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		query.setCacheable(true);
		return (List<AdAdmission>) query.list();
	}

	@Override
	public List<AdAdmission> find(String filter, AdProgram program, Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s from AdAdmission s where " + "s.program = :program "
				+ "and (upper(s.student.identityNo) like upper(:filter) "
				+ "or upper(s.student.credentialNo) like upper(:filter) "
				+ "or upper(s.student.email) like upper(:filter) " + "or upper(s.student.name) like upper(:filter)) "
				+ "and s.metadata.state = :state " + "order by s.student.name asc");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("program", program);
		query.setString("filter", WILDCARD + filter + WILDCARD);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		query.setCacheable(true);
		return (List<AdAdmission>) query.list();
	}

	@Override
	public List<AdStudent> findStudents(AdProgram program) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s.student from AdAdmission s where " + "s.program = :program "
				+ "and s.metadata.state = :state " + "order by s.student.name asc");
		query.setEntity("program", program);
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setCacheable(true);
		return (List<AdStudent>) query.list();
	}

	@Override
	public List<AdStudent> findStudents(AdProgram program, Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s.student from AdAdmission s where " + "s.program = :program "
				+ "and s.metadata.state = :state " + "order by s.student.name asc");
		query.setEntity("program", program);
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		query.setCacheable(true);
		return (List<AdStudent>) query.list();
	}
	
	 @Override
	    public List<AdAdmission> find(AdStaff staff) {
	        Session currentSession = sessionFactory.getCurrentSession();
	        Query query = currentSession
	                .createQuery("select p from AdAdmission p where " + "p.advisor = :staff ");
	        query.setEntity("staff", staff);
	        return (List<AdAdmission>) query.list();
	    }

	// ====================================================================================================
	// HELPER
	// ====================================================================================================

	@Override
	public Integer count(AdProgram program) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(s) from AdAdmission s where " + "s.program = :program "
				+ "and s.metadata.state = :state ");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("program", program);
		return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public Integer count(String filter, AdProgram program) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(s) from AdAdmission s where " + "s.program = :program "
				+ "and (upper(s.student.identityNo) like upper(:filter) "
				+ "or upper(s.student.credentialNo) like upper(:filter) "
				+ "or upper(s.student.email) like upper(:filter) " + "or upper(s.student.name) like upper(:filter)) "
				+ "and s.metadata.state = :state ");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("program", program);
		query.setString("filter", WILDCARD + filter + WILDCARD);
		query.setCacheable(true);
		return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public Integer count(AdStudent student) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(s) from AdAdmission s where " + "s.student = :student "
				+ "and s.metadata.state = :state ");
		query.setEntity("student", student);
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public Integer count(String filter, AdStudent student) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(s) from AdAdmission s where " + "s.student = :student "
				+ "and (upper(s.program.code) like upper(:filter) " + "or upper(s.program.title) like upper(:filter)) "
				+ "and s.metadata.state = :state ");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("student", student);
		query.setString("filter", WILDCARD + filter + WILDCARD);
		query.setCacheable(true);
		return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public Integer countStudent(AdProgram program) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(s) from AdAdmission s where " + "s.program = :program "
				+ "and s.metadata.state = :state ");
		query.setEntity("program", program);
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public boolean isExists(AdProgram program, AdStudent student) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*) from AdAdmission s where " + "s.student = :student "
				+ "and s.program = :program " + "and s.metadata.state = :state ");
		query.setEntity("student", student);
		query.setEntity("program", program);
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		return 0 < ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public boolean hasAdmission(AdProgram program) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*) from AdAdmission s where " + "s.program = :program "
				+ "and s.metadata.state = :state ");
		query.setEntity("program", program);
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		return 0 < ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public Integer count(String filter, AdStudent student, AdAcademicSession academicSession) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(s) from AdAdmission s where " + "s.student = :student "
				+ "and s.session = :academicSession " + "and (upper(s.program.code) like upper(:filter) "
				+ "or upper(s.program.title) like upper(:filter)) " + "and s.metadata.state = :state ");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("student", student);
		query.setEntity("academicSession", academicSession);
		query.setString("filter", WILDCARD + filter + WILDCARD);
		query.setCacheable(true);
		return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public Integer count(AdAcademicSession academicSession, AdStudent student) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(s) from AdAdmission s where " + "s.student = :student "
				+ "and s.session = :academicSession " + "and s.metadata.state = :state ");
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		query.setEntity("student", student);
		query.setEntity("academicSession", academicSession);
		query.setCacheable(true);
		return ((Long) query.uniqueResult()).intValue();

	}

	@Override
	public void removeEnrollmentApplication(AdAdmission admission, AdEnrollmentApplication application, AdUser user) {
		// todo(syikin) Please implement or remove contract
	}
 
	@Override
	public void updateAdmission(AdStudent student, AdAdmission admission, AdUser currentUser) {
		Validate.notNull(currentUser, "User cannot be null");
		Validate.notNull(admission, "admission cannot be null");
		Session session = sessionFactory.getCurrentSession();
		admission.setStudent(student);

		System.out.println("student update advisor: " + student.getName());

		// prepare metadata
		AdMetadata metadata = admission.getMetadata();
		metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		metadata.setModifierId(currentUser.getId());
		admission.setMetadata(metadata);
		session.update(admission);

	}
}
