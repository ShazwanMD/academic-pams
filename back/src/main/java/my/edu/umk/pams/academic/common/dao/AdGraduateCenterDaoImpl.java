package my.edu.umk.pams.academic.common.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import my.edu.umk.pams.academic.common.model.AdGraduateCenter;
import my.edu.umk.pams.academic.common.model.AdGraduateCenterImpl;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.planner.model.AdFaculty;

@Repository("graduateCenterDao")
public class AdGraduateCenterDaoImpl extends GenericDaoSupport<Long, AdGraduateCenter> implements AdGraduateCenterDao {

	 private static final Logger LOG = LoggerFactory.getLogger(AdGraduateCenterDaoImpl.class);
	 
	public AdGraduateCenterDaoImpl() {
		super(AdGraduateCenterImpl.class);
	}
	
	 @Override
	    public AdGraduateCenter findByCode(String code) {
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("select s from AdGraduateCenter s where s.code = :code and  " +
	                " s.metadata.state = :state");
	        query.setString("code", code);
	        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
	        query.setCacheable(true);
	        return (AdGraduateCenter) query.uniqueResult();
	    }
	 
	 @Override
	    public AdGraduateCenter findByFacultyCode(AdFaculty facultyCode) {
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("select s from AdFaculty s where s.code = :code and  " +
	                " s.metadata.state = :state");
	        query.setEntity("code", facultyCode);
	        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
	        query.setCacheable(true);
	        return (AdGraduateCenter) query.uniqueResult();
	    }

	@Override
	public List<AdGraduateCenter> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGraduateCenter s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.descriptionEn) like upper(:filter) " +
                "or upper(s.descriptionMs) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdGraduateCenter>) query.list();
	}

	@Override
	public Integer count(String filter) {
		return null;
	}

	@Override
	public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdGraduateCenter s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue() >= 1;
	}



}
