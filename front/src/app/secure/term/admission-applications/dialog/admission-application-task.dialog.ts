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

@Component( {
    selector: 'pams-admission-application-task',
    templateUrl: './admission-application-task.dialog.html',
} )

export class AdmissionApplicationTaskDialog implements OnInit {
    
    private creatorDialogRefConfirm: MdDialogRef<AdmissionApplicationTaskConfirmDialog>;

    private ADMISSION_APPLICATION: string[] = 'termModuleState.admissionApplication'.split( '.' );
    private ASSIGNED_ADMISSION_APPLICATION_TASKS: string[] = 'termModuleState.assignedAdmissionApplicationTasks'.split( '.' );
    private assignedAdmissionApplicationTasks$: Observable<AdmissionApplicationTask>;
    private admissionApplication$: Observable<AdmissionApplication[]>;

    private createForm: FormGroup;
    private _academicSession: AcademicSession;
    private _student: Student;
    private _admissionApplication: AdmissionApplication;
    private create: boolean = false;
    private edit: boolean = false;

    constructor( private formBuilder: FormBuilder,
        private store: Store<TermModuleState>,
        private actions: AdmissionApplicationActions,
        private router: Router,
        private route: ActivatedRoute,
        private snackBar: MdSnackBar,
        private vcf: ViewContainerRef,
        private dialog: MdDialog,) {

        this.admissionApplication$ = this.store.select( ...this.ADMISSION_APPLICATION );
        this.assignedAdmissionApplicationTasks$ = this.store.select( ...this.ASSIGNED_ADMISSION_APPLICATION_TASKS );
    }

    set student( value: Student ) {
        this._student = value;
        this.edit = true;
    }

    ngOnInit(): void {

        this.store.dispatch( this.actions.findAssignedAdmissionApplicationTasks() );

        this.createForm = this.formBuilder.group( {
            id: [undefined],
            //student: <Student>{},
            academicSession: ['', Validators.required],
        } );

        if ( this.edit ) this.createForm.patchValue( this._student );
    }

    save( admissionApplication: AdmissionApplication, isValid: boolean ): void {

        console.log( "_student", this._student );

        this._academicSession = admissionApplication.academicSession;
        admissionApplication.student = this._student;

        console.log( 'student: ' + admissionApplication.student.identityNo );

        // setup description
        admissionApplication.description = admissionApplication.student.identityNo + ' ' + admissionApplication.academicSession.code;
        this.store.dispatch( this.actions.startAdmissionApplicationTask( admissionApplication ) );
       
        //alert by snackbar if duplicate
        console.log( "Test subscribe:", this.admissionApplication$.subscribe( val => { val['status'] } ) );
        this.admissionApplication$.subscribe( val => console.log( 'Accumulated object display:', val['status'] ) );

        this.admissionApplication$.subscribe( val => {
            if ( val['status'] == 'Duplicate' ) {

                let snackBarRef = this.snackBar.open( 'Duplicate data: ' + admissionApplication.id + ' Please insert new data', '', { duration: 3000 } );
                snackBarRef.afterDismissed().subscribe(() => {
                    console.log( 'The snack-bar was dismissed' );
                    console.log( 'Accumulated object:', val )
                    val['status'] = '';
                    this.dialog.closeAll();
                } );

            } else {
                if ( val['status'] == 'success' ) {
                    /*let snackBarRef = this.snackBar.open( 'New admissionApplication: ' + admissionApplication.id + ' has been inserted', '', { duration: 3000 } );
                    snackBarRef.afterDismissed().subscribe(() => {
                        console.log( 'The snack-bar was dismissed' );
                        console.log( 'Accumulated object:', val )
                        val['status'] = '';
                    } );*/
                    
                    
                      //open dialog to confirm registration
                    console.log('showDialog');
                    let config = new MdDialogConfig();
                    config.viewContainerRef = this.vcf;
                    config.role = 'dialog';
                    config.width = '60%';
                    config.height = '50%';
                    config.position = { top: '0px' };
                    this.creatorDialogRefConfirm = this.dialog.open(AdmissionApplicationTaskConfirmDialog, config);
                    this.creatorDialogRefConfirm.componentInstance.student = this._student;
                    this.creatorDialogRefConfirm.afterClosed().subscribe((res) => {
                        console.log('close dialog');
                        this.dialog.closeAll();
                        // load something here
                    });
                }
            }
        }
        );
        
      
    }
}
