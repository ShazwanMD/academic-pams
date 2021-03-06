import {GradeCode} from '../../../shared/model/common/grade-code.interface';
import {Observable} from 'rxjs/Observable';
import {Component, Input, OnInit} from '@angular/core';

import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';

@Component({
  selector: 'pams-grade-code-select',
  templateUrl: './grade-code-select.component.html',
})

export class GradeCodeSelectComponent implements OnInit {

  private GRADE_CODE: string[] = 'commonModuleState.gradeCodes'.split('.');
  private gradeCodes$: Observable<GradeCode[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.gradeCodes$ = this.store.select(...this.GRADE_CODE);

  }

  ngOnInit() {
    this.store.dispatch(this.actions.findGradeCodes());
  }

  selectChangeEvent(event: GradeCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
