import { MdDialogRef } from '@angular/material';
import { Store } from '@ngrx/store';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Component, OnInit, ViewContainerRef } from '@angular/core';


import { Faculty } from "./../faculty.interface";
import { PlannerModuleState } from "../../index";
import { FacultyActions } from "../faculty.action";
import { FacultyStatus } from "../faculty-status.enum";

@Component({
    selector: 'pams-faculty-editor',
    templateUrl: './faculty-editor.dialog.html',
})

export class FacultyEditorDialog implements OnInit {

    private editorForm: FormGroup;
    private edit: boolean = false;
    private _faculty: Faculty;

    constructor(private formBuilder: FormBuilder,
        private store: Store<PlannerModuleState>,
        private actions: FacultyActions,
        private router: Router,
        private route: ActivatedRoute,
        private vcf: ViewContainerRef,
        private dialog: MdDialogRef<FacultyEditorDialog>) {
    }

    set faculty(value: Faculty) {
        this._faculty = value;
        this.edit = true;
    }
    ngOnInit(): void {
        this.editorForm = this.formBuilder.group(<Faculty>{
            id: null,
            code: '',
            description: '',
            name: '',
            prefix: '',
            status: FacultyStatus.NEW,
        });
               if (this.edit) this.editorForm.patchValue(this._faculty);
    }

    save(faculty: Faculty, isValid: boolean) {
        console.log("updating faculty");
        if (!faculty.id) this.store.dispatch(this.actions.saveFaculty(faculty));
        else this.store.dispatch(this.actions.updateFaculty(faculty));
        this.dialog.close();
    }

}