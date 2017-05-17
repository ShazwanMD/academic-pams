import { MdSnackBar } from '@angular/material';
import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {Store} from "@ngrx/store";
import {Observable} from "rxjs";

import {PlannerService} from '../../../services';
import {PlannerModuleState} from "../index";

import {AcademicSession} from "./academic-session.interface";
import {AcademicSessionActions} from "./academic-session.action";


@Component({
  selector: 'pams-academic-session-detail',
  templateUrl: './academic-session-detail.page.html',
})

export class AcademicSessionDetailPage implements OnInit {

  private ACADEMIC_SESSION = "plannerModuleState.academicSession".split(".");
  private academicSession$: Observable<AcademicSession>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AcademicSessionActions,
              private store: Store<PlannerModuleState>,
              private snackBar : MdSnackBar) {
    this.academicSession$ = this.store.select(...this.ACADEMIC_SESSION);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findAcademicSessionByCode(code));
    });
  }

  activate() {
    let snackBarRef = this.snackBar.open("Activating Academic Session", "OK");
      snackBarRef.afterDismissed().subscribe(() => {
        this.academicSession$.subscribe (academicSession => this.actions.activateAcademicSession(academicSession));
      });
  }

  deactivate() {
     let snackBarRef = this.snackBar.open("Deactivating Academic Session", "OK");
      snackBarRef.afterDismissed().subscribe(() => {
        this.academicSession$.subscribe (academicSession => this.actions.deactivateAcademicSession(academicSession));
      });
  }

}
