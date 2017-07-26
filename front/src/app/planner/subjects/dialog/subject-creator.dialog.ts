import {SubjectType} from '../subject-type.enum';
import {Curriculum} from '../../curriculums/curriculum.interface';
import {Subject} from '../../curriculums/subject.interface';
import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {SubjectActions} from '../subject.action';
import {Store} from '@ngrx/store';
import {PlannerModuleState} from '../../index';
import {MdDialogRef} from '@angular/material';

@Component({
  selector: 'pams-subject-creator',
  templateUrl: './subject-creator.dialog.html',
})

export class SubjectCreatorDialog implements OnInit {

  private creatorForm: FormGroup;
  private create: boolean = false;
  private _subject: Subject;
  private _curriculum: Curriculum;

  constructor(private formBuilder: FormBuilder,
              private store: Store<PlannerModuleState>,
              private actions: SubjectActions,
              private router: Router,
              private route: ActivatedRoute,
              private viewContainerRef: ViewContainerRef,
              private dialog: MdDialogRef<SubjectCreatorDialog>) {
  }

  set curriculum(value: Curriculum) {
    this._curriculum = value;
  }

  set subject(value: Subject) {
    this._subject = value;
    this.create = true;
  }

  ngOnInit(): void {
    this.creatorForm = this.formBuilder.group({
      id: undefined,
      ordinal: 0,
      subjectType: SubjectType.CORE,
      curriculum: <Curriculum>{},
    });

    this.creatorForm.patchValue({'curriculum': this._curriculum});
    if (this.create) this.creatorForm.patchValue(this._subject);
  }
    

  // submit(subject: Subject, isValid: boolean): void {
  //   console.log('adding Subject');
  //   if (!subject.id) this.store.dispatch(this.actions.addSubject(this._curriculum, subject));
  //   else this.store.dispatch(this.actions.updateSubject(subject));
  //   this.dialog.close();
  //   console.log(subject);
  // }

}
