import {CountryCode} from './../../common/country-codes/country-code.interface';
import {Component, OnInit} from '@angular/core';
import {Store} from '@ngrx/store';
import {SetupModuleState} from './../index';
import {SetupActions} from './../setup.action';
import {Observable} from 'rxjs/Observable';


@Component({
  selector: 'pams-country-list-page',
  templateUrl: './country-code-list.page.html',
})

export class CountryCodeListPage implements OnInit {

  private COUNTRY_CODES: string[] = "setupModuleState.countryCodes".split(".");
  private countryCodes$: Observable<CountryCode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions) {
    this.countryCodes$ = this.store.select(...this.COUNTRY_CODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findCountryCodes());
    this.store.dispatch(this.actions.changeTitle("Country Codes"))

  }

  filter(): void {
  }
}
