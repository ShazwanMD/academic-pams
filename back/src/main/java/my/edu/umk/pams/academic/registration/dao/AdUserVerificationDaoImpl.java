package my.edu.umk.pams.academic.registration.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.registration.model.AdUserVerification;
import my.edu.umk.pams.academic.registration.model.AdUserVerificationImpl;

@SuppressWarnings({"unchecked"})
@Repository("userVerificationDao")
public class AdUserVerificationDaoImpl extends GenericDaoSupport<Long,AdUserVerification> implements AdUserVerificationDao {

	public AdUserVerificationDaoImpl() {
		super(AdUserVerificationImpl.class);
		
	}

	@Override
	public AdUserVerification findByToken(String token) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from AdUserVerification u where u.token = :token ");
        query.setString("token", token);
        return (AdUserVerification) query.uniqueResult();
	}


}
