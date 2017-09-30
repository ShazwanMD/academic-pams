import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

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

  static FIND_ACADEMIC_SESSION_BY_CODE = '[AcademicSession] Find AcademicSession By Code';

  findAcademicSessionByCode(code): Action {
    return {
      type: AcademicSessionActions.FIND_ACADEMIC_SESSION_BY_CODE,
      payload: code
    };
  }

  static FIND_ACADEMIC_SESSION_BY_CODE_SUCCESS = '[AcademicSession] Find AcademicSession By Code Success';

  findAcademicSessionByCodeSuccess(code): Action {
    console.log("findAcademicSessionByCode");
    console.log("academicSession" + code)
    return {
      type: AcademicSessionActions.FIND_ACADEMIC_SESSION_BY_CODE_SUCCESS,
      payload: code
    };
  }
  
  //find graduation by session
  static FIND_GRADUATIONS_BY_ACADEMICSESSION = '[AcademicSession] Find Graduations By Session';

  findGraduationsByAcademicSession( academicSession ): Action {
      return {
          type: AcademicSessionActions.FIND_GRADUATIONS_BY_ACADEMICSESSION,
          payload: academicSession
      };
  }

  static FIND_GRADUATIONS_BY_ACADEMICSESSION_SUCCESS = '[AcademicSession] Find Graduations By Session Success';

  findGraduationsByAcademicSessionSuccess( graduations ): Action {
      return {
          type: AcademicSessionActions.FIND_GRADUATIONS_BY_ACADEMICSESSION_SUCCESS,
          payload: graduations
      };
  }

  static SAVE_ACADEMIC_SESSION = '[AcademicSession] Save AcademicSession';

  saveAcademicSession(academicSession): Action {
    console.log("saveAcademicSession");
    return {
      type: AcademicSessionActions.SAVE_ACADEMIC_SESSION,
      payload: academicSession
    };
  }

  static SAVE_ACADEMIC_SESSION_SUCCESS = '[AcademicSession] Save AcademicSession Success';

  saveAcademicSessionSuccess(message): Action {
    console.log("saveAcademicSessionSuccess");
    return {
      type: AcademicSessionActions.SAVE_ACADEMIC_SESSION_SUCCESS,
      payload: {status: message}
    };
  }

  static UPDATE_ACADEMIC_SESSION = '[AcademicSession] Update AcademicSession';

  updateAcademicSession(academicSession): Action {
    console.log("updateAcademicSession")
    return {
      type: AcademicSessionActions.UPDATE_ACADEMIC_SESSION,
      payload: academicSession
    };
  }

  static UPDATE_ACADEMIC_SESSION_SUCCESS = '[AcademicSession] Update AcademicSession';

  updateAcademisSessionSuccess(academicSession): Action {
    console.log("updateAcademicSessionSession");
    console.log("academicSession: " + academicSession);
    return {
      type: AcademicSessionActions.UPDATE_ACADEMIC_SESSION_SUCCESS,
      payload: academicSession
    };
  }

  static REMOVE_ACADEMIC_SESSION = '[AcademicSession] Remove AcademicSession';

  removeAcademicSession(academicSession): Action {
    console.log("removeAcademicSession");
    console.log("academicSession: " + academicSession);
    return {
      type: AcademicSessionActions.REMOVE_ACADEMIC_SESSION,
      payload: academicSession
    };
  }

  static REMOVE_ACADEMIC_SESSION_SUCCESS = '[AcademicSession] Remove AcademicSession Success';

  removeAcademicSessionSuccess(academicSession): Action {
    console.log("removeAcademicSessionSuccess");
    console.log("academicSession: " + academicSession);
    return {
      type: AcademicSessionActions.REMOVE_ACADEMIC_SESSION_SUCCESS,
      payload: academicSession
    };
  }

  static ACTIVATE_ACADEMIC_SESSION = '[AcademicSession] Activate AcademicSession';

  activateAcademicSession(academicSession): Action {
    console.log("activateAcademicSession");
    console.log("academicSession: " + academicSession);
    return {
      type: AcademicSessionActions.ACTIVATE_ACADEMIC_SESSION,
      payload: academicSession
    };
  }


  static ACTIVATE_ACADEMIC_SESSION_SUCCESS = '[AcademicSession] Activate AcademicSession Success';

  activateAcademicSessionSuccess(academicSession): Action {
    console.log("activateAcademicSessionSuccess");
    console.log("academicSession: " + academicSession);
    return {
      type: AcademicSessionActions.ACTIVATE_ACADEMIC_SESSION_SUCCESS,
      payload: academicSession
    };
  }

  static DEACTIVATE_ACADEMIC_SESSION = '[AcademicSession] Deactivate AcademicSession';

  deactivateAcademicSession(academicSession): Action {
    console.log("deactivateAcademicSession");
    console.log("academicSession: " + academicSession);
    return {
      type: AcademicSessionActions.DEACTIVATE_ACADEMIC_SESSION,
      payload: academicSession
    };
  }

  static DEACTIVATE_ACADEMIC_SESSION_SUCCESS = '[AcademicSession] Activate AcademicSession Success';

  deactivateAcademicSessionSuccess(academicSession): Action {
    console.log("deactivateAcademicSessionSuccess");
    console.log("academicSession: " + academicSession);
    return {
      type: AcademicSessionActions.DEACTIVATE_ACADEMIC_SESSION_SUCCESS,
      payload: academicSession
    };
  }


}
