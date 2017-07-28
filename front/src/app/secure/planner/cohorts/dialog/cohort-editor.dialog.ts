import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Cohort} from '../../../../shared/model/planner/cohort.interface';
import {CohortActions} from '../cohort.action';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../../index';
import {MdDialogRef} from '@angular/material';
;

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
    this.createForm = this.formBuilder.group({
      id: [undefined],
      program: ['', Validators.required],
      academicSession: ['', Validators.required],
    });
  }

  save(cohort: Cohort, isValid: boolean): void {
    this.store.dispatch(this.actions.saveCohort(cohort));
    this.dialog.close();
  }
}
