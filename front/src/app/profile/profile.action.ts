import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';


@Injectable()
export class ProfileActions {

  static FIND_STUDENTS = '[Profile] Find Students';
  findStudents(): Action {
    return {
      type: ProfileActions.FIND_STUDENTS
    };
  }

  static FIND_STUDENTS_SUCCESS = '[Profile] Find Students Success';
  findStudentsSuccess(students): Action {
    console.log("findStudentsSuccess");
    return {
      type: ProfileActions.FIND_STUDENTS_SUCCESS,
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
    console.log("findStudentsSuccess");
    return {
      type: ProfileActions.FIND_STUDENT_BY_IDENTITY_NO_SUCCESS,
      payload: student
    };
  }


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

   static UPDATE_STUDENT = '[Profile] Update Student';

  updateStudent(identityNo): Action {
    console.log("updateStudent");
    return {
      type: ProfileActions.UPDATE_STUDENT,
      payload: identityNo
    };
  }

  static UPDATE_STUDENT_SUCCESS = '[Profile] Update Student Success';

  updateStudentSuccess(message): Action {
    console.log("updateStudentSuccess");
    return {
      type: ProfileActions.UPDATE_STUDENT_SUCCESS,
      payload: message
    };
  }
}
