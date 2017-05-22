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


@Component({
  selector: 'pams-cohort-update',
  templateUrl: './cohort-update.dialog.html',
})

export class CohortUpdateDialog implements OnInit {
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

 set cohort(value: Cohort) {
        this._cohort = value;
        this.update = true;
  }

     ngOnInit(): void {
      this.updateForm = this.formBuilder.group(<Cohort>{
       id: null,
       code: '',
       description:'',
     });
     
       if (this.update) this.updateForm.patchValue(this._cohort);
  }
     
      save(code: Cohort, isValid: boolean) {
        if (!code.id) this.store.dispatch(this.actions.saveCohort(code));
        else  this.store.dispatch(this.actions.updateCohort(code));
        this.dialog.close();
   
   }
}

