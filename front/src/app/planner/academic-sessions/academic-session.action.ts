import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AcademicSessionActions {

  static FIND_ACADEMICSESSIONS = '[AcademicSession] Find AcademicSessions';
  findAcademicSessions(): Action {
    return {
      type: AcademicSessionActions.FIND_ACADEMICSESSIONS,
    };
  }

  static FIND_ACADEMICSESSIONS_SUCCESS = '[AcademicSession] Find AcademicSessions Success';
  findAcademicSessionsSuccess(academicSessions): Action {
    console.log("findAcademicSessionsSuccess");
    console.log("academicSessions: " + academicSessions.length);
    return {
      type: AcademicSessionActions.FIND_ACADEMICSESSIONS_SUCCESS,
      payload: academicSessions
    };
  }

  static FIND_ACADEMICSESSION = '[AcademicSession] Find AcademicSession';
  findAcademicSession(code): Action {
    return {
      type: AcademicSessionActions.FIND_ACADEMICSESSION,
      payload: code
    };
  }

  static FIND_ACADEMICSESSION_SUCCESS = '[AcademicSession] Find AcademicSession Success';
  findAcademicSessionsuccess(academicSession): Action {
    return {
      type: AcademicSessionActions.FIND_ACADEMICSESSION_SUCCESS,
      payload: academicSession
    };
  }

  static RESET_ACADEMICSESSION = '[AcademicSession] Reset Blank AcademicSession';
  resetAcademicSession(): Action {
    return {
      type: AcademicSessionActions.RESET_ACADEMICSESSION
    };
  }

  static SAVE_ACADEMICSESSION = '[AcademicSession] Save AcademicSession';
  saveAcademicSession (academicSession): Action {
    return {
      type: AcademicSessionActions.SAVE_ACADEMICSESSION,
      payload: academicSession
    };
  }

  static SAVE_ACADEMICSESSION_SUCCESS = '[AcademicSession] Save AcademicSession Success';
  saveAcademicSessionSuccess(academicSession): Action {
    return {
      type: AcademicSessionActions.SAVE_ACADEMICSESSION_SUCCESS,
      payload: academicSession
    };
  }

  static UPDATE_ACADEMICSESSION =  '[AcademicSession] Update AcademicSession';
  updateAcademicSession(academicSession): Action {
    return {
      type: AcademicSessionActions.UPDATE_ACADEMICSESSION,
      payload: academicSession
    };
  }

  static UPDATE_ACADEMICSESSION_SUCCESS =  '[AcademicSession] Update AcademicSession';
  updateAcademisSessionSuccess(academicSession): Action {
    return {
      type: AcademicSessionActions.UPDATE_ACADEMICSESSION_SUCCESS,
      payload: academicSession
    };
  }

  static CREATE_ACADEMICSESSION = '[AcademicSession] Create AcademicSession';
  createAcademicSession(academicSession): Action {
    return {
      type: AcademicSessionActions.CREATE_ACADEMICSESSION,
      payload: academicSession
    };
  }

  static CREATE_ACADEMICSESSION_SUCCESS = '[AcademicSession] Create AcademicSession Success';
  createAcademicSessionSuccess(academicSession): Action {
    return {
      type: AcademicSessionActions.CREATE_ACADEMICSESSION_SUCCESS,
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

  static REMOVE_ACADEMICSESSION_SUCCESS = '[AcademicSession] Remove AcademicSession Success';
  removeAcademicSessionSuccess(academicSession): Action {
    return {
      type: AcademicSessionActions.REMOVE_ACADEMICSESSION_SUCCESS,
      payload: academicSession
    };
  }
}
