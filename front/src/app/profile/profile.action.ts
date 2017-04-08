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
  findProfilesSuccess(accounts): Action {
    console.log("findProfilesSuccess");
    console.log("accounts: " + accounts.length);
    return {
      type: ProfileActions.FIND_PROFILES_SUCCESS,
      payload: accounts
    };
  }

  static FIND_PROFILE = '[Profile] Find Profile';
  findProfile(identityNo): Action {
    return {
      type: ProfileActions.FIND_PROFILE,
      payload: identityNo
    };
  }

  static FIND_PROFILE_SUCCESS = '[Profile] Find Profile Success';
  getProfileSuccess(account): Action {
    return {
      type: ProfileActions.FIND_PROFILE_SUCCESS,
      payload: account
    };
  }

  static RESET_PROFILE = '[Profile] Reset Blank Profile';
  resetProfile(): Action {
    return {
      type: ProfileActions.RESET_PROFILE
    };
  }

  static UPDATE_PROFILE = '[Profile] Update Profile';
  updateProfile(account): Action {
    return {
      type: ProfileActions.UPDATE_PROFILE,
      payload: account
    };
  }

  static UPDATE_PROFILE_SUCCESS = '[Profile] Update Profile Success';
  updateProfileSuccess(account): Action {
    return {
      type: ProfileActions.UPDATE_PROFILE_SUCCESS,
      payload: account
    };
  }

  static CREATE_PROFILE = '[Profile] Create Profile';
  createProfile(account): Action {
    return {
      type: ProfileActions.CREATE_PROFILE,
      payload: account
    };
  }

  static CREATE_PROFILE_SUCCESS = '[Profile] Create Profile Success';
  createProfileSuccess(account): Action {
    return {
      type: ProfileActions.CREATE_PROFILE_SUCCESS,
      payload: account
    };
  }
}
