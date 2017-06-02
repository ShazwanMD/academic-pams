import { Program } from './../../programs/program.interface';
import { Component, ViewContainerRef, OnInit, AfterViewInit } from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {PlannerService} from "../../../../services/planner.service";
import {Cohort} from "../cohort.interface";
import {CohortActions} from "../cohort.action";
import {MdDialogRef} from "@angular/material";
import {PlannerModuleState} from "../../index";
import {Store} from "@ngrx/store";
import {AcademicClassification} from "../academic-classification.enum";

@Component({
  selector: 'pams-cohort-update',
  templateUrl: './cohort-update.dialog.html',
})

export class CohortUpdateDialog implements OnInit {
  private _program: Program;
  private _cohort: Cohort;
  private updateForm: FormGroup;
  private update: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private actions: CohortActions,
              private store: Store<PlannerModuleState>,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<CohortUpdateDialog >) {
            
  }
  set program(value: Program){
    this._program = value;
  }

 set cohort(value: Cohort) {
        this._cohort = value;
        this.update = true;
  }

     ngOnInit(): void {
      this.updateForm = this.formBuilder.group(<Cohort>{
       id: null,
       code: '',
       description:'',
       academicClassification: AcademicClassification.LEVEL_MASTER

     });
     
       if (this.update) this.updateForm.patchValue(this._cohort);
  }
     
      save(cohort: Cohort, isValid: boolean) {
           console.log(JSON.stringify(cohort));
           cohort.code = this._cohort.code
        
        if(!cohort.id)this.store.dispatch(this.actions.saveCohort(this.cohort));
        else this.store.dispatch(this.actions.updateCohort(cohort))
        this.dialog.close();
   
   }
}

