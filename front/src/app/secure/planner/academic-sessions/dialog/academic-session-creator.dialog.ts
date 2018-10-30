import { MdSnackBar } from '@angular/material/snack-bar';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';
import { MdDialogRef } from '@angular/material';
import { AcademicSession } from '../../../../shared/model/planner/academic-session.interface';
import { PlannerModuleState } from '../../index';
import { AcademicSessionActions } from '../academic-session.action';
import { DateValidation } from "../component/academic-session-date-validation.component";

@Component( {
    selector: 'pams-academic-session-creator',
    templateUrl: './academic-session-creator.dialog.html',
} )

export class AcademicSessionCreatorDialog implements OnInit {

    private createForm: FormGroup;
    private create: boolean = false;
    private _academicSession: AcademicSession;
    private minLength: number = 5; // contoh

    constructor( private formBuilder: FormBuilder,
        private store: Store<PlannerModuleState>,
        private actions: AcademicSessionActions,
        private snackBar: MdSnackBar,
        private dialog: MdDialogRef<AcademicSessionCreatorDialog> ) {
    }

    set academicSession( value: AcademicSession ) {
        this._academicSession = value;
        this.create = true;
    }

    ngOnInit(): void {
        this.createForm = this.formBuilder.group( {
            id: [undefined],
            code: ['', Validators.required],
            //description: ['', Validators.minLength( this.minLength )],
            current: [true],
            startDate: ['', Validators.required],
            endDate: ['', Validators.required],

            //enroll
            enrollStartDate: [undefined, Validators.required],
            enrollEndDate: [undefined, Validators.required],

            //admission
            admissionStartDate: [undefined, Validators.required],
            admissionEndDate: [undefined, Validators.required],

            //graduation
            graduationStartDate: [undefined, Validators.required],
            graduationEndDate: [undefined, Validators.required],

            semester: ['', Validators.required],
            academicYear: ['', Validators.required],
        }, {

                validator: DateValidation.CheckDate // your validation method

                // if (this.create) this.createForm.patchValue(this._academicSession);

            } )
    }

    submit( academicSession: AcademicSession ): void {
        if ( !academicSession.id ) this.store.dispatch( this.actions.saveAcademicSession( academicSession ) );
        else this.store.dispatch( this.actions.updateAcademicSession( academicSession ) );
        this.dialog.close();
        let snackBarRef = this.snackBar.open( 'New Academic Session: ' + academicSession.code + ' has been saved', '', { duration: 3000 } );
        snackBarRef.afterDismissed().subscribe(() => {
        } );
    }
}
