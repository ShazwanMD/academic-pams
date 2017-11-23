package my.edu.umk.pams.academic.common.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import my.edu.umk.pams.academic.common.model.AdCampus;
import my.edu.umk.pams.academic.common.model.AdCampusImpl;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.planner.model.AdFaculty;

@Repository("campusDao")
public class AdCampusDaoImpl extends GenericDaoSupport<Long, AdCampus> implements AdCampusDao {
	

	 private static final Logger LOG = LoggerFactory.getLogger(AdCampusDaoImpl.class);
	 
	public AdCampusDaoImpl() {
		super(AdCampusImpl.class);
	}
	
	 @Override
	    public AdCampus findByCode(String code) {
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("select s from AdCampus s where s.code = :code and  " +
	                " s.metadata.state = :state");
	        query.setString("code", code);
	        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
	        query.setCacheable(true);
	        return (AdCampus) query.uniqueResult();
	    }
	 
	 @Override
	    public AdCampus findByFacultyCode(AdFaculty facultyCode) {
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("select s from AdFaculty s where s.code = :code and  " +
	                " s.metadata.state = :state");
	        query.setEntity("code", facultyCode);
	        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
	        query.setCacheable(true);
	        return (AdCampus) query.uniqueResult();
	    }

	@Override
	public List<AdCampus> find(String filter, Integer offset, Integer limit) {
       Session session = sessionFactory.getCurrentSession();
       Query query = session.createQuery("select s from AdCampus s where " +
               "(upper(s.code) like upper(:filter) " +
               "or upper(s.descriptionEn) like upper(:filter) " +
               "or upper(s.descriptionMs) like upper(:filter)) " +
               "and s.metadata.state = :state ");
       query.setString("filter", WILDCARD + filter + WILDCARD);
       query.setInteger("state", AdMetaState.ACTIVE.ordinal());
       query.setFirstResult(offset);
       query.setMaxResults(limit);
       query.setCacheable(true);
       return (List<AdCampus>) query.list();
	}

	@Override
	public Integer count(String filter) {
		return null;
	}

	@Override
	public boolean isExists(String code) {
       Session session = sessionFactory.getCurrentSession();
       Query query = session.createQuery("select count(*) from AdCampus s where " +
               "s.code = :code " +
               "and s.metadata.state = :state ");
       query.setString("code", code);
       query.setInteger("state", AdMetaState.ACTIVE.ordinal());
       return 0 < ((Long) query.uniqueResult()).intValue();
	}


}
