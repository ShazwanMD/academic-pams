import {StaffAppointmentListState} from './staff-appointment-list.reducer';
import {StaffActions} from './staff.action';
import {Appointment} from '../../../shared/model/term/appointment.interface';
import {Action} from '@ngrx/store';

export type StaffAppointmentListState = Appointment[];

const initialState: StaffAppointmentListState = <Appointment[]>[];

export function staffAppointmentListReducer(state = initialState, action: Action): StaffAppointmentListState {
  switch (action.type) {
    case StaffActions.FIND_APPOINTMENTS_BY_STAFF_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
