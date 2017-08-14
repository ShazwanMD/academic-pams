import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {SubjectElectiveStatus} from '../../../../shared/model/planner/subject-elective-status.enum';

@Component({
  selector: 'pams-subject-elective-status-select',
  templateUrl: './subject-elective-status-select.component.html',
})
export class SubjectElectiveStatusSelectComponent implements OnInit  {

  private subjectElectiveStatuss: SubjectElectiveStatus[] = <SubjectElectiveStatus[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (let n in SubjectElectiveStatus) {
      if (typeof SubjectElectiveStatus[n] === 'string')
        this.subjectElectiveStatuss.push(SubjectElectiveStatus[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: SubjectElectiveStatus) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

