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

}
