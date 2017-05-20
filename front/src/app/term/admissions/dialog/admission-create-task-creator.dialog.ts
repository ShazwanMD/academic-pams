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
import {AdmissionApplication} from '../admission-application.interface';
import {AdmissionApplicationActions} from "../admission-application.action";
import {Course} from "../../../planner/courses/course.interface";
import {Program} from "../../../planner/programs/program.interface";


@Component({
  selector: 'pams-admission-create-task-creator',
  templateUrl: './admission-create-task-creator.dialog.html',
})

export class AdmissionCreateTaskCreatorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private store: Store<TermModuleState>,
              private actions: AdmissionApplicationActions,
              private dialog: MdDialogRef<AdmissionCreateTaskCreatorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<AdmissionApplication>{
     
        id:null,
        gpa:'',
        cgpa:'',
        creditTaken:'',
        creditEarned:'',
        //standing:'',
        //status:'',
        //course:<Course>{},
        //program:<Program>{},*/
     
     
    });
      
  }

 /* save(offeringApplication: OfferingApplication, isValid: boolean) {
    this.store.dispatch(this.actions.startOfferingApplicationTask(offeringApplication));
    this.dialog.close();
  } */
}
