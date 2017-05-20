import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {TermModuleState} from "../../index";
import {Admission} from "../../admissions/admission.interface";
import {FlowState} from "../../../core/flow-state.enum";
import {MetaState} from "../../../core/meta-state.enum";
import {SectionUpdate} from '../section-update.interface';
import {Section} from "../../sections/section.interface";
//import {OfferingApplicationActions} from "../offering-application.action";

@Component({
  selector: 'pams-section-delete-task-creator',
  templateUrl: './section-delete-task-creator.dialog.html',
})

export class SectionDeleteTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              //private actions: OfferingApplicationActions,
              private dialog: MdDialogRef<SectionDeleteTaskCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<SectionUpdate>{
     
        id:null,
        capacity:'',
        ordinal:'',
        //section:<Section>{},
                  
    });
   
      
  }

 /* update(appointmentApplication: AppointmentApplication, isValid: boolean) {
    this.store.dispatch(this.actions.startAppointmentApplicationTask(appointmentApplication));
    this.dialog.close();
  } */
}
