import {Action} from '@ngrx/store';
import {AcademicSessionActions} from "./academic-session.action";
import {AcademicSession} from "./academic-session.interface";

export type AcademicSessionState = AcademicSession;

const initialState: AcademicSessionState = <AcademicSession> {};

export function sessionReducer (state = initialState, action: Action) : AcademicSessionState {
    switch (action.type) {
        case AcademicSessionActions.RESET_ACADEMICSESSION: {
            return initialState;
        }

        case AcademicSessionActions.FIND_ACADEMICSESSION_SUCCESS: {
            return action.payload;
        }
        default: {
            return state;
        }
    }
}
