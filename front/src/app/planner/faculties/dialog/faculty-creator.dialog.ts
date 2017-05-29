import { Store } from '@ngrx/store';
import { MdDialogRef } from '@angular/material';
import { FormGroup, FormBuilder } from '@angular/forms';
import { OnInit, Component, ViewContainerRef } from '@angular/core';

import { Faculty } from "./../faculty.interface";
import { PlannerModuleState } from "../../index";
import { FacultyActions } from "../faculty.action";
import { ActivatedRoute, Router } from '@angular/router';
import { FacultyStatus } from "../faculty-status.enum";

@Component({
    selector: 'pams-faculty-creator',
    templateUrl: './faculty-creator.dialog.html',
})

export class FacultyCreatorDialog implements OnInit {

    private creatorForm: FormGroup;
    private create: boolean = false;
    private _faculty: Faculty;

    constructor(private formBuilder: FormBuilder,
        private store: Store<PlannerModuleState>,
        private actions: FacultyActions,
        private router: Router,
        private route: ActivatedRoute,
        private vcf: ViewContainerRef,
        private dialog: MdDialogRef<FacultyCreatorDialog>) {
    }

    set faculty(value: Faculty) {
        this._faculty = value;
        this.create = true;
    }
    ngOnInit(): void {
        this.creatorForm = this.formBuilder.group(<Faculty>{
            id: null,
            code: '',
            description: '',
            name: '',
            prefix: '',
            status: FacultyStatus.NEW,
        });
               if (this.create) this.creatorForm.patchValue(this._faculty);
    }

    save(faculty: Faculty, isValid: boolean) {
        console.log("adding faculty");
        if (!faculty.id) this.store.dispatch(this.actions.saveFaculty(faculty));
        else this.store.dispatch(this.actions.updateFaculty(faculty));
        this.dialog.close();
    }

}