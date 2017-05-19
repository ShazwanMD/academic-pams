import {CountryCode} from './../../common/country-codes/country-code.interface';
import {MdDialog, MdDialogRef, MdDialogConfig} from '@angular/material';
import {StateCodeEditorDialog} from './dialog/state-code-editor.dialog';
import {Observable} from 'rxjs/Observable';
import {Store} from '@ngrx/store';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {SetupModuleState} from './../index';
import {SetupActions} from './../setup.action';
import {StateCode} from './../../common/state-codes/state-code.interface';


@Component({
  selector: 'pams-state-list-page',
  templateUrl: './state-code-list.page.html',
})
export class StateCodeListPage implements OnInit {
  private STATE_CODES: string[] = "setupModuleState.stateCodes".split(".");
  private COUNTRY_CODES: string[] = "setupModuleState.countryCodes".split(".");
  private stateCodes$: Observable<StateCode>;
  private creatorDialogRef: MdDialogRef<StateCodeEditorDialog>;

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.stateCodes$ = this.store.select(...this.STATE_CODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findStateCodes());
    this.store.dispatch(this.actions.changeTitle("State Codes"))
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: StateCode): void {
    this.showDialog(code);
  }

  delete(code: StateCode): void {
    this.store.dispatch(this.actions.removeStateCode(code))
  }


  filter(filter: string): void {
    console.log("filter");
  }


  private showDialog(code: StateCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(StateCodeEditorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.stateCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

}
