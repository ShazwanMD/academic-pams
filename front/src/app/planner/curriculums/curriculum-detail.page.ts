import {Component, Input, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {CurriculumUpdateDialog} from './dialog/curriculum-update.dialog';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Curriculum} from './curriculum.interface';
import {CurriculumActions} from './curriculum.action';
import {PlannerModuleState} from '../index';
import {MdDialog} from '@angular/material';
import {ViewContainerRef} from '@angular/core';
import {MdSnackBar} from '@angular/material';

@Component({
  selector: 'pams-curriculum-detail',
  templateUrl: './curriculum-detail.page.html',
})

export class CurriculumDetailPage implements OnInit {
  private CURRICULUM: string[] = 'plannerModuleState.curriculum'.split('.');
  private curriculum$: Observable<Curriculum>;
  @Input() curriculums: Curriculum[];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CurriculumActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {

    this.curriculum$ = this.store.select(...this.CURRICULUM);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findCurriculumByCode(code));
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/curriculums']);
  }

  filter(): void {
  }

}

