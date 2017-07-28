import {Faculty} from '../../../../shared/model/planner/faculty.interface';
import {Router, ActivatedRoute} from '@angular/router';
import {FormBuilder} from '@angular/forms';
import {PlannerModuleState} from '../../index';
import {Store} from '@ngrx/store';
import {ProgramActions} from '../program.action';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Program} from '../../../../shared/model/planner/program.interface';
import {ProgramCreatorDialog} from '../dialog/program-creator.dialog';

import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';

@Component({
  selector: 'pams-program',
  templateUrl: './program.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ProgramComponent {

  private creatorDialogRef: MdDialogRef<ProgramCreatorDialog>;
  @Input() program: Program;
  @Output() view = new EventEmitter<Program>();

  constructor(private actions: ProgramActions,
              private formBuilder: FormBuilder,
              private router: Router,
              private route: ActivatedRoute,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,) {

  }

  saveProgramDialog(program: Program, faculty: Faculty): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(ProgramCreatorDialog, config);
    // this.creatorDialogRef.componentInstance._program= this.program;
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  removeProgram(program: Program): void {
    this.store.dispatch(this.actions.removeProgram(this.program));
    console.log('deleteProgram:{}', program);
  }
}
