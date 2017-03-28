package my.edu.umk.pams.academic.identity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author PAMS
 */
@Entity(name = "AdStaff")
@Table(name = "AD_STAF")
public class AdStaffImpl extends AdActorImpl implements AdStaff {
	
    @Column(name = "STAFF_TYPE")
    private AdStaffType staffType;
    
    @Override
    public AdStaffType getStaffType() {
		return staffType;
	}

    @Override
	public void setStaffType(AdStaffType staffType) {
		this.staffType = staffType;
	}

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
