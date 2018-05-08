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

  static FIND_ACADEMIC_STAFFS = '[Staff] Find Academic Staffs';

  findAcademicStaffs(): Action {
    return {
      type: StaffActions.FIND_ACADEMIC_STAFFS
    };
  }

  static FIND_ACADEMIC_STAFFS_SUCCESS = '[Staff] Find Staffs Success';

  findAcademicStaffsSuccess(staffs): Action {
    console.log("findAcademicStaffsSuccess");
    return {
      type: StaffActions.FIND_ACADEMIC_STAFFS_SUCCESS,
      payload: staffs
    };
  }

  static SAVE_ACADEMIC_STAFF = '[Staff] save academic Staff';

  saveAcademicStaff(staff): Action {
    return {
      type: StaffActions.SAVE_ACADEMIC_STAFF,
      payload: staff
    };
  }

  static SAVE_ACADEMIC_STAFF_SUCCESS = '[Staff] save academic Staff Success';

  saveAcademicStaffSuccess(staff): Action {
    return {
      type: StaffActions.SAVE_ACADEMIC_STAFF_SUCCESS,
      payload: staff
    };
  }

  static UPDATE_ACADEMIC_STAFF = '[Staff] update academic Staff';

  updateAcademicStaff(staff): Action {
    return {
      type: StaffActions.UPDATE_ACADEMIC_STAFF,
      payload: staff
    };
  }

  static UPDATE_ACADEMIC_STAFF_SUCCESS = '[Staff] update academic Staff Success';

  updateAcademicStaffSuccess(staff): Action {
    return {
      type: StaffActions.UPDATE_ACADEMIC_STAFF_SUCCESS,
      payload: staff
    };
  }

  //find staff by id
  static FIND_STAFF_BY_IDENTITY_NO = '[Staff] Find Staff By Identity No';

  findStaffByIdentityNo(staff): Action {
    return {
      type: StaffActions.FIND_STAFF_BY_IDENTITY_NO,
      payload: staff
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
