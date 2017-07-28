import {GenderCode} from '../../../../shared/model/common/gender-code.interface';
import {SetupActions} from '../../setup.action';
import {SetupModuleState} from '../../index';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';

@Component({
  selector: 'pams-gender-code-editor',
  templateUrl: './gender-code-editor.dialog.html',
})
export class GenderCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _genderCode: GenderCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<GenderCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions) {
  }

  set genderCode(value: GenderCode) {
    this._genderCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<GenderCode>{
      id: null,
      code: '',
      description: '',
    });

    if (this.edit) this.editorForm.patchValue(this._genderCode);

  }


  submit(code: GenderCode, isValid: boolean) {
    if (!code.id) this.store.dispatch(this.actions.saveGenderCode(code));
    else  this.store.dispatch(this.actions.updateGenderCode(code));
    this.dialog.close();
  }
}
