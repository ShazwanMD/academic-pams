package my.edu.umk.pams.academic.graduation.dao;

import my.edu.umk.pams.academic.core.AdFlowState;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.graduation.model.AdGraduation;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplicationImpl;
import my.edu.umk.pams.academic.graduation.model.AdGraduationImpl;
import my.edu.umk.pams.academic.identity.model.AdGuarantor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PAMS
 */
@Repository("adGraduationDao")
public class AdGraduationDaoImpl extends GenericDaoSupport<Long, AdGraduation> implements AdGraduationDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdGraduationDaoImpl.class);

    public AdGraduationDaoImpl() {
        super(AdGraduationImpl.class);
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public List<AdGraduation> find(AdStudent student) {
        Session session = sessionFactory.getCurrentSession();
        
        Query query = session.createQuery("select a from AdGraduation a where " +
        "a.student = :student "+
        "and a.metadata.state = :state");
        query.setEntity("student", student);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (List<AdGraduation>) query.list();
    }
    
    @Override
    public List<AdGraduation> find(AdAcademicSession academicSession) {
        Session session = sessionFactory.getCurrentSession();
        
        Query query = session.createQuery("select a from AdGraduation a where " +
        "a.session = :academicSession "+
        "and a.metadata.state = :state");
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (List<AdGraduation>) query.list();
    }
   
    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    
    @Override
	public Integer count(AdAcademicSession session, AdStudent student) {
    	Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from AdGraduation p " + "where "
                + "p.session = :session " + "and p.student = :student");
        query.setEntity("session", session);
        query.setEntity("student", student);
        return ((Long) query.uniqueResult()).intValue();
	}
	
	
	
}
