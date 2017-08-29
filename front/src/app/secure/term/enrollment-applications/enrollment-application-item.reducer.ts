import {Action} from '@ngrx/store';
import {EnrollmentApplicationActions} from './enrollment-application.action';
import {EnrollmentApplicationItem} from '../../../shared/model/term/enrollment-application-item.interface';

export type EnrollmentApplicationItemState = EnrollmentApplicationItem; 

const initialState: EnrollmentApplicationItemState = <EnrollmentApplicationItem>{};

export function enrollmentApplicationItemReducer(state = initialState, action: Action): EnrollmentApplicationItemState {
  switch (action.type) {
    case EnrollmentApplicationActions.FIND_ENROLLMENT_APPLICATION_ITEM_BY_ID_SUCCESS: {
      return action.payload;
    }
    case EnrollmentApplicationActions.ADD_STUDENT_ENROLLMENT_APPLICATION_ITEM_SUCCESS: {
        return action.payload;
    }
    default: {
      return state;
    }
  }
}
