import { Component, OnInit, ViewContainerRef } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import { MdDialogRef } from '@angular/material';
import { MdDialogConfig } from '@angular/material';
import { MdDialog } from '@angular/material';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";

import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import { AcademicSession } from './academic-session.interface';
import {AcademicSessionActions} from "./academic-session.action";
import {PlannerModuleState} from "../index";
import { AcademicSessionEditorDialog } from './dialog/academic-session-editor.dialog';

@Component({
  selector: 'pams-academic-session-center',
  templateUrl: './academic-session-center.page.html',
})
export class AcademicSessionCenterPage implements OnInit {

  private ACADEMIC_SESSIONS = "plannerModuleState.academicSessions".split(".");
  private academicSessions$: Observable<AcademicSession[]>;

  private creatorDialogRef: MdDialogRef<AcademicSessionEditorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AcademicSessionActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog ) {
    this.academicSessions$ = this.store.select(...this.ACADEMIC_SESSIONS);
  }

  ngOnInit(): void {
    console.log("find academicSessions");
    this.store.dispatch(this.actions.findAcademicSessions());
  }

    createDialog(): void {
    this.showDialog(null);
  }

  filter():void{}

   private showDialog(code:AcademicSession): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AcademicSessionEditorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.academicSession = code; 
    // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
   }

  goBack(route: string): void {
    this.router.navigate(['/academic-sessions']);
  }

  viewAcademicSession(academicSession: AcademicSession) {
    console.log("academicSession: " + academicSession.code);
    this.router.navigate(['/academic-session-detail', academicSession.code]);
  }
}


