import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AcademicSessionActions {

  static FIND_ACADEMIC_SESSIONS = '[AcademicSession] FindAcademicSessions';
  findAcademicSessions(): Action {
    return {
      type: AcademicSessionActions.FIND_ACADEMIC_SESSIONS
    };
  }

  static FIND_ACADEMIC_SESSIONS_SUCCESS = '[AcademicSession] Find AcademicSessions Success';
  findAcademicSessionsSuccess(AcademicSessions): Action {
    return {
      type: AcademicSessionActions.FIND_ACADEMIC_SESSIONS_SUCCESS,
      payload: AcademicSessions
    };
  }

  static RESET_ACADEMIC_SESSION = '[AcademicSession] Reset AcademicSession';
  resetAcademicSession(): Action {
    return {
      type: AcademicSessionActions.RESET_ACADEMIC_SESSIONS
    };
  }

  static SAVE_ACADEMIC_SESSIONS = '[AcademicSession] Save AcademicSession';
  saveAcademicSession(AcademicSession): Action {
    return {
      type: AcademicSessionActions.SAVE_ACADEMIC_SESSIONS,
      payload: AcademicSession
    };
  }

  static SAVE_ACADEMIC_SESSIONS_SUCCESS = '[AcademicSession] Save AcademicSession Success';
  saveAcademicSessionSuccess(academicSession): Action {
    return {
      type: AcademicSessionActions.SAVE_ACADEMIC_SESSIONS_SUCCESS,
      payload: academicSession
    };
  }

  static CREATE_ACADEMIC_SESSIONS= '[AcademicSession] Create AcademicSession';
  createAcademicSession(AcademicSession): Action {
    return {
      type: AcademicSessionActions.CREATE_ACADEMIC_SESSIONS,
      payload: AcademicSession
    };
  }

  static CREATE_ACADEMIC_SESSIONS_SUCCESS = '[AcademicSession] Create AcademicSession Success';
  createAcademicSessionSuccess(AcademicSession): Action {
    return {
      type: AcademicSessionActions.CREATE_ACADEMIC_SESSIONS_SUCCESS,
      payload: AcademicSession
    };
  }

  static REMOVE_ACADEMIC_SESSIONS = '[AcademicSession] Remove AcademicSession';
  removeAcademicSession(AcademicSession): Action {
    return {
      type: AcademicSessionActions.REMOVE_ACADEMIC_SESSIONS,
      payload: AcademicSession
    };
  }

  static REMOVE_ACADEMIC_SESSIONS_SUCCESS = '[AcademicSession] Remove AcademicSession Success';
  removeAcademicSessionSuccess(AcademicSession): Action {
    return {
      type: AcademicSessionActions.REMOVE_ACADEMIC_SESSIONS_SUCCESS,
      payload: AcademicSession
    };
  }
}
