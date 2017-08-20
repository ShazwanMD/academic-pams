import {Action} from '@ngrx/store';

import {Appointment} from '../../shared/model/term/appointment.interface';
import {LecturerActions} from './lecturer.action';

export type AppointmentListState = Appointment[];

const initialState: AppointmentListState = <Appointment[]>[];

export function appointmentListReducer(state = initialState, action: Action): AppointmentListState {
  switch (action.type) {
    case LecturerActions.FIND_APPOINTMENTS_BY_LECTURER_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
