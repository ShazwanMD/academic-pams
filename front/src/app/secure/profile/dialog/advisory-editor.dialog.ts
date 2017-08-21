import {CountryCode} from '../../../shared/model/common/country-code.interface';
import {StateCode} from '../../../shared/model/common/state-code.interface';
import {AdmissionApplication} from '../../../shared/model/term/admission-application.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {Student} from '../../../shared/model/identity/student.interface';
import {ProfileModuleState} from '../index';
import {ProfileActions} from '../profile.action';
import {AddressType} from '../../../shared/model/profile/address-type.enum';

@Component({
  selector: 'pams-advisory-editor',
  templateUrl: './advisory-editor.dialog.html',
})

export class AdvisoryEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _student: Student;
  
  private _admissionApplication: AdmissionApplication;
  private stateCode: StateCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<AdvisoryEditorDialog>,
              private store: Store<ProfileModuleState>,
              private actions: ProfileActions) {
  }

  set student(value: Student) {
    this._student = value;
  }

  set admissionApplication(value: AdmissionApplication) {
      this._admissionApplication = value;
      this.edit = true;
    }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group( {
     
     advisor: ['', Validators.required],
     
    });
   
    if (this.edit) this.editorForm.patchValue(this._admissionApplication);
  }

  submit(admissionApplication: AdmissionApplication, isValid: boolean) {
   
    /*if (isValid)
        _admissionApplication.id = this._admissionApplication.id;
    console.log(admissionApplication);

    if (isValid) this.store.dispatch(this.actions.updateAddress(this._student, address));
    else this.store.dispatch(this.actions.addAddress(this._student, address));
    this.dialog.close();*/
  }
}
