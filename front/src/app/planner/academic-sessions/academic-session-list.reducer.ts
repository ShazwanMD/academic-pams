import {Action} from '@ngrx/store';
import {Observable}  from 'rxjs/Observable';

import * as _ from 'lodash';
import {AcademicSession} from "./academic-session.interface";
import {AcademicSessionActions} from "./academic-session.action";

export type AcademicSessionListState = AcademicSession [];

const initialState: AcademicSessionListState = <AcademicSession[]>[];

export function sessionListReducer (state = initialState, action: Action): AcademicSessionListState {
    switch (action.type) {
        case AcademicSessionActions.FIND_ACADEMICSESSIONS_SUCCESS: {
            return action.payload;
        }

        case AcademicSessionActions.CREATE_ACADEMICSESSION_SUCCESS: {
            return [...state, action.payload];
        }

        case AcademicSessionActions.SAVE_ACADEMICSESSION_SUCCESS: {
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

        case AcademicSessionActions.REMOVE_ACADEMICSESSION_SUCCESS: {
            return state.filter (academicSession => {
                return academicSession.id !== action.payload.id;
            });
        }
        default: {
            return state;
        }
    }
}
