package my.edu.umk.pams.academic.planner.model;

import javax.persistence.Column;
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

	@Column(name = "SUBJECT_SPECIALIZE", nullable = false)
	private AdSubjectElectiveStatus subjectElectiveStatus;

	@OneToMany(targetEntity = AdBundleSubjectPartImpl.class, mappedBy = "bundle", fetch = FetchType.EAGER)
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

	@Override
	public AdSubjectElectiveStatus getSubjectElectiveStatus() {
		 return subjectElectiveStatus;
	}

	@Override
	public void setSubjectElectiveStatus(AdSubjectElectiveStatus subjectElectiveStatus) {
		 this.subjectElectiveStatus = subjectElectiveStatus;

	}
}
