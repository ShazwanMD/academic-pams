import {TermService} from '../../../services/term.service';
import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Appointment} from './appointment.interface';
import {AppointmentActions} from './appointment.action';
import {TermModuleState} from '../index';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
//import {OfferingEditorDialog} from './dialog/offering-editor.dialog';


@Component({
  selector: 'pams-appointment-center',
  templateUrl: './appointment-center.page.html',
})
export class AppointmentCenterPage implements OnInit {

  private APPOINTMENTS: string[] = 'termModuleState.appointments'.split('.');
  private appointments$: Observable<Appointment[]>;
  //private creatorDialogRef: MdDialogRef<OfferingEditorDialog>;

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

  viewAppointment(appointment: Appointment): void {
    console.log('appointment ccode: ' + appointment.id);
    this.router.navigate(['/term/appointments',appointment.id]);
  }

 /* createDialog(): void {
    this.showDialog(null);
  }*/

  ngOnInit(): void {
    this.store.dispatch(this.actions.findAppointments());
  }

 /* private showDialog(code: Appointment): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '60%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(OfferingEditorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }*/

}
