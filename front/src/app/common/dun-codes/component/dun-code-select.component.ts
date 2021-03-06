import {DunCode} from '../../../shared/model/common/dun-code.interface';
import {Observable} from 'rxjs/Observable';
import {Component, Input, OnInit} from '@angular/core';

import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';

@Component({
  selector: 'pams-dun-code-select',
  templateUrl: './dun-code-select.component.html',
})

export class DunCodeSelectComponent implements OnInit {

  private DUN_CODE: string[] = 'commonModuleState.dunCodes'.split('.');
  private dunCodes$: Observable<DunCode[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.dunCodes$ = this.store.select(...this.DUN_CODE);

  }

  ngOnInit() {
    this.store.dispatch(this.actions.findDunCodes());
  }

  selectChangeEvent(event: DunCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
