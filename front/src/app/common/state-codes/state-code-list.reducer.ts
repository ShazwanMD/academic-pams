import { StateCode } from './state-code.interface';
import { CommonActions } from './../gender-codes/common.action';
import { Action } from '@ngrx/store';

export type StateCodeListState = StateCode[];

const initialState: StateCodeListState = <StateCode[]>[];

export function stateCodeListReducer(state = initialState,
                action: Action): StateCodeListState{
                    switch(action.type){
                        case CommonActions.FIND_STATE_CODES_SUCCESS:{
                            return action.payload;
                        }
                        default: {
                            return state;
                        }
                    }
                }