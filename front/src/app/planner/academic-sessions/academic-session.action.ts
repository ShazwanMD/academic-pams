import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

// todo(abiq): ACTIVATE_SESSION, DEACTIVATE SESSION

@Injectable()
export class AcademicSessionActions {

  static FIND_ACADEMIC_SESSIONS = '[AcademicSession] Find AcademicSessions';
  findAcademicSessions(): Action {
    return {
      type: AcademicSessionActions.FIND_ACADEMIC_SESSIONS,
    };
  }

  static FIND_ACADEMIC_SESSIONS_SUCCESS = '[AcademicSession] Find AcademicSessions Success';
  findAcademicSessionsSuccess(academicSessions): Action {
    console.log("findAcademicSessionsSuccess");
    console.log("academicSessions: " + academicSessions.length);
    return {
      type: AcademicSessionActions.FIND_ACADEMIC_SESSIONS_SUCCESS,
      payload: academicSessions
    };
  }

  static FIND_ACADEMIC_SESSION = '[AcademicSession] Find AcademicSession';
  findAcademicSession(code): Action {
    return {
      type: AcademicSessionActions.FIND_ACADEMIC_SESSION,
      payload: code
    };
  }

  static FIND_ACADEMIC_SESSION_SUCCESS = '[AcademicSession] Find AcademicSession Success';
  findAcademicSessionsuccess(academicSession): Action {
    return {
      type: AcademicSessionActions.FIND_ACADEMIC_SESSION_SUCCESS,
      payload: academicSession
    };
  }

  static SAVE_ACADEMIC_SESSION = '[AcademicSession] Save AcademicSession';
  saveAcademicSession (academicSession): Action {
    return {
      type: AcademicSessionActions.SAVE_ACADEMIC_SESSION,
      payload: academicSession
    };
  }

  static SAVE_ACADEMIC_SESSION_SUCCESS = '[AcademicSession] Save AcademicSession Success';
  saveAcademicSessionSuccess(academicSession): Action {
    return {
      type: AcademicSessionActions.SAVE_ACADEMIC_SESSION_SUCCESS,
      payload: academicSession
    };
  }

  static UPDATE_ACADEMIC_SESSION =  '[AcademicSession] Update AcademicSession';
  updateAcademicSession(academicSession): Action {
    return {
      type: AcademicSessionActions.UPDATE_ACADEMIC_SESSION,
      payload: academicSession
    };
  }

  static UPDATE_ACADEMIC_SESSION_SUCCESS =  '[AcademicSession] Update AcademicSession';
  updateAcademisSessionSuccess(academicSession): Action {
    return {
      type: AcademicSessionActions.UPDATE_ACADEMIC_SESSION_SUCCESS,
      payload: academicSession
    };
  }

  static REMOVE_ACADEMICSESSION = '[AcademicSession] Remove AcademicSession';
  removeAcademicSession(academicSession): Action {
    return {
      type: AcademicSessionActions.REMOVE_ACADEMICSESSION,
      payload: academicSession
    };
  }

  static REMOVE_ACADEMIC_SESSION_SUCCESS = '[AcademicSession] Remove AcademicSession Success';
  removeAcademicSessionSuccess(academicSession): Action {
    return {
      type: AcademicSessionActions.REMOVE_ACADEMIC_SESSION_SUCCESS,
      payload: academicSession
    };
  }
}
