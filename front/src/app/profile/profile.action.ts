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
}
