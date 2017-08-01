import {BundleSubject} from '../../../shared/model/planner/bundle-subject.interface';
import {SingleSubject} from '../../../shared/model/planner/single-subject.interface';
import {CurriculumEditorDialog} from './dialog/curriculum-editor.dialog';
import {MdDialogConfig, MdDialogRef} from '@angular/material/dialog';
import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Curriculum} from '../../../shared/model/planner/curriculum.interface';
import {CurriculumActions} from './curriculum.action';
import {PlannerModuleState} from '../index';
import {MdDialog, MdSnackBar} from '@angular/material';
import {Subject} from '../../../shared/model/planner/subject.interface';

@Component({
  selector: 'pams-curriculum-detail',
  templateUrl: './curriculum-detail.page.html',
})

export class CurriculumDetailPage implements OnInit {

  private CURRICULUM: string[] = 'plannerModuleState.curriculum'.split('.');
  private SUBJECTS: string[] = 'plannerModuleState.subjects'.split('.');
  private SINGLE_SUBJECT: string[] = 'plannerModuleState.singleSubjects'.split('.');
  private BUNDLE_SUBJECT: string[] = 'plannerModuleState.bundleSubjects$'.split('.');
  private curriculum$: Observable<Curriculum>;
  private subjects$: Observable<Subject[]>;
  private singleSubject$: Observable<SingleSubject[]>;
  private bundleSubject$: Observable<BundleSubject[]>;
  private editorDialogRef: MdDialogRef<CurriculumEditorDialog>;

  @Input() curriculum: Curriculum;
  
  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: CurriculumActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,
              private snackBar: MdSnackBar) {

    this.curriculum$ = this.store.select(...this.CURRICULUM);
    this.subjects$ = this.store.select(...this.SUBJECTS);
    this.singleSubject$ = this.store.select(...this.SINGLE_SUBJECT);
    this.bundleSubject$= this.store.select(...this.BUNDLE_SUBJECT);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findCurriculumByCode(code));
    });
  }

  showUpdateDialog(): void {
    console.log('edit offering');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(CurriculumEditorDialog, config);
    this.editorDialogRef.componentInstance.curriculum = this.curriculum;

    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog ');
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/curriculums']);
  }

  filter(): void {
    // no op
  }
}

