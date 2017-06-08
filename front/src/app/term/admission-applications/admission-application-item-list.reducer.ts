import { AdmissionApplicationActions } from './admission-application.action';
import { Action } from '@ngrx/store';
import { AdmissionApplicationItem } from './admission-application-item.interface';

export type AdmissionApplicationItemListState = AdmissionApplicationItem[];

const initialState: AdmissionApplicationItemListState = <AdmissionApplicationItem[]>[];

export function admissionApplicationItemListReducer(state = initialState, action: Action): AdmissionApplicationItemListState {
    switch (action.type) {
        case AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_ITEMS_SUCCESS: {
            return action.payload;
        }
        default: {
            return state;
        }
    }
}
