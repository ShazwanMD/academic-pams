import { Action } from '@ngrx/store';
import { Injectable } from '@angular/core';


@Injectable()
export class LecturerActions {

    /*==================================================================================================*/
    /*LECTURER PROFILE PANEL
    /*==================================================================================================*/

    static FIND_LECTURER_BY_USER = '[LecturerPanel] Find Lecturer By User';

    findLecturerByUser(): Action {
        console.log("Find Lecturer By User")
        return {
            type: LecturerActions.FIND_LECTURER_BY_USER,
        };
    }

    static FIND_LECTURER_BY_USER_SUCCESS = '[LecturerPanel] Find Lecturer By User Success';

    findLecturerByUserSuccess(lecturer): Action {
        console.log("Find Lecturer By User Success")
        return {
            type: LecturerActions.FIND_LECTURER_BY_USER_SUCCESS,
            payload: lecturer
        };
    }
}