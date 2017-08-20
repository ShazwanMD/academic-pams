import { Actions, Effect } from '@ngrx/effects';
import { Router } from '@angular/router';
import { LecturerPanelService } from './../../../services/lecturerPanel.service';
import { LecturerActions } from './lecturer.action';
import { Injectable } from '@angular/core';
import { from } from 'rxjs/observable/from';
import { AppointmentActions } from '../term/appointments/appointment.action';


@Injectable()
export class LecturerEffects {

    private LECTURER: string[] = "LecturerModuleState.lecturer".split( "." );

    constructor(
        private appointmentActions: AppointmentActions,
        private actions$: Actions,
        private lecturerActions: LecturerActions,
        private lecturerService: LecturerPanelService,
        private router: Router ) {

    }


    /*==================================================================================================*/
    /*FINDING THINGS - EFFECT*/
    /*==================================================================================================*/

    @Effect() findLecturerByUser$ = this.actions$
        .ofType( LecturerActions.FIND_LECTURER_BY_USER )
        .map( action => action.payload )
        .switchMap(() => this.lecturerService.findLecturerByUser() )
        .map( payload => this.lecturerActions.findLecturerByUserSuccess( payload ) )
        .mergeMap( action => from( [action,
            this.lecturerActions.findAppointmentsByLecturer( action.payload ),
        ] ) );
    
  //find appointments by lecturer
    @Effect() findAppointmentsByLecturer$ = this.actions$
    .ofType(LecturerActions.FIND_APPOINTMENTS_BY_LECTURER)
    .map(action => action.payload)
    .switchMap(lecturer => this.lecturerService.findAppointmentsByLecturer(lecturer))
    .map(appointments => this.lecturerActions.findAppointmentsByLecturerSuccess(appointments));


}