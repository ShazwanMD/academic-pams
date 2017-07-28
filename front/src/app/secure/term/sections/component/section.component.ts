import {ChangeDetectionStrategy, Component, EventEmitter, Input, Output, ViewContainerRef} from '@angular/core';
import {Section} from '../../../../shared/model/term/section.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {ActivatedRoute, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';
import {Enrollment} from '../../../../shared/model/term/enrollment.interface';
import {AppointmentEditorDialog} from '../../appointments/dialog/appointment-editor.dialog';

@Component({
  selector: 'pams-section',
  templateUrl: './section.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class SectionComponent {

  private columns: any[] = [
    {name: 'id', label: 'Id'},
    {name: 'action', label: ''},
  ];
  private creatorDialogRef: MdDialogRef<AppointmentEditorDialog>;

  @Input() section: Section;
  @Input() enrollments: Enrollment[];
  @Output() view = new EventEmitter<Section>();
  @Output() view2 = new EventEmitter<Enrollment>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
  }

  showDialog(): void {
    console.log('showDialog');
    console.log('Section to pass:' + this.section);

    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(AppointmentEditorDialog, config);
    this.creatorDialogRef.componentInstance.section = this.section;
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }

}
