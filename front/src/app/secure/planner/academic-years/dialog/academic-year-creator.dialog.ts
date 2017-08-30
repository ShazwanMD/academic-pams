import {MdSnackBar} from '@angular/material/snack-bar';
import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Store} from '@ngrx/store';
import {MdDialogRef} from '@angular/material';
import {AcademicYear} from '../../../../shared/model/planner/academic-year.interface';
import {PlannerModuleState} from '../../index';
import {AcademicYearActions} from '../academic-year.action';

@Component({
    selector: 'pams-academic-year-creator',
    templateUrl: './academic-year-creator.dialog.html',
})

export class AcademicYearCreatorDialog implements OnInit {

    private createForm: FormGroup;
    private edit: boolean = false;
    private _academicYear: AcademicYear;
    private minLength: number = 4;

    constructor(private formBuilder: FormBuilder,
        private store: Store<PlannerModuleState>,
        private actions: AcademicYearActions,
        private snackBar: MdSnackBar,
        private dialog: MdDialogRef<AcademicYearCreatorDialog>) {
    }

    set academicYear(value: AcademicYear) {
        this._academicYear = value;
        this.edit = true;
    }

    ngOnInit(): void {
        this.createForm = this.formBuilder.group({
           // id: [undefined],
            code: ['', Validators.required],
            description: ['', Validators.minLength(this.minLength)],
            year: ['', Validators.minLength(this.minLength)],

        });

        if (this.edit) {
            //use this code to disable any form control
            //But need to add extra code on the save becoz disable will remve the
            //properties
            this.createForm.get('code').disable();
            }
       
         if (this.edit) this.createForm.patchValue(this._academicYear);
    }

    save(academicYear: AcademicYear): void {
                
        if (!this.edit) this.store.dispatch(this.actions.saveAcademicYear(academicYear));

        let snackBarRef1 = this.snackBar.open( 'New Academic Years: ' + academicYear.code + ' has been saved', '', { duration: 3000 } );
        snackBarRef1.afterDismissed().subscribe(() => {
       } );

        if (this.edit) {
            console.log("Entering edit part");
            //assign code to origal code value
            academicYear.code = this._academicYear.code;
            this.store.dispatch(this.actions.updateAcademicYear(academicYear));

            let snackBarRef = this.snackBar.open( 'New Academic Years: ' + academicYear.code + ' has been updated', '', { duration: 3000 } );
            snackBarRef.afterDismissed().subscribe(() => {
           } );
        }
        this.dialog.close();
    
    }
}
