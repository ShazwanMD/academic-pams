import {Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {FormControl} from '@angular/forms';
import {Actor} from '../../../shared/model/identity/actor.interface';
import {IdentityModuleState} from '../index';
import {StaffActions} from '../staff.action';

@Component({
  selector: 'pams-staff-select',
  templateUrl: './staff-select.component.html',
  styleUrls: ['./staff-select.component.scss'],
})
export class StaffSelectComponent implements OnInit {

  private STAFFS: string[] = 'identityModuleState.staffs'.split('.');

  private staffs$: Observable<Actor[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<IdentityModuleState>,
              private actions: StaffActions) {
    this.staffs$ = this.store.select(...this.STAFFS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findStaffs());
  }

  selectChangeEvent(event: Actor) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

