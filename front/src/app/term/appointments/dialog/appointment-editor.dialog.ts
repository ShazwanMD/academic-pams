import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {TermModuleState} from "../../index";
import {AppointmentActions} from "../appointment.action";
import {Section} from "../../sections/section.interface";
import {Actor} from "../../../identity/actor.interface";
import {Course} from "../../../planner/courses/course.interface";
import {AcademicSession} from "../../../planner/academic-sessions/academic-session.interface";
import {Offering} from "../../offerings/offering.interface";
import {Appointment} from "../appointment.interface";
import {AppointmentStatus} from "../appointment-status.enum";
import {Router, ActivatedRoute} from '@angular/router';


@Component({
  selector: 'pams-appointment-editor',
  templateUrl: './appointment-editor.dialog.html',
})

export class AppointmentEditorDialog implements OnInit {

  private editorForm: FormGroup;
  private _section: Section;
  private _appointment: Appointment;
  private edit: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: AppointmentActions,
              private dialog: MdDialogRef<AppointmentEditorDialog>,
              private viewContainerRef: ViewContainerRef) {
  }


  set section(value: Section) {
    this._section = value;
  }

  set appointment(value: Appointment) {
    this._appointment = value;
    this.edit = true;
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<Appointment>{
      id: null,
      staff: <Actor>{},
      session: <AcademicSession>{},
      section: <Section>{},
      course: <Course>{},
      offering: <Offering>{},
      appointmentStatus: <AppointmentStatus>{},
      // appointmentStatus: AppointmentStatus.NEW
    });

    // set offering by default
    this.editorForm.patchValue({'section': this._section});
    if (this.edit) this.editorForm.patchValue(this._appointment);
  }


  submit(appointment: Appointment, isValid: boolean) {
    console.log("appointment",appointment);
    console.log("section", this.section);
    console.log(this._section);
    console.log(this._appointment);

    // set codes
    if (!this.edit) this.store.dispatch(this.actions.addAppointment(this._section, appointment));
    else  this.store.dispatch(this.actions.updateAppointment(this._section, appointment));
    this.dialog.close();
  }
}
