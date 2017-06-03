import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Section} from "../section.interface";
import {Offering} from "../../offerings/offering.interface";
import {SectionEditorDialog} from "../dialog/section-editor.dialog";
import {MdDialog, MdDialogConfig, MdDialogRef, MdSnackBar} from "@angular/material";
import {SectionActions} from "../section.action";
import {Store} from "@ngrx/store";
import {TermModuleState} from "../../index";

@Component({
  selector: 'pams-section-action',
  templateUrl: './section-action.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SectionActionComponent {

  @Input() _section: Section;
  @Input() section: Section;
  @Input() offering: Offering;
  private editorDialogRef: MdDialogRef<SectionEditorDialog>;

  constructor(private actions: SectionActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

  }

  updateDialog(): void {
    console.log("open section dialog");
    console.log("canonicalcode",this.section.canonicalCode);
    
    
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
    this.editorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog section update");
      
    });
  }

}
