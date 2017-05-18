import { AssessmentActions } from './assessment.action';
import { Assessment } from './assessment.interface';
import {Action} from '@ngrx/store';

export type AssessmentState = Assessment[];

const initialState: AssessmentState = <Assessment[]>[];

export function assessmentReducer(state = initialState, action: Action):AssessmentState{
    switch(action.type){
        case AssessmentActions.FIND_ASSESSMENTS_SUCCESS:{
            return action.payload;
        }
        default:{
            return state;
        }
    }
    
}