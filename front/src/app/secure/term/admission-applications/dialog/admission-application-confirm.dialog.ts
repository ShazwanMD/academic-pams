import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import { AdmissionApplicationActions } from '../admission-application.action';
import { AdmissionApplication } from '../../../../shared/model/term/admission-application.interface';
import { TermModuleState } from '../../index';
import { AcademicSession } from '../../../../shared/model/planner/academic-session.interface';
import { Student } from '../../../../shared/model/identity/student.interface';
import { Observable } from "rxjs/Observable";
import { AdmissionApplicationTask } from "../../../../shared/model/term/admission-application-task.interface";
import { Admission } from "../../../../shared/model/term/admission.interface";

@Component( {
    selector: 'pams-admission-application-confirm',
    templateUrl: './admission-application-confirm.dialog.html',
} )

export class AdmissionApplicationConfirmDialog implements OnInit {

    private ADMISSION_APPLICATION: string[] = 'termModuleState.admissionApplication'.split( '.' );
    private ASSIGNED_ADMISSION_APPLICATION_TASKS: string[] = 'termModuleState.assignedAdmissionApplicationTasks'.split( '.' );
    private assignedAdmissionApplicationTasks$: Observable<AdmissionApplicationTask>;
    private admissionApplication$: Observable<AdmissionApplication[]>;

    private createForm: FormGroup;
    private _academicSession: AcademicSession;
    private _admission: Admission;
    private create: boolean = false;
    private edit: boolean = false;

    constructor( private formBuilder: FormBuilder,
        private store: Store<TermModuleState>,
        private actions: AdmissionApplicationActions,
        private router: Router,
        private route: ActivatedRoute,
        private snackBar: MdSnackBar,
        private dialog: MdDialogRef<AdmissionApplicationConfirmDialog> ) {

        this.admissionApplication$ = this.store.select( ...this.ADMISSION_APPLICATION );
        this.assignedAdmissionApplicationTasks$ = this.store.select( ...this.ASSIGNED_ADMISSION_APPLICATION_TASKS );
    }

    set admission( value: Admission ) {
        this._admission = value;
        this.edit = true;
    }

    ngOnInit(): void {
        console.log(this._admission);
        this.store.dispatch( this.actions.findAssignedAdmissionApplicationTasks() );
       
    }
    
    save(){
        
        this.dialog.close();
    }

   
}
