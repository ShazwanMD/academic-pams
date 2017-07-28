import { Store } from '@ngrx/store';
import { MdDialogRef } from '@angular/material';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { OnInit, Component, ViewContainerRef } from '@angular/core';

import { Faculty } from '../../../../shared/model/planner/faculty.interface';
import { PlannerModuleState } from '../../index';
import { FacultyActions } from '../faculty.action';

@Component({
    selector: 'pams-faculty-creator',
    templateUrl: './faculty-creator.dialog.html',
})

export class FacultyCreatorDialog implements OnInit {

    private createForm: FormGroup;
    private create: boolean = false;
    private _faculty: Faculty;
    private minLength: number = 1;

    constructor(private formBuilder: FormBuilder,
        private store: Store<PlannerModuleState>,
        private actions: FacultyActions,
        private dialog: MdDialogRef<FacultyCreatorDialog>) {
    }

    set faculty(value: Faculty) {
        this._faculty = value;
        this.create = true;
    }
    ngOnInit(): void {
        this.createForm = this.formBuilder.group({
            id: [undefined],
            code: ['', Validators.required],
            description: ['', Validators.minLength(this.minLength)],
            name: ['', Validators.minLength(this.minLength)],
            prefix: '',
            status: ['', Validators.required],
        });
        if (this.create) this.createForm.patchValue(this._faculty);
    }

    save(faculty: Faculty, isValid: boolean) {
        /*console.log("adding faculty");*/
        if (!faculty.id) this.store.dispatch(this.actions.saveFaculty(faculty));
        else this.store.dispatch(this.actions.updateFaculty(faculty));
        this.dialog.close();
    }

}
