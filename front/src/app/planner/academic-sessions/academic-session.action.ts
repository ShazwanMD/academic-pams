import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AcademicSessionActions {

  static FIND_ACADEMICSESSIONS = '[AcademicSession] FindAcademicSessions';
  findAcademicSessions(): Action {
    return {
      type: AcademicSessionActions.FIND_ACADEMICSESSIONS
    };
  }

  static FIND_ACADEMICSESSIONS_SSUCCESS = '[AcademicSession] Find AcademicSessions Success';
  findAcademicSessionsSuccess(AcademicSessions): Action {
    return {
      type: AcademicSessionActions.FIND_ACADEMICSESSIONS_SUCCESS,
      payload: AcademicSessions
    };
  }

  static FIND_ACADEMICSESSIONS = '[AcademicSession] Find AcademicSession';
  findAcademicSession(code): Action {
    return {
      type: AcademicSessionActions.FIND_ACADEMICSESSIONS,
      payload: code
    };
  }

  static FIND_ACADEMICSESSIONS_SUCCESS = '[AcademicSession] Find AcademicSession Success';
  findAcademicSessionsuccess(AcademicSession): Action {
    return {
      type: AcademicSessionActions.FIND_ACADEMICSESSIONS_SUCCESS,
      payload: AcademicSession
    };
  }

  static RESET_AcademicSession = '[AcademicSession] Reset AcademicSession';
  resetAcademicSession(): Action {
    return {
      type: AcademicSessionActions.RESET_ACADEMICSESSIONS
    };
  }

  static SAVE_ACADEMICSESSIONS = '[AcademicSession] Save AcademicSession';
  saveAcademicSession(AcademicSession): Action {
    return {
      type: AcademicSessionActions.SAVE_ACADEMICSESSIONS,
      payload: AcademicSession
    };
  }

  static SAVE_ACADEMICSESSIONS_SUCCESS = '[AcademicSession] Save AcademicSession Success';
  saveAcademicSessionSuccess(AcademicSession): Action {
    return {
      type: AcademicSessionActions.SAVE_ACADEMICSESSIONS_SUCCESS,
      payload: AcademicSession
    };
  }

  static CREATE_ACADEMICSESSIONS= '[AcademicSession] Create AcademicSession';
  createAcademicSession(AcademicSession): Action {
    return {
      type: AcademicSessionActions.CREATE_ACADEMICSESSIONS,
      payload: AcademicSession
    };
  }

  static CREATE_ACADEMICSESSIONS_SUCCESS = '[AcademicSession] Create AcademicSession Success';
  createAcademicSessionSuccess(AcademicSession): Action {
    return {
      type: AcademicSessionActions.CREATE_ACADEMICSESSIONS_SUCCESS,
      payload: AcademicSession
    };
  }

  static REMOVE_ACADEMICSESSIONS = '[AcademicSession] Remove AcademicSession';
  removeAcademicSession(AcademicSession): Action {
    return {
      type: AcademicSessionActions.REMOVE_ACADEMICSESSIONS,
      payload: AcademicSession
    };
  }

  static REMOVE_ACADEMICSESSIONS_SUCCESS = '[AcademicSession] Remove AcademicSession Success';
  removeAcademicSessionSuccess(AcademicSession): Action {
    return {
      type: AcademicSessionActions.REMOVE_ACADEMICSESSIONS_SUCCESS,
      payload: AcademicSession
    };
  }
}
