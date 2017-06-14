import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit} from '@angular/core';
import {Enrollment} from '../../enrollments/enrollment.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {ActivatedRoute, Router} from "@angular/router";
import {EnrollmentActions} from "../../enrollments/enrollment.action";
import {Store} from "@ngrx/store";
import {TermModuleState} from "../../index";
import {EnrollmentEditorDialog} from "../../enrollments/dialog/enrollment-editor.dialog";
import {Admission} from "../admission.interface";

@Component({
  selector: 'pams-admission-enrollment-list',
  templateUrl: './admission-enrollment-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdmissionEnrollmentListComponent implements OnInit {

  @Input() enrollment: Enrollment;
  @Input() admission: Admission;
  @Input() enrollments: Enrollment[];
  @Output() view = new EventEmitter<Enrollment>();

  private selectedRows: Enrollment[];
  private creatorDialogRef: MdDialogRef<EnrollmentEditorDialog>;
  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'action', label: ''}
  ];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: EnrollmentActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,) {
  }

  ngOnInit(): void {
    //this.selectedRows = this.enrollments.filter(value => value.selected);
  }

  filter(): void {
  }

  selectRow(enrollment: Enrollment): void {
  }

  selectAllRows(enrollments: Enrollment[]): void {
  }

 /* editDialog(enrollment: Enrollment, isValid: boolean): void {
    console.log("enrollment:{}", enrollment)
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(EnrollmentEditorDialog, config);
    if (isValid) {
      this.creatorDialogRef.componentInstance.enrollment = enrollment;
      this.creatorDialogRef.componentInstance.admission = this.admission;

    }
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog section");
      // load something here
    });
  }*/

 /* addEnrollmentDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(EnrollmentEditorDialog, config);
    this.creatorDialogRef.componentInstance.admission = this.admission;
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }*/

 /* deleteEnrollment(enrollment: Enrollment): void {
    console.log("deleteSection");
    this.store.dispatch(this.actions.deleteEnrollment(this.admission, enrollment))
  }*/
}

