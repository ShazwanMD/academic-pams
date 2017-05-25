import { OnInit, Input, Component } from '@angular/core';
import { AcademicSemester } from '../academic-semester-type.enum';
import { FormControl } from '@angular/forms';



@Component({
    selector: 'pams-academic-semester-select',
    templateUrl: './academic-semester-select.component.html',
})

export class AcademicSemesterSelectComponent implements OnInit {
    private semesters: AcademicSemester[] = <AcademicSemester[]>[];
    @Input() placeholder: string;
    @Input() innerFormControl: FormControl;


    constructor() {
        for (var n in AcademicSemester) {
            if (typeof AcademicSemester[n] === 'string')
                this.semesters.push(AcademicSemester[n.toString()]);
        }
    }
    
    ngOnInit() {
  }

  selectChangeEvent(event: AcademicSemester) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
