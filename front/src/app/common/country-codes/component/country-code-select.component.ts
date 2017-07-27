import {Observable} from 'rxjs/Observable';
import {Component, Input, OnInit} from '@angular/core';

import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {CommonActions} from '../../common.action';
import {CommonModuleState} from '../../index';
import {CountryCode} from '../../../shared/model/common/country-code.interface';

@Component({
  selector: 'pams-country-code-select',
  templateUrl: './country-code-select.component.html',
})

export class CountryCodeSelectComponent implements OnInit {

  private COUNTRY_CODES: string[] = 'commonModuleState.countryCodes'.split('.');
  private countryCodes$: Observable<CountryCode[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<CommonModuleState>,
              private actions: CommonActions) {
    this.countryCodes$ = this.store.select(...this.COUNTRY_CODES);

  }

  ngOnInit() {
    this.store.dispatch(this.actions.findCountryCodes());
  }

  selectChangeEvent(event: CountryCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
