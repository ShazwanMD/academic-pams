import {
  Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit,
  OnChanges, SimpleChanges, SimpleChange, ViewChild
} from '@angular/core';
import {OfferingActions} from "../offering.action";
import {Store} from "@ngrx/store";
import {TermModuleState} from "../../index";
import {Assessment} from "../../assessments/assessment.interface";
import {GradebookMatrix} from "../gradebook-matrix.interface";
import {TdDataTableComponent} from "@covalent/core";

@Component({
  selector: 'pams-gradebook',
  templateUrl: './gradebook.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class GradebookComponent implements OnInit, OnChanges {

  @Input() gradebookMatrices: GradebookMatrix[];
  @Input() assessments: Assessment[];
  @ViewChild('dataTable') dataTable: TdDataTableComponent;

  columns: any[] = [
    {label: 'Student name', name: 'enrollment.admission.student.name'},
  ];

  constructor(private actions: OfferingActions,
              private store: Store<TermModuleState>) {
  }

  ngOnInit(): void {
  }

  ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
    console.log("on changes");
    if (changes['assessments'] && this.assessments) {
      this.assessments.forEach((assesment, index) => {
        console.log(assesment.code);
        this.columns.push({label: 'Student name', name: 'enrollment.admission.student.name'});
        // this.columns.push({label: assesment.code, name: 'gradebooks.' + index + '.score'});
      });
    }
    this.dataTable.refresh();
  }
}
