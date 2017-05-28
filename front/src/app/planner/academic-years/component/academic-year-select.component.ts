import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
//import {AcademicYearActions} from "../academicYear.action";
import {AcademicYear} from "../academic-year.interface";
import {PlannerModuleState} from "../../index";


@Component({
  selector: 'pams-academic-year-select',
  templateUrl: './academic-year-select.component.html',
})
export class AcademicYearSelectComponent implements OnInit {

  private ACADEMICYEARS: string[] = "plannerModuleState.courses".split(".");
  private academicYears$: Observable<AcademicYear[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<PlannerModuleState>,
              //private actions: AcademicYearActions
          ) {
    this.academicYears$ = this.store.select(...this.ACADEMICYEARS);
  }

  ngOnInit() {
    //this.store.dispatch(this.actions.findAcademicYears());
  }

  selectChangeEvent(event: AcademicYear) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

