import { AcademicSession } from './../../../shared/model/planner/academic-session.interface';
import { StudentDetailEditorDialog } from './../dialog/student-detail-editor.dialog';
import { StudentAddressEditorDialog } from './../dialog/student-address-editor.dialog';
import { StudentContactEditorDialog } from './../dialog/student-contact-editor.dialog';
import { ProfileActions } from './../../profile/profile.action';
import { Observable } from 'rxjs/Observable';
import { MdDialog, MdDialogRef, MdDialogConfig, MdSnackBar } from '@angular/material';
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
import { Admission } from "../../../shared/model/term/admission.interface";
import { AdmissionApplication } from "../../../shared/model/term/admission-application.interface";
import { GraduationApplication } from "../../../shared/model/graduation/graduation-application.interface";
import { OfferingUpdateDialog } from "../../term/offerings/dialog/offering-update.dialog";
import { AdmissionApplicationTaskCreatorDialog } from "../../term/admission-applications/dialog/admission-application-task-creator.dialog";
import { AdmissionApplicationTaskDialog } from "../../term/admission-applications/dialog/admission-application-task.dialog";
import { GraduationApplicationTaskDialog } from "../../term/admission-applications/dialog/graduation-application-task.dialog";
import { StudentGuardianEditorDialog } from "../dialog/student-guardian-editor.dialog";
import { StudentGuarantorEditorDialog } from "../dialog/student-guarantor-editor.dialog";
import { EnrollmentApplicationTaskCreatorDialog } from "../../term/enrollment-applications/dialog/enrollment-application-task-creator.dialog";
import { EnrollmentApplicationTaskDialog } from "../../term/enrollment-applications/dialog/enrollment-application-task.dialog";
import { GraduationApplicationCreatorDialog } from "../../graduation/graduation-applications/dialog/graduation-application-creator.dialog";
import { DatePipe } from '@angular/common';

@Component( {
    selector: 'pams-student-profile-list',
    templateUrl: 'student-profile-list.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class StudentProfileListPage implements OnInit {

    today: number = Date.now();

    private studentDialogRef: MdDialogRef<StudentDetailEditorDialog>;
    private studentContactEditorDialogRef: MdDialogRef<StudentContactEditorDialog>;
    private studentGuardianCreatorDialogRef: MdDialogRef<StudentGuardianEditorDialog>;
    private studentGuarantorCreatorDialogRef: MdDialogRef<StudentGuarantorEditorDialog>;
    private studentAddressCreatorDialogRef: MdDialogRef<StudentAddressEditorDialog>;
    private creatorDialogRef: MdDialogRef<AdmissionApplicationTaskDialog>;
    private creatorDialogRef2: MdDialogRef<EnrollmentApplicationTaskDialog>;
    private creatorDialogRef3: MdDialogRef<GraduationApplicationCreatorDialog>;
    private creatorDialogRef4: MdDialogRef<GraduationApplicationTaskDialog>;


    //inputs

    @Input() student: Student;
    @Output() view = new EventEmitter<Student>();

    @Input() addressess: Address[];
    @Input() guarantors: Guarantor[];
    @Input() guardians: Guardian[];
    @Input() contacts: Contact[];
    @Input() enrollments: Enrollment[];
    @Input() admissions: Admission[];
    @Input() academicSessions: AcademicSession[];
    @Input() admissionApplications: AdmissionApplication[];
    @Input() graduationApplications: GraduationApplication[];

    @Output() view2 = new EventEmitter<Admission>();

    //Constructor
    constructor(

        private router: Router,
        private route: ActivatedRoute,
        private actions: StudentProfileActions,
        private profileActions: ProfileActions,
        private vcf: ViewContainerRef,
        private store: Store<StudentProfileModuleState>,
        private formBuilder: FormBuilder,
        private snackBar: MdSnackBar,
        private dialog: MdDialog ) {


    }

    //Address
    private columnAddr: any[] = [
        { name: 'addressType', label: 'Address Type' },
        { name: 'address1', label: 'Address 1' },
        { name: 'address2', label: 'Address 2' },
        { name: 'address3', label: 'City' },
        { name: 'postcode', label: 'Postcode' },
        { name: 'stateCode.descriptionEn', label: 'State' },
        { name: 'countryCode.descriptionEn', label: 'Country' },
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


    //Admission
    private columnAdmission: any[] = [
        { name: 'academicSession.code', label: 'Session' },
        { name: 'cgpa', label: 'CGPA' },
        { name: 'gpa', label: 'GPA' },
        { name: 'ordinal', label: 'Semester' },
        { name: 'standing', label: 'Standing' },
        { name: 'status', label: 'Status' },
        { name: 'enrollmentCount', label: 'Approved Course' },
        { name: 'enrollmentApplicationCount', label: 'Course Registration' },
        { name: 'action', label: '' },

    ];

    //view data admissionApplications to review supervision 
    private columnAdmissionApplication: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'academicSession.code', label: 'Academic Session' },
        { name: 'advisor.name', label: 'Name' },
        { name: 'advisor.email', label: 'Email' },
        { name: 'advisor.identityNo', label: 'IdentityNo.' },
        { name: 'advisor.phone', label: 'Phone' },
        { name: 'advisor.program.code', label: 'Program' },
        { name: 'advisor.program.faculty.name', label: 'Faculty' },
        { name: 'action', label: '' },
    ];

    //view data graduationApplications
    private columnGraduationApplication: any[] = [
        { name: 'id', label: 'Id' },
        { name: 'cgpa', label: 'CGPA' },
        { name: 'creditHour', label: 'Credit Hour' },
        { name: 'referenceNo', label: 'Reference No' },
        { name: 'description', label: 'Description' },
        { name: 'academicSession.code', label: 'academicSession' },
        { name: 'action', label: '' },
    ];


    goBack( route: string ): void {
        this.router.navigate( ['/studentProfile'] );
    }

    ngOnInit(): void {

        // this.route.params.subscribe((params: { identityNo: string }) => {
        //     let identityNo: string = params.identityNo;
        //     this.store.dispatch(this.profileActions.findStudentByIdentityNo(this.student.identityNo));
        // });
    }

    /*=========================================================================================*/
    /*STUDENT INFORMATION*/
    /*=========================================================================================*/

    editStudent(): void {
        this.showDialog( this.student );
    }

    private showDialog( student: Student ): void {
        console.log( 'edit student detail' );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '50%';
        config.position = { top: '0px' };
        this.studentDialogRef = this.dialog.open( StudentDetailEditorDialog, config );
        this.studentDialogRef.componentInstance.student = this.student; // set
        this.studentDialogRef.afterClosed().subscribe(( res ) => {
            console.log( 'close dialog' );
        } );
    }


    /*=========================================================================================*/
    /*ADDRESS*/
    /*=========================================================================================*/
    //ADD ADDRESS DIALOG
    addAddressDialog(): void {
        console.log( 'add student address dialog' );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '80%';
        config.position = { top: '0px' };
        this.studentAddressCreatorDialogRef = this.dialog.open( StudentAddressEditorDialog, config );
        this.studentAddressCreatorDialogRef.componentInstance.student = this.student;
        this.studentAddressCreatorDialogRef.afterClosed().subscribe(( res ) => {
            console.log( 'close this dialog' );
        } );
    }

    //EDIT ADDRESS DIALOG
    editAddressDialog( address: Address, isValid: boolean ): void {
        console.log( "edit student address dialog" );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '80%';
        config.position = { top: '0px' };
        this.studentAddressCreatorDialogRef = this.dialog.open( StudentAddressEditorDialog, config );
        this.studentAddressCreatorDialogRef.componentInstance.address = address;
        this.studentAddressCreatorDialogRef.componentInstance.student = this.student;
        this.studentAddressCreatorDialogRef.afterClosed().subscribe(( res ) => {
            console.log( "close dialog" );
        } );
    }

    //DELETE ADDRESS
    deleteAddress( contact: Contact ): void {
        console.log( "delete student address" );
        this.store.dispatch( this.actions.deleteStudentAddress( this.student.identityNo, contact ) );
    }

    /*=========================================================================================*/
    /*CONTACT*/
    /*=========================================================================================*/
    //ADD CONTACT DIALOG
    addContactDialog(): void {
        console.log( 'Add Contact' );
        console.log( "Add Contact" + this.student.identityNo );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '80%';
        config.position = { top: '0px' };
        this.studentContactEditorDialogRef = this.dialog.open( StudentContactEditorDialog, config );
        this.studentContactEditorDialogRef.componentInstance.student = this.student;
        this.studentContactEditorDialogRef.afterClosed().subscribe(( res ) => {
        } );
    }

    //EDIT CONTACT DIALOG
    editContactDialog( contact: Contact, isValid: boolean ): void {
        console.log( "Editing Contact" );
        console.log( "EditContact" + this.student.identityNo );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '80%';
        config.position = { top: '0px' };
        this.studentContactEditorDialogRef = this.dialog.open( StudentContactEditorDialog, config );
        this.studentContactEditorDialogRef.componentInstance.contact = contact;
        this.studentContactEditorDialogRef.componentInstance.student = this.student;
        this.studentContactEditorDialogRef.afterClosed().subscribe(( res ) => {
        } );
    }

    //DELETE CONTACT
    deleteContact( contact: Contact ): void {
        console.log( this.student.identityNo );
        console.log( contact );
        this.store.dispatch( this.actions.deleteStudentContact( this.student.identityNo, contact ) );
        //console.log("ini->",contact);
    }

    /*=========================================================================================*/
    /*GUARDIAN*/
    /*=========================================================================================*/
    //ADD GUARDIAN DIALOG
    addGuardianDialog(): void {
        console.log( 'add Student Guardian' );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '80%';
        config.position = { top: '0px' };
        this.studentGuardianCreatorDialogRef = this.dialog.open( StudentGuardianEditorDialog, config );
        this.studentGuardianCreatorDialogRef.componentInstance.student = this.student;
        this.studentGuardianCreatorDialogRef.afterClosed().subscribe(( res ) => {
            console.log( 'close dialog' );
        } );
    }

    //EDIT GUARDIAN DIALOG
    editGuardianDialog( guardian: Guardian, isValid: boolean ): void {
        console.log( 'edit Student Guardian' );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '80%';
        config.position = { top: '0px' };
        this.studentGuardianCreatorDialogRef = this.dialog.open( StudentGuardianEditorDialog, config );
        this.studentGuardianCreatorDialogRef.componentInstance.guardian = guardian;
        this.studentGuardianCreatorDialogRef.componentInstance.student = this.student;
        this.studentGuardianCreatorDialogRef.afterClosed().subscribe(( res ) => {
        } );
    }

    //DELETE GUARDIAN
    deleteGuardian( guardian: Guardian ): void {
        console.log( this.student.identityNo );
        this.store.dispatch( this.actions.deleteStudentGuardian( this.student.identityNo, guardian ) );
    }


    /*=========================================================================================*/
    /*GUARANTOR*/
    /*=========================================================================================*/
    //ADD GUARANTOR DIALOG
    addGuarantorDialog(): void {
        console.log( "add student guarantor" );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '80%';
        config.position = { top: '0px' };
        this.studentGuarantorCreatorDialogRef = this.dialog.open( StudentGuarantorEditorDialog, config );
        this.studentGuarantorCreatorDialogRef.componentInstance.student = this.student;
        this.studentGuarantorCreatorDialogRef.afterClosed().subscribe(( res ) => {
            //console.log("close dialog");
        } );
    }

    //EDIT GUARANTOR DIALOG
    editGuarantorDialog( guarantor: Guarantor, isValid: boolean ): void {
        console.log( "edit student guarantor" );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '80%';
        config.position = { top: '0px' };
        this.studentGuarantorCreatorDialogRef = this.dialog.open( StudentGuarantorEditorDialog, config );
        this.studentGuarantorCreatorDialogRef.componentInstance.guarantor = guarantor;
        this.studentGuarantorCreatorDialogRef.componentInstance.student = this.student;
        this.studentGuarantorCreatorDialogRef.afterClosed().subscribe(( res ) => {

        } );
    }

    //DELETE GUARANTOR
    deleteGuarantor( guarantor: Guarantor ): void {
        this.store.dispatch( this.actions.deleteStudentGuarantor( this.student.identityNo, guarantor ) );
    }

    //SEMESTER REGISTRATION
    semesterRegister(): void {
        console.log( 'showDialog' );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '60%';
        config.height = '50%';
        config.position = { top: '0px' };
        this.creatorDialogRef = this.dialog.open( AdmissionApplicationTaskDialog, config );
        this.creatorDialogRef.componentInstance.student = this.student;
        this.creatorDialogRef.afterClosed().subscribe(( res ) => {
            console.log( 'close dialog' );
            // load something here
        } );
    }

   //COURSE ENROLLMENT
    courseEnroll(): void {
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '50%';
        config.position = { top: '0px' };
        this.creatorDialogRef2 = this.dialog.open( EnrollmentApplicationTaskDialog, config );
        this.creatorDialogRef2.afterClosed().subscribe(( res ) => {
            console.log( 'close dialog' );

            // load something here
        } );
    }

    //STATUS SEMESTER REGISTRATION
    statusSemesterRegister() {
        this.router.navigate( ['/secure/term/admission-applications/admission-application-center2'] );

    }

    //STATUS COURSE ENROLLMENT
    statusCourseEnroll() {
        this.router.navigate( ['/secure/term/enrollment-applications/student-enrollment-center'] );
    }


    /*=========================================================================================*/
    /*GRADUATION APPLICATION*/
    /*=========================================================================================*/

    //APPLY GRADUATION
    applyGraduation2(): void {
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '70%';
        config.height = '80%';
        config.position = { top: '0px' };
        this.creatorDialogRef3 = this.dialog.open( GraduationApplicationCreatorDialog, config );
        this.creatorDialogRef3.afterClosed().subscribe(( res ) => {
            console.log( 'close dialog' );
            // load something here
        } );
    }
    
    //GRADUATION APPLICATION
    applyGraduation(): void {
        console.log( 'showDialog' );
        let config = new MdDialogConfig();
        config.viewContainerRef = this.vcf;
        config.role = 'dialog';
        config.width = '60%';
        config.height = '55%';
        config.position = { top: '0px' };
        this.creatorDialogRef4 = this.dialog.open( GraduationApplicationTaskDialog, config );
        this.creatorDialogRef4.componentInstance.student = this.student;
        this.creatorDialogRef4.afterClosed().subscribe(( res ) => {
            console.log( 'close dialog' );
            // load something here
        } );
    }

    //STATUS GRADUATION
    statusGraduation() {
        this.router.navigate( ['/secure/graduation/graduation-applications/student-graduation-application-center'] );
    }

    /*=========================================================================================*/
    /*ACADEMIC SESSION HISTORY*/
    /*=========================================================================================*/

    //STATUS 
    academicSessionDetail() {
        this.router.navigate( ['/secure/academicSessions'] );
    }


}