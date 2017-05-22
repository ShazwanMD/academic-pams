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
  selector: 'pams-cohort-editor',
  templateUrl: './cohort-editor.dialog.html',
})

export class CohortEditorDialog implements OnInit {

  private _cohort: Cohort;
  private editForm: FormGroup;
  private edit: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private actions: CohortActions,
              private store: Store<PlannerModuleState>,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<CohortEditorDialog >) {
            
  }

 set academicSession(value: Cohort) {
        this._cohort = value;
        this.edit = true;
  }

  //  openDialog(): void {

  //     this.dialog.open(CohortEditorDialog, {
  //       height: '50%', // can be px or %
  //       width: '60%', // can be px or %
  //     });
  //   }

     ngOnInit(): void {
    this.editForm = this.formBuilder.group(<Cohort>{
    id: null,
    code: '',
    description: '', 
     });
     
       if (this.edit) this.editForm.patchValue(this._cohort);
  }
     
      submit(code: Cohort, isValid: boolean) {
        if (!code.id) this.store.dispatch(this.actions.saveCohort(code));
        else  this.store.dispatch(this.actions.updateCohort(code));
        this.dialog.close();
   
   }
}

