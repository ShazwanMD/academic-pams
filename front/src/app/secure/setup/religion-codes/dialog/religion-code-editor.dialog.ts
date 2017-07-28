import { SetupActions } from '../../setup.action';
import { SetupModuleState } from '../../index';
import { ReligionCode } from '../../../../shared/model/common/religion-code.interface';
import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";

@Component({
  selector: 'pams-religion-code-editor',
  templateUrl: './religion-code-editor.dialog.html',
})
export class ReligionCodeEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _religionCode: ReligionCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ReligionCodeEditorDialog>,
              private store: Store<SetupModuleState>,
              private actions: SetupActions) {
  }

  set religionCode(value: ReligionCode){
      this._religionCode = value;
      this.edit = true;
  }
    ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<ReligionCode>{
      id: null,
      code: '',
      descriptionEn: '',
      descriptionMs: '',
    });

    if (this.edit) this.editorForm.patchValue(this._religionCode);
  }


  submit(code: ReligionCode, isValid: boolean) {
    if (!code.id) this.store.dispatch(this.actions.saveReligionCode(code));
    else  this.store.dispatch(this.actions.updateReligionCode(code));
    this.dialog.close();
  }
}
