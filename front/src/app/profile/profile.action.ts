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

  static ADD_CONTACT = '[Profile] Add Contact';

  addContact(student, contact): Action {
    console.log("addContact");
    return {
      type: ProfileActions.ADD_CONTACT,
      payload: {student: student, contact: contact}
    };
  }


  static ADD_CONTACT_SUCCEESS = '[Profile] Add Contact Success';

  addContactSuccess(message): Action {
    console.log("addContactSuccess");
    return {
      type: ProfileActions.ADD_CONTACT_SUCCEESS,
      payload: message
    };
  }

  static ADD_ADDRESS = '[Profile] Add Address';

  addAddress(student, address): Action {
    console.log("addAddress");
    return {
      type: ProfileActions.ADD_ADDRESS,
      payload: {student: student, address: address}
    };
  }


  static ADD_ADDRESS_SUCCEESS = '[Profile] Add Address Success';

  addAddressSuccess(message): Action {
    console.log("addAddressSuccess");
    return {
      type: ProfileActions.ADD_ADDRESS_SUCCEESS,
      payload: message
    };
  }

  static ADD_GUARANTOR = '[Profile] Add Guarantor';

  addGuarantor(student, guarantor): Action {
    console.log("addGuarantor");
    return {
      type: ProfileActions.ADD_GUARANTOR,
      payload: {student: student, guarantor: guarantor}
    };
  }


  static ADD_GUARANTOR_SUCCEESS = '[Profile] Add Guarantor Success';

  addGuarantorSuccess(message): Action {
    console.log("addGuarantorSuccess");
    return {
      type: ProfileActions.ADD_GUARANTOR_SUCCEESS,
      payload: message
    };
  }

  static ADD_GUARDIAN = '[Profile] Add Guardian';

  addGuardian(student, guardian): Action {
    console.log("addGuardian");
    return {
      type: ProfileActions.ADD_GUARDIAN,
      payload: {student: student, guardian: guardian}
    };
  }


  static ADD_GUARDIAN_SUCCEESS = '[Profile] Add Guardian Success';

  addGuardianSuccess(message): Action {
    console.log("addGuardianSuccess");
    return {
      type: ProfileActions.ADD_GUARDIAN_SUCCEESS,
      payload: message
    };
  }

    static REMOVE_CONTACT = '[Profile] Remove Contact';

  deleteContact(student,contact): Action {
    console.log("deleteContact");
    return {
      type: ProfileActions.REMOVE_CONTACT,
      payload: {student:student, contact:contact}
    };
  }

  static REMOVE_CONTACT_SUCCESS = '[Profile] Remove Contact  Success';

  deleteContactSuccess(message): Action {
    console.log("deleteContactSuccess");
    return {
      type: ProfileActions.REMOVE_CONTACT_SUCCESS,
      payload: message
    };
  }
  

}
