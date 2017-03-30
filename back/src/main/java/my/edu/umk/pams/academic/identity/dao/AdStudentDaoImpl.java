package my.edu.umk.pams.academic.identity.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.*;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
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
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdAddress o where " +
                "o.student = :student " +
                "and o.metadata.state = :state");
        query.setEntity("student", student);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return query.list();
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

    @Override
    public void updateAddress(AdStudent student, AdAddress address, AdUser user) {
        Validate.notNull(user, "User cannot be null");
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
    public void removeAddress(AdStudent student, AdAddress address, AdUser user) {
        // todo(sam): add impl

    }
}
