import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AdmissionApplicationActions {
    
static ADD_ADMISSION = '[AdmissionApplication] Add AdmissionApplication';

  addAdmission(admission): Action {
    return {
      type: AdmissionApplicationActions.ADD_ADMISSION,
      payload: {admission:admission}
    };
  }

  static ADD_ADMISSION_SUCCESS = '[AdmissionApplication] Add AdmissionApplication Success';

  addAdmissionSuccess(message): Action {
    return {
      type: AdmissionApplicationActions.ADD_ADMISSION_SUCCESS,
      payload: message
    };
  }


}