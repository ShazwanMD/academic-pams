import { Action } from '@ngrx/store';
import { Injectable } from '@angular/core';


@Injectable()
export class LecturerActions {

    /*==================================================================================================*/
    /*LECTURER PROFILE PANEL
    /*==================================================================================================*/

    static FIND_LECTURER_BY_USER = '[LecturerPanel] Find Lecturer By User';

    findLecturerByUser(): Action {
        console.log( "Find Lecturer By User" )
        return {
            type: LecturerActions.FIND_LECTURER_BY_USER,
        };
    }

    static FIND_LECTURER_BY_USER_SUCCESS = '[LecturerPanel] Find Lecturer By User Success';

    findLecturerByUserSuccess( lecturer ): Action {
        console.log( "Find Lecturer By User Success" )
        return {
            type: LecturerActions.FIND_LECTURER_BY_USER_SUCCESS,
            payload: lecturer
        };
    }

    //find appointments by lecturer
    static FIND_APPOINTMENTS_BY_LECTURER = '[LecturerPanel] Find Appointments';

    findAppointmentsByLecturer( lecturer ): Action {
        return {
            type: LecturerActions.FIND_APPOINTMENTS_BY_LECTURER,
            payload: lecturer
        };
    }

    static FIND_APPOINTMENTS_BY_LECTURER_SUCCESS = '[LecturerPanel] Find Appointments Success';

    findAppointmentsByLecturerSuccess( appointments ): Action {
        return {
            type: LecturerActions.FIND_APPOINTMENTS_BY_LECTURER_SUCCESS,
            payload: appointments
        };
    }

    //find admission applications by lecturer
    static FIND_ADMISSION_APPLICATIONS_BY_LECTURER = '[LecturerPanel] Find AdmissionApplications';

    findAdmissionApplicationsByLecturer( lecturer ): Action {
        return {
            type: LecturerActions.FIND_ADMISSION_APPLICATIONS_BY_LECTURER,
            payload: lecturer
        };
    }

    static FIND_ADMISSION_APPLICATIONS_BY_LECTURER_SUCCESS = '[LecturerPanel] Find AdmissionApplications Success';

    findAdmissionApplicationsByLecturerSuccess( admissionApplications ): Action {
        return {
            type: LecturerActions.FIND_ADMISSION_APPLICATIONS_BY_LECTURER_SUCCESS,
            payload: admissionApplications
        };
    }
    
    //find admissions by lecturer
    static FIND_ADMISSIONS_BY_LECTURER = '[LecturerPanel] Find Admissions';

    findAdmissionsByLecturer( lecturer ): Action {
        return {
            type: LecturerActions.FIND_ADMISSIONS_BY_LECTURER,
            payload: lecturer
        };
    }

    static FIND_ADMISSIONS_BY_LECTURER_SUCCESS = '[LecturerPanel] Find Admissions Success';

    findAdmissionsByLecturerSuccess( admissions ): Action {
        return {
            type: LecturerActions.FIND_ADMISSIONS_BY_LECTURER_SUCCESS,
            payload: admissions
        };
    }
    
    
}