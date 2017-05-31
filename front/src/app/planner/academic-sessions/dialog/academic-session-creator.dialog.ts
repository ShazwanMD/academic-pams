import { create } from '@angular/language-service/language-service';
import { Component, ViewContainerRef, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Store } from "@ngrx/store";
import { MdDialogRef } from "@angular/material";

import { AcademicSession } from '../academic-session.interface';
import { PlannerModuleState } from "../../index";
import { AcademicSessionActions } from "../academic-session.action";
import { AcademicSemester } from '../academic-semester-type.enum';
import { AcademicYear } from '../../academic-years/academic-year.interface';

@Component({
    selector: 'pams-academic-session-creator',
    templateUrl: './academic-session-creator.dialog.html',
})

export class AcademicSessionCreatorDialog implements OnInit {

    private createForm: FormGroup;
    private create: boolean = false;
    private _academicSession: AcademicSession;
    private year: AcademicYear; 

    constructor(private formBuilder: FormBuilder,
        private viewContainerRef: ViewContainerRef,
        private store: Store<PlannerModuleState>,
        private actions: AcademicSessionActions,
        private dialog: MdDialogRef<AcademicSessionCreatorDialog>) {
    }

    set academicSession(value: AcademicSession) {
        this._academicSession = value;
        this.create = true;
    }

    ngOnInit(): void {
        this.createForm = this.formBuilder.group(<AcademicSession>{
            id: null,
            code: '',
            description: '',
            current: true,
            startDate: null,
            endDate: null,
            semester: AcademicSemester.SEMESTER_1,
            /*year: <AcademicYear>{},*/

        });

        if (this.create) this.createForm.patchValue(this._academicSession);
    }

    save(academicSession: AcademicSession, isValid: boolean) {
        console.log("saving academic session");
        if (!academicSession.id) this.store.dispatch(this.actions.saveAcademicSession(academicSession));
        else this.store.dispatch(this.actions.updateAcademicSession(academicSession));
        this.dialog.close();
    }
}