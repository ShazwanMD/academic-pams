// import {Component, Input, OnInit} from '@angular/core';
// import {Observable} from "rxjs";
// import {Store} from "@ngrx/store";
// import {FormControl} from "@angular/forms";
// import {CourseActions} from "../course.action";
// import {Course} from "../course.interface";
// import {PlannerModuleState} from "../../index";


// @Component({
//   selector: 'pams-course-select',
//   templateUrl: './course-select.component.html',
// })
// export class CourseSelectComponent implements OnInit {

//   private COURSES = "plannerModuleState.courses".split(".");
//   private courses$: Observable<Course[]>;
//   @Input() placeholder: string;
//   @Input() innerFormControl: FormControl;

//   constructor(private store: Store<PlannerModuleState>,
//               private actions: CourseActions) {
//     this.courses$ = this.store.select(...this.COURSES);
//   }

//   ngOnInit() {
//     this.store.dispatch(this.actions.findCourses());
//   }

//   selectChangeEvent(event: Course) {
//     this.innerFormControl.setValue(event, {emitEvent: false});
//   }
// }

