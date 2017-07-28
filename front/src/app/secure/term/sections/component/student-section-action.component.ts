import {Component, Input, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Section} from '../../../../shared/model/term/section.interface';
import {Offering} from '../../../../shared/model/term/offering.interface';
import {SectionEditorDialog} from '../dialog/section-editor.dialog';
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from '@angular/material';
import {SectionActions} from '../section.action';
import {Store} from '@ngrx/store';
import {TermModuleState} from '../../index';

@Component({
  selector: 'pams-student-section-action',
  templateUrl: './student-section-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class StudentSectionActionComponent {

  private editorDialogRef: MdDialogRef<SectionEditorDialog>;
  @Input() section: Section;
  @Input() offering: Offering;

  constructor(private actions: SectionActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

  }

  updateDialog(): void {
    console.log('open section dialog');
    console.log('canonicalcode', this.section.canonicalCode);
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(SectionEditorDialog, config);
    this.editorDialogRef.componentInstance.section = this.section;
    this.editorDialogRef.componentInstance.offering = this.offering;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog section update');

    });
  }
}
