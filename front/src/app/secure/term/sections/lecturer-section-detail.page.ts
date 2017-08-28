import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {TermService} from '../../../../services';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Section} from '../../../shared/model/term/section.interface';
import {SectionActions} from './section.action';
import {TermModuleState} from '../index';
import {MdDialog} from '@angular/material';
import {Enrollment} from '../../../shared/model/term/enrollment.interface';
import {Offering} from '../../../shared/model/term/offering.interface';
import {Gradebook} from '../../../shared/model/term/gradebook.interface';
import {GradebookMatrix} from '../../../shared/model/term/gradebook-matrix.interface';

@Component({
  selector: 'pams-lecturer-section-detail',
  templateUrl: './lecturer-section-detail.page.html',
})

export class LecturerSectionDetailPage implements OnInit {

  private OFFERING: string[] = 'termModuleState.offering'.split('.');
  private SECTION: string[] = 'termModuleState.section'.split('.');
  private ENROLLMENTS: string[] = 'termModuleState.enrollments'.split('.');
  private GRADEBOOKS: string[] = 'termModuleState.sectionGradebooks'.split('.');
  private GRADEBOOK_MATRICES: string[] = 'termModuleState.gradebookMatrices'.split('.');
  private offering$: Observable<Offering>;
  private section$: Observable<Section>;
  private gradebooks$: Observable<Gradebook[]>;
  private gradebookMatrices$: Observable<GradebookMatrix>;
  private enrollments$: Observable<Enrollment[]>;

  @Input() section: Section;
  @Input() offering: Offering;
  @Input() gradebooks: Gradebook;
  @Input() gradebookMatrices: GradebookMatrix;


  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: SectionActions,
              private termService: TermService,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.section$ = this.store.select(...this.SECTION);
    this.offering$ = this.store.select(...this.OFFERING);
    this.enrollments$ = this.store.select(...this.ENROLLMENTS);
    this.gradebooks$ = this.store.select(...this.GRADEBOOKS);
   this.gradebookMatrices$ = this.store.select(...this.GRADEBOOK_MATRICES);
  }

  showDialog(): void {
  }

  showDialogDel(): void {
  }

  filter(): void {

  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { canonicalCode: string }) => {
      let canonicalCode: string = params.canonicalCode;
      this.store.dispatch(this.actions.findSectionByCanonicalCode(canonicalCode));
    });
      
       this.section$.subscribe((section: Section) => {
      if (section.canonicalCode) this.store.dispatch(this.actions.findGradebookMatricessBySection(section));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/sections']);
  }
}
