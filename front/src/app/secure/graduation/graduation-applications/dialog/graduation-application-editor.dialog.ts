import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {GraduationModuleState} from '../../index';
import {GraduationApplicationActions} from '../graduation-application.action';
import {GraduationApplication} from '../../../../shared/model/graduation/graduation-application.interface';
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import {Student} from '../../../../shared/model/identity/student.interface';

@Component({
  selector: 'pams-graduation-application-editor',
  templateUrl: './graduation-application-editor.dialog.html',
})

export class GraduationApplicationEditorDialog implements OnInit {

  private editForm: FormGroup;
  private _application: GraduationApplication;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<GraduationModuleState>,
              private actions: GraduationApplicationActions,
              private dialog: MdDialogRef<GraduationApplicationEditorDialog>) {
  }

  ngOnInit(): void {
    this.editForm = this.formBuilder.group(<GraduationApplication>{
      referenceNo: '',
      sourceNo: '',
      description: '',
      memo: '',
      cgpa: 0.00,
      creditHour: 0,
      student: <Student>{},
      academicSession: <AcademicSession>{},
    });

    if (this._application) this.editForm.patchValue(this._application);
  }

  set application(value: GraduationApplication) {
    this._application = value;
  }

  save(graduationApplication: GraduationApplication, isValid: boolean) {
    this.store.dispatch(this.actions.updateGraduationApplication(graduationApplication));
    this.dialog.close();
  }
}