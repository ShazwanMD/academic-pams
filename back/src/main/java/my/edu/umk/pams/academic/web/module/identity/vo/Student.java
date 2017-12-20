package my.edu.umk.pams.academic.web.module.identity.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.web.module.common.vo.BankCode;
import my.edu.umk.pams.academic.web.module.common.vo.StudyMode;
import my.edu.umk.pams.academic.web.module.planner.vo.Cohort;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author PAMS
 */
public class Student extends Actor {

	private Cohort cohort;
	private StudyMode studyMode;
	private StudentStatus studentStatus;
	private boolean outstanding;
	private BigDecimal balance;
	private String memo;
	private BigDecimal minAmount;
	private String NoID;
	private String bankAccountNo;
	private BankCode bankCode;
	

	public String getNoID() {
		return NoID;
	}

	public void setNoID(String noID) {
		NoID = noID;
	}

	public BigDecimal getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(BigDecimal minAmount) {
		this.minAmount = minAmount;
	}

	public boolean getOutstanding() {
		return outstanding;
	}

	public void setOutstanding(boolean outstanding) {
		this.outstanding = outstanding;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Cohort getCohort() {
		return cohort;
	}

	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}

	public StudyMode getStudyMode() {
		return studyMode;
	}

	public void setStudyMode(StudyMode studyMode) {
		this.studyMode = studyMode;
	}

	public StudentStatus getStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(StudentStatus studentStatus) {
		this.studentStatus = studentStatus;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public BankCode getBankCode() {
		return bankCode;
	}

	public void setBankCode(BankCode bankCode) {
		this.bankCode = bankCode;
	}

	@JsonCreator
	public static Student create(String jsonString) {
		Student o = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			o = mapper.readValue(jsonString, Student.class);
		} catch (IOException e) {
			// handle
		}
		return o;
	}
}
