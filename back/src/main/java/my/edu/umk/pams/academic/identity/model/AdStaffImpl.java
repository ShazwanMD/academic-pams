package my.edu.umk.pams.academic.identity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdFacultyImpl;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramImpl;

/**
 * @author PAMS
 */
@Entity(name = "AdStaff")
@Table(name = "AD_STAF")
public class AdStaffImpl extends AdActorImpl implements AdStaff {

	@Column(name = "STAFF_TYPE")
	private AdStaffType staffType;

	public AdStaffImpl() {
		super();
		setActorType(AdActorType.STAFF);
	}
	
	@OneToOne(targetEntity = AdFacultyImpl.class)
	@JoinColumn(name = "FACULTY_ID")
	private AdFaculty faculty;
	
	@OneToOne(targetEntity = AdProgramImpl.class)
	@JoinColumn(name = "PROGRAM_ID")
	private AdProgram program;
	
	@Override
	public AdProgram getProgram() {
		return program;
	}
	@Override
	public void setProgram(AdProgram program) {
		this.program = program;
	}
	@Override
	public AdFaculty getFaculty() {
		return faculty;
	}
	@Override
	public void setFaculty(AdFaculty faculty) {
		this.faculty = faculty;
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
	public AdStaffType getStaffType() {
		return staffType;
	}

	@Override
	public void setStaffType(AdStaffType staffType) {
		this.staffType = staffType;
	}

	@Override
	public Class<?> getInterfaceClass() {
		return AdStaff.class;
	}
}
