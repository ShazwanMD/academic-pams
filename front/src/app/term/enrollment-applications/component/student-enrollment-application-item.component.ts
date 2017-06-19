/*import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {EnrollmentApplication} from "../enrollment-application.interface";
import {EnrollmentApplicationItem} from "../enrollment-application-item.interface";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {ActivatedRoute, Router} from "@angular/router";
import {Store} from "@ngrx/store";
import {TermModuleState} from "../../index";
import {Enrollment} from "../../enrollments/enrollment.interface";
//import { AppointmentEditorDialog } from "../../appointments/dialog/appointment-editor.dialog";

@Component({
  selector: 'pams-student-enrollment-application-item',
  templateUrl: './student-enrollment-application-item.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class StudentEnrollmentApplicationItemComponent {

  @Input() enrollmentApplication: EnrollmentApplication;
  @Input() enrollmentApplicationItems: EnrollmentApplicationItem[];
  @Output() view = new EventEmitter<EnrollmentApplication>();
  @Output() view2 = new EventEmitter<EnrollmentApplicationItem>();

  //display data enrollmentapplicationItems
  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'action', label: ''}
  ];


  //private creatorDialogRef: MdDialogRef<AppointmentEditorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }

  showDialog(): void {
    console.log("showDialog");
    console.log("enrollmentApplication to pass:" + this.enrollmentApplication);

    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AppointmentEditorDialog, config);
    this.creatorDialogRef.componentInstance.enrollmentApplication = this.enrollmentApplication;
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }

}*/


import {Component, Input, ChangeDetectionStrategy, ViewContainerRef, OnInit} from '@angular/core';
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {ActivatedRoute, Router} from "@angular/router";
import {TermModuleState} from "../../index";
import {Store} from "@ngrx/store";
import {EnrollmentApplication} from "../enrollment-application.interface";
import {EnrollmentApplicationItem} from "../enrollment-application-item.interface";
import {EnrollmentApplicationItemEditorDialog} from "../dialog/enrollment-application-item-editor.dialog";
import {EnrollmentApplicationActions} from "../enrollment-application.action";

@Component({
    selector: 'pams-student-enrollment-application-item',
    templateUrl: './student-enrollment-application-item.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,

  })
  export class StudentEnrollmentApplicationItemComponent implements OnInit {

  @Input() enrollmentApplication: EnrollmentApplication;
  @Input() enrollmentApplicationItems: EnrollmentApplicationItem[];

  private editorDialogRef: MdDialogRef<EnrollmentApplicationItemEditorDialog>;
  private selectedRows: EnrollmentApplicationItem[];

  private columns: any[] = [
    {name: 'section.ordinal', label: 'Section'},
    {name: 'section.code', label: 'Code'},
    {name: 'section.offering.titleEn', label: 'Title'},
    {name: 'section.offering.course.credit', label: 'Credit'},
    {name: 'action', label: 'Action'}
  ];


  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentApplicationActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }

  ngOnInit(): void {
    //this.selectedRows = this.enrollmentApplicationItems.filter(value => value.selected);
  }

  filter(): void {
  }

  selectRow(item: EnrollmentApplicationItem): void {
  }

  selectAllRows(items: EnrollmentApplicationItem[]): void {
  }

  delete(item: EnrollmentApplicationItem): void {
    this.store.dispatch(this.actions.deleteEnrollmentApplicationItem(this.enrollmentApplication, item));
  }


  createDialog(): void {
    console.log("show Dialog EnrollmentApplicationItem");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '40%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(EnrollmentApplicationItemEditorDialog, config);
    this.editorDialogRef.componentInstance.enrollmentApplication = this.enrollmentApplication;

    // close
    this.editorDialogRef.afterClosed().subscribe(res => {
      // do something
    });
  }
}

