import {TermService} from './../../../services/term.service';
import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Appointment} from "./appointment.interface";
import {AppointmentActions} from "./appointment.action";
import {TermModuleState} from "../index";
import {AppointmentCreateTaskCreatorDialog} from "./dialog/appointment-create-task-creator.dialog";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";

@Component({
  selector: 'pams-appointment-center',
  templateUrl: './appointment-center.page.html',
})
export class AppointmentCenterPage implements OnInit {

  private APPOINTMENTS = "termModuleState.appointments".split(".");
  private appointments$: Observable<Appointment[]>;
  private creatorDialogRef: MdDialogRef<AppointmentCreateTaskCreatorDialog>; 

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AppointmentActions,
              private termService: TermService,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.appointments$ = this.store.select(...this.APPOINTMENTS);
  }

  goBack(route: string): void {
    this.router.navigate(['/appointments']);
  }

  viewAppointment(appointment: Appointment) {
    console.log("appointment: " + appointment.id);
    this.router.navigate(['/appointments-detail', appointment.id]);
  }

  showDialog(): void {
      console.log("showDialog");
      let config = new MdDialogConfig();
      config.viewContainerRef = this.vcf;
      config.role = 'dialog';
      config.width = '40%';
      config.height = '40%';
      config.position = {top: '3px'};
      this.creatorDialogRef = this.dialog.open(AppointmentCreateTaskCreatorDialog, config);
      this.creatorDialogRef.afterClosed().subscribe(res => {
        console.log("close dialog");
        // load something here
      });
    }
  
  ngOnInit(): void {
    this.store.dispatch(this.actions.findAppointments());
  // this.offerings$ = this.termService.findOfferings();

  }
}

