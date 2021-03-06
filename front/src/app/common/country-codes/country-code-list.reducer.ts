import {CommonActions} from '../common.action';
import {CountryCode} from '../../shared/model/common/country-code.interface';
import {Action} from '@ngrx/store';

export type CountryCodeListState = CountryCode[];

const initialState: CountryCodeListState = <CountryCode[]>[];

export function countryCodeListReducer(state = initialState,
                                       action: Action): CountryCodeListState {
  switch (action.type) {
    case CommonActions.FIND_COUNTRY_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
