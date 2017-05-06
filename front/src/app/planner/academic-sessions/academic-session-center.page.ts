import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {PlannerModuleState} from "../index";
import {AcademicSession} from "./academic-session.interface";
import {AcademicSessionActions} from "./academic-session.action";

@Component({
  selector: 'pams-academic-session-center',
  templateUrl: './academic-session-center.page.html',
})

export class AcademicSessionCenterPage implements OnInit {

  private ACADEMIC_SESSIONS = "plannerModuleState.academicSessions".split(".");
  private academicSessions$: Observable<AcademicSession[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AcademicSessionActions,
              private store: Store<PlannerModuleState>) {

    this.academicSessions$ = this.store.select(...this.ACADEMIC_SESSIONS);
  }

  goBack(route: string): void {
    this.router.navigate(['/academic-sessions']);
  }

  viewAcademicSession(academicSession: AcademicSession) {
    this.router.navigate(['/academic-sessions/view-detail', academicSession.code]);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findAcademicSessions());
  }
}

