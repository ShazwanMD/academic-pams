import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {AppointmentActions} from "./appointment.action";
import {TermService} from "../../../services/term.service";
import {Store} from "@ngrx/store";
import {OfferingActions} from "../offerings/offering.action";
import {Offering} from "../offerings/offering.interface";
import {Section} from "../sections/section.interface";
import {TermModuleState} from "../index";
import { SectionActions } from "../sections/section.action";


@Injectable()
export class AppointmentEffects {
        
  private OFFERING: string[] = "termModuleState.offering".split(".");
  private SECTION: string[] = "termModuleState.section".split(".");
    
  constructor(private actions$: Actions,
              private appointmentActions: AppointmentActions,
              private offeringActions: OfferingActions,
              private sectionActions: SectionActions,
              private termService: TermService,
              private store$: Store<TermModuleState> ) {
  }

  @Effect() findAppointmentById$ = this.actions$
    .ofType(AppointmentActions.FIND_APPOINTMENT_BY_ID)
    .map(action => action.payload)
    .switchMap(id => this.termService.findAppointmentById(id))
    .map(appointment => this.appointmentActions.findAppointmentByIdSuccess(appointment));
    
    //save appointment
     @Effect() addAppointment$ =
     this.actions$
      .ofType(AppointmentActions.ADD_APPOINTMENT)
      .map(action => action.payload)
      .switchMap(payload => this.termService.addAppointment(payload.section, payload.appointment))
      .map(message => this.appointmentActions.addAppointmentSuccess(message))
      .withLatestFrom(this.store$.select(...this.SECTION))
      .map(state => state[1])
      .map((section: Section) => this.sectionActions.findSectionByCanonicalCode(section.canonicalCode));
       
     //update appointment
      @Effect() updateAppointment$ = this.actions$
     .ofType(AppointmentActions.UPDATE_APPOINTMENT)
     .map(action => action.payload)
     .switchMap(payload => this.termService.updateAppointment(payload.offering, payload.appointment))
     .map(message => this.appointmentActions.updateAppointmentSuccess(message))
     .withLatestFrom(this.store$.select(...this.SECTION))
     .map(state => state[1])
     //.mergeMap(action => from([action, this.appointmentActions.findAppointments()]));
     .map((offering: Offering) => this.offeringActions.findOfferingByCanonicalCode(offering.canonicalCode));
     
    
    //remove appointment
      @Effect() removeAppointment$ = this.actions$
    .ofType(AppointmentActions.REMOVE_APPOINTMENT)
    .map(action => action.payload)
    .switchMap(payload => this.termService.removeAppointment(payload.offering, payload.appointment))
    .map(message => this.appointmentActions.removeAppointmentSuccess(message))
    .withLatestFrom(this.store$.select(...this.SECTION))
    .map(state => state[1])
    .map((offering: Offering) => this.offeringActions.findOfferingByCanonicalCode(offering.canonicalCode));
  
}
