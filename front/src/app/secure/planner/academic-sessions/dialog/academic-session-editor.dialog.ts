import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';

import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import {PlannerModuleState} from '../../index';
import {AcademicSessionActions} from '../academic-session.action';
import {AcademicSemester} from '../../../../shared/model/planner/academic-semester-type.enum';

@Component({
  selector: 'pams-academic-session-editor',
  templateUrl: './academic-session-editor.dialog.html',
})

export class AcademicSessionEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _academicSession: AcademicSession;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: AcademicSessionActions,
              private dialog: MdDialogRef<AcademicSessionEditorDialog>) {
  }

  set academicSession(value: AcademicSession) {
    this._academicSession = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group({
      id: [undefined],
      code: [''],
      description: ['', Validators.minLength(10)],
      current: [true],
      startDate: [undefined, Validators.required],
      endDate: [undefined, Validators.required],
      semester: [AcademicSemester.SEMESTER_1, Validators.required],
    });

    if (this.edit) this.editorForm.patchValue(this._academicSession);
  }

  submit(academicSession: AcademicSession, isValid: boolean): void {
    console.log('updating academic session');
    if (!academicSession.id) this.store.dispatch(this.actions.saveAcademicSession(academicSession));
    else this.store.dispatch(this.actions.updateAcademicSession(academicSession));
    this.dialog.close();
  }
}

