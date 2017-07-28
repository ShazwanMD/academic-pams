import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {MaritalCodeEditorDialog} from './dialog/marital-code-editor.dialog';
import {MaritalCode} from './marital-code.interface';
import {SetupActions} from '../setup.action';
import {Observable} from 'rxjs/Observable';
import {SetupModuleState} from '../index';
import {Store} from '@ngrx/store';
import {Component, OnInit, ViewContainerRef} from '@angular/core';


@Component({
  selector: 'pams-marital-list-page',
  templateUrl: './marital-code-list.page.html',
})
export class MaritalCodeListPage implements OnInit {

  private MARITAL_CODES: string[] = "setupModuleState.maritalCodes".split(".");
  private maritalCodes$: Observable<MaritalCode>;
  private creatorDialogRef: MdDialogRef<MaritalCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'descriptionEn', label: 'DescriptionEN'},
    {name: 'descriptionMs', label: 'DescriptionMS'},
    {name: 'action', label: ''}
  ];

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.maritalCodes$ = this.store.select(...this.MARITAL_CODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findMaritalCodes());
    this.store.dispatch(this.actions.changeTitle("Marital Codes"))
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: MaritalCode): void {
    this.showDialog(code);
  }

  delete(code: MaritalCode): void {
    this.store.dispatch(this.actions.removeMaritalCode(code))
  }

  filter(): void {
  }

  private showDialog(code: MaritalCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(MaritalCodeEditorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.maritalCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

}


