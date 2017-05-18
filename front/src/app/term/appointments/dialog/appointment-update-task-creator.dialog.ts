import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {TermModuleState} from "../../index";
import {Admission} from "../../admissions/admission.interface";
import {FlowState} from "../../../core/flow-state.enum";
import {MetaState} from "../../../core/meta-state.enum";
import {AppointmentUpdate} from '../appointment-update.interface';
import {Section} from "../../sections/section.interface";
//import {OfferingApplicationActions} from "../offering-application.action";

@Component({
  selector: 'pams-appointment-update-task-creator',
  templateUrl: './appointment-update-task-creator.dialog.html',
})

export class AppointmentUpdateTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              //private actions: OfferingApplicationActions,
              private dialog: MdDialogRef<AppointmentUpdateTaskCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<AppointmentUpdate>{
     
        id:null,
        status:'',
        section:<Section>{},
       // staff:'',
             
    });
      
      
  }

 /* update(appointmentApplication: AppointmentApplication, isValid: boolean) {
    this.store.dispatch(this.actions.startAppointmentApplicationTask(appointmentApplication));
    this.dialog.close();
  } */
}
