package my.edu.umk.pams.academic.registration.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.registration.model.AdUserVerification;

public interface AdUserVerificationDao extends GenericDao<Long, AdUserVerification> {

	
	AdUserVerification findByToken(String token);
}
