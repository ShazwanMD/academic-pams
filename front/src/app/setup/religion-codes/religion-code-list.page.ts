import { ReligionCodeEditorDialog } from './dialog/religion-code-editor.dialog';
import { MdDialog, MdDialogRef, MdDialogConfig } from '@angular/material';
import { ReligionCode } from './../../common/religion-codes/religion-code.interface';
import { Observable } from 'rxjs/Observable';
import { Store } from '@ngrx/store';
import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { SetupModuleState } from './../index';
import { SetupActions } from './../setup.action';


@Component({
selector: 'pams-religion-list-page',
templateUrl: './religion-code-list.page.html',
})
export class ReligionCodeListPage implements OnInit {
    private RELIGION_CODES = "setupModuleState.religionCodes".split(".");
    private religionCodes$: Observable<ReligionCode>;
    private creatorDialogRef: MdDialogRef<ReligionCodeEditorDialog>;
    private columns: any[] =[
        {name: 'code', label:'Code'},
        {name: 'descriptionMs', label:'DescriptionMs'},
        {name: 'descriptionEn', label:'DescriptionEn'},
        {name:'action', label:''}
    ];

    constructor(private store: Store<SetupModuleState>,
                private actions: SetupActions,
                private vcf: ViewContainerRef,
                private dialog: MdDialog){
                    this.religionCodes$ = this.store.select(...this.RELIGION_CODES);
                }

                ngOnInit() {
                    this.store.dispatch(this.actions.findReligionCodes());
                    this.store.dispatch(this.actions.changeTitle("Religion Codes"))
                }
  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code:ReligionCode): void {
    this.showDialog(code);
  }

  delete(code: ReligionCode): void {
    this.store.dispatch(this.actions.removeReligionCode(code))
  }

  filter():void{}

  private showDialog(code:ReligionCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(ReligionCodeEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.religionCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

}