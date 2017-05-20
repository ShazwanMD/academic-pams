import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {TermModuleState} from "../../index";
import {Admission} from "../../admissions/admission.interface";
import {FlowState} from "../../../core/flow-state.enum";
import {MetaState} from "../../../core/meta-state.enum";
import {AdmissionUpdate} from '../admission-update.interface';
//import {OfferingApplicationActions} from "../offering-application.action";

@Component({
  selector: 'pams-admission-update-task-creator',
  templateUrl: './admission-update-task-creator.dialog.html',
})

export class AdmissionUpdateTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              //private actions: OfferingApplicationActions,
              private dialog: MdDialogRef<AdmissionUpdateTaskCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<AdmissionUpdate>{
     
       /*// id:null,
        capacity:'',
        title:'',*/
             
    });
      
      
  }

 /* update(offeringApplication: OfferingApplication, isValid: boolean) {
    this.store.dispatch(this.actions.startOfferingApplicationTask(offeringApplication));
    this.dialog.close();
  } */
}
