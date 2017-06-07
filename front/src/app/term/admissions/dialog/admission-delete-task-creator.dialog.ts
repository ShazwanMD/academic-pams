import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
import {TermModuleState} from "../../index";
import {Admission} from "../../admissions/admission.interface";
import {FlowState} from "../../../core/flow-state.enum";
import {MetaState} from "../../../core/meta-state.enum";
//import {OfferingApplicationActions} from "../offering-application.action";

@Component({
  selector: 'pams-admission-delete-task-creator',
  templateUrl: './admission-delete-task-creator.dialog.html',
})

export class AdmissionDeleteTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              //private actions: AdmissionApplicationActions,
              private dialog: MdDialogRef<AdmissionDeleteTaskCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Admission>{
     
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
