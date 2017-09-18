import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import { EnrollmentApplicationActions } from '../enrollment-application.action';
import { EnrollmentApplication } from '../../../../shared/model/term/enrollment-application.interface';
import { TermModuleState } from '../../index';
import { AcademicSession } from '../../../../shared/model/planner/academic-session.interface';
import { Admission } from '../../../../shared/model/term/admission.interface';
import { EnrollmentApplicationType } from '../../../../shared/model/term/enrollment-application-type.enum';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from "../../../../shared/model/identity/student.interface";
import { Observable } from "rxjs/Observable";
import { EnrollmentApplicationTask } from "../../../../shared/model/term/enrollment-application-task.interface";

@Component( {
    selector: 'pams-enrollment-application-task',
    templateUrl: './enrollment-application-task.dialog.html',
} )

export class EnrollmentApplicationTaskDialog implements OnInit {

    private ENROLLMENT_APPLICATION: string[] = 'termModuleState.enrollmentApplication'.split( '.' );
    private ASSIGNED_ENROLLMENT_APPLICATION_TASKS: string[] = 'termModuleState.assignedEnrollmentApplicationTasks'.split( '.' );
    private enrollmentApplication$: Observable<EnrollmentApplication[]>;
    private assignedEnrollmentApplicationTasks$: Observable<EnrollmentApplicationTask>;

    private createForm: FormGroup;
    private _academicSession: AcademicSession;
    private _admission: Admission;
    private minLength: number = 3;
    private _student: Student;
    private edit: boolean = false;

    constructor( private router: Router,
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private snackBar: MdSnackBar,
        private store: Store<TermModuleState>,
        private actions: EnrollmentApplicationActions,
        private dialog: MdDialogRef<EnrollmentApplicationTaskDialog> ) {

        this.enrollmentApplication$ = this.store.select( ...this.ENROLLMENT_APPLICATION );
        this.assignedEnrollmentApplicationTasks$ = this.store.select( ...this.ASSIGNED_ENROLLMENT_APPLICATION_TASKS );
    }

    set student( value: Student ) {
        this._student = value;
        this.edit = true;
    }

    set admission( value: Admission ) {
        this._admission = value;
        this.edit = true;
    }


    ngOnInit(): void {

        this.store.dispatch( this.actions.findAssignedEnrollmentApplicationTasks() );

        this.createForm = this.formBuilder.group( {
            id: [null],
            //description: ['', Validators.required],
            applicationType: [EnrollmentApplicationType.PRA, Validators.required],
            //admission: ['', Validators.required],
            //academicSession: ['', Validators.required],
            //auditNo: ['N/A'],
            //sourceNo: ['N/A'],
            //admission: [<Admission>{}, Validators.required],
            //academicSession: [<AcademicSession>{}, Validators.required],
            //description: ['',Validators.required, Validators.minLength( this.minLength )],

        } );
        if ( this.edit ) this.createForm.patchValue( this._admission );
    }

    save( enrollmentApplication: EnrollmentApplication, isValid: boolean ): void {

        this._academicSession = enrollmentApplication.academicSession;
        enrollmentApplication.admission = this._admission;
        enrollmentApplication.academicSession = this._admission.academicSession;
        enrollmentApplication.description = "Register " + this._admission.student.identityNo + " For Session " + this._admission.academicSession.code;
        //this._admission = enrollmentApplication.admission;

        console.log( JSON.stringify( enrollmentApplication ) );
        this.store.dispatch( this.actions.startEnrollmentApplicationTask( enrollmentApplication ) );
        this.dialog.close();
        
        console.log( "status" + this.enrollmentApplication$ );
        console.log( "Test subscribe:", this.enrollmentApplication$.subscribe( val => { val['status'] } ) );
        this.enrollmentApplication$.subscribe( val => console.log( 'Accumulated object display:', val['status'] ) );
        
        this.enrollmentApplication$.subscribe( val => {
            if ( val['status'] == 'Duplicate' ) {
                
                let snackBarRef = this.snackBar.open( 'Process failed: ' + enrollmentApplication.admission.student.identityNo + ' Application cannot be submit', '', { duration: 5000 } );
                snackBarRef.afterDismissed().subscribe(() => {
                    console.log( 'The snack-bar was dismissed' );
                    console.log( 'Accumulated object:', val )
                    val['status'] = '';
                    try{
                        this.dialog.close();
                        
                    } catch(ex){}  
                    //this.router.navigate(['/secure']);
                } );

            } else {
                if ( val['status'] == 'success' ) {
                                                     
                    let snackBarRef = this.snackBar.open( 'Reviewing semester registration ' + enrollmentApplication.admission.student.identityNo , 'OK', { duration: 5000 } );
                    snackBarRef.afterDismissed().subscribe(() => {
                        console.log( 'The snack-bar was dismissed' );
                        console.log( 'Accumulated object:', val )
                        val['status'] = '';
                        try{
                            this.dialog.close(); 
                            
                        } catch(ex){}  
                        this.router.navigate(['/secure/term/admission-applications/admission-application-center2']);
                    } );
                }
            }
        }
        );
        
       //end validation duplicate status 
      
    }
}

