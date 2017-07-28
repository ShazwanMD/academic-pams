import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';

import {Faculty} from '../../../shared/model/planner/faculty.interface';
import {FacultyActions} from './faculty.action';
import {PlannerModuleState} from '../index';
import {FacultyCreatorDialog} from './dialog/faculty-creator.dialog';

@Component({
  selector: 'pams-faculty-center',
  templateUrl: './faculty-center.page.html',
})

export class FacultyCenterPage implements OnInit {

  private FACULTIES: string[] = 'plannerModuleState.faculties'.split('.');
  private faculties$: Observable<Faculty[]>;

  private creatorDialogRef: MdDialogRef<FacultyCreatorDialog>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'name', label: 'Name'},
    {name: 'prefix', label: 'Prefix'},
    {name: 'status', label: 'FacultyStatus'},
    {name: 'action', label: ''},
  ];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: FacultyActions,
              private store: Store<PlannerModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.faculties$ = this.store.select(...this.FACULTIES);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findFaculties());
  }

  viewFaculty(faculty: Faculty) {
    console.log('faculty: ' + faculty.id);
    this.router.navigate(['/faculties-detail', faculty.id]);
  }

  createDialog(): void {
    this.showDialog(null);
  }

  private showDialog(code: Faculty): void {
    console.log('create');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '65%';
    config.height = '75%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(FacultyCreatorDialog, config);
    if (code) this.creatorDialogRef.componentInstance.faculty = code;

    //set
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

  goBack(route: string): void {
    this.router.navigate(['/faculties']);
  }

  filter(): void {
  }

}
