import {SetupActions} from '../setup.action';
import {Action} from '@ngrx/store';
import {CountryCode} from '../../../shared/model/common/country-code.interface';


export type CountryCodeListState = CountryCode[];

const initialState: CountryCodeListState = <CountryCode[]>[];

export function countryCodeListReducer(state = initialState, action: Action): CountryCodeListState {
  switch (action.type) {
    case SetupActions.FIND_COUNTRY_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
