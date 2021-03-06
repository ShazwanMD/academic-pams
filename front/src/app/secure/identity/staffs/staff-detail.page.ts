import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {IdentityService} from '../../../../services';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {StaffActions} from './staff.action';
import {IdentityModuleState} from '../index';
import {MdDialog} from '@angular/material';
import {Appointment} from '../../../shared/model/term/appointment.interface';
import {Staff} from '../../../shared/model/identity/staff.interface';

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

