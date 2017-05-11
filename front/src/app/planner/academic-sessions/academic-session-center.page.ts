import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from '../../../services';
import {CommonService} from '../../../services';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {AcademicSession} from "./academic-session.interface";
import {AcademicSessionActions} from "./academic-session.action";
import {PlannerModuleState} from "../index";

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
    console.log("academicSession: " + academicSession.code);
    this.router.navigate(['/academic-session-detail', academicSession.code]);
  }

  ngOnInit(): void {
    console.log("find academicSessions");
    this.store.dispatch(this.actions.findAcademicSessions());
  }
}

