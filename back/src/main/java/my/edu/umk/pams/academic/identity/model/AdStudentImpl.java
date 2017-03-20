package my.edu.umk.pams.academic.identity.model;

import my.edu.umk.pams.academic.studyplan.model.AdCohort;
import my.edu.umk.pams.academic.studyplan.model.AdCohortImpl;

import javax.persistence.*;
import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Entity(name = "AdApplication")
@Table(name = "AD_APCN")
public class AdStudentImpl extends AdActorImpl implements AdStudent {

    @ManyToOne(targetEntity = AdCohortImpl.class)
    @JoinColumn(name = "COHORT_ID", nullable = true) // todo(uda): nullable = false
    private AdCohort cohort;

    @OneToMany(targetEntity = AdAddressImpl.class, mappedBy = "student", fetch = FetchType.LAZY)
    private List<AdAddress> addresses;

    @Column(name = "MATRIC_NO")
    private String matricNo;
    
    @Column(name = "COHORT")
    private String Cohort;
    
    @Override
    public String getMatricNo() {
        return getIdentityNo();
    }

    @Override
    public void setMatricNo(String matricNo) {
        setIdentityNo(matricNo);
    }

    @Override
    public AdCohort getCohort() {
        return cohort;
    }

    @Override
    public void setCohort(AdCohort cohort) {
        this.cohort = cohort;
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
