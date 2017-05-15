import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";

import { AcademicSession } from '../academic-session.interface';
import {PlannerModuleState} from "../../index";
import {AcademicSessionActions} from "../academic-session.action";

@Component({
  selector: 'pams-academic-session-editor',
  templateUrl: './academic-session-editor.dialog.html',
})

export class AcademicSessionEditorDialog implements OnInit {

    private editorForm: FormGroup;
    private edit: boolean = false;
    private _academicSession: AcademicSession;

      constructor(private formBuilder: FormBuilder,
                private viewContainerRef: ViewContainerRef,
                private store: Store<PlannerModuleState>,
                private actions: AcademicSessionActions,
                private dialog: MdDialogRef<AcademicSessionEditorDialog>) {
        }

    set academicSession(value: AcademicSession) {
        this._academicSession = value;
        this.edit = true;
    }

    ngOnInit(): void {
        this.editorForm = this.formBuilder.group(<AcademicSession>{
            id: null,
            code: '',
            description: '',
        });

         if (this.edit) this.editorForm.patchValue(this._academicSession);
  }

    submit(code: AcademicSession, isValid: boolean) {
        if (!code.id) this.store.dispatch(this.actions.saveAcademicSession(code));
        else  this.store.dispatch(this.actions.updateAcademicSession(code));
        this.dialog.close();
    }
}