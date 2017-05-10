import { RaceCode } from './race-code.interface';
import { CommonActions } from './../gender-codes/common.action';
import { Action } from '@ngrx/store';

export type RaceCodeListState = RaceCode[];

const initialState: RaceCodeListState = <RaceCode[]>[];

export function raceCodeListReducer(state = initialState,
                action: Action): RaceCodeListState{
                    switch(action.type){
                        case CommonActions.FIND_RACE_CODES_SUCCESS:{
                            return action.payload;
                        }
                        default: {
                            return state;
                        }
                    }
                }