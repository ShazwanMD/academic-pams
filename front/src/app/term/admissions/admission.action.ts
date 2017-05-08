import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AdmissionActions {

  static FIND_ADMISSIONS = '[Admission] Find Admissions';
  findAdmissions(): Action {
    return {
      type: AdmissionActions.FIND_ADMISSIONS
    };
  }

   static FIND_ADMISSION_BY_CANONICAL_CODE = '[Admission] Find Admission By Canonical Code';
  findAdmissionByCanonicalCode(canonicalCode): Action {
    return {
      type: AdmissionActions.FIND_ADMISSION_BY_CANONICAL_CODE,
      payload: canonicalCode
    };
  }
  
  
}