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
  selector: 'pams-enrollment-application-item-list',
  templateUrl: './enrollment-application-item-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class EnrollmentApplicationItemComponent implements OnInit {

  @Input() enrollmentApplication: EnrollmentApplication;
  @Input() enrollmentApplicationItems: EnrollmentApplicationItem[];

  private editorDialogRef: MdDialogRef<EnrollmentApplicationItemEditorDialog>;
  private selectedRows: EnrollmentApplicationItem[];

  private columns: any[] = [
    {name: 'section.code', label: 'Section'},
    {name: 'section.ordinal', label: 'Section No'},
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
    this.selectedRows = this.enrollmentApplicationItems.filter(value => value.selected);
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
