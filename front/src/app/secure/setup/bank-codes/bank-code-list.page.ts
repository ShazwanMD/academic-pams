import { BankCode } from '../../../shared/model/common/bank-code.interface';
import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Store } from '@ngrx/store';
import { SetupModuleState } from '../index';
import { SetupActions } from '../setup.action';
import { Observable } from 'rxjs/Observable';
import { MdDialogRef, MdDialogConfig, MdDialog } from '@angular/material';
import { BankCodeEditorDialog } from './dialog/bank-code-editor.dialog';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'pams-bank-list-page',
  templateUrl: './bank-code-list.page.html',
})

export class BankCodeListPage implements OnInit {

  private BANK_CODES: string[] = "setupModuleState.bankCodes".split(".");
  private bankCodes$: Observable<BankCode>;
  private creatorDialogRef: MdDialogRef<BankCodeEditorDialog>;

  private columns: any[] = [
    { name: 'code', label: 'Code' },
    { name: 'name', label: 'Name' },
    { name: 'action', label: '' }
  ];

  constructor(private store: Store<SetupModuleState>,
    private actions: SetupActions,
    private vcf: ViewContainerRef,
    private router: Router,
    private route: ActivatedRoute,
    private dialog: MdDialog) {
    this.bankCodes$ = this.store.select(...this.BANK_CODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findBankCodes());
    this.store.dispatch(this.actions.changeTitle("Bank Codes"))

  }

  filter(): void {
  }


  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(bankCode: BankCode): void {
    this.showDialog(bankCode);
  }

  private showDialog(bankCode: BankCode): void {
    console.log("create Bank Code");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = { top: '0px' };
    this.creatorDialogRef = this.dialog.open(BankCodeEditorDialog, config);
    if (bankCode) this.creatorDialogRef.componentInstance.bankCode = bankCode; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

  delete( bankCode: BankCode ): void {
    var txt;
    var r = confirm( "Are you sure to delete this data?" );
    if ( r == true ) {
        txt = "Data has been deleted!";
        this.store.dispatch( this.actions.removeBankCode(bankCode))
    } else {
        txt = "Cancel delete!";
    }

}


}
