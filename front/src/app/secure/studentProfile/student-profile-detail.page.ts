import { PlannerModuleState } from './../planner/index';
import { AcademicSession } from './../../shared/model/planner/academic-session.interface';
import { MdDialogRef, MdDialogConfig, MdDialog } from '@angular/material';
import { Contact } from './../../shared/model/profile/contact.interface';
import { Guardian } from './../../shared/model/profile/guardian.interface';
import { Guarantor } from './../../shared/model/profile/guarantor.interface';
import { ProfileActions } from './../profile/profile.action';
import { StudentProfileModuleState } from './index';
import { StudentProfileActions } from './student-profile.action';
import { Component, OnInit, Input, EventEmitter, Output, ViewContainerRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';

import { Student } from '../../shared/model/identity/student.interface';
import { Address } from "../../shared/model/profile/address.interface";
import { Enrollment } from "../../shared/model/term/enrollment.interface";
import { FormBuilder } from "@angular/forms";
import { Admission } from "../../shared/model/term/admission.interface";

@Component({
    selector: 'pams-student-profile-detail',
    templateUrl: 'student-profile-detail.page.html',
})

export class StudentProfileDetailPage implements OnInit {

    @Input() academicSessions: AcademicSession[];
    @Input() academicSession: AcademicSession;

    private STUDENT: string[] = 'studentProfileModuleState.student'.split('.');
    private ADDRESSES: string[] = 'studentProfileModuleState.addresses'.split('.');
    private STUDENTS: string[] = 'studentProfileModuleState.students'.split('.');
    private GUARANTORS: string[] = 'studentProfileModuleState.guarantors'.split('.');
    private GUARDIANS: string[] = 'studentProfileModuleState.guardians'.split('.');
    private CONTACTS: string[] = 'studentProfileModuleState.contacts'.split('.');
    private ENROLLMENTS: string[] = 'studentProfileModuleState.enrollments'.split('.');
    private ADMISSIONS: string[] = 'studentProfileModuleState.admissions'.split('.');
    private ACADEMIC_SESSIONS: string[] = 'studentProfileModuleState.academicSessions'.split('.');
    private ACADEMIC_SESSION: string[] = 'studentProfileModuleState.academicSession'.split('.');


    private students$: Observable<Student[]>;
    private student$: Observable<Student>;
    private addressess$: Observable<Address[]>;
    private guarantors$: Observable<Guarantor>;
    private guardians$: Observable<Guardian>;
    private contacts$: Observable<Contact>;
    private enrollments$: Observable<Enrollment>;
    private admissions$: Observable<Admission>;
    private academicSessions$: Observable<AcademicSession[]>;
    private academicSession$: Observable<AcademicSession>;



    private _student: Student;
    constructor(private router: Router,
        private route: ActivatedRoute,
        private actions: StudentProfileActions,
        private profileActions: ProfileActions,
        private dialog: MdDialog,
        private vcf: ViewContainerRef,
        private formBuilder: FormBuilder,
        private store: Store<StudentProfileModuleState>,
    ) {

        this.students$ = this.store.select(...this.STUDENTS);
        this.student$ = this.store.select(...this.STUDENT);
        this.addressess$ = this.store.select(...this.ADDRESSES);
        this.guardians$ = this.store.select(...this.GUARDIANS);
        this.guarantors$ = this.store.select(...this.GUARANTORS);
        this.contacts$ = this.store.select(...this.CONTACTS);
        this.enrollments$ = this.store.select(...this.ENROLLMENTS);
        this.admissions$ = this.store.select(...this.ADMISSIONS);
        this.academicSessions$ = this.store.select(...this.ACADEMIC_SESSIONS);
        this.academicSession$ = this.store.select(...this.ACADEMIC_SESSION);

    }


    goBack(route: string): void {
        this.router.navigate(['/studentProfiles']);
    }


    ngOnInit(): void {
        console.log("find Student Profile Detail");
        this.store.dispatch(this.actions.findAcademicSessionsByStudent());

    }

    viewDetails(academicSession: AcademicSession) {
        console.log('academicSession: ' + academicSession.code);
        this.router.navigate(['/academic-session-detail', academicSession.code]);
    }

}

