// import {Observable} from "rxjs";
// import { ProgramLevel } from './../program-level.interface';
// import { Store } from '@ngrx/store';

// import {Component, Input, OnInit} from '@angular/core';
// import {FormControl} from "@angular/forms";
// import { ProgramActions } from "../program.action";
// import { PlannerModuleState } from "../../index";


// @Component({
//   selector: 'pams-program-level-select',
//   templateUrl: './program-level-select.component.html',
// })
// export class ProgramLevelSelectComponent implements OnInit {
//     programLevel$: Observable<ProgramLevel>;


//   private PROGRAMLEVEL: string[] = "plannerModuleState.programs".split(".");
//   @Input() placeholder: string;
//   @Input() innerFormControl: FormControl;

//   constructor(private store: Store<PlannerModuleState>,
//               private actions: ProgramActions) {

//         this.programLevel$ = this.store.select(...this.PROGRAMLEVEL);

//   }

//  ngOnInit() {
//     // this.store.dispatch(this.actions.findProgramLevelByCode());
//   }

//   selectChangeEvent(event: ProgramLevel) {
//     this.innerFormControl.setValue(event, {emitEvent: false});
//   }
// }

