import {EthnicityCode} from '../../../shared/model/common/ethnicity-code.interface';
import {Observable} from 'rxjs/Observable';
import {Component, Input, OnInit} from '@angular/core';

import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';

@Component({
  selector: 'pams-ethnicity-code-select',
  templateUrl: './ethnicity-code-select.component.html',
})

export class EthnicityCodeSelectComponent implements OnInit {

  private ETHNICITY_CODE: string[] = 'commonModuleState.ethnicityCodes'.split('.');
  private ethnicityCodes$: Observable<EthnicityCode[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.ethnicityCodes$ = this.store.select(...this.ETHNICITY_CODE);

  }

  ngOnInit() {
    this.store.dispatch(this.actions.findEthnicityCodes());
  }

  selectChangeEvent(event: EthnicityCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
