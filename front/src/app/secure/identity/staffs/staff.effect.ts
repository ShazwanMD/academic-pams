import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {StaffActions} from './staff.action';
import {IdentityService} from '../../../../services/identity.service';
import {IdentityModuleState} from '../index';
import {Store} from '@ngrx/store';
import {from} from 'rxjs/observable/from';

@Injectable()
export class StaffEffects {

  private STAFF: string[] = 'identityModuleState.staff'.split('.');

  constructor(private actions$: Actions,
              private staffActions: StaffActions,
              private identityService: IdentityService,
              private store$: Store<IdentityModuleState>) {
  }

  @Effect() findStaffs$ = this.actions$
    .ofType(StaffActions.FIND_STAFFS)
    .switchMap(() => this.identityService.findStaffs())
    .map((staffs) => this.staffActions.findStaffsSuccess(staffs));

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

}
