import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output, ViewContainerRef, OnInit} from '@angular/core';
import {MdDialogRef, MdDialog, MdDialogConfig} from '@angular/material';
import {ProgramLevel} from '../../../../shared/model/planner/program-level.interface';
import {ProgramLevelEditorDialog} from '../dialog/program-level-editor.dialog';
import {Router, ActivatedRoute} from '@angular/router';
import {ProgramLevelActions} from '../program-level.action';
import {PlannerModuleState} from '../../index';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'pams-program-level',
  templateUrl: './program-level.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramLevelComponent implements OnInit {

  private editorDialogRef: MdDialogRef<ProgramLevelEditorDialog>;
  private PROGRAM_LEVEL: string[] = 'plannerModuleState.programLevel'.split('.');
  private programLevel$: Observable<ProgramLevel>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''},
  ];

  @Input() programLevel: ProgramLevel;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  @Output() view = new EventEmitter<ProgramLevel>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProgramLevelActions,
              private vcf: ViewContainerRef,
              private store: Store<PlannerModuleState>,
              private dialog: MdDialog) {
    this.programLevel$ = this.store.select(...this.PROGRAM_LEVEL);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findProgramLevelByCode(code));
    });
  }

  editLevel(): void {
    console.log('edit');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(ProgramLevelEditorDialog, config);
    this.editorDialogRef.componentInstance.programLevel = this.programLevel;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

  selectChangeEvent(event: ProgramLevel) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }

}
