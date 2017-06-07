import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';

@Injectable()
export class AdmissionActions {

  static FIND_ADMISSIONS = '[Admission] Find Admissions';

  findAdmissions(): Action {
    return {
      type: AdmissionActions.FIND_ADMISSIONS
    };
  }

  static FIND_ADMISSIONS_SUCCESS = '[Admission] Find Admissions Success';
  findAdmissionsSuccess(admissions): Action {
    return {
      type: AdmissionActions.FIND_ADMISSIONS_SUCCESS,
      payload: admissions
    };
  }

  static FIND_ADMISSION_BY_ID = '[Admission] Find Admission By Id';
  findAdmissionById(id): Action {
    return {
      type: AdmissionActions.FIND_ADMISSION_BY_ID,
      payload: id
    };
  }

  static FIND_ADMISSION_BY_ID_SUCCESS = '[Admission] Find Admission By Id Success';
  findAdmissionByIdSuccess(admission): Action {
    return {
      type: AdmissionActions.FIND_ADMISSION_BY_ID_SUCCESS,
      payload: admission
    };
  }

  static FIND_ADMISSION_BY_CURRENT = '[Admission] Find Admission By Current';
  findAdmissionByCurrent(admission): Action {
    return {
      type: AdmissionActions.FIND_ADMISSION_BY_CURRENT,
      payload: admission
    };
  }

  static FIND_ADMISSION_BY_CURRENT_SUCCESS = '[Admission] Find Admission By Current Success';
  findAdmissionByCurrentSuccess(admission): Action {
    return {
      type: AdmissionActions.FIND_ADMISSION_BY_CURRENT_SUCCESS,
      payload: admission
    };
  }

  static SAVE_ADMISSION = '[AdmissionApplication] Save AdmissionApplication';
  saveAdmission(admission): Action {
    return {
      type: AdmissionActions.SAVE_ADMISSION,
      payload: admission
    };
  }

  static SAVE_ADMISSION_SUCCESS = '[AdmissionApplication] Save AdmissionApplication Success';
  saveAdmissionSuccess(message): Action {
    return {
      type: AdmissionActions.SAVE_ADMISSION_SUCCESS,
      payload: message
    };
  }

  static UPDATE_ADMISSION = '[Program] Update Program';
  updateAdmission(admission): Action {
    return {
      type: AdmissionActions.UPDATE_ADMISSION,
      payload: admission
    };
  }

  static UPDATE_ADMISSION_SUCCESS = '[Program] Update Program Success';
  updateAdmissionSuccess(message): Action {
    return {
      type: AdmissionActions.UPDATE_ADMISSION_SUCCESS,
      payload: message
    };
  }


}
