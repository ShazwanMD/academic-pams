package my.edu.umk.pams.academic.registration.service;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;

public interface RegistrationService {

    void registerUser(AdUser user, AdStudent student);

    void verifyUser(String token);
    
    void forgetPassword(AdUser user);

    boolean isUserExists(String username);

	String generateToken();
}
