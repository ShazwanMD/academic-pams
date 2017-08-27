import {CountryCode} from '../../../shared/model/common/country-code.interface';
import {StateCode} from '../../../shared/model/common/state-code.interface';
import {Address} from '../../../shared/model/profile/address.interface';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef, MdSnackBar} from '@angular/material';
import {Student} from '../../../shared/model/identity/student.interface';
import {ProfileModuleState} from '../index';
import {ProfileActions} from '../profile.action';
import {AddressType} from '../../../shared/model/profile/address-type.enum';

@Component({
  selector: 'pams-address-editor',
  templateUrl: './address-editor.dialog.html',
})

export class AddressEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _student: Student;
  private _address: Address;
  private stateCode: StateCode;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<AddressEditorDialog>,
              private store: Store<ProfileModuleState>,
              private snackBar: MdSnackBar,
              private actions: ProfileActions) {
           
       }

  set student(value: Student) {
    this._student = value;
  }

  set address(value: Address) {
    this._address = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group({
      id: [undefined],
      addressType: ['', Validators.required],
      address1: ['', Validators.required],
      address2: ['', Validators.required],
      address3: ['', Validators.required],
      postcode: ['', Validators.required],
      stateCode: ['', Validators.required],
      countryCode: ['', Validators.required],
        
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

    if (isValid) this.store.dispatch(this.actions.updateAddress(this._student, address));
    else this.store.dispatch(this.actions.addAddress(this._student, address));
    this.dialog.close();
    let snackBarRef = this.snackBar.open( 'New Address has been saved', '', { duration: 3000 } );
    snackBarRef.afterDismissed().subscribe(() => {
    } );
    
  }
}
