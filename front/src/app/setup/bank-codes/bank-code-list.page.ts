import {BankCode} from './../../common/bank-codes/bank-code.interface';
import {Component, OnInit} from '@angular/core';
import {Store} from '@ngrx/store';
import {SetupModuleState} from './../index';
import {SetupActions} from './../setup.action';
import {Observable} from 'rxjs/Observable';


@Component({
  selector: 'pams-bank-list-page',
  templateUrl: './bank-code-list.page.html',
})

export class BankCodeListPage implements OnInit {

  private BANK_CODES: string[] = "setupModuleState.bankCodes".split(".");
  private bankCodes$: Observable<BankCode>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions) {
    this.bankCodes$ = this.store.select(...this.BANK_CODES);
  }

  ngOnInit() {
    // this.store.dispatch(this.actions.findBankCodes());
    this.store.dispatch(this.actions.changeTitle("Bank Codes"))

  }

  filter(): void {
  }
}
