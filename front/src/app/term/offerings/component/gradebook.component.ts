import {
  Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit,
  OnChanges, SimpleChanges, SimpleChange
} from '@angular/core';
import {OfferingActions} from "../offering.action";
import {Store} from "@ngrx/store";
import {TermModuleState} from "../../index";
import {Assessment} from "../../assessments/assessment.interface";
import {GradebookMatrix} from "../gradebook-matrix.interface";

@Component({
  selector: 'pams-gradebook',
  templateUrl: './gradebook.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class GradebookComponent implements OnInit, OnChanges {

  @Input() gradebookMatrices: GradebookMatrix[];
  @Input() assessments: Assessment[];

  private columns: any[] = [];

  constructor(private actions: OfferingActions,
              private store: Store<TermModuleState>) {
  }

  ngOnInit(): void {
  }

  ngOnChanges(changes: { [ propName: string]: SimpleChange }) {
    console.log("on changes");
    if (changes['assessments'] && this.assessments) {
      this.assessments.forEach((assesments, index) => {
        this.columns.push(assesments.code);
      });
    }
  }
}
