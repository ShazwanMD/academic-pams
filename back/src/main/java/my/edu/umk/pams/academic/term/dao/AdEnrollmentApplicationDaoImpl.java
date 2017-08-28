package my.edu.umk.pams.academic.term.dao;


import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationImpl;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItem;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItemImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author PAMS
 */
@Repository("adEnrollmentApplicationDao")
public class AdEnrollmentApplicationDaoImpl extends GenericDaoSupport<Long, AdEnrollmentApplication> implements AdEnrollmentApplicationDao {

    public AdEnrollmentApplicationDaoImpl() {
        super(AdEnrollmentApplicationImpl.class);
    }

    @Override
    public AdEnrollmentApplication findByReferenceNo(String referenceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdEnrollmentApplication p " +
                "where p.referenceNo = :referenceNo ");
        query.setString("referenceNo", referenceNo);
        return (AdEnrollmentApplication) query.uniqueResult();
    }

    @Override
    public AdEnrollmentApplicationItem findItemById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (AdEnrollmentApplicationItem) session.get(AdEnrollmentApplicationItemImpl.class, id);
    }

    @Override
    public AdEnrollmentApplicationItem findItemBySection(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdEnrollmentApplicationItem p " +
                "where p.section = :section ");
        query.setEntity("section", section);
        return (AdEnrollmentApplicationItem) query.uniqueResult();

        // return (AdEnrollmentApplicationItem) session.get(AdEnrollmentApplicationItemImpl.class, section);
    }

    @Override
    public List<AdEnrollmentApplication> find(AdAcademicSession session) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from AdEnrollmentApplication p where " +
                "p.session = :session ");
        query.setEntity("session", session);
        return (List<AdEnrollmentApplication>) query.list();
    }

    @Override
    public List<AdEnrollmentApplication> find(AdAcademicSession session, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from AdEnrollmentApplication p where " +
                "p.session = :session ");
        query.setEntity("session", session);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdEnrollmentApplication>) query.list();
    }

    @Override
    public List<AdEnrollmentApplication> find(String filter, AdAcademicSession session, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from AdEnrollmentApplication p where " +
                "(upper(p.referenceNo) like upper(:filter) or " +
                "upper(p.description) like upper(:filter)) " +
                "and p.session = :session ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdEnrollmentApplication>) query.list();
    }

    @Override
    public List<AdEnrollmentApplication> find(String filter, AdAcademicSession session, AdStudent student, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from AdEnrollmentApplication p where " +
                "(upper(p.referenceNo) like upper(:filter) or " +
                "upper(p.description) like upper(:filter)) " +
                "and p.session = :session " +
                "and p.student = :student");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setEntity("student", student);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdEnrollmentApplication>) query.list();
    }

    @Override
    public List<AdEnrollmentApplication> find(String filter, AdAcademicSession session, AdStaff advisor, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from AdEnrollmentApplication p where " +
                "(upper(p.referenceNo) like upper(:filter) or " +
                "upper(p.description) like upper(:filter)) " +
                "and p.session = :session " +
                "and p.advisor = :advisor");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setEntity("advisor", advisor);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdEnrollmentApplication>) query.list();
    }

   /* @Override
    public List<AdEnrollmentApplication> findByFlowState(AdFlowState flowState) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdEnrollmentApplication p where " +
                "p.flowdata.state = :flowState " +
                "and p.metadata.state = :metaState");
        query.setInteger("flowState", flowState.ordinal());
        query.setInteger("metaState", AdMetaState.ACTIVE.ordinal());
        return (List<AdEnrollmentApplication>) query.list();
    }

    @Override
    public List<AdEnrollmentApplication> findByFlowStates(AdFlowState... flowStates) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdEnrollmentApplication p where " +
                "p.flowState.state in (:flowStates) " +
                "and p.metaState.state = :metaState");
        query.setParameterList("flowStates", flowStates);
        query.setInteger("metaState", AdMetaState.ACTIVE.ordinal());
        return (List<AdEnrollmentApplication>) query.list();
    }*/
    
    //sample to delete
    @Override
    public List<AdEnrollmentApplication> findByFlowState(AdFlowState flowState) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdEnrollmentApplication p where " +
                "p.flowdata.state = :flowState " +
                "and p.metadata.state = :metaState");
        query.setInteger("flowState", flowState.ordinal());
        query.setInteger("metaState", AdMetaState.ACTIVE.ordinal());
        return (List<AdEnrollmentApplication>) query.list();
    }

    @Override
    public List<AdEnrollmentApplication> findByFlowStates(AdFlowState... flowStates) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdEnrollmentApplication p where " +
                "p.flowdata.state in (:flowStates) " +
                "and p.metadata.state = :metaState");
        query.setParameterList("flowStates", flowStates);
        query.setInteger("metaState", AdMetaState.ACTIVE.ordinal());
        return (List<AdEnrollmentApplication>) query.list();
    }
    //sample nd
    

    @Override
    public List<AdEnrollmentApplicationItem> findItems(AdEnrollmentApplication application) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from AdEnrollmentApplicationItem p where " +
                "p.application = :application ");
        query.setEntity("application", application);
        return (List<AdEnrollmentApplicationItem>) query.list();
    }

    @Override
    public List<AdEnrollmentApplicationItem> findItems(AdEnrollmentApplication application, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from AdEnrollmentApplicationItem p where " +
                "p.intake = :intake ");
        query.setEntity("intake", application);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdEnrollmentApplicationItem>) query.list();
    }

    @Override
    public Integer count(AdAcademicSession session) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from AdEnrollmentApplication p " +
                "where p.session = :session");
        query.setEntity("session", session);
        return (Integer) query.uniqueResult();
    }

    @Override
    public Integer count(String filter, AdAcademicSession session) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from AdEnrollmentApplication p " +
                "where " +
                "(upper(p.referenceNo) like upper(:filter) or " +
                "upper(p.description) like upper(:filter)) " +
                "and p.session = :session");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdAcademicSession session, AdStudent student) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from AdEnrollmentApplication p " +
                "where " +
                "(upper(p.referenceNo) like upper(:filter) or " +
                "upper(p.description) like upper(:filter)) " +
                "and p.session = :session " +
                "and p.student = :student");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setEntity("student", student);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdAcademicSession session, AdStaff advisor) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from AdEnrollmentApplication p " +
                "where " +
                "(upper(p.referenceNo) like upper(:filter) or " +
                "upper(p.description) like upper(:filter)) " +
                "and p.session = :session " +
                "and p.advisor = :advisor");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setEntity("advisor", advisor);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public void addItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item, AdUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(item, "Item cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        item.setApplication(application);

        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(AdMetaState.ACTIVE);
        item.setMetadata(metadata);
        session.save(item);
    }

    @Override
    public void updateItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item, AdUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(item, "Item cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        item.setApplication(application);

        AdMetadata metadata = item.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        metadata.setState(AdMetaState.ACTIVE);
        item.setMetadata(metadata);
        session.update(item);
    }

    @Override
    public void deleteItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item, AdUser user) {
        Validate.notNull(application, "Application cannot be null");
        Validate.notNull(item, "Item cannot be null");
        Validate.notNull(user, "User cannot be null");

        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
    }

    @Override
    public List<AdEnrollmentApplication> find(AdAdmission admission) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollmentApplication s where " +
                "s.admission = :admission " +
                "and s.metadata.state = :state " +
                "order by s.id desc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("admission", admission);
        query.setCacheable(true);
        return (List<AdEnrollmentApplication>) query.list();
    }

	 @Override
	    public Integer count(AdAdmission admission) {
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("select count(s) from AdEnrollmentApplication s where " +
	                "s.admission = :admission " +
	                "and s.metadata.state = :state ");
	        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
	        query.setEntity("admission", admission);
	        return ((Long) query.uniqueResult()).intValue();
	    }


}
