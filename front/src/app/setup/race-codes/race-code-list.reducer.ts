import { CommonActions } from './../../common/gender-codes/common.action';
import { RaceCode } from './../../common/race-codes/race-code.interface';
import { SetupActions } from './../setup.action';
import {Action} from '@ngrx/store';



export type RaceCodeListState = RaceCode[];

const initialState: RaceCodeListState = <RaceCode[]>[];

export function raceCodeListReducer(state = initialState, action: Action): RaceCodeListState {
    switch (action.type) {
        case CommonActions.FIND_RACE_CODES_SUCCESS: {
            return action.payload;
        }
        default: {
            return state;
        }
    }
}
