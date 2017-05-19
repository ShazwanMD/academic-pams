import {MdDialogRef} from '@angular/material';
import {MdDialogConfig} from '@angular/material';
import {MdDialog} from '@angular/material';
import {GradeCodeEditorDialog} from './dialog/grade-code-editor.dialog';
import {GradeCode} from './../../common/grade-codes/grade-code.interface';
import {Observable} from 'rxjs/Observable';
import {Store} from '@ngrx/store';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {SetupModuleState} from './../index';
import {SetupActions} from './../setup.action';

@Component({
  selector: 'pams-grade-list-page',
  templateUrl: './grade-code-list.page.html',
})
export class GradeCodeListPage implements OnInit {
  private GRADE_CODES: string[] = "setupModuleState.gradeCodes".split(".");
  private gradeCodes$: Observable<GradeCode>;
  private creatorDialogRef: MdDialogRef<GradeCodeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'ordinal', label: 'Ordinal'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.gradeCodes$ = this.store.select(...this.GRADE_CODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findGradeCodes());
    this.store.dispatch(this.actions.changeTitle("Grade Codes"))
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: GradeCode): void {
    this.showDialog(code);
  }

  delete(code: GradeCode): void {
    this.store.dispatch(this.actions.removeGradeCode(code))
  }

  filter(): void {
  }

  private showDialog(code: GradeCode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(GradeCodeEditorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.gradeCode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }
}
