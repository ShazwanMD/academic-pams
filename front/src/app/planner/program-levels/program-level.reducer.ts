import {Action} from '@ngrx/store';
import {ProgramLevelActions} from "./program-level.action";
import {ProgramLevel} from "./program-level.interface";

export type ProgramLevelState = ProgramLevel;

const initialState: ProgramLevelState = <ProgramLevel> {};

export function programLevelReducer (state = initialState, action: Action) : ProgramLevelState {
    switch (action.type) {
        case ProgramLevelActions.FIND_PROGRAM_LEVEL_BY_CODE_SUCCESS: {
            return action.payload;
        }
        default: {
            return state;
        }
    }
}
