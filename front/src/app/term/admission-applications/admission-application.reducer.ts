import { Action } from '@ngrx/store';
import { AdmissionApplication } from '../../shared/model/term/admission-application.interface';
import { AdmissionApplicationActions } from './admission-application.action';

export type AdmissionApplicationState = AdmissionApplication;

const initialState: AdmissionApplicationState = <AdmissionApplication>{};

export function admissionApplicationReducer( state = initialState, action: Action ): AdmissionApplicationState {

    switch ( action.type ) {

        case AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_BY_ID_SUCCESS: {
            return action.payload;
        }

        case AdmissionApplicationActions.FIND_ADMISSION_APPLICATIONS_SUCCESS: {
            return action.payload;
        }
        case AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_BY_REFERENCE_NO_SUCCESS: {
            return action.payload;
        }
        default: {
            return state;
        }
    }
}
