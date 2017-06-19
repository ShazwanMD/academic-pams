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

    private editorForm: FormGroup;
    private edit: boolean = false;
    private _curriculum: Curriculum;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: CurriculumActions,
              private dialog: MdDialogRef<CurriculumEditorDialog>) {
  }

  ngOnInit(): void {
    this.editorForm = this.formBuilder.group(<Curriculum>{
      id:null,
      code:'',
      description:'',
      coreCredit: 0,
      curriculumCredit: 0,
      electiveCredit: 0,
      generalCredit: 0,
      languageCredit: 0,
      otherCredit: 0,
      requiredCredit: 0,
      totalCredit: 0,
      period: 0,
      maxPeriod: 0,
      ordinal:0,
      program: <Program>{},
      academicSession: <AcademicSession>{},
    });

    if (this.edit) this.editorForm.patchValue(this._curriculum);

  }

  save(curriculum: Curriculum, isValid: boolean): void {

 if (!curriculum.id) this.store.dispatch(this.actions.saveCurriculum(curriculum));
        else this.store.dispatch(this.actions.updateCurriculum(curriculum));
        this.dialog.close();
    
  }
}
