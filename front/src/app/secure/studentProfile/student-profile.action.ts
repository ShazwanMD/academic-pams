import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';

@Injectable()
export class StudentProfileActions {


  /*==================================================================================================*/
  /*FINDING Dashboard*/
  /*==================================================================================================*/

  static FIND_STUDENT_BY_USER = '[StudentProfile] Find Student By User';

  findStudentByUser(): Action {
    console.log("Find Student By User")
    return {
      type: StudentProfileActions.FIND_STUDENT_BY_USER,
    };
  }

  static FIND_STUDENT_BY_USER_SUCCESS = '[StudentProfile] Find Student By User Success';

  findStudentByUserSuccess(student): Action {
    console.log("Find Student By User Success")
    return {
      type: StudentProfileActions.FIND_STUDENT_BY_USER_SUCCESS,
      payload: student
    };
  }

  static FIND_STUDENTS_BY_IDENTITY_NO = '[StudentProfile] Find Students By Identity No';

  findStudentsByIdentityNo(identityNo): Action {
    return {
      type: StudentProfileActions.FIND_STUDENTS_BY_IDENTITY_NO,
      payload: identityNo
    };
  }

  static FIND_STUDENTS_BY_IDENTITY_NO_SUCCESS = '[StudentProfile] Find Students By Identity No Success';

  findStudentsByIdentityNoSuccess(student): Action {
    return {
      type: StudentProfileActions.FIND_STUDENTS_BY_IDENTITY_NO_SUCCESS,
      payload: student
    };
  }

  static FIND_ADDRESSES_BY_STUDENT = '[StudentProfile] Find Addresses By Student';

  findAddressessByStudent(): Action {
    console.log("Find Address By Student")
    return {
      type: StudentProfileActions.FIND_ADDRESSES_BY_STUDENT,

    };
  }

  static FIND_ADDRESSES_BY_STUDENT_SUCCESS = '[StudentProfile] Find Addresses By Student Success';

  findAddressessByStudentSuccess(addresses): Action {
    console.log("Find Address By Student Success")
    return {
      type: StudentProfileActions.FIND_ADDRESSES_BY_STUDENT_SUCCESS,
      payload: addresses
    };
  }

  /*==================================================================================================*/
  /*ADDRESS
  /*==================================================================================================*/
  static ADD_STUDENT_ADDRESS = '[StudentProfile] Add Student Address';

  addStudentAddress(student, address): Action {
    console.log("add student address");
    return {
      type: StudentProfileActions.ADD_STUDENT_ADDRESS,
      payload: { student: student, address: address }
    };
  }

  static ADD_STUDENT_ADDRESS_SUCCESS = '[StudentProfile] Add Student Address Success';

  addStudentAddressSuccess(message): Action {
    console.log("add student address success");
    return {
      type: StudentProfileActions.ADD_STUDENT_ADDRESS_SUCCESS,
      payload: message
    };
  }

  static UPDATE_STUDENT_ADDRESS = '[StudentProfile] Update Student Address';

  updateStudentAddress(student, address): Action {
    console.log("edit student address");
    return {
      type: StudentProfileActions.UPDATE_STUDENT_ADDRESS,
      payload: { student: student, address: address }
    };
  }

  static UPDATE_STUDENT_ADDRESS_SUCCESS = '[StudentProfile] Update Student Address Success';

  updateStudentAddressSuccess(message): Action {
    console.log("edit student address success");
    return {
      type: StudentProfileActions.UPDATE_STUDENT_ADDRESS_SUCCESS,
      payload: message
    };
  }

  static REMOVE_STUDENT_ADDRESS = '[StudentProfile] Remove Student Address';

  deleteStudentAddress(student, address): Action {
    console.log("delete student address");
    return {
      type: StudentProfileActions.REMOVE_STUDENT_ADDRESS,
      payload: { student: student, address: address }
    };
  }

  static REMOVE_STUDENT_ADDRESS_SUCCESS = '[StudentProfile] Remove Student Address Success';

  deleteStudentAddressSuccess(message): Action {
    console.log("delete student address success");
    return {
      type: StudentProfileActions.REMOVE_STUDENT_ADDRESS_SUCCESS,
      payload: message
    };
  }

  /*==================================================================================================*/
  /*GUARDIAN
  /*==================================================================================================*/


  static ADD_STUDENT_CONTACT = '[StudentProfile] Add Student Contact';

  addStudentContact(student, contact): Action {
    console.log("add student contact");
    return {
      type: StudentProfileActions.ADD_STUDENT_CONTACT,
      payload: { student: student, contact: contact }
    };
  }

  static ADD_STUDENT_CONTACT_SUCCESS = '[StudentProfile] Add Student Contact Success';

  addStudentContactSuccess(message): Action {
    console.log("add student contact success");
    return {
      type: StudentProfileActions.ADD_STUDENT_CONTACT_SUCCESS,
      payload: message
    };
  }

  static UPDATE_STUDENT_CONTACT = '[StudentProfile] Update Student Contact'

  updateStudentContact(student, contact): Action {
    console.log("update student contact");
    return {
      type: StudentProfileActions.UPDATE_STUDENT_CONTACT,
      payload: { student: student, contact: contact }
    };
  }

  static UPDATE_STUDENT_CONTACT_SUCCESS = '[StudentProfile] Update Student Contact Success';

  updateStudentContactSuccess(message): Action {
    console.log("update student contact success");
    return {
      type: StudentProfileActions.UPDATE_STUDENT_CONTACT_SUCCESS,
      payload: message
    };
  }

  static REMOVE_STUDENT_CONTACT = '[StudentProfile] Remove Student Contact';

  deleteStudentContact(student, contact): Action {
    console.log("Remove student contact");
    return {
      type: StudentProfileActions.REMOVE_STUDENT_CONTACT,
      payload: { student: student, contact: contact }
    };
  }

  static REMOVE_STUDENT_CONTACT_SUCCESS = '[StudentProfile] Remove Student Contact Success';

  deleteStudentContactSuccess(message): Action {
    console.log("Remove student contact success");
    return {
      type: StudentProfileActions.REMOVE_STUDENT_CONTACT_SUCCESS,
      payload: message
    };
  }

  /*==================================================================================================*/
  /*GUARDIAN
  /*==================================================================================================*/
  static ADD_STUDENT_GUARDIAN = '[StudentProfile] Add Student Guardian';

  addStudentGuardian(student, guardian): Action {
    console.log("add student guardian");
    return {
      type: StudentProfileActions.ADD_STUDENT_GUARDIAN,
      payload: { student: student, guardian: guardian }
    };
  }

  static ADD_STUDENT_GUARDIAN_SUCCESS = '[StudentProfile] Add Student Guardian Success';

  addStudentGuardianSuccess(message): Action {
    console.log("add student guardian success");
    return {
      type: StudentProfileActions.ADD_STUDENT_GUARDIAN_SUCCESS,
      payload: message
    };
  }

  static UPDATE_STUDENT_GUARDIAN = '[StudentProfile] Update Student Guardian';

  updateStudentGuardian(student, guardian): Action {
    console.log("update student guardian");
    return {
      type: StudentProfileActions.UPDATE_STUDENT_GUARDIAN,
      payload: { student: student, guardian: guardian }
    };
  }

  static UPDATE_STUDENT_GUARDIAN_SUCCESS = '[StudentProfile] Update Student Guardian Success';

  updateStudentGuardianSuccess(message): Action {
    console.log("update student guardian success");
    return {
      type: StudentProfileActions.UPDATE_STUDENT_GUARDIAN_SUCCESS,
      payload: message
    };
  }

  static REMOVE_STUDENT_GUARDIAN = '[StudentProfile] Remove Student Guardian';

  deleteStudentGuardian(student, guardian): Action {
    console.log("remove student guardian");
    return {
      type: StudentProfileActions.REMOVE_STUDENT_GUARDIAN,
      payload: { student: student, guardian: guardian }
    };
  }

  static REMOVE_STUDENT_GUARDIAN_SUCCESS = '[StudentProfile] Remove Student Guardian Success';

  deleteStudentGuardianSuccess(message): Action {
    console.log("remove student guardian success");
    return {
      type: StudentProfileActions.REMOVE_STUDENT_GUARDIAN_SUCCESS,
      payload: message
    };
  }

  /*==================================================================================================*/
  /*GUARANTOR
  /*==================================================================================================*/
  static ADD_STUDENT_GUARANTOR = '[StudentProfile] Add Student Guarantor';

  addStudentGuarantor(student, guarantor): Action {
    return {
      type: StudentProfileActions.ADD_STUDENT_GUARANTOR,
      payload: { student: student, guarantor: guarantor }
    };
  }

  static ADD_STUDENT_GUARANTOR_SUCCESS = '[StudentProfile] Add Student Guarantor Success';

  addStudentGuarantorSuccess(message): Action {
    return {
      type: StudentProfileActions.ADD_STUDENT_GUARANTOR_SUCCESS,
      payload: message
    };
  }

  static UPDATE_STUDENT_GUARANTOR = '[StudentProfile] Update Student Guarantor';

  updateStudentGuarantor(student, guarantor): Action {
    return {
      type: StudentProfileActions.UPDATE_STUDENT_GUARANTOR,
      payload: { student: student, guarantor: guarantor }
    };
  }

  static UPDATE_STUDENT_GUARANTOR_SUCCESS = '[StudentProfile] Update Student Guarantor Success';

  updateStudentGuarantorSuccess(message): Action {
    return {
      type: StudentProfileActions.UPDATE_STUDENT_GUARANTOR_SUCCESS,
      payload: message
    };
  }

  static REMOVE_STUDENT_GUARANTOR = '[Profile] Remove Student Guarantor';

  deleteStudentGuarantor(student, guarantor): Action {
    return {
      type: StudentProfileActions.REMOVE_STUDENT_GUARANTOR,
      payload: { student: student, guarantor: guarantor }
    };
  }

  static REMOVE_STUDENT_GUARANTOR_SUCCESS = '[Profile] Remove Student Guarantor Success';

  deleteStudentGuarantorSuccess(message): Action {
    return {
      type: StudentProfileActions.REMOVE_STUDENT_GUARANTOR_SUCCESS,
      payload: message
    };
  }

  /*==================================================================================================*/
  /*STUDENT
  /*==================================================================================================*/
  static UPDATE_STUDENT_DETAIL = '[StudentProfile] Update Student Detail';

  updateStudentDetail(identityNo): Action {
    console.log("update student detail");
    return {
      type: StudentProfileActions.UPDATE_STUDENT_DETAIL,
      payload: identityNo
    };
  }

  static UPDATE_STUDENT_DETAIL_SUCCESS = '[StudentProfile] Update Student Detail Success';

  updateStudentDetailSuccess(message): Action {
    console.log("update student detail success");
    return {
      type: StudentProfileActions.UPDATE_STUDENT_DETAIL_SUCCESS,
      payload: message
    };
  }

}
