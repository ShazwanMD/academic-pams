import { ReligionCode } from './religion-code.interface';
import { CommonActions } from './../gender-codes/common.action';
import { Action } from '@ngrx/store';

export type ReligionCodeListState = ReligionCode[];

const initialState: ReligionCodeListState = <ReligionCode[]>[];

export function religionCodeListReducer(state = initialState,
                action: Action): ReligionCodeListState{
                    switch(action.type){
                        case CommonActions.FIND_RELIGION_CODES_SUCCESS:{
                            return action.payload;
                        }
                        default: {
                            return state;
                        }
                    }
                }