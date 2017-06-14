import {CurriculumActions} from './curriculum.action';
import {CurriculumEditorDialog} from './dialog/curriculum-editor.dialog';
import {Router, ActivatedRoute} from '@angular/router';

import {Component, OnInit, ViewContainerRef, ChangeDetectionStrategy} from '@angular/core';
import {CommonService} from '../../../services';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Curriculum} from './curriculum.interface';
import {PlannerService} from './../../../services/planner.service';
import {PlannerModuleState} from '../index';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';

@Component({
  selector: 'pams-curriculum-center',
  templateUrl: './curriculum-center.page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class CurriculumCenterPage implements OnInit {

  private CURRICULUMS: string[] = 'plannerModuleState.curriculums'.split('.');
  private curriculums$: Observable<Curriculum[]>;
  private creatorDialogRef: MdDialogRef<CurriculumEditorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CurriculumActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.curriculums$ = this.store.select(...this.CURRICULUMS);
  }

  goBack(route: string): void {
    this.router.navigate(['/curriculums']);
  }

  viewCurriculum(curriculum: Curriculum) {
    console.log('curriculum: ' + curriculum.id);
    this.router.navigate(['/curriculums-detail', curriculum.id]);
  }

  filter(): void {
  }

  showDialog(): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '40%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(CurriculumEditorDialog, config);
    // this.creatorDialogRef.componentInstance.offering = this.offering;
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findCurriculums());
  }
}
