import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Store} from "@ngrx/store";
import {MdDialogRef} from "@angular/material";
//import {OfferingApplicationActions} from "../offering-application.action";
//import {OfferingApplication} from "../offering-application.interface";
import {TermModuleState} from "../../index";
import {AcademicSession} from "../../../planner/academic-sessions/academic-session.interface";
import {Admission} from "../../admissions/admission.interface";
import {FlowState} from "../../../core/flow-state.enum";
import {MetaState} from "../../../core/meta-state.enum";
import {OfferingApplication} from '../offering-application.interface';
// import {OfferingApplicationActions} from "../offering-application.action";
import {Course} from "../../../planner/courses/course.interface";
import {Program} from "../../../planner/programs/program.interface";


@Component({
  selector: 'pams-offering-application-task-creator',
  templateUrl: './offering-application-task-creator.dialog.html',
})

export class OfferingApplicationTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              // private actions: OfferingApplicationActions,
              private dialog: MdDialogRef<OfferingApplicationTaskCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<OfferingApplication>{
     
      id:null,
      referenceNo:'',
      sourceNo:'please insert your data',
      description:'please insert your data',
         
     // id:null,
     // capacity:'please insert your data',
     // canonical_code:'please insert your data',
     // code:'please insert your data',
     // title:'please insert your data',
     // course:<Course>{},
     // program:<Program>{},
    });
      
  }

  /*save(offeringApplication: OfferingApplication, isValid: boolean) {
    this.store.dispatch(this.actions.startOfferingApplicationTask(offeringApplication));
    this.dialog.close();
  }*/
}
