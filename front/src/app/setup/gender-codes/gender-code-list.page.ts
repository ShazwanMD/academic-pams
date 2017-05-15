import { MdDialog, MdDialogConfig, MdDialogRef } from '@angular/material';
import { GenderCodeEditorDialog } from './dialog/gender-code-editor.dialog';
import { SetupActions } from './../setup.action';
import { Observable } from 'rxjs/Observable';
import { SetupModuleState } from './../index';
import { Store } from '@ngrx/store';
import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { GenderCode } from './../../common/gender-codes/gender-code.interface';


@Component({
  selector: 'pams-gender-list-page',
  templateUrl: './gender-code-list.page.html',
})
export class GenderCodeListPage implements OnInit {

  private GENDER_CODES = "setupModuleState.genderCodes".split(".");
  private genderCodes$: Observable<GenderCode>;
  private creatorDialogRef: MdDialogRef<GenderCodeEditorDialog>;
  private columns: any[] = [
    { name: 'code', label: 'Code' },
    { name: 'description', label: 'Description' },
    { name: 'action', label: '' }
  ];

  constructor(private store: Store<SetupModuleState>,
    private actions: SetupActions,
    private vcf: ViewContainerRef,
    private dialog: MdDialog) {
    this.genderCodes$ = this.store.select(...this.GENDER_CODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findGenderCodes());
    this.store.dispatch(this.actions.changeTitle("Gender Codes"))
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: GenderCode): void {
    this.showDialog(code);
  }

  delete(code: GenderCode): void {
    this.store.dispatch(this.actions.removeGenderCode(code))
  }

  filter(): void { }

  private showDialog(code: GenderCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = { top: '0px' };
    this.creatorDialogRef = this.dialog.open(GenderCodeEditorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.genderCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }


}


