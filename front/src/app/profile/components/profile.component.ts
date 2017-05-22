import { AddressTypeSelectComponent } from './address-type-select.component';
import { AddressType } from "../address-type.enum";
import {ActivatedRoute} from '@angular/router';
import {Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit} from '@angular/core';

import {ProfileModuleState} from './../index';
import {ProfileActions} from './../profile.action';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';

import {Enrollment} from './../../term/enrollments/enrollment.interface';
import {Contact} from './../contact.interface';
import {Guardian} from './../guardian.interface';
import {Guarantor} from './../guarantor.interface';
import {Address} from './../address.interface';
import {Student} from "../../identity/student.interface";

import {ContactEditorDialog} from "../dialog/contact-editor.dialog";
import {DetailEditorDialog} from "../dialog/detail-editor.dialog";
import {AddressEditorDialog} from './../dialog/address-editor.dialog';
import {GuardianEditorDialog} from './../dialog/guardian-editor.dialog';
import {GuarantorEditorDialog} from './../dialog/guarantor-editor.dialog';

import { FormGroup, FormControl, FormBuilder } from '@angular/forms';

@Component({
  selector: 'pams-profile',
  templateUrl: 'profile.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class ProfileComponent implements OnInit {

  private editorForm: FormGroup;
  private editorForm1: FormGroup;
  private edit: boolean = false;
  private _address: Address;
  private _student: Student;

  @Input() student: Student;
  @Input() addressess: Address[];
  @Input() guarantors: Guarantor[];
  @Input() guardians: Guardian[];
  @Input() contacts: Contact[];
  @Input() enrollments: Enrollment[];

  private creatorDialogRef: MdDialogRef<DetailEditorDialog>;
  private contactCreatorDialogRef: MdDialogRef<ContactEditorDialog>;
  private guarantorCreatorDialogRef: MdDialogRef<GuarantorEditorDialog>;
  private guardianCreatorDialogRef: MdDialogRef<GuardianEditorDialog>;
  private addressCreatorDialogRef: MdDialogRef<AddressEditorDialog>;

  private columns: any[] = [
    {name: 'name', label: 'NAME'},
    {name: 'phone', label: 'PHONE'},
    {name: 'mobile', label: 'MOBILE'},
    {name: 'action', label: ''}
  ];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProfileActions,
              private vcf: ViewContainerRef,
              private store: Store<ProfileModuleState>,
              private formBuilder: FormBuilder,
              private dialog: MdDialog) {
  }

  set address(value: Address) {
    this._address = value;
    this.edit = true;
  }
  

  ngOnInit(): void {
    this.route.params.subscribe((params: { identityNo: string }) => {
      let identityNo: string = params.identityNo;
      this.store.dispatch(this.actions.findStudentByIdentityNo(identityNo));
    });

    this.editorForm1 = this.formBuilder.group(<Address>{
      address1: '',
      address2:'',
      address3: '',
      postcode: '',
      addressType: AddressType.BILLING
    });

     this.editorForm = this.formBuilder.group(<Student>{
      //identityNo: this.student.identityNo
    });

    if (this.edit) this.editorForm.patchValue(this._student);
    if (this.edit) this.editorForm1.patchValue(this._address);
  }

  goBack(route: string): void {
    this.router.navigate(['/profiles']);
  }

  editStudent(): void {
    this.showDialog(this.student)
  }

  addContactDialog(): void {
    console.log("edit");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.contactCreatorDialogRef = this.dialog.open(ContactEditorDialog, config);
    this.contactCreatorDialogRef.componentInstance.student = this.student;
    this.contactCreatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

  addAddressDialog(): void {
    console.log("Ini utk Add Address student");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.addressCreatorDialogRef = this.dialog.open(AddressEditorDialog, config);
    this.addressCreatorDialogRef.componentInstance.student = this.student;
    this.addressCreatorDialogRef.afterClosed().subscribe(res => {
      console.log("close this dialog");
    });
  }

    deleteContact(contact: Contact): void {
    this.store.dispatch(this.actions.deleteContact(this.student, contact))
  }

    addGuarantorDialog(): void {
    console.log("add");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.guarantorCreatorDialogRef = this.dialog.open(GuarantorEditorDialog, config);
    this.guarantorCreatorDialogRef.componentInstance.student = this.student;
    this.guarantorCreatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

  
    addGuardianDialog(): void {
    console.log("addGuardian");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.guardianCreatorDialogRef = this.dialog.open(GuardianEditorDialog, config);
    this.guardianCreatorDialogRef.componentInstance.student = this.student;
    this.guardianCreatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

  private showDialog(student: Student): void {
    console.log("edit");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(DetailEditorDialog, config);
    if (student) this.creatorDialogRef.componentInstance.student = this.student; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

  submit(student: Student, address: Address) {
    //student.identityNo = new Student();
    console.log(student);
    console.log(address);
    //console.log("student email: " + student.email);
    this.store.dispatch(this.actions.updateAddress(student, address));
    //this.dialog.close();
  }
}
