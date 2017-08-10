package my.edu.umk.pams.academic.registration.model;

import java.util.Date;

import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.identity.model.AdUser;

public interface AdUserVerification extends AdMetaObject {

	String getToken();

	void setToken(String token);

	Date getExpiryDate();

	void setExpiryDate(Date expiryDate);

	AdUser getUser();

	void setUser(AdUser user);

}
