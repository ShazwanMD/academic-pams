import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class StudentProfileActions {

  /*==================================================================================================*/
  /*BARRING PROCESS*/
  /*==================================================================================================*/
  static BAR_STUDENT = '[StudentProfile] Bar Student';

  barStudent(student): Action {
    return {
      type: StudentProfileActions.BAR_STUDENT,
      payload: student
    };
  }

  static BAR_STUDENT_SUCCESS = '[StudentProfile] Bar Student Success';

  barStudentSuccess(student): Action {
    return {
      type: StudentProfileActions.BAR_STUDENT_SUCCESS,
      payload: student
    };
  }

  /*==================================================================================================*/
  /*ACTIVATE / DEACTIVATE STUDENT*/
  /*==================================================================================================*/
  static ACTIVATE_STUDENT = '[StudentProfile] Activate Student';

  activateStudent(student): Action {
    return {
      type: StudentProfileActions.ACTIVATE_STUDENT,
      payload: student
    };
  }

  static ACTIVATE_STUDENT_SUCCESS = '[StudentProfile] Activate Student Success';

  activateStudentSuccess(student): Action {
    return {
      type: StudentProfileActions.ACTIVATE_STUDENT_SUCCESS,
      payload: student
    };
  }

  static DEACTIVATE_STUDENT = '[StudentProfile] Deactivate Student';

  deactivateStudent(student): Action {
    return {
      type: StudentProfileActions.DEACTIVATE_STUDENT,
      payload: student
    };
  }

  static DEACTIVATE_STUDENT_SUCCESS = '[StudentProfile] Activate Student Success';

  deactivateStudentSuccess(student): Action {
    return {
      type: StudentProfileActions.DEACTIVATE_STUDENT_SUCCESS,
      payload: student
    };
  }

  /*==================================================================================================*/
  /*FINDING THINGS*/
  /*==================================================================================================*/
  static FIND_STUDENTS = '[StudentProfile] Find Students';

  findStudents(): Action {
    return {
      type: StudentProfileActions.FIND_STUDENTS
    };
  }

  static FIND_STUDENTS_SUCCESS = '[StudentProfile] Find Students Success';

  findStudentsSuccess(students): Action {
    return {
      type: StudentProfileActions.FIND_STUDENTS_SUCCESS,
      payload: students
    };
  }

  static FIND_STUDENT_BY_IDENTITY_NO = '[StudentProfile] Find Student By Identity No';

  findStudentByIdentityNo(identityNo): Action {
    return {
      type: StudentProfileActions.FIND_STUDENT_BY_IDENTITY_NO,
      payload: identityNo
    };
  }

  static FIND_STUDENT_BY_IDENTITY_NO_SUCCESS = '[StudentProfile] Find Student By Identity No Success';

  findStudentByIdentityNoSuccess(student): Action {
    return {
      type: StudentProfileActions.FIND_STUDENT_BY_IDENTITY_NO_SUCCESS,
      payload: student
    };
  }

  static FIND_ADDRESSES = '[StudentProfile] Find Addresses';

  findAddresses(student): Action {
    return {
      type: StudentProfileActions.FIND_ADDRESSES,
      payload: student
    };
  }

  static FIND_ADDRESSES_SUCCESS = '[StudentProfile] Find Addresses Success';

  findAddressesSuccess(addresses): Action {
    return {
      type: StudentProfileActions.FIND_ADDRESSES_SUCCESS,
      payload: addresses
    };
  }

  static FIND_GUARANTORS = '[StudentProfile] Find Guarantors';

  findGuarantors(student): Action {
    return {
      type: StudentProfileActions.FIND_GUARANTORS,
      payload: student
    };
  }

  static FIND_GUARANTORS_SUCCESS = '[StudentProfile] Find Guarantors Success';

  findGuarantorsSuccess(guarantors): Action {
    return {
      type: StudentProfileActions.FIND_GUARANTORS_SUCCESS,
      payload: guarantors
    };
  }

  static FIND_CONTACTS = '[StudentProfile] Find Contacts';

  findContacts(student): Action {
    return {
      type: StudentProfileActions.FIND_CONTACTS,
      payload: student
    };
  }

  static FIND_CONTACTS_SUCCESS = '[StudentProfile] Find Contacts Success';

  findContactsSuccess(contacts): Action {
    return {
      type: StudentProfileActions.FIND_CONTACTS_SUCCESS,
      payload: contacts
    };
  }

  static FIND_GUARDIANS = '[StudentProfile] Find Guardians';

  findGuardians(student): Action {
    return {
      type: StudentProfileActions.FIND_GUARDIANS,
      payload: student
    };
  }

  static FIND_GUARDIANS_SUCCESS = '[StudentProfile] Find Guardians Success';

  findGuardiansSuccess(guardians): Action {
    return {
      type: StudentProfileActions.FIND_GUARDIANS_SUCCESS,
      payload: guardians
    };
  }

  static FIND_ENROLLMENTS_BY_STUDENT = '[StudentProfile] Find Enrollments';

  findEnrollments(student): Action {
    return {
      type: StudentProfileActions.FIND_ENROLLMENTS_BY_STUDENT,
      payload: student
    };
  }

  static FIND_ENROLLMENTS_BY_STUDENT_SUCCESS = '[StudentProfile] Find Enrollments Success';

  findEnrollmentsSuccess(enrollments): Action {
    return {
      type: StudentProfileActions.FIND_ENROLLMENTS_BY_STUDENT_SUCCESS,
      payload: enrollments
    };
  }

  /*==================================================================================================*/
  /*ADD / UPD STUDENT*/
  /*==================================================================================================*/
  static UPDATE_STUDENT = '[StudentProfile] Update Student';

  updateStudent(identityNo): Action {
    return {
      type: StudentProfileActions.UPDATE_STUDENT,
      payload: identityNo
    };
  }

  static UPDATE_STUDENT_SUCCESS = '[StudentProfile] Update Student Success';

  updateStudentSuccess(message): Action {
    return {
      type: StudentProfileActions.UPDATE_STUDENT_SUCCESS,
      payload: message
    };
  }

  /*==================================================================================================*/
  /*ADD / UPD / DEL ADDRESS*/
  /*==================================================================================================*/
  static ADD_ADDRESS = '[StudentProfile] Add Address';

  addAddress(student, address): Action {
    return {
      type: StudentProfileActions.ADD_ADDRESS,
      payload: {student: student, address: address}
    };
  }

  static ADD_ADDRESS_SUCCESS = '[StudentProfile] Add Address Success';

  addAddressSuccess(message): Action {
    return {
      type: StudentProfileActions.ADD_ADDRESS_SUCCESS,
      payload: message
    };
  }

  static UPDATE_ADDRESS = '[StudentProfile] Update Address';

  updateAddress(student, address): Action {
    return {
      type: StudentProfileActions.UPDATE_ADDRESS,
      payload: {student: student, address: address}
    };
  }

  static UPDATE_ADDRESS_SUCCESS = '[StudentProfile] Update Address Success';

  updateAddressSuccess(message): Action {
    return {
      type: StudentProfileActions.UPDATE_ADDRESS_SUCCESS,
      payload: message
    };
  }

  static REMOVE_ADDRESS = '[StudentProfile] Remove Address';

  deleteAddress(student, address): Action {
    return {
      type: StudentProfileActions.REMOVE_ADDRESS,
      payload: {student: student, address: address}
    };
  }

  static REMOVE_ADDRESS_SUCCESS = '[StudentProfile] Remove Address Success';

  deleteAddressSuccess(message): Action {
    return {
      type: StudentProfileActions.REMOVE_ADDRESS_SUCCESS,
      payload: message
    };
  }

  /*==================================================================================================*/
  /*ADD / UPD / DEL GUARANTOR*/
  /*==================================================================================================*/
  static ADD_GUARANTOR = '[StudentProfile] Add Guarantor';

  addGuarantor(student, guarantor): Action {
    return {
      type: StudentProfileActions.ADD_GUARANTOR,
      payload: {student: student, guarantor: guarantor}
    };
  }

  static ADD_GUARANTOR_SUCCESS = '[StudentProfile] Add Guarantor Success';

  addGuarantorSuccess(message): Action {
    return {
      type: StudentProfileActions.ADD_GUARANTOR_SUCCESS,
      payload: message
    };
  }

  static UPDATE_GUARANTOR = '[StudentProfile] Update Guarantor';

  updateGuarantor(student, guarantor): Action {
    return {
      type: StudentProfileActions.UPDATE_GUARANTOR,
      payload: {student: student, guarantor: guarantor}
    };
  }

  static UPDATE_GUARANTOR_SUCCESS = '[StudentProfile] Update Guarantor Success';

  updateGuarantorSuccess(message): Action {
    return {
      type: StudentProfileActions.UPDATE_GUARANTOR_SUCCESS,
      payload: message
    };
  }

  static REMOVE_GUARANTOR = '[StudentProfile] Remove Guarantor';

  deleteGuarantor(student, guarantor): Action {
    return {
      type: StudentProfileActions.REMOVE_GUARANTOR,
      payload: {student: student, guarantor: guarantor}
    };
  }

  static REMOVE_GUARANTOR_SUCCESS = '[StudentProfile] Remove Guarantor Success';

  deleteGuarantorSuccess(message): Action {
    return {
      type: StudentProfileActions.REMOVE_GUARANTOR_SUCCESS,
      payload: message
    };
  }

  /*==================================================================================================*/
  /*ADD / UPD / DEL GUARDIAN*/
  /*==================================================================================================*/
  static ADD_GUARDIAN = '[StudentProfile] Add Guardian';

  addGuardian(student, guardian): Action {
    return {
      type: StudentProfileActions.ADD_GUARDIAN,
      payload: {student: student, guardian: guardian}
    };
  }

  static ADD_GUARDIAN_SUCCESS = '[StudentProfile] Add Guardian Success';

  addGuardianSuccess(message): Action {
    return {
      type: StudentProfileActions.ADD_GUARDIAN_SUCCESS,
      payload: message
    };
  }

  static UPDATE_GUARDIAN = '[StudentProfile] Update Guardian';

  updateGuardian(student, guardian): Action {
    return {
      type: StudentProfileActions.UPDATE_GUARDIAN,
      payload: {student: student, guardian: guardian}
    };
  }

  static UPDATE_GUARDIAN_SUCCESS = '[StudentProfile] Update Guardian Success';

  updateGuardianSuccess(message): Action {
    return {
      type: StudentProfileActions.UPDATE_GUARDIAN_SUCCESS,
      payload: message
    };
  }

  static REMOVE_GUARDIAN = '[StudentProfile] Remove Guardian';

  deleteGuardian(student, guardian): Action {
    return {
      type: StudentProfileActions.REMOVE_GUARDIAN,
      payload: {student: student, guardian: guardian}
    };
  }

  static REMOVE_GUARDIAN_SUCCESS = '[StudentProfile] Remove Guardian Success';

  deleteGuardianSuccess(message): Action {
    return {
      type: StudentProfileActions.REMOVE_GUARDIAN_SUCCESS,
      payload: message
    };
  }

  /*==================================================================================================*/
  /*ADD / UPD / DEL CONTACT*/
  /*==================================================================================================*/
  static ADD_CONTACT = '[StudentProfile] Add Contact';

  addContact(student, contact): Action {
    return {
      type: StudentProfileActions.ADD_CONTACT,
      payload: {student: student, contact: contact}
    };
  }

  static ADD_CONTACT_SUCCESS = '[StudentProfile] Add Contact Success';

  addContactSuccess(message): Action {
    return {
      type: StudentProfileActions.ADD_CONTACT_SUCCESS,
      payload: message
    };
  }

  static UPDATE_CONTACT = '[StudentProfile] Update Contact'

  updateContact(student, contact): Action {
    return {
      type: StudentProfileActions.UPDATE_CONTACT,
      payload: {student: student, contact: contact}
    };
  }

  static UPDATE_CONTACT_SUCCESS = '[StudentProfile] Update Contact Success';

  updateContactSuccess(message): Action {
    return {
      type: StudentProfileActions.UPDATE_CONTACT_SUCCESS,
      payload: message
    };
  }

  static REMOVE_CONTACT = '[StudentProfile] Remove Contact';

  deleteContact(student, contact): Action {
    //console.log("Ini-->",contact);
    return {
      type: StudentProfileActions.REMOVE_CONTACT,
      payload: {student: student, contact: contact}
    };
  }

  static REMOVE_CONTACT_SUCCESS = '[StudentProfile] Remove Contact Success';

  deleteContactSuccess(message): Action {
    return {
      type: StudentProfileActions.REMOVE_CONTACT_SUCCESS,
      payload: message
    };
  }

  static SWITCH_STUDY_MODE = '[StudentProfile] Switch Study Mode';

  switchStudyMode(student, switcher): Action {
    return {
      type: StudentProfileActions.SWITCH_STUDY_MODE,
      payload: {student: student, switchStudyMode: switcher}
    };
  }

  static SWITCH_STUDY_MODE_SUCCESS = '[StudentProfile] Switch Study Mode Success';

  switchStudyModeSuccess(message): Action {
    return {
      type: StudentProfileActions.SWITCH_STUDY_MODE_SUCCESS,
      payload: message
    };
  }

  static TRANSFER_COHORT = '[StudentProfile] Transfer Cohort ';

  transferCohort(student, transfer): Action {
    return {
      type: StudentProfileActions.TRANSFER_COHORT,
      payload: {student: student, transferCohort: transfer}
    };
  }

  static TRANSFER_COHORT_SUCCESS = '[StudentProfile] Transfer Cohort Success';

  transferCohortSuccess(message): Action {
    return {
      type: StudentProfileActions.TRANSFER_COHORT_SUCCESS,
      payload: message
    };
  }
}
