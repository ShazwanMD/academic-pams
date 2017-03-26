package my.edu.umk.pams.academic.identity.model;

import my.edu.umk.pams.academic.studyplan.model.AdCohort;
import my.edu.umk.pams.academic.studyplan.model.AdCohortImpl;

import javax.persistence.*;
import java.util.List;

/**
 * @author PAMS
 */
@Entity(name = "AdStudent")
@Table(name = "AD_STDN")
public class AdStudentImpl extends AdActorImpl implements AdStudent {

	@ManyToOne(targetEntity = AdCohortImpl.class)
	@JoinColumn(name = "COHORT_ID", nullable = true) // todo(uda): nullable =
														// false
	private AdCohort cohort;

	@OneToMany(targetEntity = AdAddressImpl.class, mappedBy = "student", fetch = FetchType.LAZY)
	private List<AdAddress> addresses;

	@Column(name = "STUDENT_STATUS")
	private AdStudentStatus studentStatus;

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

	@Override
	public AdStudentStatus getStudentStatus() {
		return studentStatus;
	}

	@Override
	public void setStudentStatus(AdStudentStatus studentStatus) {
		this.studentStatus = studentStatus;

	}

}
