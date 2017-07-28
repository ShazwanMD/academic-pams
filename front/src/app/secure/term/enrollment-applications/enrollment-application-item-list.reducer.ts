import { Action } from '@ngrx/store';
import { EnrollmentApplicationActions } from "./enrollment-application.action";
import {EnrollmentApplication} from "../../../shared/model/term/enrollment-application.interface";
import {EnrollmentApplicationItem} from "../../../shared/model/term/enrollment-application-item.interface";

export type EnrollmentApplicationItemListState = EnrollmentApplicationItem[];

const initialState: EnrollmentApplicationItemListState = <EnrollmentApplicationItem[]>[];

export function enrollmentApplicationItemListReducer(state = initialState, action: Action): EnrollmentApplicationItemListState {
    switch (action.type) {
        case EnrollmentApplicationActions.FIND_ENROLLMENT_APPLICATION_ITEMS_SUCCESS: {
            return action.payload;
        }
        default: {
            return state;
        }
    }
}
