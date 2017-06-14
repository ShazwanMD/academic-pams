import {Component, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Curriculum} from '../curriculum.interface';
import {CurriculumActions} from '../curriculum.action';
;
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../../index';
import {MdDialogRef} from '@angular/material';
import {AcademicSession} from '../../academic-sessions/academic-session.interface';
import {Program} from '../../programs/program.interface';

@Component({
  selector: 'pams-curriculum-editor',
  templateUrl: './curriculum-editor.dialog.html',
})

export class CurriculumEditorDialog implements OnInit {

  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: CurriculumActions,
              private dialog: MdDialogRef<CurriculumEditorDialog>) {
  }

  ngOnInit(): void {
    this.createForm = this.formBuilder.group(<Curriculum>{
      program: <Program>{},
      academicSession: <AcademicSession>{},
    });
  }

  save(curriculum: Curriculum, isValid: boolean): void {
    this.store.dispatch(this.actions.saveCurriculum(curriculum));
    this.dialog.close();
  }
}
