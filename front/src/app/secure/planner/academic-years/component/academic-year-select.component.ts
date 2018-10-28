import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {AcademicYearActions} from '../academic-year.action';
import {AcademicYear} from '../../../../shared/model/planner/academic-year.interface';
import {PlannerModuleState} from '../../index';

@Component({
  selector: 'pams-academic-year-select',
  templateUrl: './academic-year-select.component.html',
  styleUrls: ['./academic-year-select.scss'],
})
export class AcademicYearSelectComponent implements OnInit {

  private ACADEMIC_YEARS: string[] = 'plannerModuleState.academicYears'.split('.');
  private academicYears$: Observable<AcademicYear[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<PlannerModuleState>,
              private actions: AcademicYearActions) {

    this.academicYears$ = this.store.select(...this.ACADEMIC_YEARS);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findAcademicYears());
  }

  selectChangeEvent(event: AcademicYear) {

    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

