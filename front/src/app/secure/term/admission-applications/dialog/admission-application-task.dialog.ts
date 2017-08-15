import {ActivatedRoute, Router} from '@angular/router';
import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef, MdSnackBar} from '@angular/material';
import {AdmissionApplicationActions} from '../admission-application.action';
import {AdmissionApplication} from '../../../../shared/model/term/admission-application.interface';
import {TermModuleState} from '../../index';
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import {Student} from '../../../../shared/model/identity/student.interface';
import { Observable } from "rxjs/Observable";
import { AdmissionApplicationTask } from "../../../../shared/model/term/admission-application-task.interface";

@Component({
  selector: 'pams-admission-application-task',
  templateUrl: './admission-application-task.dialog.html',
})

export class AdmissionApplicationTaskDialog implements OnInit {

  private ADMISSION_APPLICATION: string[] = 'termModuleState.admissionApplication'.split('.');
  private ASSIGNED_ADMISSION_APPLICATION_TASKS: string[] = 'termModuleState.assignedAdmissionApplicationTasks'.split('.');
  private assignedAdmissionApplicationTasks$: Observable<AdmissionApplicationTask>;
  private admissionApplication$: Observable<AdmissionApplication[]>;
    
  private createForm: FormGroup;
  private _academicSession: AcademicSession;
  private _student: Student;
  private create: boolean = false;
  private edit: boolean = false;
  

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: AdmissionApplicationActions,
              private router: Router,
              private route: ActivatedRoute,
              private snackBar: MdSnackBar,
              private dialog: MdDialogRef<AdmissionApplicationTaskDialog>) {
      
      this.admissionApplication$ = this.store.select(...this.ADMISSION_APPLICATION);
      this.assignedAdmissionApplicationTasks$ = this.store.select(...this.ASSIGNED_ADMISSION_APPLICATION_TASKS);
  }
  
  set student(value: Student) {
      this._student = value;
      this.edit = true;
    }

  ngOnInit(): void {
      
    this.store.dispatch(this.actions.findAssignedAdmissionApplicationTasks());
      
    this.createForm = this.formBuilder.group({
      
      student: '',
      academicSession: ['', Validators.required],
    });
    
    if (this.edit) this.createForm.patchValue(this._student);
  }
  
  save(admissionApplication: AdmissionApplication, isValid: boolean): void {
    console.log(JSON.stringify(admissionApplication));
    this.store.dispatch(this.actions.startAdmissionApplicationTask(admissionApplication));
    this.dialog.close(); 
  }
  
}
