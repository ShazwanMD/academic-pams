import { NationalityCode } from './../../../common/nationality-codes/nationality-code.interface';
import { SetupActions } from './../../setup.action';
import { SetupModuleState } from './../../index';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";


@Component({
  selector: 'pams-nationality-code-editor',
  templateUrl: './nationality-code-editor.dialog.html',
})
export class NationalityCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _nationalityCode: NationalityCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<NationalityCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions) {
  }

  set nationalityCode(value: NationalityCode){
      this._nationalityCode = value;
      this.edit = true;
  }
    ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<NationalityCode>{
      id: null,
      code: '',
      descriptionEn: '',
      descriptionMs: '',
    });

    if (this.edit) this.editorForm.patchValue(this._nationalityCode);
  }


  submit(code: NationalityCode, isValid: boolean) {
    if (!code.id) this.store.dispatch(this.actions.saveNationalityCode(code));
    else  this.store.dispatch(this.actions.updateNationalityCode(code));
    this.dialog.close();
  }
}