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


@Component({
  selector: 'pams-appointment-create-task-creator',
  templateUrl: './appointment-create-task-creator.dialog.html',
})

export class AppointmentCreateTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              //private actions: AppointmentApplicationActions,
              private dialog: MdDialogRef<AppointmentCreateTaskCreatorDialog>) {
  }

  ngOnInit(): void {
   /* this.createForm = this.formBuilder.group(<AppointmentApplication>{
     
        id:null,
        status:'',
        section:<Section>{},
       // staff:<Staff>{},
     
     
    });*/
      
  }

 /* save(offeringApplication: OfferingApplication, isValid: boolean) {
    this.store.dispatch(this.actions.startOfferingApplicationTask(offeringApplication));
    this.dialog.close();
  } */
}
