import {StudyMode} from '../../../shared/model/common/study-mode.interface';
import {StudyModeEditorDialog} from './dialog/study-mode-editor.dialog';
import {MdDialog, MdDialogRef, MdDialogConfig} from '@angular/material';
import {Observable} from 'rxjs/Observable';
import {Store} from '@ngrx/store';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {SetupModuleState} from '../index';
import {SetupActions} from '../setup.action';


@Component({
  selector: 'pams-study-mode-list-page',
  templateUrl: './study-mode-list.page.html',
})
export class StudyModeListPage implements OnInit {
  private STUDY_MODES: string[] = "setupModuleState.studyModes".split(".");
  private studyModes$: Observable<StudyMode>;
  private creatorDialogRef: MdDialogRef<StudyModeEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'prefix', label: 'Prefix'},
    {name: 'action', label: ''}
  ];

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.studyModes$ = this.store.select(...this.STUDY_MODES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findStudyModes());
    this.store.dispatch(this.actions.changeTitle("Study Modes"))
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: StudyMode): void {
    this.showDialog(code);
  }

  delete(code: StudyMode): void {
    this.store.dispatch(this.actions.removeStudyMode(code))
  }

  filter(): void {
  }

  private showDialog(code: StudyMode): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(StudyModeEditorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.studyMode = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

}
