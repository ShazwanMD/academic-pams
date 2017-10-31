import {AdmissionApplicationTask} from '../../../../shared/model/term/admission-application-task.interface';
import {TermModuleState} from '../../index';
import {ActivatedRoute, Router} from '@angular/router';
import {Actor} from '../../../../shared/model/identity/actor.interface';
import {Student} from '../../../../shared/model/identity/student.interface';
import {StudyCenter} from '../../../setup/study-centers/study-center.interface';
import {Program} from '../../../../shared/model/planner/program.interface';
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {AdmissionApplicationActions} from '../admission-application.action';
import {AdmissionApplication} from '../../../../shared/model/term/admission-application.interface';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import { Staff } from "../../../../shared/model/identity/staff.interface";

@Component({
  selector: 'pams-admission-application-task-editor',
  templateUrl: './admission-application-task-editor.dialog.html',
})

export class AdmissionApplicationTaskEditorDialog implements OnInit {
  private editForm: FormGroup;
  private edit: boolean = false;
  private _admissionApplication: AdmissionApplication;
  private _admissionApplicationTask: AdmissionApplicationTask;
  private admissionApplicationTask: AdmissionApplicationTask = <AdmissionApplicationTask>{};


  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private actions: AdmissionApplicationActions,
              private dialog: MdDialogRef<AdmissionApplicationTaskEditorDialog>) {

  }

  set admissionApplication(value: AdmissionApplication) {
    this._admissionApplication = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<AdmissionApplication>{
      id: undefined,
      referenceNo: '',
      sourceNo: '',
      auditNo: '',
      ordinal: 0,
      description: '',
      cancelComment: '',
      removeComment: '',
      advisor: <Staff>{},
      student: <Student>{},
      academicSession: <AcademicSession>{},
      program: <Program>{},
      studyCenter: <StudyCenter>{},
    });
    if (this.edit) this.editForm.patchValue(this._admissionApplication);
  }

  submit(application: AdmissionApplication, isValid: boolean) {
    console.log('updating application');
    console.log('referenceNo: ' + application.referenceNo);
    console.log(JSON.stringify(application));
    this.store.dispatch(this.actions.updateAdmissionApplication(application));
    this.dialog.close();
  }
}
