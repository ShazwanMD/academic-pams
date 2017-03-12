package my.edu.umk.pams.academic.identity.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Entity(name = "AdApplication")
@Table(name = "AD_APCN")
public class AdStudentImpl extends AdActorImpl implements AdStudent {

    @OneToMany(targetEntity = AdAddressImpl.class, mappedBy = "student", fetch = FetchType.LAZY)
    private List<AdAddress> addresses;

    @Override
    public String getMatricNo() {
        return getIdentityNo();
    }

    @Override
    public void setMatricNo(String matricNo) {
        setIdentityNo(matricNo);
    }

    @Override
    public List<AdAddress> getAddresses() {
        return addresses;
    }

    @Override
    public void setAddresses(List<AdAddress> addresses) {
        this.addresses = addresses;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdStudent.class;
    }

}
