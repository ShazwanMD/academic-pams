import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';
import { MdDialogRef, MdSnackBar } from '@angular/material';
import { TermModuleState } from '../../index';
import { AppointmentActions } from '../appointment.action';
import { Section } from '../../../../shared/model/term/section.interface';
import { Course } from '../../../../shared/model/planner/course.interface';
import { AcademicSession } from '../../../../shared/model/planner/academic-session.interface';
import { Offering } from '../../../../shared/model/term/offering.interface';
import { Appointment } from '../../../../shared/model/term/appointment.interface';
import { AppointmentStatus } from '../../../../shared/model/term/appointment-status.enum';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from "rxjs/Observable";

@Component( {
    selector: 'pams-appointment-editor',
    templateUrl: './appointment-editor.dialog.html',
} )

export class AppointmentEditorDialog implements OnInit {

    private APPOINTMENT: string[] = 'termModuleState.appointment'.split( '.' );
    private appointment$: Observable<Appointment[]>;


    private editorForm: FormGroup;
    private _section: Section;
    private _appointment: Appointment;
    private edit: boolean = false;

    constructor( private router: Router,
        private route: ActivatedRoute,
        private formBuilder: FormBuilder,
        private snackBar: MdSnackBar,
        private store: Store<TermModuleState>,
        private actions: AppointmentActions,
        private dialog: MdDialogRef<AppointmentEditorDialog>,
        private viewContainerRef: ViewContainerRef ) {

        this.appointment$ = this.store.select( ...this.APPOINTMENT );
    }

    set section( value: Section ) {
        this._section = value;
    }

    set appointment( value: Appointment ) {
        this._appointment = value;
        this.edit = true;
    }

    ngOnInit(): void {
        this.editorForm = this.formBuilder.group( {
            id: null,
            staff: ['', Validators.required],
            session: <AcademicSession>{},
            section: <Section>{},
            course: <Course>{},
            offering: <Offering>{},
            //appointmentStatus: <AppointmentStatus>{},
            //appointmentStatus: AppointmentStatus.CONFIRMED,
            appointmentStatus: [AppointmentStatus.CONFIRMED, Validators.required],
        } );

        // set offering by default
        this.editorForm.patchValue( { 'section': this._section } );
        if ( this.edit ) this.editorForm.patchValue( this._appointment );
    }

    submit( appointment: Appointment, isValid: boolean ) {
        console.log( 'appointment', appointment );
        console.log( 'section', this.section );
        console.log( this._section );
        console.log( this._appointment );

        // set codes
        if ( !this.edit ) {

            this.store.dispatch( this.actions.addAppointment( this._section, appointment ) );
            this.appointment$.subscribe( val => console.log( 'Accumulated object:', val ) );
            this.appointment$.subscribe( val => { window.alert( 'Duplicate data' ); } );
            this.dialog.close();

        } else {
            this.store.dispatch( this.actions.updateAppointment( this._section, appointment ) );
            this.dialog.close();
        }
    }
}
