package my.edu.umk.pams.academic.identity.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Entity(name = "AdApplication")
@Table(name = "AD_APCN")
public class AdStudentImpl extends AdActorImpl implements AdStudent {

    @Override
    public String getApplicationNo() {
        return getIdentityNo();
    }

    @Override
    public void setApplicationNo(String applicationNo) {
        setIdentityNo(applicationNo);
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdStudent.class;
    }

}
