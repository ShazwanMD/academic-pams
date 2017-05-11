import {Action} from '@ngrx/store';
import {AppointmentActions} from "./appointment.action";
import {Appointment} from "./appointment.interface";

export type AppointmentState = Appointment;

const initialState: AppointmentState = <Appointment>{};

export function appointmentReducer(state = initialState, action: Action): AppointmentState {
  switch (action.type) {
    case AppointmentActions.FIND_APPOINTMENT_BY_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
