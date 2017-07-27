import {Action} from '@ngrx/store';

import {Contact} from '../shared/model/profile/contact.interface';
import {ProfileActions} from './profile.action';

export type ContactListState = Contact[];

const initialState: ContactListState = <Contact[]>[];

export function contactListReducer(state = initialState, action: Action): ContactListState {
  switch (action.type) {
    case ProfileActions.FIND_CONTACTS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
