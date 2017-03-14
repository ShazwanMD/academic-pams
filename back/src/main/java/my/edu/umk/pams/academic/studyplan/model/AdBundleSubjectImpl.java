package my.edu.umk.pams.academic.studyplan.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author PAMS
 */
@Entity(name = "AdBundleSubject")
@Table(name = "AD_BNDL_SBJT")
public class AdBundleSubjectImpl extends AdSubjectImpl implements AdBundleSubject {

    @OneToMany(targetEntity = AdBundleSubjectPartImpl.class, mappedBy = "bundle", fetch = FetchType.LAZY)
    private List<AdBundleSubjectPart> parts;

    @Override
    public List<AdBundleSubjectPart> getParts() {
        return parts;
    }

    @Override
    public void setParts(List<AdBundleSubjectPart> parts) {
        this.parts = parts;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdBundleSubject.class;
    }
}
