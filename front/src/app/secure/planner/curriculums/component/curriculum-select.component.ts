import {CurriculumActions} from '../curriculum.action';
import {PlannerModuleState} from '../../index';
import {FormControl} from '@angular/forms';
import {Component, Input, OnInit} from '@angular/core';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs/Rx';
import {Curriculum} from '../../../../shared/model/planner/curriculum.interface';

@Component({
  selector: 'pams-curriculum-select',
  templateUrl: './curriculum-select.component.html',
})
export class CurriculumSelectComponent implements OnInit {

  private CURRICULUMS: string[] = 'plannerModuleState.curriculums'.split('.');
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  curriculums$: Observable<Curriculum[]>;

  constructor(private store: Store<PlannerModuleState>,
              private actions: CurriculumActions) {
    this.curriculums$ = this.store.select(...this.CURRICULUMS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findCurriculums());
  }

  selectChangeEvent(event: Curriculum) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
