import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {FormControl} from "@angular/forms";
//import {SectionActions} from "../section.action";
import {TermModuleState} from "../../index";
import {Section} from "../section.interface";


@Component({
  selector: 'pams-section-select',
  templateUrl: './section-select.component.html',
})
export class SectionSelectComponent implements OnInit {

  private SECTIONS = "termModuleState.sections".split(".");
  private sections$: Observable<Section[]>;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<TermModuleState>,
              //private actions: SectionActions
  ) {
    this.sections$ = this.store.select(...this.SECTIONS);
  }

  ngOnInit() {
    //this.store.dispatch(this.actions.findSections());
  }

  selectChangeEvent(event: Section) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}

