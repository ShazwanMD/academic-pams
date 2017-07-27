import {DunCode} from '../../shared/model/common/dun-code.interface';
import {Observable} from 'rxjs/Observable';
import {Store} from '@ngrx/store';
import {Component, OnInit} from '@angular/core';
import {SetupModuleState} from './../index';
import {SetupActions} from './../setup.action';

@Component({
  selector: 'pams-dun-list-page',
  templateUrl: './dun-code-list.page.html',
})
export class DunCodeListPage implements OnInit {
  private DUN_CODES: string[] = "setupModuleState.dunCodes".split(".");
  private dunCodes$: Observable<DunCode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions) {
    this.dunCodes$ = this.store.select(...this.DUN_CODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findDunCodes());
    this.store.dispatch(this.actions.changeTitle("Dun Codes"))
  }

  filter(): void {
  }
}
