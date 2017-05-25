import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {Contact} from "../contact.interface";
import {Student} from "../../identity/student.interface";
import {ProfileModuleState} from "../index";
import {ProfileActions} from "../profile.action";
import { ContactType } from "../contact-type.enum";

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
    this.editorForm = this.formBuilder.group(<Contact>{
      id: null,
      name: '',
      identityNo: '',
      contactType: ContactType.FATHER
    });

    if (this.edit) this.editorForm.patchValue(this._contact);
  }

  submit(contact: Contact, isValid: boolean) {

    if(isValid)
    contact.id = this._contact.id;

    if(isValid)this.store.dispatch(this.actions.updateContact(this._student, contact));
    else this.store.dispatch(this.actions.addContact(this._student, contact));
    this.dialog.close();
  }
}
