import {NationalityCodeEditorDialog} from './dialog/nationality-code-editor.dialog';
import {NationalityCode} from './../../common/nationality-codes/nationality-code.interface';
import {Observable} from 'rxjs/Observable';
import {Store} from '@ngrx/store';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {SetupModuleState} from './../index';
import {SetupActions} from './../setup.action';
import {MdDialog, MdDialogRef, MdDialogConfig} from '@angular/material';

@Component({
  selector: 'pams-nationality-list-page',
  templateUrl: './nationality-code-list.page.html',
})
export class NationalityCodeListPage implements OnInit {
  private NATIONALITY_CODES: string[] = "setupModuleState.nationalityCodes".split(".");
  private nationalityCodes$: Observable<NationalityCode>;
  private creatorDialogRef: MdDialogRef<NationalityCodeEditorDialog>;

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionMs', label: 'DescriptionMs'},
    {name: 'descriptionEn', label: 'DescriptionEn'},
    {name: 'action', label: ''}
  ];

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.nationalityCodes$ = this.store.select(...this.NATIONALITY_CODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findNationalityCodes());
    this.store.dispatch(this.actions.changeTitle("Nationality Codes"))
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: NationalityCode): void {
    this.showDialog(code);
  }

  delete(code: NationalityCode): void {
    this.store.dispatch(this.actions.removeNationalityCode(code))
  }

  filter(): void {
  }

  private showDialog(code: NationalityCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(NationalityCodeEditorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.nationalityCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }


}
