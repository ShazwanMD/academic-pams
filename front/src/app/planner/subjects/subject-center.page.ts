import {SubjectCreatorDialog} from './dialog/subject-creator.dialog';
import {Router, ActivatedRoute} from '@angular/router';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {MdDialogRef} from '@angular/material';
import {MdDialogConfig} from '@angular/material';
import {MdDialog} from '@angular/material';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {PlannerModuleState} from '../index';
import {Subject} from '../curriculums/subject.interface';

@Component({
  selector: 'pams-subject-center',
  templateUrl: './subject-center.page.html',
})

export class SubjectCenterPage implements OnInit {

  private SUBJECTS: string[] = 'plannerModuleState.subjects'.split('.');
  private subjects$: Observable<Subject[]>;
  private creatorDialogRef: MdDialogRef<SubjectCreatorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.subjects$ = this.store.select(...this.SUBJECTS);
  }
  viewsubject(subject: Subject) {
    console.log('subject: ' + subject.id);
    this.router.navigate(['./subjects-detail', subject.id]);
  }

  ngOnInit(): void {
    console.log('find subjects');
    // this.store.dispatch(this.actions.findSubjects());
  }

  createDialog(): void {
    this.showDialog(null);
  }

  private showDialog(id: Subject): void {
    console.log('save');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '70';
    config.position = {top: '1px'};
    this.creatorDialogRef = this.dialog.open(SubjectCreatorDialog, config); if (id) this.creatorDialogRef.componentInstance.subject = id; ;
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

   goBack(route: string): void {
    this.router.navigate(['/subjects']);
   }

  filter(): void {
  }

}

