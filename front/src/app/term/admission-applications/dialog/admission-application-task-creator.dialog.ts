import {Actor} from '../../../identity/actor.interface';
import {StudyCenter} from '../../../setup/study-centers/study-center.interface';
import {Router, ActivatedRoute} from '@angular/router';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
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
  private create: boolean = false;
  private _admissionApplication: AdmissionApplication;

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: AdmissionApplicationActions,
              private router: Router,
              private route: ActivatedRoute,
              private vcf: ViewContainerRef,
              private dialog: MdDialogRef<AdmissionApplicationTaskCreatorDialog>) {
  }

  set admissionApplication(value: AdmissionApplication) {
    this._admissionApplication = value;
    this.create = true;
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<AdmissionApplication>{
      id: undefined,
      referenceNo: '',
      sourceNo: 'N/A',
      auditNo: 'N/A',
      description: '',
      cancelComment: 'N/A',
      removeComment: 'N/A',
      actor: <Actor>{},
      student: <Student>{},
      academicSession: <AcademicSession>{},
      program: <Program>{},
      studyCenter: <StudyCenter>{},
    });
    if (this.create) this.createForm.patchValue(this._admissionApplication);
  }

  save(admissionApplication: AdmissionApplication, isValid: boolean) {
    console.log('referenceNo: ' + admissionApplication.referenceNo);
    console.log('sourceNo: ' + admissionApplication.sourceNo);
    console.log('auditNo: ' + admissionApplication.auditNo);
    console.log('description: ' + admissionApplication.description);
    console.log('academicSession: ' + admissionApplication.academicSession.id);
    console.log('student: ' + admissionApplication.student.id);
    console.log('studyCenter: ' + admissionApplication.studyCenter.id);
    console.log('program: ' + admissionApplication.program.id);
    console.log('advisor: ' + admissionApplication.actor.id);
    console.log(JSON.stringify(admissionApplication));

    // setup description
    admissionApplication.description = admissionApplication.student.identityNo + ' ' + admissionApplication.academicSession.code;

    this.store.dispatch(this.actions.startAdmissionApplicationTask(admissionApplication));
    this.dialog.close();
  }
}
