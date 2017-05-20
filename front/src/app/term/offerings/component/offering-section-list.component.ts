import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import { Section } from '../../sections/section.interface';
import { SectionCreateTaskCreatorDialog } from "../../sections/dialog/section-create-task-creator.dialog";
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";

@Component({
  selector: 'pams-offering-section-list',
  templateUrl: './offering-section-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingSectionListComponent {
    
    private creatorDialogRef: MdDialogRef<SectionCreateTaskCreatorDialog>;

    constructor(private vcf: ViewContainerRef,
        private dialog: MdDialog) {


  @Input() sections: Section[];
  @Output() view = new EventEmitter<Section>();

      private columns: any[] = [
    { name: 'id', label: 'Id' },
    { name: 'code', label: 'Code' },
    { name: 'capacity', label: 'Capacity' },
    { name: 'appointmentCount', label: 'Appointment' },
    { name: 'enrollmentCount', label: 'Enrollment' },
    { name: 'action', label: '' }
  ];

  showDialog(): void {
      console.log("showDialog");
      let config = new MdDialogConfig();
      config.viewContainerRef = this.vcf;
      config.role = 'dialog';
      config.width = '50%';
      config.height = '70%';
      config.position = {top: '0px'};
      this.creatorDialogRef = this.dialog.open(SectionCreateTaskCreatorDialog, config);
      this.creatorDialogRef.afterClosed().subscribe(res => {
        console.log("close dialog");
        // load something here
      });
    }
}

