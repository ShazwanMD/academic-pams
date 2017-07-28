import {SetupModuleState} from './../../index';
import {SetupActions} from './../../setup.action';
import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
import {MaritalCode} from "../marital-code.interface";

// pascalCase: MaritalCode
// snakeCase: marital_code
// camelCase: maritalCode
// kebabCase: marital-code


@Component({
  selector: 'pams-marital-code-select',
  templateUrl: './marital-code-select.component.html',
})
export class MaritalCodeSelectComponent implements OnInit {

  private MARITAL_CODE: string[] = "setupModuleState.maritalCode".split(".");
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  maritalCodes$: Observable<MaritalCode[]>;

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions) {
    this.maritalCodes$ = this.store.select(...this.MARITAL_CODE);
  }

  ngOnInit() {
    this.store.dispatch(this.actions.findMaritalCodes());
  }

  selectChangeEvent(event: MaritalCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

