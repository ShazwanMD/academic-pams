import { LecturerActions } from './lecturer.action';
import { Action } from '@ngrx/store';
import { Staff } from './../../shared/model/identity/staff.interface';


export type LecturerState = Staff;

const initialState: LecturerState = <Staff>{};

export function lecturerReducer(state = initialState, action: Action): LecturerState {
    switch (action.type) {
        case LecturerActions.FIND_LECTURER_BY_USER_SUCCESS: {
            return action.payload;
        }
        default: {
            return state;
        }
    }
}