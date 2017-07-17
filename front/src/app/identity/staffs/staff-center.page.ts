import {TermService} from '../../../services/term.service';
import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Staff} from './staff.interface';
import {StaffActions} from './staff.action';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import { IdentityModuleState } from "../index";


@Component({
  selector: 'pams-staff-center',
  templateUrl: './staff-center.page.html',
})
export class StaffCenterPage implements OnInit {

  private STAFFS: string[] = 'identityModuleState.staffs'.split('.');
  private staffs$: Observable<Staff[]>;
  

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: StaffActions,
              private termService: TermService,
              private store: Store<IdentityModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.staffs$ = this.store.select(...this.STAFFS);
  }

  goBack(route: string): void {
    this.router.navigate(['/staffs']);
  }

  viewStaff(staff: Staff): void {
    console.log('staff identityNo: ' + staff.identityNo);
    this.router.navigate(['/identity/staffs',staff.identityNo]);
  }

 

  ngOnInit(): void {
    this.store.dispatch(this.actions.findStaffs());
  }


}
