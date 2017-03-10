package my.edu.umk.pams.academic.identity.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author canang technologies
 * @since 7/2/2015.
 */
@Entity(name = "AdStaff")
@Table(name = "AD_STAF")
public class AdStaffImpl extends AdActorImpl implements AdStaff {

    public AdStaffImpl() {
        super();
        setActorType(AdActorType.STAFF);
    }

    @Override
    public String getStaffNo() {
        return getIdentityNo();
    }

    @Override
    public void setStaffNo(String staffNo) {
        setIdentityNo(staffNo);
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdStaff.class;
    }

}
