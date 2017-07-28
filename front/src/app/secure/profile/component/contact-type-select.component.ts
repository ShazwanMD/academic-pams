import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {ContactType} from '../../../shared/model/profile/contact-type.enum';

@Component({
  selector: 'pams-contact-type-select',
  templateUrl: './contact-type-select.component.html',
})
export class ContactTypeSelectComponent implements OnInit {

  private contactTypes: ContactType[] = <ContactType[]>[];
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor() {
    for (let n in ContactType) {
      if (typeof ContactType[n] === 'string')
        this.contactTypes.push(ContactType[n.toString()]);
    }
  }

  ngOnInit() {
  }

  selectChangeEvent(event: ContactType) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

