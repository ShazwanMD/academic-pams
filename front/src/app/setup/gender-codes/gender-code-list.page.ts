import {SetupActions} from './../setup.action';
import {Observable} from 'rxjs/Observable';
import {SetupModuleState} from './../index';
import {Store} from '@ngrx/store';
import {Component, OnInit} from '@angular/core';
import {GenderCode} from './../../common/gender-codes/gender-code.interface';


@Component({
  selector: 'pams-gender-list-page',
  templateUrl: './gender-code-list.page.html',
})
export class GenderCodeListPage implements OnInit {

  private GENDER_CODES = "setupModuleState.genderCodes".split(".");
  private genderCodes$: Observable<GenderCode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions) {
    this.genderCodes$ = this.store.select(...this.GENDER_CODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findGenderCodes());
    this.store.dispatch(this.actions.changeTitle("Gender Codes"))
  }

}


