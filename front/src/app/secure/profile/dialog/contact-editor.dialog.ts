import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {MdDialogRef, MdSnackBar} from '@angular/material';
import {Contact} from '../../../shared/model/profile/contact.interface';
import {Student} from '../../../shared/model/identity/student.interface';
import {ProfileModuleState} from '../index';
import {ProfileActions} from '../profile.action';
import {ContactType} from '../../../shared/model/profile/contact-type.enum';

@Component({
  selector: 'pams-contact-editor',
  templateUrl: './contact-editor.dialog.html',
})

export class ContactEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private edit: boolean = false;
  private _student: Student;
  private _contact: Contact;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<ContactEditorDialog>,
              private store: Store<ProfileModuleState>,
              private snackBar: MdSnackBar,
              private actions: ProfileActions) {
  }

  set student(value: Student) {
    this._student = value;
  }

  set contact(value: Contact) {
    this._contact = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group({
      id: [undefined],
      name: ['', Validators.required],
      identityNo: ['', Validators.required],
      phone: ['', Validators.required],
      contactType:['', Validators.required],
    });

    if (this.edit) this.editorForm.patchValue(this._contact);
  }

  submit(contact: Contact, isValid: boolean) {

    if (isValid)
      contact.id = this._contact.id;

    if (isValid) this.store.dispatch(this.actions.updateContact(this._student, contact));
    else this.store.dispatch(this.actions.addContact(this._student, contact));
    this.dialog.close();
    let snackBarRef = this.snackBar.open( 'New Contact has been saved', '', { duration: 3000 } );
    snackBarRef.afterDismissed().subscribe(() => {
    } );
  }
}
