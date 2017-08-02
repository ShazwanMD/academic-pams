import {ActivatedRoute, Router} from '@angular/router';
import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {AdmissionApplicationActions} from '../admission-application.action';
import {AdmissionApplication} from '../../../../shared/model/term/admission-application.interface';
import {TermModuleState} from '../../index';
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import {Student} from '../../../../shared/model/identity/student.interface';
import { Observable } from "rxjs/Observable";

@Component({
  selector: 'pams-admission-application-task-creator',
  templateUrl: './admission-application-task-creator.dialog.html',
})

export class AdmissionApplicationTaskCreatorDialog implements OnInit {

  private ADMISSION_APPLICATION: string[] = 'termModuleState.admissionApplication'.split('.');
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
              private dialog: MdDialogRef<AdmissionApplicationTaskCreatorDialog>) {
      
      this.admissionApplication$ = this.store.select(...this.ADMISSION_APPLICATION);
  }

  ngOnInit(): void {
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
    console.log(JSON.stringify(admissionApplication));

    // setup description
    admissionApplication.description = admissionApplication.student.identityNo + ' ' + admissionApplication.academicSession.code;
    this.store.dispatch(this.actions.startAdmissionApplicationTask(admissionApplication));
    
    this.dialog.close();
    window.alert('Save new data');
    this.admissionApplication$.subscribe( val => console.log( 'Accumulated object admissionApplication$:', val['status'] ) );
  }
}
