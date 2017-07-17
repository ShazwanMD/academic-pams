import { Component, ViewContainerRef, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Store } from "@ngrx/store";
import { MdDialogRef } from "@angular/material";
import { EnrollmentApplicationActions } from "../enrollment-application.action";
import { EnrollmentApplication } from "../enrollment-application.interface";
import { TermModuleState } from "../../index";
import { AcademicSession } from "../../../planner/academic-sessions/academic-session.interface";
import { Admission } from "../../admissions/admission.interface";
import { EnrollmentApplicationType } from "../enrollment-application-type.enum";
import { ActivatedRoute, Router } from "@angular/router";


@Component( {
    selector: 'pams-enrollment-application-task-creator',
    templateUrl: './enrollment-application-task-creator.dialog.html',
} )

export class EnrollmentApplicationTaskCreatorDialog implements OnInit {

    private createForm: FormGroup;
    private _academicSession: AcademicSession;
    private _admission: Admission;
    private minLength: number = 10;

    constructor( private router: Router,
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private store: Store<TermModuleState>,
        private actions: EnrollmentApplicationActions,
        private dialog: MdDialogRef<EnrollmentApplicationTaskCreatorDialog> ) {
    }


    ngOnInit(): void {
        this.createForm = this.formBuilder.group( {
            id: [undefined],
            /* auditNo: ['N/A'],
             sourceNo: ['N/A'],*/
            description: ['', Validators.required],
            /* applicationType: [EnrollmentApplicationType.PRA, Validators.required],*/
            admission: [undefined, Validators.required],
            academicSession: [undefined, Validators.required],

        } );
    }



    save( enrollmentApplication: EnrollmentApplication, isValid: boolean ): void {

        this._academicSession = enrollmentApplication.academicSession;
        this._admission = enrollmentApplication.admission;

        console.log( "description: " + enrollmentApplication.description )
        console.log( "admission: " + enrollmentApplication.admission.id )
        console.log( "academicSession: " + enrollmentApplication.academicSession.id )
        console.log( JSON.stringify( enrollmentApplication ) );
        this.store.dispatch( this.actions.startEnrollmentApplicationTask(enrollmentApplication));
        this.dialog.close();
    }
}
//
//submit(enrollmenApplication: EnrollmenApplication, isValid: boolean): void {
//    // workaround
//    this._program = enrollmenApplication.program;
//    this._course = enrollmenApplication.course;
//
//    enrollmenApplication. = this.enrollmenApplication.code + '-' + this._course.code;
//    enrollmenApplication.code = this.enrollmenApplication.code;
//    offering.titleMs = this._course.titleMs;
//    offering.titleEn = this._course.titleEn;
//
//    this.store.dispatch(this.actions.saveOffering(this._program, this._course, offering));
//    console.log('Save a new offering');
//    this.dialog.close();
//  }
//}
//
