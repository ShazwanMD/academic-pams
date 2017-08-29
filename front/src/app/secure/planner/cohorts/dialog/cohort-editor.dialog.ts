import {MdSnackBar} from '@angular/material/snack-bar';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Cohort } from '../../../../shared/model/planner/cohort.interface';
import { CohortActions } from '../cohort.action';
import { Store } from '@ngrx/store';
import { PlannerModuleState } from '../../index';
import { MdDialogRef } from '@angular/material';
import { Program } from "../../../../shared/model/planner/program.interface";
import { Course } from "../../../../shared/model/planner/course.interface";
import { AcademicSession } from "../../../../shared/model/planner/academic-session.interface";
;

@Component( {
    selector: 'pams-cohort-editor',
    templateUrl: './cohort-editor.dialog.html',
} )

export class CohortEditorDialog implements OnInit {

    private createForm: FormGroup;
    private create: boolean = false;
    private _cohort: Cohort;
    private _program: Program;
    private _academicSession: AcademicSession;

    constructor( private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private store: Store<PlannerModuleState>,
        private actions: CohortActions,
        private snackBar: MdSnackBar,
        private dialog: MdDialogRef<CohortEditorDialog> ) {
    }

    set cohort( value: Cohort ) {
        this._cohort = value;
        this.create = true;
    }

    ngOnInit(): void {
        this.createForm = this.formBuilder.group( {
            id: [undefined],
            code: [''],
            program: ['', Validators.required],
            academicSession: ['', Validators.required],
        } );
    }

    save( cohort: Cohort, isValid: boolean ): void {
        
        this._program = cohort.program;
        this._academicSession = cohort.academicSession;
        cohort.code = this._program.code + '-' + this._academicSession.code;
        
        console.log( this._program );
        console.log( this._academicSession );
        console.log( cohort.code );
        console.log( "save click" );
        
        //this.store.dispatch(this.actions.saveCohort(cohort));
        if ( !cohort.id ) this.store.dispatch( this.actions.saveCohort( this._program, this._academicSession, cohort ) );
        else this.store.dispatch( this.actions.updateCohort( cohort ) );
        this.dialog.close();
        console.log( cohort );

        let snackBarRef = this.snackBar.open( 'New Cohorts: ' + cohort.code + ' has been saved', '', { duration: 3000 } );
        snackBarRef.afterDismissed().subscribe(() => {
            
         } );
        
    }
}
