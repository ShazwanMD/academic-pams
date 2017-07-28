import {Action} from '@ngrx/store';

import {Appointment} from '../../../shared/model/term/appointment.interface';
import {SectionActions} from './section.action';

export type AppointmentListState = Appointment[];

const initialState: AppointmentListState = <Appointment[]>[];

export function appointmentListReducer(state = initialState, action: Action): AppointmentListState {
  switch (action.type) {
    case SectionActions.FIND_APPOINTMENTS_BY_SECTION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
