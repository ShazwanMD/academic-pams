import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';
import { MdDialogRef, MdSnackBar, MdDialogConfig, MdDialog } from '@angular/material';
import { AdmissionApplicationActions } from '../admission-application.action';
import { AdmissionApplication } from '../../../../shared/model/term/admission-application.interface';
import { TermModuleState } from '../../index';
import { AcademicSession } from '../../../../shared/model/planner/academic-session.interface';
import { Student } from '../../../../shared/model/identity/student.interface';
import { Observable } from "rxjs/Observable";
import { AdmissionApplicationTask } from "../../../../shared/model/term/admission-application-task.interface";
import { AdmissionApplicationTaskConfirmDialog } from "./admission-application-task-confirm.dialog";
import { GraduationApplication } from "../../../../shared/model/graduation/graduation-application.interface";
import { GraduationApplicationActions } from "../../../graduation/graduation-applications/graduation-application.action";
import { GraduationApplicationTask } from "../../../../shared/model/graduation/graduation-application-task.interface";

@Component( {
    selector: 'pams-graduation-application-task',
    templateUrl: './graduation-application-task.dialog.html',
} )

export class GraduationApplicationTaskDialog implements OnInit {

    private creatorDialogRefConfirm: MdDialogRef<AdmissionApplicationTaskConfirmDialog>;

    private GRADUATION_APPLICATION: string[] = 'graduationModuleState.graduationApplication'.split( '.' );
    private ASSIGNED_GRADUATION_APPLICATION_TASKS: string[] = 'graduationModuleState.assignedGraduationApplicationTasks'.split( '.' );
    private assignedGraduationApplicationTasks$: Observable<GraduationApplicationTask>;
    private graduationApplication$: Observable<GraduationApplication[]>;

    private createForm: FormGroup;
    private _academicSession: AcademicSession;
    private _student: Student;
    private _graduationApplication: GraduationApplication;
    private create: boolean = false;
    private edit: boolean = false;

    constructor( private formBuilder: FormBuilder,
        private store: Store<TermModuleState>,
        private actions: GraduationApplicationActions,
        private router: Router,
        private route: ActivatedRoute,
        private snackBar: MdSnackBar,
        private vcf: ViewContainerRef,
        private dialog: MdDialog, ) {

        this.graduationApplication$ = this.store.select( ...this.GRADUATION_APPLICATION );

    }

    set student( value: Student ) {
        this._student = value;
        this.edit = true;
    }

    ngOnInit(): void {

        this.store.dispatch( this.actions.findAssignedGraduationApplicationTasks() );

        /*this.createForm = this.formBuilder.group( {
            id: [undefined],
            //student: <Student>{},
            description: '',
            memo: '',
            academicSession: ['', Validators.required],
        } );*/
        
        this.createForm = this.formBuilder.group({
            referenceNo:  '',
            sourceNo: '',
            description: '',
            memo:  '',
            cgpa: [0.00],
            creditHour: [0],
            //student:  ['', Validators.required],
            academicSession: ['', Validators.required],
          });

        if ( this.edit ) this.createForm.patchValue( this._student );
    }

    /*save( graduationApplication: GraduationApplication, isValid: boolean ): void {

        console.log( "_student", this._student );

        this._academicSession = graduationApplication.academicSession;
        graduationApplication.student = this._student;
        //admissionApplication.ordinal = 1;

        console.log( 'student: ' + graduationApplication.student.identityNo );
        //console.log( 'ordinal: ' + graduationApplication.ordinal );

        // setup description
        graduationApplication.description = graduationApplication.student.identityNo + ' ' + graduationApplication.academicSession.code;
        this.store.dispatch( this.actions.startGraduationApplicationTask( graduationApplication ) );

        //alert by snackbar if duplicate
        console.log( "Test subscribe:", this.graduationApplication$.subscribe( val => { val['status'] } ) );
        this.graduationApplication$.subscribe( val => console.log( 'Accumulated object display:', val['status'] ) );

        this.graduationApplication$.subscribe( val => {
            if ( val['status'] == 'Duplicate' ) {

                let snackBarRef = this.snackBar.open( 'Duplicate data: ' + graduationApplication.student.identityNo + ' Application has been submitted', '', { duration: 3000 } );
                snackBarRef.afterDismissed().subscribe(() => {
                    console.log( 'The snack-bar was dismissed' );
                    console.log( 'Accumulated object:', val )
                    val['status'] = '';
                    try {
                        this.dialog.closeAll();

                    } catch ( ex ) { }
                } );

            } else {
                if ( val['status'] == 'success' ) {

                    //open dialog to confirm registration
                    console.log( 'showDialog' );
                    let config = new MdDialogConfig();
                    config.viewContainerRef = this.vcf;
                    config.role = 'dialog';
                    config.width = '60%';
                    config.height = '50%';
                    config.position = { top: '0px' };
                    this.creatorDialogRefConfirm = this.dialog.open( AdmissionApplicationTaskConfirmDialog, config );
                    this.creatorDialogRefConfirm.componentInstance.student = this._student;
                    this.creatorDialogRefConfirm.afterClosed().subscribe(( res ) => {
                        console.log( 'close dialog' );
                        try {
                            this.dialog.closeAll();

                        } catch ( ex ) { }
                        // load something here
                    } );
                }
            }
        }
        );


    }*/
    
    save(graduationApplication: GraduationApplication, isValid: boolean) {
        
        console.log( "_student", this._student );

        this._academicSession = graduationApplication.academicSession;
        graduationApplication.student = this._student;
        console.log( 'student: ' + graduationApplication.student.identityNo );

        this.store.dispatch(this.actions.startGraduationApplicationTask(graduationApplication));
        console.log(JSON.stringify(graduationApplication));
        this.dialog.closeAll();
        this.router.navigate(['/secure/graduation/graduation-applications/student-graduation-application-center']);
        let snackBarRef = this.snackBar.open( 'New graduation has been saved','',{ duration: 2000 } );
        snackBarRef.afterDismissed().subscribe(() => {
           } );
      }
    
}
