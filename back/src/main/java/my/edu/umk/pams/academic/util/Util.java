package my.edu.umk.pams.academic.util;

import my.edu.umk.pams.academic.identity.model.AdGroup;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.security.integration.AdUserDetails;
import org.joda.time.LocalDate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public class Util {

    public static Integer getCurrentYear() {
        return new LocalDate().getYear();
    }

    @Deprecated // anti-pattern
    public static AdUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            return ((AdUserDetails) auth.getPrincipal()).getUser();
        } else {
            return null;
        }
    }

    /**
     * Returns the given string if it is nonempty; {@code N/A string} otherwise.
     *
     * @param string the string to test and possibly return
     * @return {@code string} itself if it is nonempty; {@code 'N/A'} if it is
     * empty or null
     */
    public static String toNotApplicable(String string) {
        return (string == null) ? "N/A" : string;
    }

    public static String toEmpty(String string) {
        return (string == null) ? "" : string;
    }

    public static String toWildcard(Object obj) {
        return (obj.toString() == null) ? "%" : obj.toString();
    }

    public static Set<String> toString(Set<AdGroup> groups) {
        Set<String> str = new HashSet<>();
        for (AdGroup group : groups) {
            str.add(group.getName());
        }
        return str;
    }

    // todo(uda): better impl
    public static Integer toOffset(Integer page) {
        Integer limit = 10;
        Integer offset = (page - 1) * limit;
        return offset;
    }

    // todo(uda): better impl
    public static Integer toLimit(Integer page) {
        Integer limit = 10;
        return limit;
    }

}
