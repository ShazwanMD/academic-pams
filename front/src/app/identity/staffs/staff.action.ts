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
  
  //find staff by id
  static FIND_STAFF_BY_IDENTITY_NO = '[Staff] Find Staff By Identity No';
  findStaffByIdentityNo(identityNo): Action {
    return {
      type: StaffActions.FIND_STAFF_BY_IDENTITY_NO,
      payload: identityNo
    };
  }

  static FIND_STAFF_BY_IDENTITY_NO_SUCCESS = '[Staff] Find Staff By Identity No Success';
  findStaffByIdentityNoSuccess(staff): Action {
    return {
      type: StaffActions.FIND_STAFF_BY_IDENTITY_NO_SUCCESS,
      payload: staff
    };
  }
  
  //find appointments by staff
  static FIND_APPOINTMENTS_BY_STAFF = '[Staff] Find Appointments By Staff';

  findAppointmentsByStaff(staff): Action {
      console.log("findAppointmentsByStaff");
      return {
          type: StaffActions.FIND_APPOINTMENTS_BY_STAFF,
          payload: staff
      };
  }

  static FIND_APPOINTMENTS_BY_STAFF_SUCCESS = '[Staff] Find Appointments By Staff Success';

  findAppointmentsByStaffSuccess(appointments): Action {
      console.log("findAppointmentsByStaffSuccess");
      return {
          type: StaffActions.FIND_APPOINTMENTS_BY_STAFF_SUCCESS,
          payload: appointments
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
