import {StudyCenterEditorDialog} from './dialog/study-center-editor.dialog';
import {Store} from '@ngrx/store';
import {StudyCenter} from './study-center.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {SetupActions} from '../setup.action';
import {Observable} from 'rxjs/Observable';
import {SetupModuleState} from '../index';
import {Component, OnInit, ViewContainerRef} from '@angular/core';


@Component({
  selector: 'pams-study-center-list-page',
  templateUrl: './study-center-list.page.html',
})
export class StudyCenterListPage implements OnInit {

  private STUDY_CENTERS: string[] = "setupModuleState.studyCenters".split(".");
  private studyCenters$: Observable<StudyCenter>;
  private creatorDialogRef: MdDialogRef<StudyCenterEditorDialog>;

  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.studyCenters$ = this.store.select(...this.STUDY_CENTERS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findStudyCenters());
    this.store.dispatch(this.actions.changeTitle("Study Centers"))
  }

  createDialog(): void {
    this.showDialog(null);
  }

  editDialog(code: StudyCenter): void {
    this.showDialog(code);
  }

  delete(code: StudyCenter): void {
    this.store.dispatch(this.actions.removeStudyCenter(code))
  }

  filter(): void {
  }

  private showDialog(code: StudyCenter): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '65%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(StudyCenterEditorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.studyCenter = code; // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

}
