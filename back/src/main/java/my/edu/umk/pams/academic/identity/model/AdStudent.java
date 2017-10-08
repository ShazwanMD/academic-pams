package my.edu.umk.pams.academic.identity.model;

import my.edu.umk.pams.academic.common.model.AdStudyMode;
import my.edu.umk.pams.academic.planner.model.AdCohort;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author PAMS
 */
public interface AdStudent extends AdActor {
	
	String getNoID();

	void setNoID(String NoID);

	String getMatricNo();

	void setMatricNo(String matricNo);

	AdStudentStatus getStudentStatus();

	void setStudentStatus(AdStudentStatus studentStatus);

	AdCohort getCohort();

	void setCohort(AdCohort cohort);
	
	AdStudyMode getStudyMode();
	
	void setStudyMode(AdStudyMode studyMode);
	
	String getMemo();
	
	void setMemo(String memo);
	
	Boolean getOutstanding();
	
	void setOutstanding(Boolean outstanding);
	
	BigDecimal getBalance();
	
	void setBalance(BigDecimal balance);
	
	List<AdAddress> getAddresses();

	void setAddresses(List<AdAddress> addresses);

	List<AdContact> getContacts();

	void setContacts(List<AdContact> contactes);

	List<AdGuardian> getGuardians();

	void setGuardians(List<AdGuardian> guardians);

	List<AdGuarantor> getGuarantors();

	void setGuarantors(List<AdGuarantor> guarantors);
	
	BigDecimal getMinimalAmount();
	
	void setMinimalAmount(BigDecimal minimalAmount);
	
	
	

	
}
