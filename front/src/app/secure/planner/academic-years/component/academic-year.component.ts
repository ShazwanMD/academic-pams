import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {AcademicSemester} from '../../../../shared/model/planner/academic-semester-type.enum';
import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output, ViewContainerRef} from '@angular/core';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {AcademicYear} from '../../../../shared/model/planner/academic-year.interface';
import {ActivatedRoute, Router} from '@angular/router';
import {AcademicYearActions} from '../academic-year.action';
import {PlannerModuleState} from '../../index';
import {FormControl} from '@angular/forms';
//import {AcademicYearCreatorDialog} from '../dialog/academic-year-creator.dialog';

@Component({
  selector: 'pams-academic-year',
  templateUrl: './academic-year.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AcademicYearComponent implements OnInit {

  //private editorDialogRef: MdDialogRef<AcademicYearCreatorDialog>;
  private ACADEMIC_YEAR: string[] = 'plannerModuleState.academicYear'.split('.');
  private academicYear$: Observable<AcademicYear>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'action', label: ''},
  ];

  @Input() academicYear: AcademicYear;
 
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  @Output() view = new EventEmitter<AcademicYear>();


  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AcademicYearActions,
              private vcf: ViewContainerRef,
              private store: Store<PlannerModuleState>,
              private dialog: MdDialog) {
    this.academicYear$ = this.store.select(...this.ACADEMIC_YEAR);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findAcademicYearByCode(code));
    });
  }

 /* editSession(): void {
    console.log('edit');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(AcademicYearCreatorDialog, config);
    this.editorDialogRef.componentInstance.academicYear = this.academicYear;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }*/

  selectChangeEvent(event: AcademicYear) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }

}
