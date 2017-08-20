import {MdSnackBar} from '@angular/material/snack-bar';
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import {Program} from '../../../../shared/model/planner/program.interface';
import {Curriculum} from '../../../../shared/model/planner/curriculum.interface';
import {Component, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';

import {CurriculumActions} from '../curriculum.action';
;
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../../index';
import {MdDialogRef} from '@angular/material';


@Component({
  selector: 'pams-curriculum-editor',
  templateUrl: './curriculum-editor.dialog.html',
})

export class CurriculumEditorDialog implements OnInit {

    private editorForm: FormGroup;
    private edit: boolean = false;
    private curriculum: Curriculum;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private snackBar: MdSnackBar,
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

    if (this.edit) this.editorForm.patchValue(this.curriculum);

  }

  save(curriculum: Curriculum, isValid: boolean): void {

 if (!curriculum.id) this.store.dispatch(this.actions.saveCurriculum(curriculum));
        else this.store.dispatch(this.actions.updateCurriculum(curriculum));
        this.dialog.close();

         let snackBarRef = this.snackBar.open( 'New assessment: ' + curriculum.code + ' has been inserted', '', { duration: 3000 } );
         snackBarRef.afterDismissed().subscribe(() => {
       } );
  }
}
