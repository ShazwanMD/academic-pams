import {ReligionCode} from '../../../shared/model/common/religion-code.interface';
import {Observable} from 'rxjs/Observable';
import {Component, Input, OnInit} from '@angular/core';

import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';

@Component({
  selector: 'pams-religion-code-select',
  templateUrl: './religion-code-select.component.html',
})

export class ReligionCodeSelectComponent implements OnInit {

  private RELIGION_CODE: string[] = 'commonModuleState.religionCodes'.split('.');
  private religionCodes$: Observable<ReligionCode[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.religionCodes$ = this.store.select(...this.RELIGION_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findReligionCodes());
  }

  selectChangeEvent(event: ReligionCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
