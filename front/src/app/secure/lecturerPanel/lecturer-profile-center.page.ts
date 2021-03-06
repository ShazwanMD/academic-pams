import { LecturerModuleState } from './index';
import { Store } from '@ngrx/store';
import { FormBuilder } from '@angular/forms';
import { MdDialog } from '@angular/material/dialog';
import { LecturerActions } from './lecturer.action';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Staff } from './../../shared/model/identity/staff.interface';
import { Component, OnChanges, OnInit, ViewContainerRef, Input } from '@angular/core';
import { Appointment } from "../../shared/model/term/appointment.interface";
import { AdmissionApplication } from "../../shared/model/term/admission-application.interface";
import { Admission } from "../../shared/model/term/admission.interface";


@Component( {
    selector: 'pams-lecturer-profile-center',
    templateUrl: 'lecturer-profile-center.page.html',
} )

export class LecturerProfileCenterPage implements OnInit {

    private LECTURER: string[] = 'LecturerModuleState.lecturer'.split( '.' );
    private LECTURERS: string[] = 'LecturerModuleState.lecturers'.split( '.' );
    private APPOINTMENTS: string[] = 'LecturerModuleState.appointments'.split( '.' );
    private ADMISSION_APPLICATIONS: string[] = 'LecturerModuleState.admissionApplications'.split( '.' );
private ADMISSIONS: string[] = 'LecturerModuleState.admissions'.split( '.' );

    private lecturer$: Observable<Staff>;
    private lecturers$: Observable<Staff[]>;
    private appointments$: Observable<Appointment>;
    private admissionApplications$: Observable<AdmissionApplication>;
private admissions$: Observable<Admission>;

    constructor( private router: Router,
        private route: ActivatedRoute,
        private actions: LecturerActions,
        private dialog: MdDialog,
        private vcf: ViewContainerRef,
        private formBuilder: FormBuilder,
        private store: Store<LecturerModuleState> ) {

        this.lecturer$ = this.store.select( ...this.LECTURER );
        this.lecturers$ = this.store.select( ...this.LECTURERS );
        this.appointments$ = this.store.select( ...this.APPOINTMENTS );
        this.admissionApplications$ = this.store.select( ...this.ADMISSION_APPLICATIONS );
        this.admissions$ = this.store.select( ...this.ADMISSIONS );
    }

    ngOnInit(): void {
        console.log( "find Lecturer Profile" );
        this.store.dispatch( this.actions.findLecturerByUser() );

    }
}