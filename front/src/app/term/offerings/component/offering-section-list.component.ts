import {Component, Input, EventEmitter, Output, ChangeDetectionStrategy, ViewContainerRef} from '@angular/core';
import {Section} from '../../sections/section.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from "@angular/material";
import {ActivatedRoute, Router} from "@angular/router";
import {SectionActions} from "../../sections/section.action";
import {Store} from "@ngrx/store";
import {TermModuleState} from "../../index";
import {SectionEditorDialog} from "../../sections/dialog/section-editor.dialog";
import {Offering} from "../offering.interface";

@Component({
  selector: 'pams-offering-section-list',
  templateUrl: './offering-section-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class OfferingSectionListComponent {

  private creatorDialogRef: MdDialogRef<SectionEditorDialog>;
  private edit: boolean = false;
  private _offering: Offering;
  private _section: Section;

  @Input() section: Section;
  @Input() offering: Offering;
  @Input() sections: Section[];
  @Output() view = new EventEmitter<Section>();

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: SectionActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog,) {
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { canonicalCode: string }) => {
      let canonicalCode: string = params.canonicalCode;
      this.store.dispatch(this.actions.findOfferingByCanonicalCode(canonicalCode));
    });
  }

  private columns: any[] = [
    {name: 'ordinal', label: 'Ordinal'},
    {name: 'code', label: 'Code'},
    {name: 'capacity', label: 'Capacity'},
    {name: 'appointmentCount', label: 'Appointment'},
    {name: 'enrollmentCount', label: 'Enrollment'},
    {name: 'action', label: ''}
  ];

   //update section using dialog
     updateSection(section: Section): void {
         console.log(section);
      this.showUpdateDialog(section)
    } 
    
         
   //show update dialog for section
    
    private showUpdateDialog(canonicalCode: Section): void {
    console.log("update section dialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '70%';
    config.height = '50%';
    config.position = { top: '0px' };
    this.creatorDialogRef = this.dialog.open(SectionEditorDialog, config);
    if (this.section) this.creatorDialogRef.componentInstance.section = this.section; 
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog for update section");
    });
  }
    
 
    
  showSectionDialog(): void {
    console.log("showDialog");
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '50%';
    config.height = '50%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(SectionEditorDialog, config);
    this.creatorDialogRef.componentInstance.offering = this.offering;
    this.creatorDialogRef.afterClosed().subscribe(res => {
      console.log("close dialog");
      // load something here
    });
  }
    

  deleteSection(section: Section): void {
      console.log("deleteSection");
      console.log(section);
    this.store.dispatch(this.actions.deleteSection(this.offering, section))
  }
  
    
}

