package my.edu.umk.pams.academic.identity.dao;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStaffImpl;
import my.edu.umk.pams.academic.identity.model.AdStaffType;
import my.edu.umk.pams.academic.planner.model.AdFaculty;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author team canang
 * @since 6/6/2015.
 */
@Repository("staffDao")
public class AdStaffDaoImpl extends GenericDaoSupport<Long, AdStaff> implements AdStaffDao {

    public AdStaffDaoImpl() {
        super(AdStaffImpl.class);
    }

    @Override
    public AdStaff findByStaffNo(String staffNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdStaff p where " +
                "p.identityNo = :identityNo ");
        query.setString("identityNo", staffNo);
        return (AdStaff) query.uniqueResult();
    }
    
    @Override
    public AdStaff findByIdentityNo(String identityNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdStaff p where " +
                "p.identityNo = :identityNo ");
        query.setString("identityNo", identityNo);
        return (AdStaff) query.uniqueResult();
    }

    @Override
    public AdStaff findByNricNo(String nricNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdStaff p where " +
                "p.identityNo= :nricNo "); // TODO: fix this
        query.setString("nricNo", nricNo);
        return (AdStaff) query.uniqueResult();
    }

    @Override
    public AdStaff findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdStaff p where " +
                "p.email = :email ");
        query.setString("email", email);
        return (AdStaff) query.uniqueResult();
    }

    @Override
    public AdStaff findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdStaff p where " +
                "p.name = :name ");
        query.setString("name", name);
        return (AdStaff) query.uniqueResult();
    }

    @Override
    public List<AdStaff> find(AdStaffType type, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdStaff s where " +
                "s.staffType = :staffType " +
                "order by s.name asc ");
        query.setInteger("staffType", type.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }
    
    @Override
    public List<AdStaff> findAcademicStaffByFaculty(AdStaffType type,AdFaculty faculty, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdStaff s where " +
                "s.staffType = :staffType " +
                "and s.faculty = :faculty " +
                "order by s.name asc ");
        query.setInteger("staffType", type.ordinal());
        query.setEntity("faculty", faculty);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdStaff s where " +
                "(upper(s.identityNo) like upper(:filter) " +
                "or upper(s.name) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String staffNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdStaff s where " +
                "s.identityNo = :staffNo " +
                "and s.metadata.state = :state ");
        query.setString("staffNo", staffNo);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isEmailExists(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdStaff s where " +
                "s.email = :email " +
                "and s.metadata.state = :state ");
        query.setString("email", email);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Integer) query.uniqueResult() > 0);
    }
}
