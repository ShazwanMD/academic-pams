import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {AdmissionActions} from "../admission.action";
import {TermModuleState} from "../../index";
import {Admission} from "../admission.interface";


@Component({
  selector: 'pams-admission-select',
  templateUrl: './admission-select.component.html',
  styleUrls: ['./admission-select.scss'],
})
export class AdmissionSelectComponent implements OnInit {

  private ADMISSIONS: string[] = "termModuleState.admissions".split(".");
  private admissions$: Observable<Admission[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<TermModuleState>,
              private actions: AdmissionActions) {
    this.admissions$ = this.store.select(...this.ADMISSIONS);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findAdmissions());
  }

  selectChangeEvent(event: Admission) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

