import { GuardianEditorDialog } from './../../profile/dialog/guardian-editor.dialog';
import { StudentContactEditorDialog } from './../dialog/student-contact-editor.dialog';
import { ProfileActions } from './../../profile/profile.action';
import { Observable } from 'rxjs/Observable';
import { MdDialog, MdDialogRef, MdDialogConfig } from '@angular/material';
import { FormBuilder } from '@angular/forms';
import { StudentProfileModuleState } from './../index';
import { Store } from '@ngrx/store';
import { StudentProfileActions } from './../student-profile.action';
import { Component, OnInit, ViewContainerRef, Input, ChangeDetectionStrategy, Output, EventEmitter } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { Student } from "../../../shared/model/identity/student.interface";
import { Address } from "../../../shared/model/profile/address.interface";
import { Guarantor } from "../../../shared/model/profile/guarantor.interface";
import { Guardian } from "../../../shared/model/profile/guardian.interface";
import { Contact } from "../../../shared/model/profile/contact.interface";
import { Enrollment } from "../../../shared/model/term/enrollment.interface";


@Component({
    selector: 'pams-student-menu',
    templateUrl: 'student-menu.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentMenu implements OnInit {

    private studentContactEditorDialogRef: MdDialogRef<StudentContactEditorDialog>;
    private studentGuardianCreatorDialogRef: MdDialogRef<GuardianEditorDialog>;
    //inputs

    @Input() student: Student;
    @Output() view = new EventEmitter<Student>();

  


    //Constructor
    constructor(private router: Router,
        private route: ActivatedRoute,
        private actions: StudentProfileActions,
        private profileActions: ProfileActions,
        private vcf: ViewContainerRef,
        private store: Store<StudentProfileModuleState>,
        private formBuilder: FormBuilder,
        private dialog: MdDialog) {

    }

   
    goBack(route: string): void {
        this.router.navigate(['/studentProfile']);
    }

    ngOnInit(): void {
        // this.route.params.subscribe((params: { identityNo: string }) => {
        //     let identityNo: string = params.identityNo;
        //     this.store.dispatch(this.profileActions.findStudentByIdentityNo(this.student.identityNo));
        // });
    }

    /*=========================================================================================*/
    /*CONTACT*/
    /*=========================================================================================*/
    //ADD CONTACT DIALOG
    addContactDialog(): void {
        console.log('Add Contact');
        console.log("Add Contact" + this.student.identityNo);
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '80%';
        config.position = { top: '0px' };
        this.studentContactEditorDialogRef = this.dialog.open(StudentContactEditorDialog, config);
        this.studentContactEditorDialogRef.componentInstance.student = this.student;
        this.studentContactEditorDialogRef.afterClosed().subscribe((res) => {
        });
    }

    //EDIT CONTACT DIALOG
    editContactDialog(contact: Contact, isValid: boolean): void {
        console.log("Editing Contact");
        console.log("EditContact" + this.student.identityNo);
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '80%';
        config.position = { top: '0px' };
        this.studentContactEditorDialogRef = this.dialog.open(StudentContactEditorDialog, config);
        this.studentContactEditorDialogRef.componentInstance.contact = contact;
        this.studentContactEditorDialogRef.componentInstance.student = this.student;
        this.studentContactEditorDialogRef.afterClosed().subscribe((res) => {
        });
    }

    //DELETE CONTACT
    deleteContact(contact: Contact): void {
        console.log(this.student.identityNo);
        console.log(contact);
        this.store.dispatch(this.actions.deleteStudentContact(this.student.identityNo, contact));
        //console.log("ini->",contact);
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
        this.studentGuardianCreatorDialogRef = this.dialog.open(GuardianEditorDialog, config);
        this.studentGuardianCreatorDialogRef.componentInstance.student = this.student;
        this.studentGuardianCreatorDialogRef.afterClosed().subscribe((res) => {
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
        this.studentGuardianCreatorDialogRef = this.dialog.open(GuardianEditorDialog, config);
        this.studentGuardianCreatorDialogRef.componentInstance.guardian = guardian;
        this.studentGuardianCreatorDialogRef.componentInstance.student = this.student;
        this.studentGuardianCreatorDialogRef.afterClosed().subscribe((res) => {
        });
    }

    //DELETE GUARDIAN
    deleteGuardian(guardian: Guardian): void {
        console.log(this.student.identityNo);
        this.store.dispatch(this.actions.deleteStudentGuardian(this.student.identityNo, guardian));
    }


}