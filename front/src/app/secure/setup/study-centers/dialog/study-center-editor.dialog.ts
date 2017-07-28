import {StudyCenter} from '../study-center.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';

@Component({
  selector: 'pams-study-center-editor',
  templateUrl: './study-center-editor.dialog.html',
})

export class StudyCenterEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _studyCenter: StudyCenter;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<StudyCenterEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions) {
  }

  set studyCenter(value: StudyCenter) {
    this._studyCenter = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group({
      id: null,
      code: ['', Validators.required],
      description: ['', Validators.required],

    });

    if (this.edit) this.editorForm.patchValue(this._studyCenter);
  }


  submit(code: StudyCenter, isValid: boolean) {
    if (!code.id) this.store.dispatch(this.actions.saveStudyCenter(code));
    else this.store.dispatch(this.actions.updateStudyCenter(code));
    this.dialog.close();
  }
}
