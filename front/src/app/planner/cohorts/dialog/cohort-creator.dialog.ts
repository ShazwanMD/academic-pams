import { Faculty } from './../../faculties/faculty.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {PlannerService} from "../../../../services/planner.service";
import {Cohort} from "../cohort.interface";
import {CohortActions} from "../cohort.action";;
import {FlowState} from "../../../core/flow-state.enum";
import {MetaState} from "../../../core/meta-state.enum";
import {Store} from "@ngrx/store";
import {PlannerModuleState} from "../../index";
import {MdDialogRef} from "@angular/material";
import { create } from '@angular/language-service/language-service';

@Component({
  selector: 'pams-cohort-creator',
  templateUrl: './cohort-creator.dialog.html',
})

export class CohortCreatorDialog implements OnInit {

 private creatorForm: FormGroup;
  private create: boolean = false;
  private _cohort: Cohort;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: CohortActions,
              private dialog: MdDialogRef<CohortCreatorDialog>) {
  }


    set cohort(value: Cohort) {
        this._cohort = value;
        this.create = true;
    }

   ngOnInit(): void {
      this.creatorForm= this.formBuilder.group(<Cohort>{
       id: null,
       code: '',
       title: '',
       faculty:<Faculty>{},

     
     });

        if (this.create) this.creatorForm.patchValue(this._cohort);
  }
  
   save(code: Cohort, isValid: boolean) {

console.log(code.code);

        if (!code.id) this.store.dispatch(this.actions.saveCohort(code));
        else  this.store.dispatch(this.actions.updateCohort(code));
        this.dialog.close();
}
}
