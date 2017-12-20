package my.edu.umk.pams.academic.identity.model;

import my.edu.umk.pams.academic.common.model.AdBankCode;
import my.edu.umk.pams.academic.common.model.AdBankCodeImpl;
import my.edu.umk.pams.academic.common.model.AdGenderCode;
import my.edu.umk.pams.academic.common.model.AdGenderCodeImpl;
import my.edu.umk.pams.academic.common.model.AdMaritalCode;
import my.edu.umk.pams.academic.common.model.AdMaritalCodeImpl;
import my.edu.umk.pams.academic.common.model.AdNationalityCode;
import my.edu.umk.pams.academic.common.model.AdNationalityCodeImpl;
import my.edu.umk.pams.academic.common.model.AdRaceCode;
import my.edu.umk.pams.academic.common.model.AdRaceCodeImpl;
import my.edu.umk.pams.academic.common.model.AdReligionCode;
import my.edu.umk.pams.academic.common.model.AdReligionCodeImpl;
import my.edu.umk.pams.academic.common.model.AdStudyMode;
import my.edu.umk.pams.academic.common.model.AdStudyModeImpl;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCohortImpl;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author PAMS
 */
@Entity(name = "AdStudent")
@Table(name = "AD_STDN")
public class AdStudentImpl extends AdActorImpl implements AdStudent {

	@Column(name = "STUDENT_STATUS")
	private AdStudentStatus studentStatus;

	@ManyToOne(targetEntity = AdCohortImpl.class)
	@JoinColumn(name = "COHORT_ID", nullable = true) // todo(uda): nullable =
	private AdCohort cohort;

	@OneToMany(targetEntity = AdAddressImpl.class, mappedBy = "student", fetch = FetchType.LAZY)
	private List<AdAddress> addresses;

	@OneToMany(targetEntity = AdContactImpl.class, mappedBy = "student", fetch = FetchType.LAZY)
	private List<AdContact> contacts;

	@OneToMany(targetEntity = AdGuardianImpl.class, mappedBy = "student")
	private List<AdGuardian> guardians;

	@OneToMany(targetEntity = AdGuarantorImpl.class, mappedBy = "student")
	private List<AdGuarantor> guarantors;
	
	@OneToOne(targetEntity = AdStudyModeImpl.class)
	@JoinColumn(name = "STUDY_MODE_ID", nullable = true)
	private AdStudyMode studyMode;
	
	@Column(name = "MEMO")
	private String memo;
	
	@Column(name = "BALANCE")
	private BigDecimal balance = BigDecimal.ZERO;
		
	@Column(name = "OUTSTANDING")
	private Boolean outstanding;

	@Column(name = "NO_ID")
	private String NoID;
	
	@Column(name = "BANK_ACCT_NO")
	private String bankAccountNo;
	
	@Column(name = "MIN_AMOUNT")
	private BigDecimal minimalAmount = BigDecimal.ZERO;
	
	@OneToOne(targetEntity = AdGenderCodeImpl.class)
	@JoinColumn(name = "GENDER_ID", nullable = true)
	private AdGenderCode genderCode;
	
	@OneToOne(targetEntity = AdReligionCodeImpl.class)
	@JoinColumn(name = "RELIGION_ID", nullable = true)
	private AdReligionCode religionCode;
	
	@OneToOne(targetEntity = AdMaritalCodeImpl.class)
	@JoinColumn(name = "MARITAL_ID", nullable = true)
	private AdMaritalCode maritalCode;
	
	@OneToOne(targetEntity = AdNationalityCodeImpl.class)
	@JoinColumn(name = "NATIONALITY_ID", nullable = true)
	private AdNationalityCode nationalityCode;
	
	@OneToOne(targetEntity = AdRaceCodeImpl.class)
	@JoinColumn(name = "RACE_CODE_ID", nullable = true)
	private AdRaceCode raceCode;
	
	@OneToOne(targetEntity = AdBankCodeImpl.class)
	@JoinColumn(name = "BANK_CODE_ID", nullable = true)
	private AdBankCode bankCode;
	
	
	public AdStudentImpl() {
		super();
		setActorType(AdActorType.STUDENT);
	}
	
	@Override
	public BigDecimal getBalance() {
		return balance;
	}
	@Override
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	@Override
	public Boolean getOutstanding() {
		return outstanding;
	}
	@Override
	public void setOutstanding(Boolean outstanding) {
		this.outstanding = outstanding;
	}
	@Override
	public String getMemo() {
		return memo;
	}
	@Override
	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String getMatricNo() {
		return getIdentityNo();
	}

	@Override
	public void setMatricNo(String matricNo) {
		setIdentityNo(matricNo);
	}

	@Override
	public AdStudentStatus getStudentStatus() {
		return studentStatus;
	}

	@Override
	public void setStudentStatus(AdStudentStatus studentStatus) {
		this.studentStatus = studentStatus;
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
	public List<AdContact> getContacts() {
		return contacts;
	}

	@Override
	public void setContacts(List<AdContact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public List<AdGuardian> getGuardians() {
		return guardians;
	}

	@Override
	public void setGuardians(List<AdGuardian> guardians) {
		this.guardians = guardians;
	}

	@Override
	public List<AdGuarantor> getGuarantors() {
		return guarantors;
	}

	@Override
	public void setGuarantors(List<AdGuarantor> guarantors) {
		this.guarantors = guarantors;
	}

	@Override
	public Class<?> getInterfaceClass() {
		return AdStudent.class;
	}

	@Override
	public AdStudyMode getStudyMode() {
		return studyMode;
	}

	@Override
	public void setStudyMode(AdStudyMode studyMode) {
		this.studyMode = studyMode;
		
	}

	@Override
	public String getNoID() {
		return NoID;
	}

	@Override
	public void setNoID(String NoID) {
		this.NoID = NoID;
	}

	@Override
	public BigDecimal getMinimalAmount() {
		return minimalAmount;
	}

	@Override
	public void setMinimalAmount(BigDecimal minimalAmount) {
		this.minimalAmount = minimalAmount;
		
	}

	public AdGenderCode getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(AdGenderCode genderCode) {
		this.genderCode = genderCode;
	}

	public AdReligionCode getReligionCode() {
		return religionCode;
	}

	public void setReligionCode(AdReligionCode religionCode) {
		this.religionCode = religionCode;
	}

	public AdMaritalCode getMaritalCode() {
		return maritalCode;
	}

	public void setMaritalCode(AdMaritalCode maritalCode) {
		this.maritalCode = maritalCode;
	}

	public AdNationalityCode getNationalityCode() {
		return nationalityCode;
	}

	public void setNationalityCode(AdNationalityCode nationalityCode) {
		this.nationalityCode = nationalityCode;
	}

	public AdRaceCode getRaceCode() {
		return raceCode;
	}

	public void setRaceCode(AdRaceCode raceCode) {
		this.raceCode = raceCode;
	}

	public AdBankCode getBankCode() {
		return bankCode;
	}

	public void setBankCode(AdBankCode bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	
	

	
	
	

}
