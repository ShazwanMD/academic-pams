import {Action} from '@ngrx/store';

import * as _ from 'lodash';
import {Appointment} from '../../shared/model/term/appointment.interface';
import {AppointmentActions} from './appointment.action';

export type AppointmentListState = Appointment[];

const initialState: AppointmentListState = <Appointment[]>[];

export function appointmentListReducer(state = initialState, action: Action): AppointmentListState {
  switch (action.type) {
    case AppointmentActions.FIND_APPOINTMENTS_SUCCESS: {
      return action.payload;
    }
    case AppointmentActions.ADD_APPOINTMENT_SUCCESS: {
      let index = _.findIndex(state, {id: action.payload.id});
      if (index >= 0) {
        return [
          ...state.slice(0, index),
          action.payload,
          ...state.slice(index + 1),
        ];
      }
      return state;
    }
    case AppointmentActions.REMOVE_APPOINTMENT_SUCCESS: {
      return state.filter((appointment) => {
        return appointment.id !== action.payload.id;
      });
    }
    default: {
      return state;
    }
  }
}
