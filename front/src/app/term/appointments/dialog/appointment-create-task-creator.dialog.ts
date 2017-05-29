import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {TermModuleState} from "../../index";
import {FlowState} from "../../../core/flow-state.enum";
import {MetaState} from "../../../core/meta-state.enum";
//import {AppointmentApplication} from '../appointment-application.interface';
import {AppointmentActions} from "../appointment.action";
import { Section } from "../../sections/section.interface";
import {Actor} from "../../../identity/actor.interface";
import { Course } from "../../../planner/courses/course.interface";
import { AcademicSession } from "../../../planner/academic-sessions/academic-session.interface";
import {Offering} from "../../offerings/offering.interface";
import {Appointment} from "../appointment.interface";
import { AppointmentStatus } from "../appointment-status.enum";
import {Router, ActivatedRoute} from '@angular/router';


@Component({
    selector: 'pams-appointment-create-task-creator',
    templateUrl: './appointment-create-task-creator.dialog.html',
})

export class AppointmentCreateTaskCreatorDialog implements OnInit {

    private createForm: FormGroup;
    private _offering: Offering;
    private _appointment: Appointment;
    private edit: boolean = false;


    constructor(private router: Router,
                private route: ActivatedRoute,
                private formBuilder: FormBuilder,
                private store: Store<TermModuleState>,
                private actions: AppointmentActions,
                private dialog: MdDialogRef<AppointmentCreateTaskCreatorDialog>,
                private viewContainerRef: ViewContainerRef) {
    }

    set offering(value: Offering) {
        this._offering = value;
    }

     set appointment(value: Appointment) {
    this._appointment = value;
    this.edit = true;
  }
    
    ngOnInit(): void {
        this.createForm = this.formBuilder.group(<Appointment>{
            id: null,
            staff: <Actor>{},
            session: <AcademicSession>{},
            section: <Section>{},
            course: <Course>{},
            offering: <Offering>{},
            appointmentStatus: AppointmentStatus.NEW



        });

        // set offering by default
        this.createForm.patchValue({ 'offering': this._offering });
    }


    /* save(offeringApplication: OfferingApplication, isValid: boolean) {
       this.store.dispatch(this.actions.startOfferingApplicationTask(offeringApplication));
       this.dialog.close();
     } */
}
