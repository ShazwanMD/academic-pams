import {Offering} from './offerings/offering.interface';
import {Admission} from './admissions/admission.interface';
import {Program} from './../planner/programs/program.interface';
import {Faculty} from './../planner/faculties/faculty.interface';
import {PlannerService} from './../../services/planner.service';
import {Router, ActivatedRoute} from '@angular/router';
import {IdentityService} from '../../services';
import {TermService} from "../../services/term.service";
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {TermModuleState} from "./index";
import {AdmissionActions} from "./admissions/admission.action";

@Component({
  selector: 'pams-term-page',
  templateUrl: './term.page.html',
})

export class TermPage implements OnInit {

 // private ADMISSIONS = "termModuleState.admissions".split(".");
  private admission$: Observable<Admission[]>;

  private _router: Router;
  private _route: ActivatedRoute;
  private _identityService: IdentityService;
  private _termService: TermService;
  

  constructor(private router: Router,
              plannerService: PlannerService,
              route: ActivatedRoute,
              identityService: IdentityService,
              private store: Store<TermModuleState>,
            //  private actions: AdmissionActions,
              private termService: TermService) {
    this._router = router;
    this._route = route;
    this._termService = termService;
  //  this.admission$ = this.store.select(...this.ADMISSIONS);
  }

  private columns: any[] = [
    {name: 'id', label: 'Code'},
    {name: 'gpa', label: 'Gpa'},
     {name: 'cgpa', label: 'Cgpa'},
    {name: 'action', label: 'Action'}
  ];

 viewAdmission(admission: Admission) {
    console.log("admission: " + admission.id);
    this.router.navigate(['/admission-detail', admission.id]);
  }
  ngOnInit(): void {
    this._route.params.subscribe(() => {
    });
    this.admission$ = this.termService.findAdmissions();
  //  this.store.dispatch(this.actions.findAdmissions());
  }
}
