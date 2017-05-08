// import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
// import {Router, ActivatedRoute} from '@angular/router';
// import {IdentityService} from '../../../services';
// import {CommonService} from '../../../services';
// import {Store} from "@ngrx/store";
// import {Observable} from "rxjs";
// import {AcademicSession} from "./academicSession.interface";
// import {AcademicSessionActions} from "./academicSession.action";
// import {PlannerModuleState} from "../index";

// @Component({
//   selector: 'pams-academicSession-center',
//   templateUrl: './academicSession-center.page.html',
// })
// export class AcademicSessionCenterPage implements OnInit {

//   private SESSIONS = "plannerModuleState.sessions".split(".");
//   private sessions$: Observable<AcademicSession[]>;

//   constructor(private router: Router,
//               private route: ActivatedRoute,
//               private actions: AcademicSessionActions,
//               private store: Store<PlannerModuleState>) {
//     this.sessions$ = this.store.select(...this.SESSIONS);
//   }

//   goBack(route: string): void {
//     this.router.navigate(['/sessions']);
//   }

//   viewSession(session : AcademicSession) {
//     console.log("session: " + session.id);
//     this.router.navigate(['/sessions-detail', session.id]);
//   }

//   ngOnInit(): void {
//       console.log("find sessions");
//     this.store.dispatch(this.actions.findAcademicSession());
//   }
// }

