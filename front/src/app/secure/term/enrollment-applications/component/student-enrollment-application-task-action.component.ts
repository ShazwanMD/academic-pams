import { Store } from '@ngrx/store';
import { ChangeDetectionStrategy, Component, Input, ViewContainerRef } from '@angular/core';
import { TermModuleState } from '../../index';
import { MdDialogRef, MdSnackBar, MdDialog } from '@angular/material';
import { AdmissionApplication } from '../../../../shared/model/term/admission-application.interface';
import { EnrollmentApplication } from "../../../../shared/model/term/enrollment-application.interface";
import { EnrollmentApplicationItem } from "../../../../shared/model/term/enrollment-application-item.interface";
import { EnrollmentApplicationActions } from "../enrollment-application.action";
import { ActivatedRoute, Router } from '@angular/router';
import { EnrollmentApplicationTask } from '../../../../shared/model/term/enrollment-application-task.interface';

@Component( {
    selector: 'pams-student-enrollment-application-task-action',
    templateUrl: './student-enrollment-application-task-action.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )

export class StudentEnrollmentApplicationTaskActionComponent {

    private _snackBar: MdSnackBar;

    @Input() enrollmentApplicationItems: EnrollmentApplicationItem[];
    @Input() enrollmentApplicationTask: EnrollmentApplicationTask;

    constructor( private actions: EnrollmentApplicationActions,
        private router: Router,
        private store: Store<TermModuleState>,
        private snackBar: MdSnackBar,
        private vcf: ViewContainerRef,
        private dialog: MdDialog ) {


        this._snackBar = snackBar;

    }

    register() {

        var r = confirm( "Are you sure to proceed in registering the courses?" );
        if ( r == true ) {

            let snackBarRef = this._snackBar.open( 'Course enrollments completed', '', {duration:2000} );
            snackBarRef.afterDismissed().subscribe(() => {
                this.store.dispatch( this.actions.completeEnrollmentApplicationTask( this.enrollmentApplicationTask ) );
                this.router.navigate( ['/secure'] );
                //this.goBack();
            } );

        } else {

            let snackBarRef = this._snackBar.open( 'Continue to add/drop courses',  '', {duration:2000} );
            snackBarRef.afterDismissed().subscribe(() => {
            } );
        }
    }

    /*register() {
        this.store.dispatch( this.actions.completeEnrollmentApplicationTask( this.enrollmentApplicationTask ) );
        this.goBack();
    }*/

    remove() {
        
        var txt;
        var r = confirm("Are you sure to remove this application?");
        if (r == true) {
            this.store.dispatch( this.actions.releaseEnrollmentApplicationTask( this.enrollmentApplicationTask ) );
            this.goBack();
        } else {
            txt = "Remove application has been cancelled";
        }
       
    }

    goBack(): void {
        this.router.navigate( ['/secure/term/enrollment-applications/student-enrollment-center'] );
    }

    /* editDialog(): void {
       console.log('edit application');
       let config = new MdDialogConfig();
       config.viewContainerRef = this.vcf;
       config.role = 'dialog';
       config.width = '60%';
       config.height = '50%';
       config.position = {top: '0px'};
       this.editorDialogRef = this.dialog.open(AdmissionApplicationTaskEditorDialog, config);
       this.editorDialogRef.componentInstance.admissionApplication = this.admissionApplication;
   
       // set
       this.editorDialogRef.afterClosed().subscribe((res) => {
         console.log('close dialog');
       });
     }*/

}
