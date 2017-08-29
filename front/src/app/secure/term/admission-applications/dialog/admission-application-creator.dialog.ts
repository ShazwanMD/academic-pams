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
import { Admission } from "../../../../shared/model/term/admission.interface";
import { AdmissionApplicationConfirmDialog } from "./admission-application-confirm.dialog";

@Component( {
    selector: 'pams-admission-application-creator',
    templateUrl: './admission-application-creator.dialog.html',
} )

export class AdmissionApplicationCreatorDialog implements OnInit {
    
    private creatorDialogRefConfirm: MdDialogRef<AdmissionApplicationConfirmDialog>;

    private ADMISSION_APPLICATION: string[] = 'termModuleState.admissionApplication'.split( '.' );
    private ASSIGNED_ADMISSION_APPLICATION_TASKS: string[] = 'termModuleState.assignedAdmissionApplicationTasks'.split( '.' );
    private assignedAdmissionApplicationTasks$: Observable<AdmissionApplicationTask>;
    private admissionApplication$: Observable<AdmissionApplication[]>;

    private createForm: FormGroup;
    private _academicSession: AcademicSession;
    private _student: Student;
    private _admission: Admission;
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
    
    set admission(value: Admission) {
        this._admission = value;
        this.edit = true;
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

        if ( this.edit ) this.createForm.patchValue( this._admission );
    }

    save( admissionApplication: AdmissionApplication, isValid: boolean ): void {

        console.log( "_admission", this._admission );
        console.log( "admissionApplication", admissionApplication );
        
        this._academicSession = admissionApplication.academicSession;
        admissionApplication.student = this._admission.student;
        admissionApplication.ordinal = this._admission.ordinal + 1;

        console.log( 'student: ' + admissionApplication.student.identityNo );

        // setup description
        admissionApplication.description = admissionApplication.student.identityNo + ' ' + admissionApplication.academicSession.code;
        console.log( 'admissionApplication.description: ' + admissionApplication.student.identityNo + ' ' + admissionApplication.academicSession.code );
        console.log( "admissionApplication.ordinal", admissionApplication.ordinal );
       
        this.store.dispatch( this.actions.startAdmissionApplicationTask( admissionApplication ) );
               
        //alert by snackbar if duplicate
        console.log( "Test subscribe:", this.admissionApplication$.subscribe( val => { val['status'] } ) );
        this.admissionApplication$.subscribe( val => console.log( 'Accumulated object display:', val['status'] ) );

        this.admissionApplication$.subscribe( val => {
            if ( val['status'] == 'Duplicate' ) {

                let snackBarRef = this.snackBar.open( 'Duplicate data: ' + admissionApplication.student.identityNo + ' Application has been submitted', '', { duration: 5000 } );
                snackBarRef.afterDismissed().subscribe(() => {
                    console.log( 'The snack-bar was dismissed' );
                    console.log( 'Accumulated object:', val )
                    val['status'] = '';
                    try{
                        this.dialog.closeAll(); 
                        
                    } catch(ex){}  
                    //this.router.navigate(['/secure']);
                } );

            } else {
                if ( val['status'] == 'success' ) {
                                 
                    //open dialog to confirm registration
                    console.log('showDialog');
                    let config = new MdDialogConfig();
                    config.viewContainerRef = this.vcf;
                    config.role = 'dialog';
                    config.width = '60%';
                    config.height = '50%';
                    config.position = { top: '0px' };
                    this.creatorDialogRefConfirm = this.dialog.open(AdmissionApplicationConfirmDialog, config);
                    this.creatorDialogRefConfirm.componentInstance.admission = this._admission;
                    this.creatorDialogRefConfirm.afterClosed().subscribe((res) => {
                        console.log('close dialog');
                        try{
                            this.dialog.closeAll(); 
                            
                        } catch(ex){}  
                        //router navigate to my profile
                        //this.router.navigate(['/secure']);
                        
                    });
                }
            }
        }
        );
        
       //end validation duplicate status 
      
    }
}
