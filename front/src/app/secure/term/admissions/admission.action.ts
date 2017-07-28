import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';

@Injectable()
export class AdmissionActions {

  static FIND_ADMISSIONS = '[Admission] Find Admissions';

  findAdmissions(): Action {
    return {
      type: AdmissionActions.FIND_ADMISSIONS
    };
  }

  static FIND_ADMISSIONS_SUCCESS = '[Admission] Find Admissions Success';
  findAdmissionsSuccess(admissions): Action {
    return {
      type: AdmissionActions.FIND_ADMISSIONS_SUCCESS,
      payload: admissions
    };
  }
  
  //find admission applications
  static FIND_ADMISSION_APPLICATIONS = '[Admission Application] Find Admission Applications';

  findAdmissionApplications(): Action {
    return {
      type: AdmissionActions.FIND_ADMISSION_APPLICATIONS
    };
  }

  static FIND_ADMISSION_APPLICATIONS_SUCCESS = '[Admission Application] Find Admission Applications Success';
  findAdmissionApplicationsSuccess(admissionApplications): Action {
    return {
      type: AdmissionActions.FIND_ADMISSION_APPLICATIONS_SUCCESS,
      payload: admissionApplications
    };
  }


  static FIND_ADMISSION_BY_ID = '[Admission] Find Admission By Id';
  findAdmissionById(id): Action {
    return {
      type: AdmissionActions.FIND_ADMISSION_BY_ID,
      payload: id
    };
  }

  static FIND_ADMISSION_BY_ID_SUCCESS = '[Admission] Find Admission By Id Success';
  findAdmissionByIdSuccess(admission): Action {
    return {
      type: AdmissionActions.FIND_ADMISSION_BY_ID_SUCCESS,
      payload: admission
    };
  }

  //FIND ENROLLMENTS BY ADMISSION
   static FIND_ENROLLMENTS_BY_ADMISSION = '[Admission] Find Enrollments By Admission';

  findEnrollmentsByAdmission(admission): Action {
    return {
      type: AdmissionActions.FIND_ENROLLMENTS_BY_ADMISSION,
      payload: admission
    };
  }

  static FIND_ENROLLMENTS_BY_ADMISSION_SUCCESS = '[Admission] Find Enrollments By Admission Success';

  findEnrollmentsByAdmissionSuccess(enrollments): Action {
    return {
      type: AdmissionActions.FIND_ENROLLMENTS_BY_ADMISSION_SUCCESS,
      payload: enrollments
    };
  }
  
  //FIND ENROLLMENTAPPLICATIONS BY ADMISSION
  static FIND_ENROLLMENTAPPLICATIONS_BY_ADMISSION = '[Admission] Find EnrollmentApplications By Admission';

 findEnrollmentApplicationsByAdmission(admission): Action {
   return {
     type: AdmissionActions.FIND_ENROLLMENTAPPLICATIONS_BY_ADMISSION,
     payload: admission
   };
 }

 static FIND_ENROLLMENTAPPLICATIONS_BY_ADMISSION_SUCCESS = '[Admission] Find EnrollmentApplications By Admission Success';

 findEnrollmentApplicationsByAdmissionSuccess(enrollmentApplications): Action {
   return {
     type: AdmissionActions.FIND_ENROLLMENTAPPLICATIONS_BY_ADMISSION_SUCCESS,
     payload: enrollmentApplications
   };
 }
  
  static FIND_ADMISSION_BY_CURRENT = '[Admission] Find Admission By Current';
  findAdmissionByCurrent(admission): Action {
    return {
      type: AdmissionActions.FIND_ADMISSION_BY_CURRENT,
      payload: admission
    };
  }

  static FIND_ADMISSION_BY_CURRENT_SUCCESS = '[Admission] Find Admission By Current Success';
  findAdmissionByCurrentSuccess(admission): Action {
    return {
      type: AdmissionActions.FIND_ADMISSION_BY_CURRENT_SUCCESS,
      payload: admission
    };
  }

  static SAVE_ADMISSION = '[AdmissionApplication] Save AdmissionApplication';
  saveAdmission(admission): Action {
    return {
      type: AdmissionActions.SAVE_ADMISSION,
      payload: admission
    };
  }

  static SAVE_ADMISSION_SUCCESS = '[AdmissionApplication] Save AdmissionApplication Success';
  saveAdmissionSuccess(message): Action {
    return {
      type: AdmissionActions.SAVE_ADMISSION_SUCCESS,
      payload: message
    };
  }

  static UPDATE_ADMISSION = '[Admission] Update Admission';
  updateAdmission(admission): Action {
      console.log("updateAdmission");
    return {
      type: AdmissionActions.UPDATE_ADMISSION,
      payload: admission
    };
  }

  static UPDATE_ADMISSION_SUCCESS = '[Admission] Update Admission Success';
  updateAdmissionSuccess(message): Action {
      console.log("updateAdmissionSuccess");
    return {
      type: AdmissionActions.UPDATE_ADMISSION_SUCCESS,
      payload: message
    };
  }


}
