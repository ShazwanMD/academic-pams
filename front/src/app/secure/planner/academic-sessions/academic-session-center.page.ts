import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';

import {AcademicSession} from '../../../shared/model/planner/academic-session.interface';
import {AcademicSessionActions} from './academic-session.action';
import {PlannerModuleState} from '../index';
import {AcademicSessionCreatorDialog} from './dialog/academic-session-creator.dialog';

@Component({
  selector: 'pams-academic-session-center',
  templateUrl: './academic-session-center.page.html',
})
export class AcademicSessionCenterPage implements OnInit {

  private ACADEMIC_SESSIONS: string[] = 'plannerModuleState.academicSessions'.split('.');
  private academicSessions$: Observable<AcademicSession[]>;
  private creatorDialogRef: MdDialogRef<AcademicSessionCreatorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'current', label: 'Current'},
    {name: 'startDate', label: 'Start Date'},
    {name: 'endDate', label: 'End Date'},
    {name: 'semester', label: 'AcademicSemester'},
    {name: 'year', label: 'AcademicYear'},
    {name: 'action', label: ''},
  ];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AcademicSessionActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.academicSessions$ = this.store.select(...this.ACADEMIC_SESSIONS);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findAcademicSessions());
  }

  viewAcademicSession(academicSession: AcademicSession) {
    console.log('academicSession: ' + academicSession.code);
    this.router.navigate(['/academic-session-detail', academicSession.code]);
  }

  createDialog(): void {
    this.showDialog(null);
  }

  filter(): void {

  }

  private showDialog(code: AcademicSession): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '65%';
    config.height = '90%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AcademicSessionCreatorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.academicSession = code;

    this.creatorDialogRef.afterClosed().subscribe((res) => {
      // console.log ("close dialog");
    });
  }
}

