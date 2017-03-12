package my.edu.umk.pams.academic.identity.dao;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdAddressImpl;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@SuppressWarnings({"unchecked"})
@Repository("studentDao")
public class AdStudentDaoImpl extends GenericDaoSupport<Long, AdStudent> implements AdStudentDao {

    public AdStudentDaoImpl() {
        super(AdStudentImpl.class);
    }

    @Override
    public AdStudent findByStudentNo(String studentNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from AdStudent a where " +
                "a.identityNo = :identityNo");
        query.setString("identityNo", studentNo);
        return (AdStudent) query.uniqueResult();
    }

    @Override
    public AdAddress findAddressById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (AdAddress) session.get(AdAddressImpl.class, id);
    }

    @Override
    public List<AdStudent> findAddresses(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdStudent s where " +
                "(upper(s.identityNo) like upper(:filter) " +
                "or upper(s.name) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return query.list();
    }

    @Override
    public List<AdAddress> findAddresses(AdStudent student) {
        // todo(sam): add impl i.e AdProgramDao.addOffering
        return null;
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdStudent s where " +
                "(upper(s.identityNo) like upper(:filter) " +
                "or upper(s.name) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countAddress(AdStudent student) {
        // todo(sam): add impl i.e AdProgramDao
        return null;
    }

    @Override
    public void addAddress(AdStudent student, AdAddress address) {
        // todo(sam): add impl

    }

    @Override
    public void updateAddress(AdStudent student, AdAddress address) {
        // todo(sam): add impl
    }

    @Override
    public void removeAddress(AdStudent student, AdAddress address) {
        // todo(sam): add impl

    }
}
