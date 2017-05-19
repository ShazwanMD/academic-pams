import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {AppointmentActions} from "./appointment.action";
import {TermService} from "../../../services/term.service";


@Injectable()
export class AppointmentEffects {
  constructor(private actions$: Actions,
              private appointmentActions: AppointmentActions,
              private termService: TermService,) {
  }

  @Effect() findAppointmentById$ = this.actions$
    .ofType(AppointmentActions.FIND_APPOINTMENT_BY_ID)
    .map(action => action.payload)
    .switchMap(id => this.termService.findAppointmentById(id))
    .map(appointment => this.appointmentActions.findAppointmentByIdSuccess(appointment));
}
