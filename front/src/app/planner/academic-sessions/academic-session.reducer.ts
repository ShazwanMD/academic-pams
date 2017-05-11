import {Action} from '@ngrx/store';
import {AcademicSessionActions} from "./academic-session.action";
import {AcademicSession} from "./academic-session.interface";

export type AcademicSessionState = AcademicSession;

const initialState: AcademicSessionState = <AcademicSession> {};

export function sessionReducer (state = initialState, action: Action) : AcademicSessionState {
    switch (action.type) {
        case AcademicSessionActions.FIND_ACADEMIC_SESSION_SUCCESS: {
            return action.payload;
        }
        default: {
            return state;
        }
    }
}
