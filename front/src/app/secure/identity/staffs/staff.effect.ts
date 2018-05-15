import { Injectable } from '@angular/core';
import { Actions, Effect } from '@ngrx/effects';
import { StaffActions } from './staff.action';
import { IdentityService } from '../../../../services/identity.service';
import { IdentityModuleState } from '../index';
import { Store } from '@ngrx/store';
import { from } from 'rxjs/observable/from';
import { CommonService } from '../../../../services/index';

@Injectable()
export class StaffEffects {

  private STAFF: string[] = 'identityModuleState.staff'.split('.');

  constructor(private actions$: Actions,
    private staffActions: StaffActions,
    private identityService: IdentityService,
    private commonService: CommonService,
    private store$: Store<IdentityModuleState>) {
  }

  @Effect() findStaffs$ = this.actions$
    .ofType(StaffActions.FIND_STAFFS)
    .switchMap(() => this.identityService.findStaffs())
    .map((staffs) => this.staffActions.findStaffsSuccess(staffs));

  @Effect() findAcademicStaffs$ = this.actions$
    .ofType(StaffActions.FIND_ACADEMIC_STAFFS)
    .switchMap(() => this.identityService.findAcademicStaffs())
    .map((staffs) => this.staffActions.findAcademicStaffsSuccess(staffs));

  // find staff by identityNo
  @Effect() findStaffByIdentityNo$ = this.actions$
    .ofType(StaffActions.FIND_STAFF_BY_IDENTITY_NO)
    .map((action) => action.payload)
    .switchMap((identityNo) => this.identityService.findStaffByIdentityNo(identityNo))
    .map((staff) => this.staffActions.findStaffByIdentityNoSuccess(staff))
    .mergeMap((action) => from([action, this.staffActions.findAppointmentsByStaff(action.payload)]));

  //find appointment by staff
  @Effect() findAppointmentsByStaff$ = this.actions$
    .ofType(StaffActions.FIND_APPOINTMENTS_BY_STAFF)
    .map((action) => action.payload)
    .switchMap((staff) => this.identityService.findAppointmentsByStaff(staff))
    .map((staffs) => this.staffActions.findAppointmentsByStaffSuccess(staffs));

  @Effect() saveAcademicStaff$ = this.actions$
    .ofType(StaffActions.SAVE_ACADEMIC_STAFF)
    .map(action => action.payload)
    .switchMap(payload => this.identityService.saveAcademicStaff(payload))
    .map(message => this.staffActions.saveAcademicStaffSuccess(message))
    .mergeMap(action => from([action, this.staffActions.findAcademicStaffs()]));

  @Effect() updateAcademicStaff$ = this.actions$
    .ofType(StaffActions.UPDATE_ACADEMIC_STAFF)
    .map(action => action.payload)
    .switchMap(payload => this.identityService.updateAcademicStaff(payload))
    .map(message => this.staffActions.updateAcademicStaffSuccess(message))
    .mergeMap(action => from([action, this.staffActions.findAcademicStaffs()]));

    
  @Effect() deactiveStaffAcademic$ = this.actions$
  .ofType(StaffActions.DEACTIVE_STAFF_ACADEMIC)
  .map(action => action.payload)
  .switchMap(payload => this.identityService.deactiveStaffAcademic(payload))
  .map(message => this.staffActions.deactiveStaffAcademicSuccess(message))
  .mergeMap(action => from([action, this.staffActions.findAcademicStaffs()]));



}
