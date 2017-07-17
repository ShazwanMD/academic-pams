import {CurriculumEditorDialog} from './dialog/curriculum-editor.dialog';
import {MdDialogRef, MdDialogConfig} from '@angular/material/dialog';
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
import { Subject } from "../subjects/subject.interface";

@Component({
  selector: 'pams-curriculum-detail',
  templateUrl: './curriculum-detail.page.html',
})

export class CurriculumDetailPage implements OnInit {
  private CURRICULUM: string[] = 'plannerModuleState.curriculum'.split('.');
  private SUBJECTS : string[] = 'plannerModuleState.subjects'.split('.');
  private curriculum$: Observable<Curriculum>;
  private subjects$: Observable<Subject[]>;

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
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findCurriculumByCode(code));
    });
  }

   showUpdateDialog(): void {
    console.log("edit offering");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(CurriculumEditorDialog, config);
    this.editorDialogRef.componentInstance.curriculum= this.curriculum;


    this.editorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog ");
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/curriculums']);
  }

  filter(): void {
  }

}

