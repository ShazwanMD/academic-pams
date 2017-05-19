import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {AcademicSession} from "../academic-session.interface";
import {PlannerModuleState} from "../../index";
import {AcademicSessionActions} from "../academic-session.action";


@Component({
  selector: 'pams-academic-session-select',
  templateUrl: './academic-session-select.component.html',
})
export class AcademicSessionSelectComponent implements OnInit {

  private ACADEMIC_SESSIONS: string[] = "plannerModuleState.academicSessions".split(".");
  private academicSessions$: Observable<AcademicSession[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<PlannerModuleState>,
              private actions: AcademicSessionActions) {
    this.academicSessions$ = this.store.select(...this.ACADEMIC_SESSIONS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findAcademicSessions());
  }

  selectChangeEvent(event: AcademicSession) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

