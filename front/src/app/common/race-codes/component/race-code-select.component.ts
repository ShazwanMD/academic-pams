import {RaceCode} from '../../../shared/model/common/race-code.interface';
import {Observable} from 'rxjs/Observable';
import {Component, Input, OnInit} from '@angular/core';

import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';

@Component({
  selector: 'pams-race-code-select',
  templateUrl: './race-code-select.component.html',
})

export class RaceCodeSelectComponent implements OnInit {

  private RACE_CODE: string[] = 'commonModuleState.raceCodes'.split('.');
  private raceCodes$: Observable<RaceCode[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.raceCodes$ = this.store.select(...this.RACE_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findRaceCodes());
  }

  selectChangeEvent(event: RaceCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
