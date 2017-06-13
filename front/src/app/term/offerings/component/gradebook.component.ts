import {
  Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, 
  OnChanges, SimpleChanges, SimpleChange, ViewChild
} from '@angular/core';
import { OfferingActions } from "../offering.action";
import { Store } from "@ngrx/store";
import { TermModuleState } from "../../index";
import { Assessment } from "../../assessments/assessment.interface";
import { GradebookMatrix } from "../gradebook-matrix.interface";
import { TdDataTableComponent } from "@covalent/core";

@Component({
  selector: 'pams-gradebook',
  templateUrl: './gradebook.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class GradebookComponent implements  OnChanges{

  @Input() gradebookMatrices: GradebookMatrix[];
  //@Input() assessments: Assessment[];
  @ViewChild('dataTable') dataTable: TdDataTableComponent;

  columns: any[] = [
     { label: 'Student name', name: 'enrollment.admission.student.name' }
  //   { label: 'Assessment', name: 'gradebooks.0.score' },
  ];


  constructor(private actions: OfferingActions,
    private store: Store<TermModuleState>) {
  }

  ngOnChanges(changes: { [propName: string]: SimpleChange }) {
    var a=changes['gradebookMatrices']['currentValue'];
    if(a.length>0){
      //if (a['gradebooks'] && a['gradebooks'].length>0)
      //if (a['gradebooks'])
      a.forEach(i => {
        var b = i['gradebooks'];
        if (b.length>0){
          for(var j = 0; j < b.length; j++){
            this.columns[j+1] = {
              label:b[j].assessment.description,
              name:'gradebooks.'+j+'.score',
            }
          }
           console.log( this.columns);
        }
          console.log(i['gradebooks']);
      });
      
    }
    
  }
}
