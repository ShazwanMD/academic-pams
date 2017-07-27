import { StateCode } from '../../shared/model/common/state-code.interface';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit } from '@angular/core';

import { ProfileModuleState } from '../index';
import { ProfileActions } from '../profile.action';
import { MdDialog, MdDialogConfig, MdDialogRef } from '@angular/material';

import { Enrollment } from '../../shared/model/term/enrollment.interface';
import { Contact } from '../../shared/model/profile/contact.interface';
import { Guardian } from '../../shared/model/profile/guardian.interface';
import { Guarantor } from '../../shared/model/profile/guarantor.interface';
import { Address } from '../../shared/model/profile/address.interface';
import { Student } from '../../shared/model/identity/student.interface';

import { ContactEditorDialog } from '../dialog/contact-editor.dialog';
import { DetailEditorDialog } from '../dialog/detail-editor.dialog';
import { AddressEditorDialog } from '../dialog/address-editor.dialog';
import { GuardianEditorDialog } from '../dialog/guardian-editor.dialog';
import { GuarantorEditorDialog } from '../dialog/guarantor-editor.dialog';

import { FormGroup, FormControl, FormBuilder } from '@angular/forms';

@Component({
  selector: 'pams-profile',
  templateUrl: 'profile.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class ProfileComponent implements OnInit {
  private stateCode: StateCode;
  private creatorDialogRef: MdDialogRef<DetailEditorDialog>;
  private contactCreatorDialogRef: MdDialogRef<ContactEditorDialog>;
  private guarantorCreatorDialogRef: MdDialogRef<GuarantorEditorDialog>;
  private guardianCreatorDialogRef: MdDialogRef<GuardianEditorDialog>;
  private addressCreatorDialogRef: MdDialogRef<AddressEditorDialog>;

  //Student Information
  private columns: any[] = [
    { name: 'name', label: 'Name' },
    { name: 'phone', label: 'Phone' },
    { name: 'mobile', label: 'Mobile' },
    { name: 'action', label: '' },
  ];
  //Address
  private columnAddr: any[] = [
    { name: 'addressType', label: 'Address Type' },
    { name: 'address1', label: 'Address 1' },
    { name: 'address2', label: 'Address 2' },
    { name: 'address3', label: 'City' },
    { name: 'postcode', label: 'Postcode' },
    { name: 'stateCode.description', label: 'State' },
    { name: 'countryCode.description', label: 'Country' },
    { name: 'action', label: 'Action' },
  ];

  //Guarantor
  private columnGuarantor: any[] = [
    { name: 'guarantorType', label: 'Guarantor Type' },
    { name: 'identityNo', label: 'Identity No' },
    { name: 'name', label: 'Name' },
    { name: 'phone', label: 'Mobile No' },
    { name: 'action', label: 'Action' },
  ];

  //Guardian
  private columnGuardian: any[] = [
    { name: 'guardianType', label: 'Guardian Type' },
    { name: 'identityNo', label: 'Identity No' },
    { name: 'name', label: 'Name' },
    { name: 'phone', label: 'Mobile No' },
    { name: 'action', label: 'Action' },
  ];

  //Contact
  private columnContact: any[] = [
    { name: 'contactType', label: 'Contact Type' },
    { name: 'name', label: 'Name' },
    { name: 'phone', label: 'Mobile No' },
    { name: 'action', label: 'Action' },
  ];

  @Input() student: Student;
  @Input() addressess: Address[];
  @Input() guarantors: Guarantor[];
  @Input() guardians: Guardian[];
  @Input() contacts: Contact[];
  @Input() enrollments: Enrollment[];


  //Constructor
  constructor(private router: Router,
    private route: ActivatedRoute,
    private actions: ProfileActions,
    private vcf: ViewContainerRef,
    private store: Store<ProfileModuleState>,
    private formBuilder: FormBuilder,
    private dialog: MdDialog) { }

  ngOnInit(): void {
    this.route.params.subscribe((params: { identityNo: string }) => {
      let identityNo: string = params.identityNo;
      this.store.dispatch(this.actions.findStudentByIdentityNo(identityNo));
    });

  }

  goBack(route: string): void {
    this.router.navigate(['/profiles']);
  }

  /*=========================================================================================*/
  /*STUDENT INFORMATION*/
  /*=========================================================================================*/

  editStudent(): void {
    this.showDialog(this.student);
  }

  private showDialog(student: Student): void {
    console.log('edit');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '50%';
    config.position = { top: '0px' };
    this.creatorDialogRef = this.dialog.open(DetailEditorDialog, config);
    if (student) this.creatorDialogRef.componentInstance.student = this.student; // set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

  /*=========================================================================================*/
  /*CONTACT*/
  /*=========================================================================================*/
  //ADD CONTACT DIALOG
  addContactDialog(): void {
    console.log('edit');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = { top: '0px' };
    this.contactCreatorDialogRef = this.dialog.open(ContactEditorDialog, config);
    this.contactCreatorDialogRef.componentInstance.student = this.student;
    this.contactCreatorDialogRef.afterClosed().subscribe((res) => {
    });
  }

  //EDIT CONTACT DIALOG
  editContactDialog(contact: Contact, isValid: boolean): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = { top: '0px' };
    this.contactCreatorDialogRef = this.dialog.open(ContactEditorDialog, config);
    if (isValid) {
      this.contactCreatorDialogRef.componentInstance.contact = contact;
      this.contactCreatorDialogRef.componentInstance.student = this.student;
    }
    this.contactCreatorDialogRef.afterClosed().subscribe((res) => {
    });
  }

  //DELETE CONTACT
  deleteContact(contact: Contact): void {
    this.store.dispatch(this.actions.deleteContact(this.student, contact));
    //console.log("ini->",contact);
  }

  /*=========================================================================================*/
  /*ADDRESS*/
  /*=========================================================================================*/
  //ADD ADDRESS DIALOG
  addAddressDialog(): void {
    console.log('Ini utk Add Address student');
    console.log(this.stateCode);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = { top: '0px' };
    this.addressCreatorDialogRef = this.dialog.open(AddressEditorDialog, config);
    this.addressCreatorDialogRef.componentInstance.student = this.student;
    this.addressCreatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close this dialog');
    });
  }

  //EDIT ADDRESS DIALOG
  editAddressDialog(address: Address, isValid: boolean): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = { top: '0px' };
    this.addressCreatorDialogRef = this.dialog.open(AddressEditorDialog, config);
    if (isValid) {
      this.addressCreatorDialogRef.componentInstance.address = address;
      this.addressCreatorDialogRef.componentInstance.student = this.student;
    }
    this.addressCreatorDialogRef.afterClosed().subscribe((res) => {
    });
  }

  //DELETE ADDRESS
  deleteAddress(contact: Contact): void {
    this.store.dispatch(this.actions.deleteAddress(this.student, contact));
  }

  /*=========================================================================================*/
  /*GUARANTOR*/
  /*=========================================================================================*/
  //ADD GUARANTOR DIALOG
  addGuarantorDialog(): void {
    //console.log("add");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = { top: '0px' };
    this.guarantorCreatorDialogRef = this.dialog.open(GuarantorEditorDialog, config);
    this.guarantorCreatorDialogRef.componentInstance.student = this.student;
    this.guarantorCreatorDialogRef.afterClosed().subscribe((res) => {
      //console.log("close dialog");
    });
  }

  //EDIT GUARANTOR DIALOG
  editGuarantorDialog(guarantor: Guarantor, isValid: boolean): void {
    //console.log("Ini utk Edit Address student", student);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = { top: '0px' };
    this.guarantorCreatorDialogRef = this.dialog.open(GuarantorEditorDialog, config);
    //console.log(isValid);
    if (isValid) {
      this.guarantorCreatorDialogRef.componentInstance.guarantor = guarantor;
      //console.log(this.addressCreatorDialogRef.componentInstance);
      this.guarantorCreatorDialogRef.componentInstance.student = this.student;
    }
    this.guarantorCreatorDialogRef.afterClosed().subscribe((res) => {
      //console.log("close this dialog");
    });
  }

  //DELETE GUARANTOR
  deleteGuarantor(guarantor: Guarantor): void {
    this.store.dispatch(this.actions.deleteGuarantor(this.student, guarantor));
  }

  /*=========================================================================================*/
  /*GUARDIAN*/
  /*=========================================================================================*/
  //ADD GUARDIAN DIALOG
  addGuardianDialog(): void {
    console.log('addGuardian');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = { top: '0px' };
    this.guardianCreatorDialogRef = this.dialog.open(GuardianEditorDialog, config);
    this.guardianCreatorDialogRef.componentInstance.student = this.student;
    this.guardianCreatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

  //EDIT GUARDIAN DIALOG
  editGuardianDialog(guardian: Guardian, isValid: boolean): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '80%';
    config.position = { top: '0px' };
    this.guardianCreatorDialogRef = this.dialog.open(GuardianEditorDialog, config);
    if (isValid) {
      this.guardianCreatorDialogRef.componentInstance.guardian = guardian;
      this.guardianCreatorDialogRef.componentInstance.student = this.student;
    }
    this.guardianCreatorDialogRef.afterClosed().subscribe((res) => {
    });
  }

  //DELETE GUARDIAN
  deleteGuardian(guardian: Guardian): void {
    this.store.dispatch(this.actions.deleteGuardian(this.student, guardian));
  }
}
