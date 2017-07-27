import {SubjectType} from '../../../shared/model/planner/subject-type.enum';
import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'pams-subject-type-select',
  templateUrl: './subject-type-select.component.html',
  styleUrls: ['./subject-type-select.component.scss'],
})
export class SubjectTypeSelectComponent implements OnInit {

  private subjectTypes: SubjectType[] = <SubjectType[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (let n in SubjectType) {
      if (typeof SubjectType[n] === 'string')
        this.subjectTypes.push(SubjectType[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: SubjectType) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

