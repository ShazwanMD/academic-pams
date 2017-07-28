import {GradebookMatrix} from '../../../shared/model/term/gradebook-matrix.interface';
import {Student} from '../../../shared/model/identity/student.interface';
import {Component, OnInit, ChangeDetectionStrategy, ViewContainerRef, Input, EventEmitter, Output} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Offering} from '../../../shared/model/term/offering.interface';
import {OfferingActions} from './offering.action';
import {TermModuleState} from '../index';
import {Enrollment} from '../../../shared/model/term/enrollment.interface';
import {Assessment} from '../../../shared/model/term/assessment.interface';
import {Gradebook} from '../../../shared/model/term/gradebook.interface';

@Component({
  selector: 'pams-gradebook-detail',
  templateUrl: './gradebook-detail.page.html',
})

export class GradebookDetailPage implements OnInit {

  private OFFERING: string[] = 'termModuleState.offering'.split('.');
  private GRADEBOOK_MATRICES: string[] = 'termModuleState.gradebookMatrices'.split('.');
  private ASSESSMENTS: string[] = 'termModuleState.assessments'.split('.');
  private ENROLLMENTS: string[] = 'termModuleState.enrollments'.split('.');

  private enrollments$: Observable<Enrollment>;
  private assessments$: Observable<Assessment>;
  private offering$: Observable<Offering>;
  private gradebookMatrices$: Observable<GradebookMatrix>;

  @Input() enrollment: Enrollment;
  @Input() student: Student;
  @Input() gradebooks: Gradebook;
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
