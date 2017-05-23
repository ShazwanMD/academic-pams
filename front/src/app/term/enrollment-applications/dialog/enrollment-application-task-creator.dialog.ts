import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {EnrollmentApplicationActions} from "../enrollment-application.action";
import {EnrollmentApplication} from "../enrollment-application.interface";
import {TermModuleState} from "../../index";
import {AcademicSession} from "../../../planner/academic-sessions/academic-session.interface";
import {Admission} from "../../admissions/admission.interface";
import { EnrollmentApplicationType } from "../enrollment-application-type.enum";


@Component({
    selector: 'pams-enrollment-application-task-creator',
    templateUrl: './enrollment-application-task-creator.dialog.html',
})

export class EnrollmentApplicationTaskCreatorDialog implements OnInit {

    private createForm: FormGroup;

    constructor(private formBuilder: FormBuilder,
        private store: Store<TermModuleState>,
        private actions: EnrollmentApplicationActions,
        private dialog: MdDialogRef<EnrollmentApplicationTaskCreatorDialog>) {
    }

    ngOnInit(): void {
        this.createForm = this.formBuilder.group(<EnrollmentApplication>{
            id: null,
            auditNo: '',
            sourceNo: '',
            description: '',
            admission: <Admission>{},
            academicSession: <AcademicSession>{},
            enrollmentApplicationType: EnrollmentApplicationType.PRA
        });
    }

    save(application: EnrollmentApplication, isValid: boolean) {
        console.log("admission: " + application.admission.id)
        console.log("session: " + application.academicSession)
        this.store.dispatch(this.actions.startEnrollmentApplicationTask(application));
        this.dialog.close();
    }
}
