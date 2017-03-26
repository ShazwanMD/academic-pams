package my.edu.umk.pams.academic.identity.model;

import my.edu.umk.pams.academic.planner.model.AdCohort;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdStudent extends AdActor {

	String getMatricNo();

	void setMatricNo(String matricNo);

	AdCohort getCohort();

	void setCohort(AdCohort cohort);

	List<AdAddress> getAddresses();

	void setAddresses(List<AdAddress> addresses);

	// =========================================================
	// STUDENT STATUS
	// =========================================================

	AdStudentStatus getStudentStatus();

	void setStudentStatus(AdStudentStatus studentStatus);

}
