import {Actor} from '../../../identity/actor.interface';
import {StudyCenter} from '../../../setup/study-centers/study-center.interface';
import {Router, ActivatedRoute} from '@angular/router';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder, Validators} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {AdmissionApplicationActions} from '../admission-application.action';
import {AdmissionApplication} from '../admission-application.interface';
import {TermModuleState} from '../../index';
import {AcademicSession} from '../../../planner/academic-sessions/academic-session.interface';
import {Program} from '../../../planner/programs/program.interface';
import {Student} from '../../../identity/student.interface';

@Component({
  selector: 'pams-admission-application-task-creator',
  templateUrl: './admission-application-task-creator.dialog.html',
})

export class AdmissionApplicationTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;
  private _academicSession: AcademicSession;
  private _student : Student;
  private create: boolean = false;

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: AdmissionApplicationActions,
              private router: Router,
              private route: ActivatedRoute,
              private dialog: MdDialogRef<AdmissionApplicationTaskCreatorDialog>) {
  }

//  set admissionApplication(value: AdmissionApplication) {
//    this._admissionApplication = value;
//    this.create = true;
//  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group( {
      id: [undefined],
      semester: ['', Validators.required],
      student: ['', Validators.required],
      academicSession: ['', Validators.required],   
      //student: [<Student>{}, Validators.required],
      //academicSession: [<AcademicSession>{}, Validators.required],     
    });
  }

  save(admissionApplication: AdmissionApplication, isValid: boolean) : void {
      
      this._academicSession = admissionApplication.academicSession;
      this._student= admissionApplication.student;

    console.log('academicSession: ' + admissionApplication.academicSession.id);
    console.log('student: ' + admissionApplication.student.id);
    console.log(JSON.stringify(admissionApplication));

    // setup description
    admissionApplication.description = admissionApplication.student.identityNo + ' ' + admissionApplication.academicSession.code;
    this.store.dispatch(this.actions.startAdmissionApplicationTask(admissionApplication));
    this.dialog.close();
  }
}
