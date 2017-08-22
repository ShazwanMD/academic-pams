package my.edu.umk.pams.academic.identity.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.*;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.term.model.AdAdmission;

import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * todo(ihsan): finish up
 * 
 * @author PAMS
 */
@SuppressWarnings({ "unchecked" })
@Repository("studentDao")
public class AdStudentDaoImpl extends GenericDaoSupport<Long, AdStudent> implements AdStudentDao {

	public AdStudentDaoImpl() {
		super(AdStudentImpl.class);
	}

	@Override
	public AdStudent findByStudentNo(String studentNo) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select a from AdStudent a where " + "a.identityNo = :identityNo");
		query.setString("identityNo", studentNo);
		return (AdStudent) query.uniqueResult();
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/* Find by ID */
	/*
	 * =========================================================================
	 * ===================
	 */
	@Override
	public AdAddress findAddressById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (AdAddress) session.get(AdAddressImpl.class, id);
	}

	@Override
	public AdGuarantor findGuarantorById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (AdGuarantor) session.get(AdGuarantorImpl.class, id);
	}

	@Override
	public AdGuardian findGuardianById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (AdGuardian) session.get(AdGuardianImpl.class, id);
	}

	@Override
	public AdContact findContactById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (AdContact) session.get(AdContactImpl.class, id);
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/* Find by Type */
	/*
	 * =========================================================================
	 * ===================
	 */
	@Override
	public AdGuarantor findGuarantorByType(AdGuarantorType type, AdStudent student) {
		return null;
	}

	@Override
	public AdGuardian findGuardianByType(AdGuardianType guardianType, AdStudent student) {
		return null;
	}

	@Override
	public AdContact findContactByType(AdContactType type, AdStudent student) {
		return null;
	}

	@Override
	public AdAddress findAddressByType(AdAddressType type, AdStudent student) {
		return null;
	}

	@Override
	public Integer count(String filter) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("select count(s) from AdStudent s where " + "(upper(s.identityNo) like upper(:filter) " +

						"or upper(s.name) like upper(:filter)) " + "and s.metadata.state = :state ");
		query.setString("filter", WILDCARD + filter + WILDCARD);
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		return ((Long) query.uniqueResult()).intValue();
	}

	@Override
	public Integer countAddress(AdStudent student) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"select count(s) from AdAddress s where" + "s.student = : student" + "and s.metadata.state = :state");
		query.setEntity("student", student);
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		return (Integer) query.uniqueResult();
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/* Listing All - Guardian/Guarantor/Contact/Address by Student MatricNo */
	/*
	 * =========================================================================
	 * ===================
	 */
	@Override
	public List<AdGuarantor> findGuarantors(AdStudent student) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"select o from AdGuarantor o where " + "o.student = :student " + "and o.metadata.state = :state");
		query.setEntity("student", student);
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		return query.list();
	}

	@Override
	public List<AdGuardian> findGuardians(AdStudent student) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"select o from AdGuardian o where " + "o.student = :student " + "and o.metadata.state = :state");
		query.setEntity("student", student);
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		return query.list();
	}

	@Override
	public List<AdContact> findContacts(AdStudent student) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"select o from AdContact o where " + "o.student = :student " + "and o.metadata.state = :state");
		query.setEntity("student", student);
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		return query.list();
	}

	@Override
	public List<AdAddress> findAddresses(AdStudent student) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"select o from AdAddress o where " + "o.student = :student " + "and o.metadata.state = :state");
		query.setEntity("student", student);
		query.setInteger("state", AdMetaState.ACTIVE.ordinal());
		return query.list();
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/*
	 * ADD/UPDATE/DELETE - GUARDIAN
	 * /*=======================================================================
	 * =====================
	 */
	@Override
	public void addGuardian(AdStudent student, AdGuardian guardian, AdUser user) {
		Validate.notNull(user, "User cannot be null");
		Validate.notNull(student, "student cannot be null");
		Validate.notNull(guardian, "guardian cannot be null");
		Session session = sessionFactory.getCurrentSession();
		guardian.setStudent(student);
		// prepare metadata
		AdMetadata metadata = new AdMetadata();
		metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		metadata.setCreatorId(user.getId());
		metadata.setState(AdMetaState.ACTIVE);
		guardian.setMetadata(metadata);
		session.save(guardian);

	}

	@Override
	public void updateGuardian(AdStudent student, AdGuardian guardian, AdUser user) {
		Validate.notNull(user, "User cannot be null");
		Validate.notNull(guardian, "guarantor cannot be null");
		Session session = sessionFactory.getCurrentSession();
		guardian.setStudent(student);

		// prepare metadata
		AdMetadata metadata = guardian.getMetadata();
		metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		metadata.setModifierId(user.getId());
		guardian.setMetadata(metadata);
		session.update(guardian);

	}

	@Override
	public void deleteGuardian(AdStudent student, AdGuardian guardian, AdUser user) {
		Validate.notNull(user, "User cannot be null");
		Session session = sessionFactory.getCurrentSession();
		guardian.setStudent(student);

		// prepare metadata
		AdMetadata metadata = guardian.getMetadata();
		metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
		metadata.setDeleterId(user.getId());
		metadata.setState(AdMetaState.INACTIVE);
		guardian.setMetadata(metadata);
		session.update(guardian);
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/*
	 * ADD/UPDATE/DELETE - GUARANTOR
	 * /*=======================================================================
	 * =====================
	 */
	@Override
	public void addGuarantor(AdStudent student, AdGuarantor guarantor, AdUser user) {
		Validate.notNull(user, "User cannot be null");
		Validate.notNull(student, "student cannot be null");
		Validate.notNull(guarantor, "guarantor cannot be null");
		Session session = sessionFactory.getCurrentSession();
		guarantor.setStudent(student);
		// prepare metadata
		AdMetadata metadata = new AdMetadata();
		metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		metadata.setCreatorId(user.getId());
		metadata.setState(AdMetaState.ACTIVE);
		guarantor.setMetadata(metadata);
		session.save(guarantor);

	}

	public void updateGuarantor(AdStudent student, AdGuarantor guarantor, AdUser user) {
		Validate.notNull(user, "User cannot be null");
		Validate.notNull(guarantor, "guarantor cannot be null");
		Session session = sessionFactory.getCurrentSession();
		guarantor.setStudent(student);

		// prepare metadata
		AdMetadata metadata = guarantor.getMetadata();
		metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		metadata.setModifierId(user.getId());
		guarantor.setMetadata(metadata);
		session.update(guarantor);
	}

	@Override
	public void deleteGuarantor(AdStudent student, AdGuarantor guarantor, AdUser user) {
		Validate.notNull(user, "User cannot be null");
		Session session = sessionFactory.getCurrentSession();
		guarantor.setStudent(student);

		// prepare metadata
		AdMetadata metadata = guarantor.getMetadata();
		metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
		metadata.setDeleterId(user.getId());
		metadata.setState(AdMetaState.INACTIVE);
		guarantor.setMetadata(metadata);
		session.update(guarantor);
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/*
	 * ADD/UPDATE/DELETE - CONTACT
	 * /*=======================================================================
	 * =====================
	 */
	@Override
	public void addContact(AdStudent student, AdContact contact, AdUser user) {
		Validate.notNull(user, "User cannot be null");
		Validate.notNull(student, "Faculty cannot be null");
		Validate.notNull(contact, "section cannot be null");
		Session session = sessionFactory.getCurrentSession();
		contact.setStudent(student);
		// prepare metadata
		AdMetadata metadata = new AdMetadata();
		metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		metadata.setCreatorId(user.getId());
		metadata.setState(AdMetaState.ACTIVE);
		contact.setMetadata(metadata);
		session.save(contact);

	}

	@Override
	public void updateContact(AdStudent student, AdContact contact, AdUser user) {
		Validate.notNull(user, "User cannot be null");
		Validate.notNull(contact, "Address cannot be null");
		Session session = sessionFactory.getCurrentSession();
		contact.setStudent(student);

		// prepare metadata
		AdMetadata metadata = contact.getMetadata();
		metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		metadata.setModifierId(user.getId());
		contact.setMetadata(metadata);
		session.update(contact);
	}

	@Override
	public void deleteContact(AdStudent student, AdContact contact, AdUser user) {
		Validate.notNull(user, "User cannot be null");
		Session session = sessionFactory.getCurrentSession();
		contact.setStudent(student);

		// prepare metadata
		AdMetadata metadata = contact.getMetadata();
		metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
		metadata.setDeleterId(user.getId());
		metadata.setState(AdMetaState.INACTIVE);
		contact.setMetadata(metadata);
		session.update(contact);
	}

	/*
	 * =========================================================================
	 * ===================
	 */
	/*
	 * ADD/UPDATE/DELETE - ADDRESS
	 * /*=======================================================================
	 * =====================
	 */
	@Override
	public void addAddress(AdStudent student, AdAddress address, AdUser user) {
		Validate.notNull(user, "User cannot be null");
		Validate.notNull(student, "student cannot be null");
		Validate.notNull(address, "address cannot be null");
		Session session = sessionFactory.getCurrentSession();
		address.setStudent(student);

		// prepare metadata
		AdMetadata metadata = new AdMetadata();
		metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		metadata.setCreatorId(user.getId());
		metadata.setState(AdMetaState.ACTIVE);
		address.setMetadata(metadata);
		session.save(address);
	}

	public void updateAddress(AdStudent student, AdAddress address, AdUser user) {
		Validate.notNull(user, "User cannot be null");
		Validate.notNull(address, "Address cannot be null");
		Session session = sessionFactory.getCurrentSession();
		address.setStudent(student);

		// prepare metadata
		AdMetadata metadata = address.getMetadata();
		metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		metadata.setModifierId(user.getId());
		address.setMetadata(metadata);
		session.update(address);
	}

	@Override
	public void deleteAddress(AdStudent student, AdAddress address, AdUser user) {
		Validate.notNull(user, "User cannot be null");
		Session session = sessionFactory.getCurrentSession();
		address.setStudent(student);

		// prepare metadata
		AdMetadata metadata = address.getMetadata();
		metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
		metadata.setDeleterId(user.getId());
		metadata.setState(AdMetaState.INACTIVE);
		address.setMetadata(metadata);
		session.update(address);
	}

	@Override
	public AdAdmission findAdmissionByAcademicSessionAndStudent(AdAcademicSession academicSession, AdStudent student) {
		
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdAdmission o where "
                + "o.session = :session "
                + "and o.student = :student " + "and o.metadata.state = :state");
        query.setEntity("session", academicSession);
        query.setEntity("student", student);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdAdmission) query.uniqueResult();
	}
}