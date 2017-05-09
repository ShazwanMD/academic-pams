import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {IdentityService} from '../../../services';
import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Appointment} from "./appointment.interface";
import {AppointmentActions} from "./appointment.action";
import {TermModuleState} from "../index";

@Component({
  selector: 'pams-appointment-detail',
  templateUrl: './appointment-detail.page.html',
})

export class AppointmentDetailPage implements OnInit {

  private APPOINTMENT = "termModuleState.appointment".split(".");
  private appointment$: Observable<Appointment>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AppointmentActions,
              private termService: TermService,
              private store: Store<TermModuleState>) {

    this.appointment$ = this.store.select(...this.APPOINTMENT);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: {id: string}) => {
      let id: string = params.id;
      this.store.dispatch(this.actions.findAppointmentById(id));
     //this.appointment$ = this.termService.findAppointmentByCanonicalCode(canonicalCode);


    });
  }

  goBack(route: string): void {
    this.router.navigate(['/offerings']);
  }
}

