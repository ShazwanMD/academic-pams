import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';

import {AcademicYear} from '../../../shared/model/planner/academic-year.interface';
import {AcademicYearActions} from './academic-year.action';
import {PlannerModuleState} from '../index';
import {AcademicYearCreatorDialog} from './dialog/academic-year-creator.dialog';

@Component({
  selector: 'pams-academic-year-center',
  templateUrl: './academic-year-center.page.html',
})
export class AcademicYearCenterPage implements OnInit {

  private ACADEMIC_YEARS: string[] = 'plannerModuleState.academicYears'.split('.');
  private academicYears$: Observable<AcademicYear[]>;
  private creatorDialogRef: MdDialogRef<AcademicYearCreatorDialog>;
  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'action', label: ''},
  ];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AcademicYearActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.academicYears$ = this.store.select(...this.ACADEMIC_YEARS);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findAcademicYears());
  }

  viewAcademicYear(academicYear: AcademicYear) {
    console.log('academicYear: ' + academicYear.code);
    this.router.navigate(['/academic-year-detail', academicYear.code]);
  }

  createDialog(): void {
    this.showDialog(null);
  }

  filter(): void {

  }

  private showDialog(code: AcademicYear): void {
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '45%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AcademicYearCreatorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.academicYear = code;

    this.creatorDialogRef.afterClosed().subscribe((res) => {
      // console.log ("close dialog");
    });
  }
}

