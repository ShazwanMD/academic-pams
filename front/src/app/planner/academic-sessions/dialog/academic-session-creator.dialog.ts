import { create } from '@angular/language-service/language-service';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";

import { AcademicSession } from '../academic-session.interface';
import {PlannerModuleState} from "../../index";
import {AcademicSessionActions} from "../academic-session.action";

@Component({
  selector: 'pams-academic-session-creator',
  templateUrl: './academic-session-creator.dialog.html',
})

export class AcademicSessionCreatorDialog implements OnInit {

    private creatorForm: FormGroup;
    private create: boolean = false;
    private _academicSession: AcademicSession;

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
        this.creatorForm = this.formBuilder.group(<AcademicSession>{
            id: null,
            code: '',
            description: '',
        });

         if (this.create) this.creatorForm.patchValue(this._academicSession);
  }

    save(code: AcademicSession, isValid: boolean) {
        if (!code.id) this.store.dispatch(this.actions.saveAcademicSession(code));
        else  this.store.dispatch(this.actions.updateAcademicSession(code));
        this.dialog.close();
    }
}