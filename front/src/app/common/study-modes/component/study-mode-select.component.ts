import {StudyMode} from './../study-mode.interface';
import {Observable} from 'rxjs/Observable';
import {Component, Input, OnInit} from '@angular/core';

import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from './../../gender-codes/common.action';
import {CommonModuleState} from './../../index';


@Component({
  selector: 'pams-study-mode-select',
  templateUrl: './study-mode-select.component.html',
})

export class StudyModeSelectComponent implements OnInit {

  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  private STUDY_MODES: string[] = "commonModuleState.studyModes".split(".");
  studyModes$: Observable<StudyMode[]>;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.studyModes$ = this.store.select(...this.STUDY_MODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findStudyModes());
  }

  selectChangeEvent(event: StudyMode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
