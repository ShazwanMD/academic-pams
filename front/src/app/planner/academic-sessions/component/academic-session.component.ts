import { Store } from '@ngrx/store';
import { AcademicYear } from './../academic-session-year.interface';
import { AcademicSemester } from '../academic-session-semester-type.enum';
import { ChangeDetectionStrategy, Component, EventEmitter, Input, Output, ViewContainerRef } from '@angular/core';
import { MdDialogRef, MdDialog, MdDialogConfig } from '@angular/material';
import { AcademicSession } from "../academic-session.interface";
import { AcademicSessionCreatorDialog } from '../dialog/academic-session-creator.dialog';
import { AcademicSessionEditorDialog } from '../dialog/academic-session-editor.dialog';
import { Router, ActivatedRoute } from '@angular/router';
import { AcademicSessionActions } from '../academic-session.action';
import { PlannerModuleState } from '../../index';

@Component({
  selector: 'pams-academic-session',
  templateUrl: 'academic-session.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AcademicSessionComponent {

  @Input() academicSession: AcademicSession;
  @Input() semester: AcademicSemester;
  @Input() year: AcademicYear;

  private editorDialogRef: MdDialogRef<AcademicSessionEditorDialog>;

  private columns: any[] = [
    { name: 'code', label: 'Code' },
    { name: 'description', label: 'Description' },
    { name: 'current', label: 'Current' },
    { name: 'startDate', label: 'Start Date' },
    { name: 'endDate', label: 'End Date' },
    { name: 'semester', label: 'AcademicSemester' },
    { name: 'year.year', label: 'AcademicYear' },
    { name: 'action', label: '' }
  ];

  constructor(private router: Router,
    private route: ActivatedRoute,
    private actions: AcademicSessionActions,
    private vcf: ViewContainerRef,
    private store: Store<PlannerModuleState>,
    private dialog: MdDialog) {
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { academicSession: string }) => {
      let academicSession: string = params.academicSession;
      this.store.dispatch(this.actions.findAcademicSessionByCode(academicSession));
    });
  }
 editSession(): void {
    console.log("edit");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = { top: '0px' };
    this.editorDialogRef = this.dialog.open(AcademicSessionEditorDialog, config);
    this.editorDialogRef.componentInstance.academicSession = this.academicSession;

    // set
    this.editorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
    });
  }

}
