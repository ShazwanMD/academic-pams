import { Injectable } from '@angular/core';
import { Actions, Effect } from '@ngrx/effects';
import { EnrollmentApplicationActions } from './enrollment-application.action';
import { from } from 'rxjs/observable/from';
import { TermService } from '../../../../services/term.service';
import { TermModuleState } from '../index';
import { Store } from '@ngrx/store';
import 'rxjs/add/operator/withLatestFrom';
import { EnrollmentApplicationTask } from '../../../shared/model/term/enrollment-application-task.interface';
import { AdmissionActions } from '../admissions/admission.action';
import { Admission } from '../../../shared/model/term/admission.interface';
import { NotificationService } from "../../../../services/notification.service";
import { EnrollmentApplication } from "../../../shared/model/term/enrollment-application.interface";

@Injectable()
export class EnrollmentApplicationEffects {

    private ENROLLMENT_APPLICATION_TASK: string[] = 'termModuleState.enrollmentApplicationTask'.split( '.' );
    private ADMISSION: string[] = 'termModuleState.admission'.split( '.' );
    private ENROLLMENT_APPLICATION: string[] = 'termModuleState.enrollmentApplication'.split( '.' );

    constructor( private actions$: Actions,
        private enrollmentApplicationActions: EnrollmentApplicationActions,
        private admissionActions: AdmissionActions,
        private termService: TermService,
        private notificationService: NotificationService,
        private store$: Store<TermModuleState> ) {
    }

    @Effect() findEnrollmentApplications$ = this.actions$
        .ofType( EnrollmentApplicationActions.FIND_ENROLLMENT_APPLICATIONS )
        .switchMap(() => this.termService.findEnrollmentApplications() )
        .map(( enrollmentApplications ) => this.enrollmentApplicationActions.findEnrollmentApplicationsSuccess( enrollmentApplications ) );

    @Effect() findAssignedEnrollmentApplicationTasks$ = this.actions$
        .ofType( EnrollmentApplicationActions.FIND_ASSIGNED_ENROLLMENT_APPLICATION_TASKS )
        .switchMap(() => this.termService.findAssignedEnrollmentApplicationTasks() )
        .map(( enrollmentApplications ) => this.enrollmentApplicationActions.findAssignedEnrollmentApplicationTasksSuccess( enrollmentApplications ) );

    @Effect() findPooledEnrollmentApplicationTasks$ = this.actions$
        .ofType( EnrollmentApplicationActions.FIND_POOLED_ENROLLMENT_APPLICATION_TASKS )
        .switchMap(() => this.termService.findPooledEnrollmentApplicationTasks() )
        .map(( enrollmentApplications ) => this.enrollmentApplicationActions.findPooledEnrollmentApplicationTasksSuccess( enrollmentApplications ) );

    //archived
    @Effect() findArchivedEnrollmentApplications$ = this.actions$
        .ofType( EnrollmentApplicationActions.FIND_ARCHIVED_ENROLLMENT_APPLICATIONS )
        .switchMap(() => this.termService.findArchivedEnrollmentApplications() )
        .map(( enrollmentApplications ) => this.enrollmentApplicationActions.findArchivedEnrollmentApplicationsSuccess( enrollmentApplications ) );

    @Effect() findEnrollmentApplicationTaskByTaskId = this.actions$
        .ofType( EnrollmentApplicationActions.FIND_ENROLLMENT_APPLICATION_TASK_BY_TASK_ID )
        .map(( action ) => action.payload )
        .switchMap(( taskId ) => this.termService.findEnrollmentApplicationTaskByTaskId( taskId ) )
        .map(( task ) => this.enrollmentApplicationActions.findEnrollmentApplicationTaskByTaskIdSuccess( task ) );

    @Effect() findEnrollmentApplicationByReferenceNo$ = this.actions$
        .ofType( EnrollmentApplicationActions.FIND_ENROLLMENT_APPLICATION_BY_REFERENCE_NO )
        .map(( action ) => action.payload )
        .switchMap(( referenceNo ) => this.termService.findEnrollmentApplicationByReferenceNo( referenceNo ) )
        .map(( enrollmentApplication ) => this.enrollmentApplicationActions.findEnrollmentApplicationByReferenceNoSuccess( enrollmentApplication ) )
        .mergeMap(( action ) => from( [action,
            this.enrollmentApplicationActions.findEnrollmentApplicationItems( action.payload )] ) );

    @Effect() findEnrollmentApplicationItems$ = this.actions$
        .ofType( EnrollmentApplicationActions.FIND_ENROLLMENT_APPLICATION_ITEMS )
        .map(( action ) => action.payload )
        .switchMap(( enrollmentApplication ) => this.termService.findEnrollmentApplicationItems( enrollmentApplication ) )
        .map(( items ) => this.enrollmentApplicationActions.findEnrollmentApplicationItemsSuccess( items ) );

    //find enrollment application item by id
    @Effect() findEnrollmentApplicationItemById$ = this.actions$
        .ofType( EnrollmentApplicationActions.FIND_ENROLLMENT_APPLICATION_ITEM_BY_ID )
        .map(( action ) => action.payload )
        .switchMap(( enrollmentApplication ) => this.termService.findEnrollmentApplicationItemById( enrollmentApplication ) )
        .map(( item ) => this.enrollmentApplicationActions.findEnrollmentApplicationByIdSuccess( item ) );

    //student startEnrollmentApplicationTask
    @Effect() startEnrollmentApplicationTask$ = this.actions$
        .ofType( EnrollmentApplicationActions.START_ENROLLMENT_APPLICATION_TASK )
        .map(( action ) => action.payload )
        .switchMap(( enrollmentApplication ) => this.termService.startEnrollmentApplicationTask( enrollmentApplication ) )
        .map(( message ) => this.enrollmentApplicationActions.startEnrollmentApplicationTaskSuccess( message ) )
        .mergeMap(( action ) => from( [action,
            this.enrollmentApplicationActions.findAssignedEnrollmentApplicationTasks(),
            this.enrollmentApplicationActions.findPooledEnrollmentApplicationTasks(),
            this.enrollmentApplicationActions.findArchivedEnrollmentApplications(),], ) );
    //.withLatestFrom( this.store$.select( ...this.ADMISSION ) )
    //.map(( state ) => state[1] )
    //.map(( admission: Admission ) => this.admissionActions.findAdmissionById( admission.id ) ); 
    
    //administrator startEnrollmentApplicationTask
    @Effect() startAdminEnrollmentApplicationTask$ = this.actions$
        .ofType( EnrollmentApplicationActions.START_ADMIN_ENROLLMENT_APPLICATION_TASK )
        .map(( action ) => action.payload )
        .switchMap(( enrollmentApplication ) => this.termService.startEnrollmentApplicationTask( enrollmentApplication ) )
        .map(( message ) => this.enrollmentApplicationActions.startAdminEnrollmentApplicationTaskSuccess( message ) )
        .mergeMap(( action ) => from( [action,
            this.enrollmentApplicationActions.findAssignedEnrollmentApplicationTasks(),
            this.enrollmentApplicationActions.findPooledEnrollmentApplicationTasks(),
            this.enrollmentApplicationActions.findArchivedEnrollmentApplications(),], ) );
    //.catch((error) => this.notificationService.showError(error));


    @Effect() completeEnrollmentApplicationTask$ = this.actions$
        .ofType( EnrollmentApplicationActions.COMPLETE_ENROLLMENT_APPLICATION_TASK )
        .map(( action ) => action.payload )
        .switchMap(( enrollmentApplicationTask ) => this.termService.completeEnrollmentApplicationTask( enrollmentApplicationTask ) )
        .map(( message ) => this.enrollmentApplicationActions.completeEnrollmentApplicationTaskSuccess( message ) )
        .mergeMap(( action ) => from( [action,
            this.enrollmentApplicationActions.findAssignedEnrollmentApplicationTasks(),
            this.enrollmentApplicationActions.findPooledEnrollmentApplicationTasks(),
            this.enrollmentApplicationActions.findArchivedEnrollmentApplications(),
        ],
        ) );

    @Effect() claimEnrollmentApplicationTask$ = this.actions$
        .ofType( EnrollmentApplicationActions.CLAIM_ENROLLMENT_APPLICATION_TASK )
        .map(( action ) => action.payload )
        .switchMap(( enrollmentApplicationTask ) => this.termService.claimEnrollmentApplicationTask( enrollmentApplicationTask ) )
        .map(( message ) => this.enrollmentApplicationActions.claimEnrollmentApplicationTaskSuccess( message ) )
        .mergeMap(( action ) => from( [action,
            this.enrollmentApplicationActions.findAssignedEnrollmentApplicationTasks(),
            this.enrollmentApplicationActions.findPooledEnrollmentApplicationTasks(),
            this.enrollmentApplicationActions.findArchivedEnrollmentApplications()] ) )
        .withLatestFrom( this.store$.select( ...this.ENROLLMENT_APPLICATION_TASK ) )
        .map(( state ) => state[1] )
        .map(( application: EnrollmentApplicationTask ) => this.enrollmentApplicationActions.findEnrollmentApplicationByReferenceNo( application.referenceNo ) );

    @Effect() releaseEnrollmentApplicationTask$ = this.actions$
        .ofType( EnrollmentApplicationActions.RELEASE_ENROLLMENT_APPLICATION_TASK )
        .map(( action ) => action.payload )
        .switchMap(( enrollmentApplicationTask ) => this.termService.releaseEnrollmentApplicationTask( enrollmentApplicationTask ) )
        .map(( message ) => this.enrollmentApplicationActions.releaseEnrollmentApplicationTaskSuccess( message ) )
        .mergeMap(( action ) => from( [action,
            this.enrollmentApplicationActions.findAssignedEnrollmentApplicationTasks(),
            this.enrollmentApplicationActions.findPooledEnrollmentApplicationTasks(),
            this.enrollmentApplicationActions.findArchivedEnrollmentApplications(),
        ],
        ) );

    @Effect() updateEnrollmentApplication$ = this.actions$
        .ofType( EnrollmentApplicationActions.UPDATE_ENROLLMENT_APPLICATION )
        .map(( action ) => action.payload )
        .switchMap(( enrollmentApplication ) => this.termService.updateEnrollmentApplication( enrollmentApplication ) )
        .map(( enrollmentApplication ) => this.enrollmentApplicationActions.updateEnrollmentApplicationSuccess( enrollmentApplication ) );

    @Effect() addEnrollmentApplicationItem$ = this.actions$
        .ofType( EnrollmentApplicationActions.ADD_ENROLLMENT_APPLICATION_ITEM )
        .map(( action ) => action.payload )
        .switchMap(( payload ) => this.termService.addEnrollmentApplicationItem( payload.application, payload.item ) )
        .map(( message ) => this.enrollmentApplicationActions.addEnrollmentApplicationItemSuccess( message ) )
        .withLatestFrom( this.store$.select( ...this.ENROLLMENT_APPLICATION_TASK ) )
        .map(( state ) => state[1] )
        .map(( task: EnrollmentApplicationTask ) => this.enrollmentApplicationActions.findEnrollmentApplicationItems( task.application ) );

    //add items in studentPage
    @Effect() addStudentEnrollmentApplicationItem$ = this.actions$
        .ofType( EnrollmentApplicationActions.ADD_STUDENT_ENROLLMENT_APPLICATION_ITEM )
        .map(( action ) => action.payload )
        .switchMap(( payload ) => this.termService.addStudentEnrollmentApplicationItem( payload.application, payload.item ) )
        .map(( message ) => this.enrollmentApplicationActions.addStudentEnrollmentApplicationItemSuccess( message ) )
        .withLatestFrom( this.store$.select( ...this.ENROLLMENT_APPLICATION ) )
        .map(( state ) => state[1] )
        .map(( application: EnrollmentApplication ) => this.enrollmentApplicationActions.findEnrollmentApplicationItems( application ) );


    @Effect() deleteEnrollmentApplicationItem$ = this.actions$
        .ofType( EnrollmentApplicationActions.DELETE_ENROLLMENT_APPLICATION_ITEM )
        .map(( action ) => action.payload )
        .switchMap(( payload ) => this.termService.deleteEnrollmentApplicationItem( payload.application, payload.item ) )
        .map(( message ) => this.enrollmentApplicationActions.deleteEnrollmentApplicationItemSuccess( message ) )
        .withLatestFrom( this.store$.select( ...this.ENROLLMENT_APPLICATION_TASK ) )
        .map(( state ) => state[1] )
        .map(( enrollmentApplication ) => this.enrollmentApplicationActions.findEnrollmentApplicationItems( enrollmentApplication ) );

    //student: delete enrollment application item
    @Effect() deleteStudentEnrollmentApplicationItem$ = this.actions$
        .ofType( EnrollmentApplicationActions.DELETE_STUDENT_ENROLLMENT_APPLICATION_ITEM )
        .map(( action ) => action.payload )
        .switchMap(( payload ) => this.termService.deleteStudentEnrollmentApplicationItem( payload.application, payload.item ) )
        .map(( message ) => this.enrollmentApplicationActions.deleteStudentEnrollmentApplicationItemSuccess( message ) )
        .withLatestFrom( this.store$.select( ...this.ENROLLMENT_APPLICATION ) )
        .map(( state ) => state[1] )
        .map(( enrollmentApplication ) => this.enrollmentApplicationActions.findEnrollmentApplicationItems( enrollmentApplication ) );


    @Effect() updateEnrollmentApplicationItem$ = this.actions$
        .ofType( EnrollmentApplicationActions.UPDATE_ENROLLMENT_APPLICATION_ITEM )
        .map(( action ) => action.payload )
        .switchMap(( payload ) => this.termService.updateEnrollmentApplicationItem( payload.application, payload.item ) )
        .map(( message ) => this.enrollmentApplicationActions.updateEnrollmentApplicationItemSuccess( message ) )
        .withLatestFrom( this.store$.select( ...this.ENROLLMENT_APPLICATION_TASK ) )
        .map(( state ) => state[1] )
        .map(( application: EnrollmentApplicationTask ) => this.enrollmentApplicationActions.findEnrollmentApplicationByReferenceNo( application.referenceNo ) );

    @Effect() removeEnrollmentApplication$ = this.actions$
        .ofType( EnrollmentApplicationActions.REMOVE_ENROLLMENT_APPLICATION )
        .map(( action ) => action.payload )
        .switchMap(( payload ) => this.termService.removeEnrollmentApplication( payload.admission, payload.application ) )
        .map(( message ) => this.enrollmentApplicationActions.removeEnrollmentApplicationSuccess( message ) )
        .withLatestFrom( this.store$.select( ...this.ADMISSION ) )
        .map(( state ) => state[1] )
        .map(( admission: Admission ) => this.admissionActions.findAdmissionById( admission.id ) );

}
