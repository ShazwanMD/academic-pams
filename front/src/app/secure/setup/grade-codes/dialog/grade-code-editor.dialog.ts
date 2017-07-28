import {GradeCode} from '../../../../shared/model/common/grade-code.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';


@Component({
  selector: 'pams-grade-code-editor',
  templateUrl: './grade-code-editor.dialog.html',
})

export class GradeCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _gradeCode: GradeCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<GradeCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions) {
  }

  set gradeCode(value: GradeCode) {
    this._gradeCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group({
      id: null,
      code: ['', Validators.required],
      description: ['', Validators.required],
      ordinal: [0, Validators.required],
      point: [0, Validators.required],
      max: [0, Validators.required],
      min: [0, Validators.required],
    });

    if (this.edit) this.editorForm.patchValue(this._gradeCode);
  }

  submit(code: GradeCode, isValid: boolean) {
    if (!code.id) this.store.dispatch(this.actions.saveGradeCode(code));
    else  this.store.dispatch(this.actions.updateGradeCode(code));
    this.dialog.close();
  }
}
