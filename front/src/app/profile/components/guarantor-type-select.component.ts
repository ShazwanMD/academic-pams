import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {GuarantorType} from "../guarantor-type.enum";


@Component({
  selector: 'pams-guarantor-type-select',
  templateUrl: './guarantor-type-select.component.html',
})
export class GuarantorTypeSelectComponent implements OnInit {

  private guarantorTypes: GuarantorType[] = <GuarantorType[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (var n in GuarantorType) {
      if(typeof GuarantorType[n] === 'string')
        this.guarantorTypes.push(GuarantorType[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: GuarantorType) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

