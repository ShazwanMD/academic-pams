import {Component, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {FormBuilder, Validators} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Cohort} from '../cohort.interface';
import {CohortActions} from '../cohort.action';
;
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../../index';
import {MdDialogRef} from '@angular/material';
import {AcademicSession} from '../../academic-sessions/academic-session.interface';
import {Program} from '../../programs/program.interface';

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
