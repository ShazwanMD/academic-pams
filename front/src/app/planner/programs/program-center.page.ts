import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { MdDialogRef } from '@angular/material';
import { MdDialogConfig } from '@angular/material';
import { MdDialog } from '@angular/material';
import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Program} from "./program.interface";
import {ProgramActions} from "./program.action";
import {PlannerModuleState} from "../index";
import { ProgramCreatorDialog } from './dialog/program-creator.dialog';


@Component({
  selector: 'pams-program-center',
  templateUrl: './program-center.page.html',
})

export class ProgramCenterPage implements OnInit {

  private PROGRAMS = "plannerModuleState.programs".split(".");
  private programs$: Observable<Program[]>;

   private creatorDialogRef: MdDialogRef<ProgramCreatorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'title', label: 'Title'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''}
  ];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: ProgramActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog ) {
    this.programs$ = this.store.select(...this.PROGRAMS);
  }

  goBack(route: string): void {
    this.router.navigate(['/programs']);
  }

  viewProgram(program: Program) {
    console.log("program: " + program.code);
    this.router.navigate(['/programs-detail', program.code]);
  }

  ngOnInit(): void {
    console.log("find programs");
    this.store.dispatch(this.actions.findPrograms());
  }

    createDialog(): void {
    this.showDialog(null);
  }

  filter():void{}

   private showDialog(code:Program): void {
    console.log("create");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '90%';
    config.position = {top: '1px'};
    this.creatorDialogRef = this.dialog.open(ProgramCreatorDialog, config);
    if(code) this.creatorDialogRef.componentInstance.program = code; 
   
    // set
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
   }
}

