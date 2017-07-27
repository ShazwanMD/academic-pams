import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { MdDialogRef } from '@angular/material';
import { MdDialogConfig } from '@angular/material';
import { MdDialog } from '@angular/material';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';

import { ProgramLevel } from '../../shared/model/planner/program-level.interface';
import { ProgramLevelActions } from './program-level.action';
import { PlannerModuleState } from '../index';
import { ProgramLevelCreatorDialog } from './dialog/program-level-creator.dialog';

@Component({
  selector: 'pams-program-level-center',
  templateUrl: './program-level-center.page.html',
})
export class ProgramLevelCenterPage implements OnInit {

  private PROGRAM_LEVELS: string[] = 'plannerModuleState.programLevels'.split('.');
  private programLevels$: Observable<ProgramLevel[]>;

  private creatorDialogRef: MdDialogRef<ProgramLevelCreatorDialog>;
  private columns: any[] = [
    { name: 'code', label: 'Code' },
    { name: 'description', label: 'Description' },
    { name: 'current', label: 'Current' },
    { name: 'startDate', label: 'Start Date' },
    { name: 'endDate', label: 'End Date' },
    { name: 'semester', label: 'ProgramSemester' },
    { name: 'year', label: 'ProgramYear' },
    { name: 'action', label: '' },
  ];

  constructor(private router: Router,
    private route: ActivatedRoute,
    private actions: ProgramLevelActions,
    private store: Store<PlannerModuleState>,
    private vcf: ViewContainerRef,
    private dialog: MdDialog) {
    this.programLevels$ = this.store.select(...this.PROGRAM_LEVELS);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findProgramLevels());
  }

  viewProgramLevel(programLevel: ProgramLevel) {
    console.log('programLevel: ' + programLevel.code);
    this.router.navigate(['/program-level-detail', programLevel.code]);
  }

  createDialog(): void {
    this.showDialog(null);
  }

  filter(): void{

  }

  private showDialog(code: ProgramLevel): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '65%';
    config.height = '90%';
    config.position =  {top: '0px'};
    this.creatorDialogRef = this.dialog.open(ProgramLevelCreatorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.programLevel = code;

    //set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log ('close dialog');
    });
  }
}

