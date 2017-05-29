import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {AppointmentActions} from "./appointment.action";
import {TermService} from "../../../services/term.service";
import {Store} from "@ngrx/store";
import {OfferingActions} from "../offerings/offering.action";
import {Offering} from "../offerings/offering.interface";
import {TermModuleState} from "../index";


@Injectable()
export class AppointmentEffects {
        
  private OFFERING: string[] = "termModuleState.offering".split(".");
    
  constructor(private actions$: Actions,
              private appointmentActions: AppointmentActions,
              private offeringActions: OfferingActions,
              private termService: TermService,
              private store$: Store<TermModuleState> ) {
  }

  @Effect() findAppointmentById$ = this.actions$
    .ofType(AppointmentActions.FIND_APPOINTMENT_BY_ID)
    .map(action => action.payload)
    .switchMap(id => this.termService.findAppointmentById(id))
    .map(appointment => this.appointmentActions.findAppointmentByIdSuccess(appointment));
    
    //save appointment
     @Effect() saveAppointment$ =
     this.actions$
      .ofType(AppointmentActions.SAVE_APPOINTMENT)
      .map(action => action.payload)
      .switchMap(payload => this.termService.saveAppointment(payload.offering, payload.appointment))
      .map(message => this.appointmentActions.saveAppointmentSuccess(message))
      .withLatestFrom(this.store$.select(...this.OFFERING))
      .map(state => state[1])
      .map((offering: Offering) => this.offeringActions.findOfferingByCanonicalCode(offering.canonicalCode));
    
    //remove appointment
      @Effect() removeAppointment$ = this.actions$
    .ofType(AppointmentActions.REMOVE_APPOINTMENT)
    .map(action => action.payload)
    .switchMap(payload => this.termService.removeAppointment(payload.offering, payload.appointment))
    .map(message => this.appointmentActions.removeAppointmentSuccess(message))
    .withLatestFrom(this.store$.select(...this.OFFERING))
    .map(state => state[1])
    .map((offering: Offering) => this.offeringActions.findOfferingByCanonicalCode(offering.canonicalCode));
  
}
