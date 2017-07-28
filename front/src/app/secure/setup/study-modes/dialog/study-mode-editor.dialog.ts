import {StudyMode} from '../../../../shared/model/common/study-mode.interface';
import {SetupActions} from '../../setup.action';
import {SetupModuleState} from '../../index';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';

@Component({
  selector: 'pams-study-mode-editor',
  templateUrl: './study-mode-editor.dialog.html',
})
export class StudyModeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _studyMode: StudyMode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<StudyModeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions) {
  }

  set studyMode(value: StudyMode) {
    this._studyMode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group({
      id: null,
      code: ['', Validators.required],
      prefix: ['', Validators.required],
      description: ['', Validators.required],
    });

    if (this.edit) this.editorForm.patchValue(this._studyMode);
  }


  submit(code: StudyMode, isValid: boolean) {
    if (!code.id) this.store.dispatch(this.actions.saveStudyMode(code));
    else  this.store.dispatch(this.actions.updateStudyMode(code));
    this.dialog.close();
  }
}
