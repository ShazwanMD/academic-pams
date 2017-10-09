import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';

@Injectable()
export class ProfileActions {

    /*==================================================================================================*/
    /*BARRING PROCESS*/
    /*==================================================================================================*/
    static BAR_STUDENT = '[Profile] Bar Student';

    barStudent(student): Action {
        return {
            type: ProfileActions.BAR_STUDENT,
            payload: student
        };
    }

    static BAR_STUDENT_SUCCESS = '[Profile] Bar Student Success';

    barStudentSuccess(student): Action {
        return {
            type: ProfileActions.BAR_STUDENT_SUCCESS,
            payload: student
        };
    }

    /*==================================================================================================*/
    /*ACTIVATE / DEACTIVATE STUDENT*/
    /*==================================================================================================*/
    static ACTIVATE_STUDENT = '[Profile] Activate Student';

    activateStudent(student): Action {
        return {
            type: ProfileActions.ACTIVATE_STUDENT,
            payload: student
        };
    }

    static ACTIVATE_STUDENT_SUCCESS = '[Profile] Activate Student Success';

    activateStudentSuccess(student): Action {
        return {
            type: ProfileActions.ACTIVATE_STUDENT_SUCCESS,
            payload: student
        };
    }

    static DEACTIVATE_STUDENT = '[Profile] Deactivate Student';

    deactivateStudent(student): Action {
        return {
            type: ProfileActions.DEACTIVATE_STUDENT,
            payload: student
        };
    }

    static DEACTIVATE_STUDENT_SUCCESS = '[Profile] Activate Student Success';

    deactivateStudentSuccess(student): Action {
        return {
            type: ProfileActions.DEACTIVATE_STUDENT_SUCCESS,
            payload: student
        };
    }

    /*==================================================================================================*/
    /*FINDING THINGS*/
    /*==================================================================================================*/
    static FIND_STUDENTS = '[Profile] Find Students';

    findStudents(): Action {
        return {
            type: ProfileActions.FIND_STUDENTS
        };
    }

    static FIND_STUDENTS_SUCCESS = '[Profile] Find Students Success';

    findStudentsSuccess(students): Action {
        return {
            type: ProfileActions.FIND_STUDENTS_SUCCESS,
            payload: students
        };
    }

    //find graduated students
    static FIND_GRADUATED_STUDENTS = '[Profile] Find Graduated Students';

    findGraduatedStudents(): Action {
        return {
            type: ProfileActions.FIND_GRADUATED_STUDENTS
        };
    }

    static FIND_GRADUATED_STUDENTS_SUCCESS = '[Profile] Find Graduated Students Success';

    findGraduatedStudentsSuccess(students): Action {
        return {
            type: ProfileActions.FIND_GRADUATED_STUDENTS_SUCCESS,
            payload: students
        };
    }

    static FIND_STUDENT_BY_IDENTITY_NO = '[Profile] Find Student By Identity No';

    findStudentByIdentityNo(identityNo): Action {
        return {
            type: ProfileActions.FIND_STUDENT_BY_IDENTITY_NO,
            payload: identityNo
        };
    }

    static FIND_STUDENT_BY_IDENTITY_NO_SUCCESS = '[Profile] Find Student By Identity No Success';

    findStudentByIdentityNoSuccess(student): Action {
        return {
            type: ProfileActions.FIND_STUDENT_BY_IDENTITY_NO_SUCCESS,
            payload: student
        };
    }

    /*//find admissionApplications by student 22/8/17
    static FIND_ADMISSION_APPLICATIONS = '[Profile] Find AdmissionApplications';
  
    findAdmissionApplications(student): Action {
      return {
        type: ProfileActions.FIND_ADMISSION_APPLICATIONS,
        payload: student
      };
    }
  
    static FIND_ADMISSION_APPLICATIONS_SUCCESS = '[Profile] Find AdmissionApplications Success';
  
    findAdmissionApplicationsSuccess(admissionApplications): Action {
      return {
        type: ProfileActions.FIND_ADMISSION_APPLICATIONS_SUCCESS,
        payload: admissionApplications
      };
    }*/

    static FIND_ADDRESSES = '[Profile] Find Addresses';

    findAddresses(student): Action {
        return {
            type: ProfileActions.FIND_ADDRESSES,
            payload: student
        };
    }

    static FIND_ADDRESSES_SUCCESS = '[Profile] Find Addresses Success';

    findAddressesSuccess(addresses): Action {
        return {
            type: ProfileActions.FIND_ADDRESSES_SUCCESS,
            payload: addresses
        };
    }

    static FIND_GUARANTORS = '[Profile] Find Guarantors';

    findGuarantors(student): Action {
        return {
            type: ProfileActions.FIND_GUARANTORS,
            payload: student
        };
    }

    static FIND_GUARANTORS_SUCCESS = '[Profile] Find Guarantors Success';

    findGuarantorsSuccess(guarantors): Action {
        return {
            type: ProfileActions.FIND_GUARANTORS_SUCCESS,
            payload: guarantors
        };
    }

    static FIND_CONTACTS = '[Profile] Find Contacts';

    findContacts(student): Action {
        return {
            type: ProfileActions.FIND_CONTACTS,
            payload: student
        };
    }

    static FIND_CONTACTS_SUCCESS = '[Profile] Find Contacts Success';

    findContactsSuccess(contacts): Action {
        return {
            type: ProfileActions.FIND_CONTACTS_SUCCESS,
            payload: contacts
        };
    }

    static FIND_GUARDIANS = '[Profile] Find Guardians';

    findGuardians(student): Action {
        return {
            type: ProfileActions.FIND_GUARDIANS,
            payload: student
        };
    }

    static FIND_GUARDIANS_SUCCESS = '[Profile] Find Guardians Success';

    findGuardiansSuccess(guardians): Action {
        return {
            type: ProfileActions.FIND_GUARDIANS_SUCCESS,
            payload: guardians
        };
    }

    static FIND_ENROLLMENTS_BY_STUDENT = '[Profile] Find Enrollments';

    findEnrollments(student): Action {
        return {
            type: ProfileActions.FIND_ENROLLMENTS_BY_STUDENT,
            payload: student
        };
    }

    static FIND_ENROLLMENTS_BY_STUDENT_SUCCESS = '[Profile] Find Enrollments Success';

    findEnrollmentsSuccess(enrollments): Action {
        return {
            type: ProfileActions.FIND_ENROLLMENTS_BY_STUDENT_SUCCESS,
            payload: enrollments
        };
    }

    //find Admissions By Student
    static FIND_ADMISSIONS_BY_STUDENT = '[Profile] Find Admissions';

    findAdmissions(student): Action {
        return {
            type: ProfileActions.FIND_ADMISSIONS_BY_STUDENT,
            payload: student
        };
    }

    static FIND_ADMISSIONS_BY_STUDENT_SUCCESS = '[Profile] Find Admissions Success';

    findAdmissionsSuccess(admissions): Action {
        return {
            type: ProfileActions.FIND_ADMISSIONS_BY_STUDENT_SUCCESS,
            payload: admissions
        };
    }

    //find Graduation Applications By Student
    static FIND_GRADUATION_APPLICATIONS_BY_STUDENT = '[Profile] Find Graduation Applications';

    findGraduationApplications(student): Action {
        return {
            type: ProfileActions.FIND_GRADUATION_APPLICATIONS_BY_STUDENT,
            payload: student
        };
    }

    static FIND_GRADUATION_APPLICATIONS_BY_STUDENT_SUCCESS = '[Profile] Find Graduation Success';

    findGraduationApplicationsSuccess(graduationApplications): Action {
        return {
            type: ProfileActions.FIND_GRADUATION_APPLICATIONS_BY_STUDENT_SUCCESS,
            payload: graduationApplications
        };
    }

    //find Graduations By Student
    static FIND_GRADUATIONS_BY_STUDENT = '[Profile] Find Graduations';

    findGraduations(student): Action {
        return {
            type: ProfileActions.FIND_GRADUATIONS_BY_STUDENT,
            payload: student
        };
    }

    static FIND_GRADUATIONS_BY_STUDENT_SUCCESS = '[Profile] Find Graduations Success';

    findGraduationsSuccess(graduations): Action {
        return {
            type: ProfileActions.FIND_GRADUATIONS_BY_STUDENT_SUCCESS,
            payload: graduations
        };
    }

    //find AdmissionApplications By Student 22/8/17
    static FIND_ADMISSION_APPLICATIONS_BY_STUDENT = '[Profile] Find AdmissionApplications';

    findAdmissionApplications(student): Action {
        return {
            type: ProfileActions.FIND_ADMISSION_APPLICATIONS_BY_STUDENT,
            payload: student
        };
    }

    static FIND_ADMISSION_APPLICATIONS_BY_STUDENT_SUCCESS = '[Profile] Find AdmissionApplications Success';

    findAdmissionApplicationsSuccess(admissionApplications): Action {
        return {
            type: ProfileActions.FIND_ADMISSION_APPLICATIONS_BY_STUDENT_SUCCESS,
            payload: admissionApplications
        };
    }


    /*==================================================================================================*/
    /*ADD / UPD STUDENT*/
    /*==================================================================================================*/
    static UPDATE_STUDENT = '[Profile] Update Student';

    updateStudent(identityNo): Action {
        return {
            type: ProfileActions.UPDATE_STUDENT,
            payload: identityNo
        };
    }

    static UPDATE_STUDENT_SUCCESS = '[Profile] Update Student Success';

    updateStudentSuccess(message): Action {
        return {
            type: ProfileActions.UPDATE_STUDENT_SUCCESS,
            payload: message
        };
    }

    static ADD_MIN_AMOUNT = '[Profile] Add Min Amount';

    addMinAmount(identityNo): Action {
        return {
            type: ProfileActions.ADD_MIN_AMOUNT,
            payload: identityNo
        };
    }

    static ADD_MIN_AMOUNT_SUCCESS = '[Profile] Add Min Amount Success';

    addMinAmountSuccess(message): Action {
        return {
            type: ProfileActions.ADD_MIN_AMOUNT_SUCCESS,
            payload: message
        };
    }

    /*==================================================================================================*/
    /*ADD / UPD / DEL ADMISSION -ADVISORY*/
    /*==================================================================================================*/


    static UPDATE_ADMISSION_APPLICATION = '[Profile] Update AdmissionApplication';

    updateAdmissionApplication(student, admissionApplication): Action {
        console.log("updateAdmissionApplication");
        return {
            type: ProfileActions.UPDATE_ADMISSION_APPLICATION,
            payload: { student: student, admissionApplication: admissionApplication }
        };
    }

    static UPDATE_ADMISSION_APPLICATION_SUCCESS = '[Profile] Update AdmissionApplication Success';

    updateAdmissionApplicationSuccess(message): Action {
        console.log("updateAdmissionApplicationSuccess");
        return {
            type: ProfileActions.UPDATE_ADMISSION_APPLICATION_SUCCESS,
            payload: message
        };
    }

    static UPDATE_ADMISSION = '[Profile] Update Admission';

    updateAdmission(student, admission): Action {
        console.log("updateAdmission");
        return {
            type: ProfileActions.UPDATE_ADMISSION,
            payload: { student: student, admission: admission }
        };
    }

    static UPDATE_ADMISSION_SUCCESS = '[Profile] Update Admission Success';

    updateAdmissionSuccess(message): Action {
        console.log("updateAdmissionSuccess");
        return {
            type: ProfileActions.UPDATE_ADMISSION_SUCCESS,
            payload: message
        };
    }


    /*==================================================================================================*/
    /*ADD / UPD / DEL ADDRESS*/
    /*==================================================================================================*/
    static ADD_ADDRESS = '[Profile] Add Address';

    addAddress(student, address): Action {
        return {
            type: ProfileActions.ADD_ADDRESS,
            payload: { student: student, address: address }
        };
    }

    static ADD_ADDRESS_SUCCESS = '[Profile] Add Address Success';

    addAddressSuccess(message): Action {
        return {
            type: ProfileActions.ADD_ADDRESS_SUCCESS,
            payload: message
        };
    }

    static UPDATE_ADDRESS = '[Profile] Update Address';

    updateAddress(student, address): Action {
        return {
            type: ProfileActions.UPDATE_ADDRESS,
            payload: { student: student, address: address }
        };
    }

    static UPDATE_ADDRESS_SUCCESS = '[Profile] Update Address Success';

    updateAddressSuccess(message): Action {
        return {
            type: ProfileActions.UPDATE_ADDRESS_SUCCESS,
            payload: message
        };
    }

    static REMOVE_ADDRESS = '[Profile] Remove Address';

    deleteAddress(student, address): Action {
        return {
            type: ProfileActions.REMOVE_ADDRESS,
            payload: { student: student, address: address }
        };
    }

    static REMOVE_ADDRESS_SUCCESS = '[Profile] Remove Address Success';

    deleteAddressSuccess(message): Action {
        return {
            type: ProfileActions.REMOVE_ADDRESS_SUCCESS,
            payload: message
        };
    }

    /*==================================================================================================*/
    /*ADD / UPD / DEL GUARANTOR*/
    /*==================================================================================================*/
    static ADD_GUARANTOR = '[Profile] Add Guarantor';

    addGuarantor(student, guarantor): Action {
        return {
            type: ProfileActions.ADD_GUARANTOR,
            payload: { student: student, guarantor: guarantor }
        };
    }

    static ADD_GUARANTOR_SUCCESS = '[Profile] Add Guarantor Success';

    addGuarantorSuccess(message): Action {
        return {
            type: ProfileActions.ADD_GUARANTOR_SUCCESS,
            payload: message
        };
    }

    static UPDATE_GUARANTOR = '[Profile] Update Guarantor';

    updateGuarantor(student, guarantor): Action {
        return {
            type: ProfileActions.UPDATE_GUARANTOR,
            payload: { student: student, guarantor: guarantor }
        };
    }

    static UPDATE_GUARANTOR_SUCCESS = '[Profile] Update Guarantor Success';

    updateGuarantorSuccess(message): Action {
        return {
            type: ProfileActions.UPDATE_GUARANTOR_SUCCESS,
            payload: message
        };
    }

    static REMOVE_GUARANTOR = '[Profile] Remove Guarantor';

    deleteGuarantor(student, guarantor): Action {
        return {
            type: ProfileActions.REMOVE_GUARANTOR,
            payload: { student: student, guarantor: guarantor }
        };
    }

    static REMOVE_GUARANTOR_SUCCESS = '[Profile] Remove Guarantor Success';

    deleteGuarantorSuccess(message): Action {
        return {
            type: ProfileActions.REMOVE_GUARANTOR_SUCCESS,
            payload: message
        };
    }

    /*==================================================================================================*/
    /*ADD / UPD / DEL GUARDIAN*/
    /*==================================================================================================*/
    static ADD_GUARDIAN = '[Profile] Add Guardian';

    addGuardian(student, guardian): Action {
        return {
            type: ProfileActions.ADD_GUARDIAN,
            payload: { student: student, guardian: guardian }
        };
    }

    static ADD_GUARDIAN_SUCCESS = '[Profile] Add Guardian Success';

    addGuardianSuccess(message): Action {
        return {
            type: ProfileActions.ADD_GUARDIAN_SUCCESS,
            payload: message
        };
    }

    static UPDATE_GUARDIAN = '[Profile] Update Guardian';

    updateGuardian(student, guardian): Action {
        return {
            type: ProfileActions.UPDATE_GUARDIAN,
            payload: { student: student, guardian: guardian }
        };
    }

    static UPDATE_GUARDIAN_SUCCESS = '[Profile] Update Guardian Success';

    updateGuardianSuccess(message): Action {
        return {
            type: ProfileActions.UPDATE_GUARDIAN_SUCCESS,
            payload: message
        };
    }

    static REMOVE_GUARDIAN = '[Profile] Remove Guardian';

    deleteGuardian(student, guardian): Action {
        return {
            type: ProfileActions.REMOVE_GUARDIAN,
            payload: { student: student, guardian: guardian }
        };
    }

    static REMOVE_GUARDIAN_SUCCESS = '[Profile] Remove Guardian Success';

    deleteGuardianSuccess(message): Action {
        return {
            type: ProfileActions.REMOVE_GUARDIAN_SUCCESS,
            payload: message
        };
    }

    /*==================================================================================================*/
    /*ADD / UPD / DEL CONTACT*/
    /*==================================================================================================*/
    static ADD_CONTACT = '[Profile] Add Contact';

    addContact(student, contact): Action {
        return {
            type: ProfileActions.ADD_CONTACT,
            payload: { student: student, contact: contact }
        };
    }

    static ADD_CONTACT_SUCCESS = '[Profile] Add Contact Success';

    addContactSuccess(message): Action {
        return {
            type: ProfileActions.ADD_CONTACT_SUCCESS,
            payload: message
        };
    }

    static UPDATE_CONTACT = '[Profile] Update Contact'

    updateContact(student, contact): Action {
        return {
            type: ProfileActions.UPDATE_CONTACT,
            payload: { student: student, contact: contact }
        };
    }

    static UPDATE_CONTACT_SUCCESS = '[Profile] Update Contact Success';

    updateContactSuccess(message): Action {
        return {
            type: ProfileActions.UPDATE_CONTACT_SUCCESS,
            payload: message
        };
    }

    static REMOVE_CONTACT = '[Profile] Remove Contact';

    deleteContact(student, contact): Action {
        //console.log("Ini-->",contact);
        return {
            type: ProfileActions.REMOVE_CONTACT,
            payload: { student: student, contact: contact }
        };
    }

    static REMOVE_CONTACT_SUCCESS = '[Profile] Remove Contact Success';

    deleteContactSuccess(message): Action {
        return {
            type: ProfileActions.REMOVE_CONTACT_SUCCESS,
            payload: message
        };
    }

    static SWITCH_STUDY_MODE = '[Profile] Switch Study Mode';

    switchStudyMode(student, switcher): Action {
        return {
            type: ProfileActions.SWITCH_STUDY_MODE,
            payload: { student: student, switchStudyMode: switcher }
        };
    }

    static SWITCH_STUDY_MODE_SUCCESS = '[Profile] Switch Study Mode Success';

    switchStudyModeSuccess(message): Action {
        return {
            type: ProfileActions.SWITCH_STUDY_MODE_SUCCESS,
            payload: message
        };
    }

    static TRANSFER_COHORT = '[Profile] Transfer Cohort ';

    transferCohort(student, transfer): Action {
        return {
            type: ProfileActions.TRANSFER_COHORT,
            payload: { student: student, transferCohort: transfer }
        };
    }

    static TRANSFER_COHORT_SUCCESS = '[Profile] Transfer Cohort Success';

    transferCohortSuccess(message): Action {
        return {
            type: ProfileActions.TRANSFER_COHORT_SUCCESS,
            payload: message
        };
    }
}
