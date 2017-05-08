import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AcademicSessionActions {

  static FIND_SESSIONS = '[Session] Find Sessions';
  findAcademicSession(): Action {
    return {
      type: AcademicSessionActions.FIND_SESSION,
    };
  }

  static FIND_SESSIONS_SUCCESS = '[Session] Find Sessions Success';
  findSessionsSuccess(sessions): Action {
    console.log("findSessionsSuccess");
    console.log("sessions: " + sessions.length);
    return {
      type: AcademicSessionActions.FIND_SESSIONS_SUCCESS,
      payload: sessions
    };
  }

  static FIND_SESSION = '[Session] Find Session';
  findSession(code): Action {
    return {
      type: AcademicSessionActions.FIND_SESSION,
      payload: code
    };
  }

  static FIND_SESSION_SUCCESS = '[Session] Find Session Success';
  findSessionsuccess(session): Action {
    return {
      type: AcademicSessionActions.FIND_SESSION_SUCCESS,
      payload: session
    };
  }

  static RESET_SESSION = '[Session] Reset Blank Session';
  resetSession(): Action {
    return {
      type: AcademicSessionActions.RESET_SESSION
    };
  }

  static SAVE_SESSION = '[Session] Save Session';
  saveSession (session): Action {
    return {
      type: AcademicSessionActions.SAVE_SESSION,
      payload: session
    };
  }

  static SAVE_SESSION_SUCCESS = '[Session] Save Session Success';
  saveSessionSuccess(session): Action {
    return {
      type: AcademicSessionActions.SAVE_SESSION_SUCCESS,
      payload: session
    };
  }

  static CREATE_SESSION = '[Session] Create Session';
  createSession(session): Action {
    return {
      type: AcademicSessionActions.CREATE_SESSION,
      payload: session
    };
  }

  static CREATE_SESSION_SUCCESS = '[Session] Create Session Success';
  createSessionSuccess(session): Action {
    return {
      type: AcademicSessionActions.CREATE_SESSION_SUCCESS,
      payload: session  
    };
  }

  static REMOVE_SESSION = '[Session] Remove Session';
  removeSession(session): Action {
    return {
      type: AcademicSessionActions.REMOVE_SESSION,
      payload: session
    };
  }

  static REMOVE_SESSION_SUCCESS = '[Session] Remove Session Success';
  removeSessionSuccess(session): Action {
    return {
      type: AcademicSessionActions.REMOVE_SESSION_SUCCESS,
      payload: session
    };
  }
}
