import {MdTabsModule} from '@angular/material';
import {Subject} from "../Subject.interface";
import { Store } from '@ngrx/store';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder } from '@angular/forms';
// import { SubjectActions } from './../Subject.action';
import { PlannerModuleState } from './../../index';
import { Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef } from '@angular/core';
import { SubjectCreatorDialog } from "../dialog/Subject-creator.dialog";

import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";

@Component({
  selector: 'pams-Subject',
  templateUrl: 'Subject.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SubjectComponent {

  @Input() subject: Subject;
  @Output() view = new EventEmitter<Subject>();


  private creatorDialogRef: MdDialogRef<SubjectCreatorDialog>;

  constructor(
              private formBuilder: FormBuilder,
              private router: Router,
              private route: ActivatedRoute,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              // private actions: SubjectActions,
              private dialog: MdDialog,){

  }

   saveSubjectDialog(subject:Subject): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(SubjectCreatorDialog, config);
    // this.creatorDialogRef.componentInstance.Subject= this.Subject;
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
   }
}

//   removeSubject(Subject:Subject): void {
//     this.store.dispatch(this.actions.removeSubject(this.subject))
//     console.log("deleteSubject:{}", this.subject)
//   } 
// }
