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
    findAdmissionsSuccess( admissions ): Action {
        return {
            type: AdmissionActions.FIND_ADMISSIONS_SUCCESS,
            payload: admissions
        };
    }

    static FIND_ADMISSION_BY_ID = '[Admission] Find Admission By Id';
    findAdmissionById( id ): Action {
        return {
            type: AdmissionActions.FIND_ADMISSION_BY_ID,
            payload: id
        };
    }

    static FIND_ADMISSION_BY_ID_SUCCESS = '[Admission] Find Admission By Id Success';
    findAdmissionByIdSuccess( admission ): Action {
        return {
            type: AdmissionActions.FIND_ADMISSION_BY_ID_SUCCESS,
            payload: admission
        };
    }

    static FIND_ADMISSION_BY_CURRENT = '[Admission] Find Admission By Current';
    findAdmissionByCurrent( admission ): Action {
        return {
            type: AdmissionActions.FIND_ADMISSION_BY_CURRENT,
            payload: admission
        };
    }

    static FIND_ADMISSION_BY_CURRENT_SUCCESS = '[Admission] Find Admission By Current Success';
    findAdmissionByCurrentSuccess( admission ): Action {
        return {
            type: AdmissionActions.FIND_ADMISSION_BY_CURRENT_SUCCESS,
            payload: admission
        };
    }


}
