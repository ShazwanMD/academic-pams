import { ActivatedRoute, Router } from '@angular/router';
import { Component, ViewContainerRef, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Store } from "@ngrx/store";
import { MdDialogRef } from "@angular/material";

import { AcademicSession } from '../academic-session.interface';
import { PlannerModuleState } from "../../index";
import { AcademicSessionActions } from "../academic-session.action";
import { AcademicYear } from '../academic-session-year.interface';
import { AcademicSemester } from '../academic-session-semester-type.enum';

@Component({
    selector: 'pams-academic-session-editor',
    templateUrl: './academic-session-editor.dialog.html',
})

export class AcademicSessionEditorDialog implements OnInit {

    private editorForm: FormGroup;
    private edit: boolean = false;
    private _academicSession: AcademicSession;
    private _semester: AcademicSemester;
    private _year: AcademicYear;

    constructor(private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private viewContainerRef: ViewContainerRef,
        private store: Store<PlannerModuleState>,
        private actions: AcademicSessionActions,
        private dialog: MdDialogRef<AcademicSessionEditorDialog>) {
    }

    set academicSession(value: AcademicSession) {
        this._academicSession = value;
        this.edit = true;
    }

    set semester(value: AcademicSemester) {
        this._semester = value;
    }

    set year(value: AcademicYear) {
        this._year = value;
        this.edit = true;
    }

    ngOnInit(): void {
        this.editorForm = this.formBuilder.group(<AcademicSession>{
            id: null,
            code: '',
            description: '',
            current: true,
            startDate: null,
            endDate: null,
            semester: <AcademicSemester>{},
            year: <AcademicYear>{},
        });

        if (this.edit) this.editorForm.patchValue(this._academicSession);
    }

    save(academicSession: AcademicSession, isValid: boolean) {
        console.log("updating academic session");
        if (!academicSession.id) this.store.dispatch(this.actions.saveAcademicSession(academicSession));
        else this.store.dispatch(this.actions.updateAcademicSession(academicSession));
        this.dialog.close();
    }
}


