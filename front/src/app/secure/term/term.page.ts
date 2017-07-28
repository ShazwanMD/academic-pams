import {Admission} from '../../shared/model/term/admission.interface';
import {PlannerService} from '../../../services/planner.service';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {TermModuleState} from "./index";
import {AdmissionActions} from "./admissions/admission.action";
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, OnInit} from '@angular/core';

@Component({
  selector: 'pams-term-page',
  templateUrl: './term.page.html',
})

export class TermPage implements OnInit {

  private ADMISSIONS: string[] = "termModuleState.admissions".split(".");
  private admissions$: Observable<Admission[]>;

  constructor(private router: Router,
              route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private actions: AdmissionActions) {
    this.admissions$ = this.store.select(...this.ADMISSIONS);
  }

  goBack(route: string): void {
    this.router.navigate(['/admissions']);
  }

  viewAdmission(admission: Admission) {
    console.log("admission: " + admission.id);
    this.router.navigate(['/admission-detail', admission.id]);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findAdmissions());
  }

  @Input() admissions: Admission[];
  @Output() view = new EventEmitter<Admission>();

  private columns: any[] = [
    {name: 'student.name', label: 'StudentName'},
    {name: 'student.identityNo', label: 'StudentIC'},
    {name: 'academicSession.description', label: 'AcademicSession'},
    {name: 'cohort.code', label: 'Cohort'},
    {name: 'gpa', label: 'GPA'},
    {name: 'cgpa', label: 'CGPA'},
    {name: 'action', label: ''}
  ];

}
