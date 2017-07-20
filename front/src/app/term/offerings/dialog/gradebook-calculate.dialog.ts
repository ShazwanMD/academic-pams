import { Component, ViewContainerRef, OnInit, Input } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from "../../../../services/identity.service";
import {CommonService} from "../../../../services/common.service";
import {PlannerService} from "../../../../services/planner.service";
import {TermService} from "../../../../services/term.service";
import {Offering} from "../offering.interface";
import {OfferingActions} from "../offering.action";
import {MdDialog} from '@angular/material';
import {MdDialogRef} from "@angular/material";
import {Store} from "@ngrx/store";
import {AcademicSession} from "../../../planner/academic-sessions/academic-session.interface";
import {Course} from "../../../planner/courses/course.interface";
import {Program} from "../../../planner/programs/program.interface";
import {TermModuleState} from "../../index";

@Component({
  selector: 'pams-gradebook-calculate',
  templateUrl: './gradebook-calculate.dialog.html',
})
export class GradebookCalculateDialog{

      @Input() offering: Offering;

        constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private viewContainerRef: ViewContainerRef,
              private actions: OfferingActions,
              public dialog: MdDialogRef<GradebookCalculateDialog>) {
  }

  calculate(offering:Offering){
      console.log("offering CanonicalCode:{}",this.offering.canonicalCode);
      this.store.dispatch(this.actions.calculateGradebook(this.offering));
      this.dialog.close();
  }
  cancel(offering:Offering){
      this.dialog.close();
  }

}

