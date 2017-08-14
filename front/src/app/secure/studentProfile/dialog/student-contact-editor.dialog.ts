import { StudentProfileActions } from './../student-profile.action';
import { StudentProfileModuleState } from './../index';
import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { MdDialogRef } from '@angular/material';
import { Contact } from '../../../shared/model/profile/contact.interface';
import { Student } from '../../../shared/model/identity/student.interface';
import { ContactType } from '../../../shared/model/profile/contact-type.enum';

@Component({
    selector: 'pams-student-contact-editor',
    templateUrl: './student-contact-editor.dialog.html',
})

export class StudentContactEditorDialog implements OnInit {

    private editorForm: FormGroup;
    private edit: boolean = false;
    private _student: Student;
    private _contact: Contact;

    constructor(private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private viewContainerRef: ViewContainerRef,
        private dialog: MdDialogRef<StudentContactEditorDialog>,
        private store: Store<StudentProfileModuleState>,
        private actions: StudentProfileActions) {
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
            phone: '',
            contactType: ContactType.FATHER,
        });

        if (this.edit) this.editorForm.patchValue(this._contact);
    }

    submit(contact: Contact, isValid: boolean) {
        console.log(this._student);
        console.log(this._contact);

        if (isValid)
            contact.id = this._contact.id;

         if (isValid) 
        this.store.dispatch(this.actions.updateStudentContact(this._student.identityNo, contact));
        else this.store.dispatch(this.actions.addStudentContact(this._student.identityNo, contact));
        this.dialog.close();
        console.log(contact);
    }
}
