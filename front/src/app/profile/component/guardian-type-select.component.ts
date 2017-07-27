import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {GuardianType} from '../../shared/model/profile/guardian-type.enum';

@Component({
  selector: 'pams-guardian-type-select',
  templateUrl: './guardian-type-select.component.html',
})
export class GuardianTypeSelectComponent implements OnInit {

  private guardianTypes: GuardianType[] = <GuardianType[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (let n in GuardianType) {
      if (typeof GuardianType[n] === 'string')
        this.guardianTypes.push(GuardianType[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: GuardianType) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
