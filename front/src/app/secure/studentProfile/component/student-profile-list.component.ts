import { ContactEditorDialog } from './../../profile/dialog/contact-editor.dialog';
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
    selector: 'pams-student-profile-list',
    templateUrl: 'student-profile-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentProfileListPage implements OnInit {

    private contactCreatorDialogRef: MdDialogRef<ContactEditorDialog>;
    //inputs

    @Input() student: Student;
    @Output() view = new EventEmitter<Student>();

    @Input() addressess: Address[];
    @Input() guarantors: Guarantor[];
    @Input() guardians: Guardian[];
    @Input() contacts: Contact[];
    @Input() enrollments: Enrollment[];


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
        console.log(this.student.identityNo);
        console.log(contact);
        this.store.dispatch(this.actions.deleteStudentContact(this.student.identityNo, contact));
        //console.log("ini->",contact);
    }


}