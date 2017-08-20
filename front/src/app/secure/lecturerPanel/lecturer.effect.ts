import { Actions, Effect } from '@ngrx/effects';
import { Router } from '@angular/router';
import { LecturerPanelService } from './../../../services/lecturerPanel.service';
import { LecturerActions } from './lecturer.action';
import { Injectable } from '@angular/core';


@Injectable()
export class LecturerEffects {
    constructor(private actions$: Actions,
        private lecturerActions: LecturerActions,
        private lecturerService: LecturerPanelService,
        private router: Router) {

    }


    /*==================================================================================================*/
    /*FINDING THINGS - EFFECT*/
    /*==================================================================================================*/

    @Effect() findLecturerByUser$ = this.actions$
    .ofType(LecturerActions.FIND_LECTURER_BY_USER)
    .map(action => action.payload)
    .switchMap(() => this.lecturerService.findLecturerByUser())
    .map(payload =>this.lecturerActions.findLecturerByUserSuccess(payload));
}