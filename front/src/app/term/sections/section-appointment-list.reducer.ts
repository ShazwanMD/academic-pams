import { SectionAppointmentListState} from './section-appointment-list.reducer';
import { SectionActions} from './section.action';
import {Appointment} from '../appointments/appointment.interface';
import {Action} from '@ngrx/store';

export type SectionAppointmentListState = Appointment[];

const initialState: SectionAppointmentListState = <Appointment[]>[];

export function sectionAppointmentListReducer(state = initialState, action: Action): SectionAppointmentListState {
  switch (action.type) {
    case SectionActions.FIND_APPOINTMENTS_BY_SECTION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}