import {Action} from '@ngrx/store';

import {Appointment} from "../appointments/appointment.interface";
import {OfferingActions} from "./offering.action";

export type AppointmentListState = Appointment[];

const initialState: AppointmentListState = <Appointment[]>[];

export function appointmentListReducer(state = initialState, action: Action): AppointmentListState {
  switch (action.type) {
    case OfferingActions.FIND_APPOINTMENTS_BY_OFFERING_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
