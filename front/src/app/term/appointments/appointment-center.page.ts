import {TermService} from './../../../services/term.service';
import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Appointment} from "./appointment.interface";
import {AppointmentActions} from "./appointment.action";
import {TermModuleState} from "../index";

@Component({
  selector: 'pams-appointment-center',
  templateUrl: './appointment-center.page.html',
})
export class AppointmentCenterPage implements OnInit {

  private APPOINTMENTS = "termModuleState.appointments".split(".");
  private appointments$: Observable<Appointment[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AppointmentActions,
              private termService: TermService,
              private store: Store<TermModuleState>) {
    this.appointments$ = this.store.select(...this.APPOINTMENTS);
  }

  goBack(route: string): void {
    this.router.navigate(['/appointments']);
  }

  viewAppointment(appointment: Appointment) {
    console.log("appointment: " + appointment.id);
    this.router.navigate(['/appointments-detail', appointment.id]);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findAppointments());
  // this.offerings$ = this.termService.findOfferings();

  }
}

