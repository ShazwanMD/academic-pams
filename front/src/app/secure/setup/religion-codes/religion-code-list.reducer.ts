import {ReligionCode} from '../../../shared/model/common/religion-code.interface';
import {SetupActions} from '../setup.action';
import {Action} from '@ngrx/store';


export type ReligionCodeListState = ReligionCode[];

const initialState: ReligionCodeListState = <ReligionCode[]>[];

export function religionCodeListReducer(state = initialState, action: Action): ReligionCodeListState {
  switch (action.type) {
    case SetupActions.FIND_RELIGION_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
