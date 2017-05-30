import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {FacultyActions} from "../faculty.action";
import {Faculty} from "../faculty.interface";
import {PlannerModuleState} from "../../index";

@Component({
  selector: 'pams-faculty-select',
  templateUrl: './faculty-select.component.html',
})
export class FacultySelectComponent implements OnInit {

  private FACULTIES: string[] = "plannerModuleState.faculties".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<PlannerModuleState>,
              private actions: FacultyActions) {
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findFaculties());
  }

  selectChangeEvent(event: Faculty) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}


