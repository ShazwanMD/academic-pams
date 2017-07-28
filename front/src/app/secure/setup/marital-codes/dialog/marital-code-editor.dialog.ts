import {MaritalCode} from '../marital-code.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {SetupModuleState} from '../../index';
import {SetupActions} from '../../setup.action';


@Component({
  selector: 'pams-marital-code-editor',
  templateUrl: './marital-code-editor.dialog.html',
})

export class MaritalCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _maritalCode: MaritalCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<MaritalCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions) {
  }

  set maritalCode(value: MaritalCode) {
    this._maritalCode = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<MaritalCode>{
      id: null,
      code: '',
      descriptionEn: '',
      descriptionMs: '',
    });

    if (this.edit) this.editorForm.patchValue(this._maritalCode);
  }

  submit(code: MaritalCode, isValid: boolean) {
    if (!code.id) this.store.dispatch(this.actions.saveMaritalCode(code));
    else  this.store.dispatch(this.actions.updateMaritalCode(code));
    this.dialog.close();
  }
}
