import { StudyMode } from '../../shared/model/common/study-mode.interface';
import { SetupActions } from './../setup.action';
import { Action } from '@ngrx/store';

export type StudyModeListState = StudyMode[];

const initialState: StudyModeListState = <StudyMode[]>[];

export function studyModeListReducer(state = initialState,
                action: Action): StudyModeListState{
                    switch(action.type){
                        case SetupActions.FIND_STUDY_MODES_SUCCESS:{
                            return action.payload;
                        }
                        default: {
                            return state;
                        }
                    }
                }
