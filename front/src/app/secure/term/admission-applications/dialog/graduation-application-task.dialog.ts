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
import { Graduation } from "../../../../shared/model/graduation/graduation.interface";

@Component( {
    selector: 'pams-graduation-application-task',
    templateUrl: './graduation-application-task.dialog.html',
} )

export class GraduationApplicationTaskDialog implements OnInit {

    private creatorDialogRefConfirm: MdDialogRef<AdmissionApplicationTaskConfirmDialog>;

    private GRADUATION_APPLICATION: string[] = 'graduationModuleState.graduationApplication'.split( '.' );
    private GRADUATION: string[] = 'graduationModuleState.graduation'.split( '.' );
    private ASSIGNED_GRADUATION_APPLICATION_TASKS: string[] = 'graduationModuleState.assignedGraduationApplicationTasks'.split( '.' );
    private assignedGraduationApplicationTasks$: Observable<GraduationApplicationTask>;
    private graduationApplication$: Observable<GraduationApplication[]>;
    private graduation$: Observable<Graduation[]>;

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
        this.graduation$ = this.store.select( ...this.GRADUATION );

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
            id: [undefined],
            description: '',
            memo:  '',
            //cgpa: [0.00],
            //creditHour: [0],
            //student:  ['', Validators.required],
            academicSession: ['', Validators.required],
          });

        if ( this.edit ) this.createForm.patchValue( this._student );
    }

   
    save(graduationApplication: GraduationApplication, isValid: boolean) {
        
        console.log( "_student", this._student );

        this._academicSession = graduationApplication.academicSession;
        graduationApplication.student = this._student;
        console.log( 'student: ' + graduationApplication.student.identityNo );

        this.store.dispatch(this.actions.startGraduationApplicationTask(graduationApplication));
        console.log(JSON.stringify(graduationApplication));
        this.dialog.closeAll();
        
        console.log( "Test subscribe:", this.graduationApplication$.subscribe( val => { val['status'] } ) );
        this.graduationApplication$.subscribe( val => console.log( 'Accumulated object display:', val['status'] ) );
       
        this.graduationApplication$.subscribe( val => {
            if ( val['status'] == 'Duplicate' ) {
                

                let snackBarRef = this.snackBar.open( 'Process failed: ' + graduationApplication.student.identityNo + ' Application cannot be submit', 'OK', { duration: 2000 } );
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
                                                    
                    let snackBarRef = this.snackBar.open( 'Reviewing semester registration ' + graduationApplication.student.identityNo , 'OK', { duration: 2000 } );
                    snackBarRef.afterDismissed().subscribe(() => {
                        console.log( 'The snack-bar was dismissed' );
                        console.log( 'Accumulated object:', val )
                        val['status'] = '';
                        try{
                            this.dialog.closeAll(); 
                            
                        } catch(ex){}  
                        this.router.navigate(['/secure/graduation/graduation-applications/student-graduation-application-center']);
                    } );
                }
            }
        }
        );
        
       //end validation duplicate status 
        
      }
    
}
