import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import { AcademicSemester } from '../academic-session-semester-type.enum';


@Component({
  selector: 'pams-academic-session-semester',
  templateUrl: './academic-session-semester.component.html',
})
export class AcademicSessionSemesterComponent implements OnInit {

  private addressTypes: AcademicSemester[] = <AcademicSemester[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (var n in AcademicSemester) {
      if(typeof AcademicSemester[n] === 'string')
        this.addressTypes.push(AcademicSemester[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: AcademicSemester) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

