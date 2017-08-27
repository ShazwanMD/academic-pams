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

@Component( {
    selector: 'pams-admission-application-creator',
    templateUrl: './admission-application-creator.dialog.html',
} )

export class AdmissionApplicationCreatorDialog implements OnInit {
    
    private creatorDialogRefConfirm: MdDialogRef<AdmissionApplicationTaskConfirmDialog>;

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

        
      
    }
}
