import { AcademicYear } from '../../shared/model/planner/academic-year.interface';
import { AcademicYearActions } from './academic-year.action';
import { Action } from '@ngrx/store';

export type AcademicYearState = AcademicYear;

const initialState: AcademicYearState = <AcademicYear>{};

export function academicYearReducer (state = initialState, action: Action): AcademicYearState {
    switch (action.type) {
        case AcademicYearActions.FIND_ACADEMICYEARS_SUCCESS: {
            return action.payload;
        }
        default: {
            return state;
        }
    }
}
