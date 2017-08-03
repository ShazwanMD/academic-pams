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
  selector: 'pams-admission-application-task-creator',
  templateUrl: './admission-application-task-creator.dialog.html',
})

export class AdmissionApplicationTaskCreatorDialog implements OnInit {

  private ADMISSION_APPLICATION: string[] = 'termModuleState.admissionApplication'.split('.');
  private ASSIGNED_ADMISSION_APPLICATION_TASKS: string[] = 'termModuleState.assignedAdmissionApplicationTasks'.split('.');
  private assignedAdmissionApplicationTasks$: Observable<AdmissionApplicationTask>;
  private admissionApplication$: Observable<AdmissionApplication[]>;
    
  private createForm: FormGroup;
  private _academicSession: AcademicSession;
  private _student: Student;
  private create: boolean = false;
  

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: AdmissionApplicationActions,
              private router: Router,
              private route: ActivatedRoute,
              private snackBar: MdSnackBar,
              private dialog: MdDialogRef<AdmissionApplicationTaskCreatorDialog>) {
      
      this.admissionApplication$ = this.store.select(...this.ADMISSION_APPLICATION);
      this.assignedAdmissionApplicationTasks$ = this.store.select(...this.ASSIGNED_ADMISSION_APPLICATION_TASKS);
  }

  ngOnInit(): void {
      
    this.store.dispatch(this.actions.findAssignedAdmissionApplicationTasks());
      
    this.createForm = this.formBuilder.group({
      id: [undefined],
      student: ['', Validators.required],
      academicSession: ['', Validators.required],
    });
  }

  save(admissionApplication: AdmissionApplication, isValid: boolean): void {

    this._academicSession = admissionApplication.academicSession;
    this._student = admissionApplication.student;
    console.log('academicSession: ' + admissionApplication.academicSession.id);
    console.log('student: ' + admissionApplication.student.id);
    //console.log(JSON.stringify(admissionApplication));

    // setup description
    admissionApplication.description = admissionApplication.student.identityNo + ' ' + admissionApplication.academicSession.code;
    this.store.dispatch(this.actions.startAdmissionApplicationTask(admissionApplication));
    this.dialog.close();
    
    this.assignedAdmissionApplicationTasks$.subscribe( val => console.log( 'Accumulated object admissionApplication$:', val['status'] ) );
    window.alert("Alert:" + this.assignedAdmissionApplicationTasks$.subscribe(val => {val['status']}));
    
    //start subcribe
    
    this.assignedAdmissionApplicationTasks$.subscribe(val => {
        if(val['status']== 'Duplicate'){
            
            let snackBarRef = this.snackBar.open('Duplicate data. Please insert new data', '', {duration:3000});
            snackBarRef.afterDismissed().subscribe(() => {
            console.log('The snack-bar was dismissed');
            console.log('Accumulated object:', val)
            val['status'] = '';
           }); 
            
        } else {
            if(val['status']== 'success'){
            window.alert('Success insert new data:');
            console.log('Accumulated object:', val)
            val['status'] = '';
            }
        }
    } 
  );
    
    //end subscribe
    
    
  }
}
