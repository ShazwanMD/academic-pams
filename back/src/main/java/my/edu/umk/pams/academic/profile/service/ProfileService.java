package my.edu.umk.pams.academic.profile.service;

import my.edu.umk.pams.academic.common.model.AdGraduateCenter;
import my.edu.umk.pams.academic.common.model.AdStudyMode;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.identity.model.*;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;

import java.util.List;

/**
 * @author PAMS
 */
public interface ProfileService {

	// ====================================================================================================
	// STUDENT
	// ====================================================================================================

	// note: thin wrapper
	/*FindBy ID / MatricNo*/
	AdStudent findStudentById(Long id);
	AdStudent findStudentByMatricNo(String matricNo);
	AdAddress findAddressById(Long id);
	AdGuarantor findGuarantorById(Long id);
	AdGuardian findGuardianById(Long id);
	AdContact findContactById(Long id);

	/*Listing*/
	List<AdStudent> findStudents();
//	List<AdStudent> findStudents(Integer offset, Integer limit);
	List<AdStudent> findGraduatedStudents(Integer offset, Integer limit);
	List<AdStudent> findStudents(String filter, Integer offset, Integer limit);
	List<AdAddress> findAddresses(AdStudent student);
	List<AdAdmissionApplication> findAdmissionApplications(AdStudent student);
	List<AdGuarantor> findGuarantors(AdStudent student);
	List<AdGraduationApplication> findGraduationApplications(AdStudent student);
	List<AdGuardian> findGuardians(AdStudent student);
	List<AdContact> findContacts(AdStudent student);
	
	List<AdStudent> findStudentsByFaculty(AdFaculty faculty);
	
	List<AdStudent> findStudentsByGraduateCenter(AdGraduateCenter graduateCenter);
	
	//AdmissionByAcademicSession
	AdAdmission findAdmissionByAcademicSessionAndStudent(AdAcademicSession academicSession, AdStudent student);

	/*Student Information*/
	void updateStudent(AdStudent student);
	void addMinAmount(AdStudent student);

	/*Address*/
	void addAddress(AdStudent student, AdAddress address);
	void updateAddress(AdStudent student, AdAddress address);
	void deleteAddress(AdStudent student, AdAddress address);

	/*Guarantor*/
	void addGuarantor(AdStudent student, AdGuarantor guarantor);
	void updateGuarantor(AdStudent student, AdGuarantor guarantor);
	void deleteGuarantor(AdStudent student, AdGuarantor guarantor);

	/*Guardian*/
	void addGuardian(AdStudent student, AdGuardian guardian);
	void updateGuardian(AdStudent student, AdGuardian guardian);
	void deleteGuardian(AdStudent student, AdGuardian guardian);

	/*Contact*/
	void addContact(AdStudent student, AdContact contact);
	void updateContact(AdStudent student, AdContact contact);
	void deleteContact(AdStudent student, AdContact contact);

	/*Business*/
	void activateStudent(AdStudent student);
	void deactivateStudent(AdStudent student);

    //====================================================================================================
    // GENERATOR
    //====================================================================================================

	@Deprecated // use transfer cohort
    String transferFaculty(AdStudent student, AdAcademicSession academicSession, AdFaculty fromFaculty, AdFaculty toFaculty);

    String transferCohort(AdStudent student, AdAcademicSession academicSession, AdCohort fromCohort, AdCohort toCohort);

    String switchStudyMode(AdStudent student, AdAcademicSession academicSession, AdStudyMode fromMode, AdStudyMode toMode);

	void barStudent(AdStudent student);
	
	
	
}
