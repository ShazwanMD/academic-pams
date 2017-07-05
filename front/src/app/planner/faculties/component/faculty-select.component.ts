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
  styleUrls: ['./faculty-select.component.scss'],
})
export class FacultySelectComponent implements OnInit {

  private FACULTIES: string[] = "plannerModuleState.faculties".split(".");
  private faculties$: Observable<Faculty[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<PlannerModuleState>,
              private actions: FacultyActions) {
    this.faculties$ = this.store.select(...this.FACULTIES);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findFaculties());
  }

  selectChangeEvent(event: Faculty) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}


