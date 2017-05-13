import {MaritalCode} from './marital-code.interface';
import {SetupActions} from './../setup.action';
import {Observable} from 'rxjs/Observable';
import {SetupModuleState} from './../index';
import {Store} from '@ngrx/store';
import {Component, OnInit} from '@angular/core';


@Component({
  selector: 'pams-marital-list-page',
  templateUrl: './marital-code-list.page.html',
})
export class MaritalCodeListPage implements OnInit {

  private MARITAL_CODES = "setupModuleState.maritalCodes".split(".");
  private maritalCodes$: Observable<MaritalCode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionEn', label: 'DescriptionEN'},
    {name: 'descriptionMs', label: 'DescriptionMS'},
    {name: 'action', label: ''}
  ];

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions) {
    this.maritalCodes$ = this.store.select(...this.MARITAL_CODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findMaritalCodes());
    this.store.dispatch(this.actions.changeTitle("Marital Codes"))
  }

  filter():void{}

}


