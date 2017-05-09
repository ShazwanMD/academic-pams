import {Action} from '@ngrx/store';
import {Observable}  from 'rxjs/Observable';

import * as _ from 'lodash';
import {AcademicSession} from "./academic-session.interface";
import {AcademicSessionActions} from "./academic-session.action";

export type AcademicSessionListState = AcademicSession [];

const initialState: AcademicSessionListState = <AcademicSession[]>[];

export function sessionListReducer (state = initialState, action: Action): AcademicSessionListState {
    console.log ("action: " + action.type);
    switch (action.type) {
        case AcademicSessionActions.FIND_SESSIONS_SUCCESS: {
            return action.payload;
        }

        case AcademicSessionActions.CREATE_SESSION_SUCCESS: {
            return [...state, action.payload];
        }

        case AcademicSessionActions.SAVE_SESSION_SUCCESS: {
            let index = _.findIndex (state, {id: action.payload.id});
            if (index >= 0) {
                return [
                    ...state.slice(0, index),
                    action.payload,
                    ...state.slice(index+1),
                ];
            }
            return state;
        }

        case AcademicSessionActions.REMOVE_SESSION_SUCCESS: {
            return state.filter (session => {
                return session.id !== action.payload.id;
            });
        }
        default: {
            return state;
        }
    }
}