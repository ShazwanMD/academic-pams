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

  static FIND_STUDENTS_BY_IDENTITY_NO = '[Profile] Find Students By Identity No';

  findStudentsByIdentityNo(identityNo): Action {
    return {
      type: StudentProfileActions.FIND_STUDENTS_BY_IDENTITY_NO,
      payload: identityNo
    };
  }

  static FIND_STUDENTS_BY_IDENTITY_NO_SUCCESS = '[Profile] Find Students By Identity No Success';

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

  static ADD_STUDENT_CONTACT = '[Profile] Add Student Contact';

  addStudentContact(student, contact): Action {
    console.log("add student contact");
    return {
      type: StudentProfileActions.ADD_STUDENT_CONTACT,
      payload: { student: student, contact: contact }
    };
  }

  static ADD_STUDENT_CONTACT_SUCCESS = '[Profile] Add Student Contact Success';

  addStudentContactSuccess(message): Action {
    console.log("add student contact success");
    return {
      type: StudentProfileActions.ADD_STUDENT_CONTACT_SUCCESS,
      payload: message
    };
  }

  static UPDATE_STUDENT_CONTACT = '[Profile] Update Student Contact'

  updateStudentContact(student, contact): Action {
    console.log("update student contact");
    return {
      type: StudentProfileActions.UPDATE_STUDENT_CONTACT,
      payload: { student: student, contact: contact }
    };
  }

  static UPDATE_STUDENT_CONTACT_SUCCESS = '[Profile] Update Student Contact Success';

  updateStudentContactSuccess(message): Action {
    console.log("update student contact success");
    return {
      type: StudentProfileActions.UPDATE_STUDENT_CONTACT_SUCCESS,
      payload: message
    };
  }

  static REMOVE_STUDENT_CONTACT = '[Profile] Remove Student Contact';

  deleteStudentContact(student, contact): Action {
    console.log("Remove student contact");
    return {
      type: StudentProfileActions.REMOVE_STUDENT_CONTACT,
      payload: { student: student, contact: contact }
    };
  }

  static REMOVE_STUDENT_CONTACT_SUCCESS = '[Profile] Remove Student Contact Success';

  deleteStudentContactSuccess(message): Action {
    console.log("Remove student contact success");
    return {
      type: StudentProfileActions.REMOVE_STUDENT_CONTACT_SUCCESS,
      payload: message
    };
  }

}
