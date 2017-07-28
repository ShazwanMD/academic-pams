import {StudyCenter} from './study-center.interface';
import {SetupActions} from '../setup.action';
import {Action} from '@ngrx/store';

export type StudyCenterListState = StudyCenter[];

const initialState: StudyCenterListState = <StudyCenter[]>[];

export function studyCenterListReducer(state = initialState, action: Action): StudyCenterListState {
  switch (action.type) {
    case SetupActions.FIND_STUDY_CENTERS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
