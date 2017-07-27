import {OnInit, Input, Component} from '@angular/core';
import {FormControl} from '@angular/forms';
import {AcademicStanding} from '../../../shared/model/term/academic-standing.enum';
@Component({
  selector: 'pams-academic-standing-select',
  templateUrl: './academic-standing-select.component.html',
})

export class AcademicStandingSelectComponent implements OnInit {
  private standings: AcademicStanding[] = <AcademicStanding[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;


  constructor() {
    for (var n in AcademicStanding) {
      if (typeof AcademicStanding[n] === 'string')
        this.standings.push(AcademicStanding[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: AcademicStanding) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
