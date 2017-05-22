import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {TermModuleState} from "../../index";
import {FlowState} from "../../../core/flow-state.enum";
import {MetaState} from "../../../core/meta-state.enum";
//import {AppointmentApplication} from '../appointment-application.interface';
//import {AppointmentApplicationActions} from "../appointment-application.action";
import { Section } from "../../sections/section.interface";
import { Course } from "../../../planner/courses/course.interface";
import { AcademicSession } from "../../../planner/academic-sessions/academic-session.interface";
import {Offering} from "../../offerings/offering.interface";
import {Appointment} from "../appointment.interface";


@Component({
  selector: 'pams-appointment-create-task-creator',
  templateUrl: './appointment-create-task-creator.dialog.html',
})

export class AppointmentCreateTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;
  private _offering: Offering;
  private edit: boolean = false;
    

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              //private actions: AppointmentApplicationActions,
              private dialog: MdDialogRef<AppointmentCreateTaskCreatorDialog>,
              private viewContainerRef: ViewContainerRef) {
  }

  set offering(value: Offering) {
    this._offering = value;
  }
    
   ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Appointment>{
      id: null,
      session: <AcademicSession>{},
      section: <Section>{},
      course: <Course>{},
      offering: <Offering>{},
      
       
      
    });

    // set offering by default
    this.createForm.patchValue({'offering': this._offering});
  }


 /* save(offeringApplication: OfferingApplication, isValid: boolean) {
    this.store.dispatch(this.actions.startOfferingApplicationTask(offeringApplication));
    this.dialog.close();
  } */
}
