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
  selector: 'pams-academicSession-center',
  templateUrl: './academic-session-center.page.html',
})
export class AcademicSessionCenterPage implements OnInit {

  private SESSIONS = "plannerModuleState.session".split(".");
  private sessions$: Observable<AcademicSession[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AcademicSessionActions,
              private store: Store<PlannerModuleState>) {
    this.sessions$ = this.store.select(...this.SESSIONS);
  }

  goBack(route: string): void {
    this.router.navigate(['/academicSession']);
  }

  viewSession(session : AcademicSession) {
    console.log("session: " + session.id);
    this.router.navigate(['/academic-session-detail', session.id]);
  }

  ngOnInit(): void {
      console.log("find sessions");
    this.store.dispatch(this.actions.findSessions());
  }
}

