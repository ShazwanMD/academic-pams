import {SubjectType} from '../subject-type.enum';
import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";


@Component({
  selector: 'pams-subject-type-select',
  templateUrl: './subject-type-select.component.html',
})
export class SubjectTypeSelectComponent implements OnInit {

  private subjectTypes: SubjectType[] = <SubjectType[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (var n in SubjectType) {
      if(typeof SubjectType[n] === 'string')
        this.subjectTypes.push(SubjectType[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: SubjectType) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

