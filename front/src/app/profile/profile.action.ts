import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';


@Injectable()
export class ProfileActions {

  static FIND_PROFILES = '[Profile] Find Profiles';
  findProfiles(): Action {
    return {
      type: ProfileActions.FIND_PROFILES
    };
  }

  static FIND_PROFILES_SUCCESS = '[Profile] Find Profiles Success';
  findProfilesSuccess(students): Action {
    console.log("findProfilesSuccess");
    console.log("students: " + students.length);
    return {
      type: ProfileActions.FIND_PROFILES_SUCCESS,
      payload: students
    };
  }

  static FIND_PROFILE = '[Profile] Find Profile';
  findProfile(identityNo): Action {
    return {
      type: ProfileActions.FIND_PROFILE,
      payload: identityNo
    };
  }

  static FIND_STUDENT_BY_MATRICNO = '[Profile] Find Profile';
  findStudentByMatricNo(identityNo): Action {
    return {
      type: ProfileActions.FIND_STUDENT_BY_MATRICNO,
      payload: identityNo
    };
  }


  static FIND_PROFILE_SUCCESS = '[Profile] Find Profile Success';
  getProfileSuccess(student): Action {
    return {
      type: ProfileActions.FIND_PROFILE_SUCCESS,
      payload: student
    };
  }

  static RESET_PROFILE = '[Profile] Reset Blank Profile';
  resetProfile(): Action {
    return {
      type: ProfileActions.RESET_PROFILE
    };
  }

  static UPDATE_PROFILE = '[Profile] Update Profile';
  updateProfile(student): Action {
    return {
      type: ProfileActions.UPDATE_PROFILE,
      payload: student
    };
  }

  static UPDATE_PROFILE_SUCCESS = '[Profile] Update Profile Success';
  updateProfileSuccess(student): Action {
    return {
      type: ProfileActions.UPDATE_PROFILE_SUCCESS,
      payload: student
    };
  }

  static CREATE_PROFILE = '[Profile] Create Profile';
  createProfile(student): Action {
    return {
      type: ProfileActions.CREATE_PROFILE,
      payload: student
    };
  }

  static CREATE_PROFILE_SUCCESS = '[Profile] Create Profile Success';
  createProfileSuccess(student): Action {
    return {
      type: ProfileActions.CREATE_PROFILE_SUCCESS,
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
}
