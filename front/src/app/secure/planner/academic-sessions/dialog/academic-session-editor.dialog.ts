import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';

import { AcademicSession } from '../../../../shared/model/planner/academic-session.interface';
import { PlannerModuleState } from '../../index';
import { AcademicSessionActions } from '../academic-session.action';
import { AcademicSemester } from '../../../../shared/model/planner/academic-semester-type.enum';
import { Observable } from "rxjs/Observable";

@Component( {
    selector: 'pams-academic-session-editor',
    templateUrl: './academic-session-editor.dialog.html',
} )

export class AcademicSessionEditorDialog implements OnInit {
    private editorForm: FormGroup;
    private edit: boolean = false;
    private _academicSession: AcademicSession;
    private session: Observable<AcademicSession[]>;
    private SESSION: string[] = 'termModuleState.session'.split( '.' );
    private minLength: number = 5; // contoh

    constructor( private formBuilder: FormBuilder,
        private store: Store<PlannerModuleState>,
        private actions: AcademicSessionActions,
        private snackBar: MdSnackBar,
        private dialog: MdDialogRef<AcademicSessionEditorDialog> ) {

        this.session = this.store.select( ...this.SESSION );

    }

    set academicSession( value: AcademicSession ) {
        this._academicSession = value;
        this.edit = true;
    }

    ngOnInit(): void {
        this.editorForm = this.formBuilder.group( {
            id: [undefined],
            code: [''],
            description: ['', Validators.minLength( this.minLength )],
            current: [true],
            startDate: [undefined, Validators.required],
            endDate: [undefined, Validators.required],

            //enroll
            enrollStartDate: [undefined, Validators.required],
            enrollEndDate: [undefined, Validators.required],

            //admission
            admissionStartDate: [undefined, Validators.required],
            admissionEndDate: [undefined, Validators.required],

            //graduation
            graduationStartDate: [undefined, Validators.required],
            graduationEndDate: [undefined, Validators.required],

            semester: [AcademicSemester.SEMESTER_1, Validators.required],
        } );

        if ( this.edit ) this.editorForm.patchValue( this._academicSession );
    }

    submit( academicSession: AcademicSession, isValid: boolean ): void {
        console.log( 'updating academic session' );
        if ( !academicSession.id ) {

            this.store.dispatch( this.actions.saveAcademicSession( academicSession ) );

            let snackBarRef = this.snackBar.open( 'New Academic Sessions: ' + academicSession.code + ' has been saved', '', { duration: 3000 } );
            snackBarRef.afterDismissed().subscribe(() => {
            } );

            this.dialog.close();

            this.session.subscribe( val => console.log( 'Accumulated object:', val ) );

            this.session.subscribe( val => {
                if ( val['status'] == 'Duplicate' ) {

                    let snackBarRef = this.snackBar.open( 'Duplicate data:' + academicSession.code + 'Please insert new data', '', { duration: 5000 } );
                    snackBarRef.afterDismissed().subscribe(() => {
                        console.log( 'The snack-bar was dismissed' );
                        console.log( 'Accumulated object:', val )
                        val['status'] = '';
                    } );
                } else {
                    if ( val['status'] == 'success' ) {
                        window.alert( 'Success insert new data:' );
                        console.log( 'Accumulated object:', val )
                        val['status'] = '';
                    }
                }
            }
            );


        } else {
            this.store.dispatch( this.actions.updateAcademicSession( academicSession ) );
            let snackBarRef = this.snackBar.open( 'New Academic Sessions: ' + academicSession.code + ' has been updated', '', { duration: 3000 } );
            snackBarRef.afterDismissed().subscribe(() => {
            } );
            this.dialog.close();
        }
    }
}