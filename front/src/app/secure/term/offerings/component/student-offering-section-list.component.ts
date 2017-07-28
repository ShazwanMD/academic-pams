import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef, OnInit} from '@angular/core';
import {Section} from '../../../../shared/model/term/section.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {SectionActions} from '../../sections/section.action';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';
import {SectionEditorDialog} from '../../sections/dialog/section-editor.dialog';
import {Offering} from '../../../../shared/model/term/offering.interface';

@Component({
  selector: 'pams-student-offering-section-list',
  templateUrl: './student-offering-section-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentOfferingSectionListComponent implements OnInit {

  private selectedRows: Section[];
  private creatorDialogRef: MdDialogRef<SectionEditorDialog>;
  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'ordinal', label: 'Section No'},
    {name: 'code', label: 'Code'},
    {name: 'capacity', label: 'Capacity'},
    {name: 'appointmentCount', label: 'Appointment'},
    {name: 'enrollmentCount', label: 'Enrollment'},
    {name: 'action', label: ''},
  ];

  @Input() section: Section;
  @Input() offering: Offering;
  @Input() sections: Section[];
  @Output() view = new EventEmitter<Section>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: SectionActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog, ) {
  }

  ngOnInit(): void {
    this.selectedRows = this.sections.filter((value) => value.selected);
  }

  filter(): void {
  }

  selectRow(section: Section): void {
  }

  selectAllRows(sections: Section[]): void {
  }

  editDialog(section: Section, isValid: boolean): void {
    console.log('Section:{}', section);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(SectionEditorDialog, config);
    if (isValid) {
      this.creatorDialogRef.componentInstance.section = section;
      this.creatorDialogRef.componentInstance.offering = this.offering;

    }
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog section');
      // load something here
    });
  }

  addSectionDialog(): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(SectionEditorDialog, config);
    this.creatorDialogRef.componentInstance.offering = this.offering;
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

  deleteSection(section: Section): void {
    console.log('deleteSection');
    this.store.dispatch(this.actions.deleteSection(this.offering, section));
  }
}

