import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef, Input, EventEmitter, Output} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {TermService, IdentityService} from '../../../services';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Staff} from './staff.interface';
import {StaffActions} from './staff.action';
import {IdentityModuleState} from '../index';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {Appointment} from '../../term/appointments/appointment.interface';

@Component({
  selector: 'pams-staff-detail',
  templateUrl: './staff-detail.page.html',
})

export class StaffDetailPage implements OnInit {

  private STAFF: string[] = 'identityModuleState.staff'.split('.');
  private APPOINTMENTS: string[] = 'identityModuleState.staffAppointments'.split('.');
  private staff$: Observable<Staff>;
  private appointments$: Observable<Appointment[]>;

  @Input() staff: Staff;
  @Input() appointment: Appointment;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: StaffActions,
              private identityService: IdentityService,
              private store: Store<IdentityModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.staff$ = this.store.select(...this.STAFF);
    this.appointments$ = this.store.select(...this.APPOINTMENTS);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { identityNo: string }) => {
      let identityNo: string = params.identityNo;
      this.store.dispatch(this.actions.findStaffByIdentityNo(identityNo));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/staffs']);
  }
}

