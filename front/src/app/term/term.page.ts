import {Admission} from './admissions/admission.interface';
import {PlannerService} from './../../services/planner.service';
import {Router, ActivatedRoute} from '@angular/router';
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

  private ADMISSIONS = "termModuleState.admissions".split(".");
  private admissions$: Observable<Admission[]>;

  constructor(private router: Router,
              route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private actions: AdmissionActions) {
    this.admissions$ = this.store.select(...this.ADMISSIONS);
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
    this.store.dispatch(this.actions.findAdmissions());
  }
}
