import { TermModuleState } from './../../index';
import { ActivatedRoute } from '@angular/router';
import { Actor } from './../../../identity/actor.interface';
import { Student } from './../../../identity/student.interface';
import { StudyCenter } from './../../../setup/study-centers/study-center.interface';
import { Program } from './../../../planner/programs/program.interface';
import { AcademicSession } from './../../../planner/academic-sessions/academic-session.interface';
import { Store } from '@ngrx/store';
import { MdDialogRef } from '@angular/material';
import { Router } from '@angular/router';
import { AdmissionApplicationActions } from './../admission-application.action';
import { AdmissionApplication } from './../admission-application.interface';
import { FormGroup, FormBuilder } from '@angular/forms';
import { OnInit, ViewContainerRef, Component } from '@angular/core';


@Component({
    selector: 'pams-admission-application-task-editor',
    templateUrl: './admission-application-task-editor.dialog.html',
})

export class AdmissionApplicationTaskEditorDialog implements OnInit {
    private editForm: FormGroup;
    private edit: boolean = false;
    private _admissionApplication: AdmissionApplication;

    constructor(private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private store: Store<TermModuleState>,
        private vcf: ViewContainerRef,
        private actions: AdmissionApplicationActions,
        private dialog: MdDialogRef<AdmissionApplicationTaskEditorDialog>) {

    }
    set admissionApplication(value: AdmissionApplication) {
        this._admissionApplication = value;
        this.edit = true;
    }

    ngOnInit(): void {
        this.editForm = this.formBuilder.group(<AdmissionApplication>{
            // id: null,
            // referenceNo: '',
            // sourceNo: '',
            // auditNo: '',
            // description: '',
            // cancelComment: '',
            // removeComment: '',
            // actor: <Actor>{},
            // student: <Student>{},
            // academicSession: <AcademicSession>{},
            // program: <Program>{},
            // studyCenter: <StudyCenter>{},
        });
        if (this.edit) this.editForm.patchValue(this._admissionApplication);
    }
    submit(admissionApplication: AdmissionApplication, isValid: boolean) {
        console.log("updating application");
        if (!admissionApplication.id) this.store.dispatch(this.actions.saveAdmissionApplication(admissionApplication));
        else this.store.dispatch(this.actions.updateAdmissionApplication(admissionApplication));
        this.dialog.close();
    }

}
