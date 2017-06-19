import { Gradebook } from './../gradebook.interface';
import { FormGroup, FormBuilder } from '@angular/forms';
import {
  Component, Input, ChangeDetectionStrategy,
  OnChanges, SimpleChange, ViewChild
} from '@angular/core';
import { OfferingActions } from "../offering.action";
import { Store } from "@ngrx/store";
import { TermModuleState } from "../../index";
import { GradebookMatrix } from "../gradebook-matrix.interface";
import { TdDataTableComponent } from "@covalent/core";
import { Offering } from "../offering.interface";
import { Assessment } from "../../assessments/assessment.interface";

@Component({
  selector: 'pams-gradebook',
  templateUrl: './gradebook.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class GradebookComponent implements OnChanges {

  @Input() offering: Offering;
  @Input() gradebookMatrices: GradebookMatrix[];
  @Input() assessments: Assessment[];
  @ViewChild('dataTable') dataTable: TdDataTableComponent;

  columns: any[] = [
    { label: 'Student name', name: 'enrollment.admission.student.name' }
  ];


  constructor(private actions: OfferingActions,
    private store: Store<TermModuleState>) {
  }


  ngOnChanges(changes: { [propName: string]: SimpleChange }) {
    if (changes['gradebookMatrices'] && this.gradebookMatrices) {
      var a = changes['gradebookMatrices']['currentValue'];
      if (a.length > 0) {
        a.forEach(i => {
          var b = i['gradebooks'];
          if (b.length > 0) {
            for (var j = 0; j < b.length; j++) {
              this.columns[j + 1] = {
                label: b[j].assessment.description,
                name: 'gradebooks.' + j + '.score',
              }
            }
            console.log(this.columns);
          }
          console.log(i['gradebooks']);
        });

      }
    }
  }


  download(): void {
    this.store.dispatch(this.actions.downloadGradebook(this.offering));
  }

  upload(file: File): void {
    console.log("gradebookComponent", file);
    this.store.dispatch(this.actions.uploadGradebook(this.offering, file));

  }

}
