
import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import { ProgramStatus } from "../program-status.enum";


@Component({
  selector: 'pams-program-status-select',
  templateUrl: './program-status-select.component.html',
})
export class ProgramStatusSelectComponent implements OnInit {

  private programStatuss: ProgramStatus[] = <ProgramStatus[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (var n in ProgramStatus) {
      if(typeof ProgramStatus[n] === 'string')
        this.programStatuss.push(ProgramStatus[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: ProgramStatus) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

