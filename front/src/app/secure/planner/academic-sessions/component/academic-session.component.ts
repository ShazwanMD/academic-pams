import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {AcademicYear} from '../../../../shared/model/planner/academic-year.interface';
import {AcademicSemester} from '../../../../shared/model/planner/academic-semester-type.enum';
import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output, ViewContainerRef} from '@angular/core';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {AcademicSession} from '../../../../shared/model/planner/academic-session.interface';
import {AcademicSessionEditorDialog} from '../dialog/academic-session-editor.dialog';
import {ActivatedRoute, Router} from '@angular/router';
import {AcademicSessionActions} from '../academic-session.action';
import {PlannerModuleState} from '../../index';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'pams-academic-session',
  templateUrl: './academic-session.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AcademicSessionComponent implements OnInit {

  private editorDialogRef: MdDialogRef<AcademicSessionEditorDialog>;
  private ACADEMIC_SESSION: string[] = 'plannerModuleState.academicSession'.split('.');
  private academicSession$: Observable<AcademicSession>;
  private columns: any[] = [
    {name: 'code', label: 'Code'},
    {name: 'description', label: 'Description'},
    {name: 'current', label: 'Current'},
    {name: 'startDate', label: 'Start Date'},
    {name: 'endDate', label: 'End Date'},
    {name: 'semester', label: 'AcademicSemester'},
    {name: 'year', label: 'AcademicYear'},
    {name: 'action', label: ''},
  ];

  @Input() academicSession: AcademicSession;
  @Input() semester: AcademicSemester;
  @Input() year: AcademicYear;
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;
  @Output() view = new EventEmitter<AcademicSession>();


  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: AcademicSessionActions,
              private vcf: ViewContainerRef,
              private store: Store<PlannerModuleState>,
              private dialog: MdDialog) {
    this.academicSession$ = this.store.select(...this.ACADEMIC_SESSION);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { code: string }) => {
      let code: string = params.code;
      this.store.dispatch(this.actions.findAcademicSessionByCode(code));
    });
  }

  editSession(): void {
    console.log('edit');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '80%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(AcademicSessionEditorDialog, config);
    this.editorDialogRef.componentInstance.academicSession = this.academicSession;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
    });
  }

  selectChangeEvent(event: AcademicSession) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }

}
