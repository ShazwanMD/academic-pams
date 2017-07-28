import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class StaffActions {

  static FIND_STAFFS = '[Staff] Find Staffs';

  findStaffs(): Action {
    return {
      type: StaffActions.FIND_STAFFS
    };
  }

  static FIND_STAFFS_SUCCESS = '[Staff] Find Staffs Success';

  findStaffsSuccess(staffs): Action {
    console.log("findStaffsSuccess");
    return {
      type: StaffActions.FIND_STAFFS_SUCCESS,
      payload: staffs
    };
  }

  static FIND_STAFF = '[Staff] Find Staff';

  findStaff(identityNo): Action {
    return {
      type: StaffActions.FIND_STAFF,
      payload: identityNo
    };
  }

  static FIND_STAFF_SUCCESS = '[Staff] Find Staff Success';

  findStaffSuccess(staff): Action {
    console.log("findStaffSuccess");
    return {
      type: StaffActions.FIND_STAFF_SUCCESS,
      payload: staff
    };
  }


  static UPDATE_STAFF = '[Staff] Update Staff';

  updateStaff(account): Action {
    return {
      type: StaffActions.UPDATE_STAFF,
      payload: account
    };
  }

  static UPDATE_STAFF_SUCCESS = '[Staff] Update Staff Success';

  updateStaffSuccess(account): Action {
    return {
      type: StaffActions.UPDATE_STAFF_SUCCESS,
      payload: account
    };
  }
}
