import {Enrollment} from '../../../../shared/model/term/enrollment.interface';
import {GradebookMatrix} from '../../../../shared/model/term/gradebook-matrix.interface';
import {Observable} from 'rxjs/Observable';
import {OfferingActions} from '../../offerings/offering.action';
import {TermModuleState} from '../../index';
import {Store} from '@ngrx/store';
import {Offering} from '../../../../shared/model/term/offering.interface';
import {Student} from '../../../../shared/model/identity/student.interface';
import {Assessment} from '../../../../shared/model/term/assessment.interface';
import {Router, ActivatedRoute} from '@angular/router';
import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit} from '@angular/core';

@Component({
  selector: 'pams-assessment',
  templateUrl: './assessment.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AssessmentComponent implements OnInit {

  private OFFERING: string[] = 'termModuleState.offering'.split('.');
  private GRADEBOOK_MATRICES: string[] = 'termModuleState.gradebookMatrices'.split('.');
  private ASSESSMENTS: string[] = 'termModuleState.assessments'.split('.');
  private ENROLLMENTS: string[] = 'termModuleState.enrollments'.split('.');
  private enrollments$: Observable<Enrollment>;
  private assessments$: Observable<Assessment>;
  private offering$: Observable<Offering>;
  private gradebookMatrices$: Observable<GradebookMatrix>;
  private columns: any[] =
    [
      {label: 'Student name', name: 'enrollment.admission.student.name'},
    ];

  @Input() assessments: Assessment;
  @Input() enrollment: Enrollment;
  @Input() student: Student;
  @Input() gradebookMatrices: GradebookMatrix;

  @Input() offerings: Offering;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: OfferingActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef) {

    this.offering$ = this.store.select(...this.OFFERING);
    this.assessments$ = this.store.select(...this.ASSESSMENTS);
    this.gradebookMatrices$ = this.store.select(...this.GRADEBOOK_MATRICES);
    this.enrollments$ = this.store.select(...this.ENROLLMENTS);

  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { canonicalCode: string }) => {
      let canonicalCode: string = params.canonicalCode;
      this.store.dispatch(this.actions.findOfferingByCanonicalCode(canonicalCode));
    });

    this.offering$.subscribe((offering: Offering) => {
      if (offering.canonicalCode) this.store.dispatch(this.actions.findGradebookMatricessByOffering(offering));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/offerings', +this.offerings.canonicalCode]);
  }
}
