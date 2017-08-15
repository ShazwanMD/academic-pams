import { StudentProfileModuleState } from './../index';
import { StudentProfileActions } from './../student-profile.action';
import {CountryCode} from '../../../shared/model/common/country-code.interface';
import {StateCode} from '../../../shared/model/common/state-code.interface';
import {Address} from '../../../shared/model/profile/address.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {Student} from '../../../shared/model/identity/student.interface';
import {AddressType} from '../../../shared/model/profile/address-type.enum';

@Component({
  selector: 'pams-student-address-editor',
  templateUrl: './student-address-editor.dialog.html',
})

export class StudentAddressEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _student: Student;
  private _address: Address;
  private stateCode: StateCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<StudentAddressEditorDialog>,
              private store: Store<StudentProfileModuleState>,
              private actions: StudentProfileActions) {
  }

  set student(value: Student) {
    this._student = value;
  }

  set address(value: Address) {
    this._address = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<Address>{
      addressType: AddressType.CURRENT,
      address1: '',
      address2: '',
      address3: '',
      postcode: '',
      stateCode: <StateCode>{},
      countryCode: <CountryCode>{},
    });
    //console.log(this._address, this._student)
    if (this.edit) this.editorForm.patchValue(this._address);
  }

  submit(address: Address, isValid: boolean) {
    //console.log(this._student);
    //console.log("ini address saja=",this._address.id);
    //console.log(isValid);

    if (isValid)
      address.id = this._address.id;
    //console.log(address);

    if (isValid) this.store.dispatch(this.actions.updateStudentAddress(this._student.identityNo, address));
    else this.store.dispatch(this.actions.addStudentAddress(this._student.identityNo, address));
    this.dialog.close();
  }
}
