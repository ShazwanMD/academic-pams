import { Component, Input, OnInit, ViewContainerRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MdDialog, MdDialogConfig, MdSnackBar } from '@angular/material';
import { EnrollmentApplicationItem } from '../../../../shared/model/term/enrollment-application-item.interface';
import { EnrollmentApplication } from '../../../../shared/model/term/enrollment-application.interface';
import { EnrollmentApplicationItemEditorDialog } from '../dialog/enrollment-application-item-editor.dialog';
import { EnrollmentApplicationTask } from '../../../../shared/model/term/enrollment-application-task.interface';
import { Observable } from 'rxjs/Observable';
import { EnrollmentApplicationActions } from '../enrollment-application.action';
import { TermModuleState } from '../../index';
import { Store } from '@ngrx/store';
import { TermService } from "../../../../../services/term.service";
import { AdmissionApplicationTaskConfirmDialog } from "../../admission-applications/dialog/admission-application-task-confirm.dialog";

@Component( {
    selector: 'pams-student-enrollment-application-draft-task',
    templateUrl: './student-enrollment-application-draft-task.panel.html',
} )

export class StudentEnrollmentApplicationDraftTaskPanel implements OnInit {

    private ENROLLMENT_APPLICATION_ITEMS: string[] = 'termModuleState.enrollmentApplicationItems'.split( '.' );
    private ENROLLMENT_APPLICATION_TASK: string[] = 'termModuleState.enrollmentApplicationTask'.split( '.' );
    private enrollmentApplicationItems$: Observable<EnrollmentApplicationItem[]>;
    private enrollmentApplicationTask$: Observable<EnrollmentApplication[]>;

    private _termService: TermService;
    private _snackBar: MdSnackBar;


    @Input() enrollmentApplicationTask: EnrollmentApplicationTask;

    constructor( private router: Router,
        private route: ActivatedRoute,
        private viewContainerRef: ViewContainerRef,
        private dialog: MdDialog,
        private termService: TermService,
        private snackBar: MdSnackBar,
        private actions: EnrollmentApplicationActions,
        private store: Store<TermModuleState> ) {

        this.enrollmentApplicationItems$ = this.store.select( ...this.ENROLLMENT_APPLICATION_ITEMS );
        this.enrollmentApplicationTask$ = this.store.select( ...this.ENROLLMENT_APPLICATION_TASK );
        this._termService = termService;
        this._snackBar = snackBar;
    }

    ngOnInit(): void {
        this.store.dispatch( this.actions.findEnrollmentApplicationItems( this.enrollmentApplicationTask.application ) );
    }

    filter(): void {
    }

    editItem( item: EnrollmentApplicationItem ) {
        console.log( JSON.stringify( this.enrollmentApplicationTask.application ) );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.viewContainerRef;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '60%';
        config.position = { top: '0px' };
        let editorDialogRef = this.dialog.open( EnrollmentApplicationItemEditorDialog, config );
        editorDialogRef.componentInstance.enrollmentApplication = this.enrollmentApplicationTask.application;
        editorDialogRef.componentInstance.enrollmentApplicationItem = item;
    }

    register() {

        var r = confirm( "Are you sure to proceed in registering the courses?" );
        if ( r == true ) {

            let snackBarRef = this._snackBar.open( 'Course enrollments completed', 'OK', {duration:3000} );
            snackBarRef.afterDismissed().subscribe(() => {
                this.store.dispatch( this.actions.completeEnrollmentApplicationTask( this.enrollmentApplicationTask ) );
                this.router.navigate( ['/secure'] );
                //this.goBack();
            } );

        } else {

            let snackBarRef = this._snackBar.open( 'Continue to add/drop courses', 'OK', {duration:3000} );
            snackBarRef.afterDismissed().subscribe(() => {
            } );

        }
    }

    remove() {
        this.store.dispatch( this.actions.releaseEnrollmentApplicationTask( this.enrollmentApplicationTask ) );
        this.goBack();
    }

    goBack(): void {
        this.router.navigate( ['/secure/term/enrollment-applications/student-enrollment-center'] );
    }
}
