import {StateCode} from '../../../shared/model/common/state-code.interface';
import {Observable} from 'rxjs/Observable';
import {Component, Input, OnInit} from '@angular/core';

import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';

@Component({
  selector: 'pams-state-code-select',
  templateUrl: './state-code-select.component.html',
})

export class StateCodeSelectComponent implements OnInit {

  private stateCodes$: Observable<StateCode[]>;
  private STATE_CODES: string[] = 'commonModuleState.stateCodes'.split('.');
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.stateCodes$ = this.store.select(...this.STATE_CODES);

  }

  ngOnInit() {
    this.store.dispatch(this.actions.findStateCodes());
  }

  selectChangeEvent(event: StateCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
