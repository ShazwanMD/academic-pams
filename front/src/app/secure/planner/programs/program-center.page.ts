import {ActivatedRoute, Router} from '@angular/router';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Program} from '../../../shared/model/planner/program.interface';
import {ProgramActions} from './program.action';
import {PlannerModuleState} from '../index';
import {ProgramCreatorDialog} from './dialog/program-creator.dialog';

@Component({
  selector: 'pams-program-center',
  templateUrl: './program-center.page.html',
})

export class ProgramCenterPage implements OnInit {

  private PROGRAMS: string[] = 'plannerModuleState.programs'.split('.');
  private programs$: Observable<Program[]>;
  private creatorDialogRef: MdDialogRef<ProgramCreatorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'titleMs', label: 'TitleMs'},
    {name: 'titleEn', label: 'TitleEn'},
    {name: 'status', label: 'Status'},
    {name: 'action', label: ''},
  ];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProgramActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.programs$ = this.store.select(...this.PROGRAMS);
  }

  viewProgram(program: Program) {
    console.log('program: ' + program.code);
    this.router.navigate(['/programs-detail', program.code]);
  }

  ngOnInit(): void {
    console.log('find programs');
    this.store.dispatch(this.actions.findPrograms());
  }

  createDialog(): void {
    this.showDialog(null);
  }

  private showDialog(code: Program): void {
    console.log('save');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '70';
    config.position = {top: '1px'};
    this.creatorDialogRef = this.dialog.open(ProgramCreatorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.program = code;

    //set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/programs']);
  }

  filter(): void {
  }

}

