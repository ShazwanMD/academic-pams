// import {CourseCreatorDialog} from '../../courses/dialog/course-creator.dialog';
// import {Curriculum} from '../curriculum.interface';
// import {CourseEditorDialog} from '../../courses/dialog/course-editor.dialog';
// import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit} from '@angular/core';
// import {Course} from '../../courses/course.interface';
// import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
// import {ActivatedRoute, Router} from "@angular/router";
// import { CourseActions } from '../../courses/course.action';
// import {Store} from "@ngrx/store";
// import { PlannerModuleState } from './../../index';

// @Component({
//   selector: 'pams-curriculum-course-list',
//   templateUrl: './curriculum-course-list.component.html',
//   changeDetection: ChangeDetectionStrategy.OnPush,
// })
// export class CurriculumCourseListComponent implements OnInit {

//   @Input() course: Course;
//   @Input() curriculum: Curriculum;
//   @Input() courses: Course[];
//   @Output() view = new EventEmitter<Course>();

//   private selectedRows: Course[];
//   private creatorDialogRef: MdDialogRef<CourseCreatorDialog>;
//   private columns: any[] = [
//     {name: 'code', label: 'Code'},
//     {name: 'titleEn', label: 'Title(En)'},
//     {name: 'titleMs', label: 'Title(Ms)'},
//     {name: 'credit', label: 'Credit'},
//     {name: 'action', label: ''}
//   ];

//   constructor(private router: Router,
//               private route: ActivatedRoute,
//               private actions: CourseActions,
//               private store: Store<PlannerModuleState>,
//               private vcf: ViewContainerRef,
//               private dialog: MdDialog,) {
//   }

//   ngOnInit(): void {
//     this.selectedRows = this.courses.filter(value => value.selected);
//   }

//   filter(): void {
//   }

//   selectRow(course: Course): void {
//   }

//   selectAllRows(courses: Course[]): void {
//   }

//   editDialog(course: Course, isValid: boolean): void {
//     console.log("course:{}", course)
//     let config = new MdDialogConfig();
//     config.viewContainerRef = this.vcf;
//     config.role = 'dialog';
//     config.width = '60%';
//     config.height = '80%';
//     config.position = {top: '0px'};
//     this.creatorDialogRef = this.dialog.open(CourseCreatorDialog, config);
//     if (isValid) {
//       this.creatorDialogRef.componentInstance.course = course;
//       this.creatorDialogRef.componentInstance.curriculum = this.curriculum;

//     }
//     this.creatorDialogRef.afterClosed().subscribe(res => {
//       console.log("close dialog section");
//       // load something here
//     });
//   }

//   addCourseDialog(): void {
//     console.log("showDialog");
//     let config = new MdDialogConfig();
//     config.viewContainerRef = this.vcf;
//     config.role = 'dialog';
//     config.width = '50%';
//     config.height = '80%';
//     config.position = {top: '0px'};
//     this.creatorDialogRef = this.dialog.open(CourseCreatorDialog, config);
//     this.creatorDialogRef.componentInstance.curriculum = this.curriculum;
//     this.creatorDialogRef.afterClosed().subscribe(res => {
//       console.log("close dialog");
//       // load something here
//     });
//   }
// }
  
