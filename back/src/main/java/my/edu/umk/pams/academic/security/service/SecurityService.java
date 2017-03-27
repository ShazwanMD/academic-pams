package my.edu.umk.pams.academic.security.service;

import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.identity.model.AdUser;
import org.springframework.security.core.Authentication;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
public interface SecurityService {

    List<AdMetaObject> find(Authentication authentication, Class<?> clazz, Integer offset, Integer limit);

    Integer count(Authentication authentication, Class<?> clazz);

    AdUser getCurrentUser();
}
