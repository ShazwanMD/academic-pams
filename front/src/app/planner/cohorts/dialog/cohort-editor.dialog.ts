import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {CommonService} from "../../../../services/common.service";
import {PlannerService} from "../../../../services/planner.service";
import {Cohort} from "../cohort.interface";
import {CohortActions} from "../cohort.action";
;
import {Store} from "@ngrx/store";
import {PlannerModuleState} from "../../index";
import {MdDialogRef} from "@angular/material";
import {AcademicSession} from "../../../planner/academic-sessions/academic-session.interface";
import {Program} from './../../programs/program.interface';
import {MdDialog} from '@angular/material';
import {IdentityService} from "../../../../services/identity.service";

@Component({
  selector: 'pams-cohort-editor',
  templateUrl: './cohort-editor.dialog.html',
})

export class CohortEditorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: CohortActions,
              private dialog: MdDialogRef<CohortEditorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Cohort>{
      program: <Program>{},
      academicSession: <AcademicSession>{},
    });
  }

  save(cohort: Cohort, isValid: boolean) {
    this.store.dispatch(this.actions.saveCohort(cohort));
    this.dialog.close();
  }
}
