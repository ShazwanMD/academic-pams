import { StudyMode } from './study-mode.interface';
import { CommonActions } from './../gender-codes/common.action';
import { Action } from '@ngrx/store';

export type StudyModeListState = StudyMode[];

const initialState: StudyModeListState = <StudyMode[]>[];

export function studyModeListReducer(state = initialState,
                action: Action): StudyModeListState{
                    switch(action.type){
                        case CommonActions.FIND_STUDY_MODES_SUCCESS:{
                            return action.payload;
                        }
                        default: {
                            return state;
                        }
                    }
                }