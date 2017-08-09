import {TermService} from '../../../../services/term.service';
import {Component, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Offering} from '../../../shared/model/term/offering.interface';
import {OfferingActions} from './offering.action';
import {TermModuleState} from '../index';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {OfferingEditorDialog} from './dialog/offering-editor.dialog';

@Component({
  selector: 'pams-offering-center',
  templateUrl: './offering-center.page.html',
})
export class OfferingCenterPage implements OnInit {

  private OFFERINGS: string[] = 'termModuleState.offerings'.split('.');
  private offerings$: Observable<Offering[]>;
  private creatorDialogRef: MdDialogRef<OfferingEditorDialog>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: OfferingActions,
              private termService: TermService,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {
    this.offerings$ = this.store.select(...this.OFFERINGS);
  }

  goBack(route: string): void {
    this.router.navigate(['/offerings']);
  }

  viewOffering(offering: Offering): void {
    console.log('offering ccode: ' + offering.canonicalCode);
    this.router.navigate(['/secure/term/offerings', offering.canonicalCode]);
  }

  createDialog(): void {
    this.showDialog(null);
  }

  ngOnInit(): void {
    this.store.dispatch(this.actions.findOfferings());
    

  }

  private showDialog(code: Offering): void {
    console.log('showDialog');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '60%';
    config.position = {top: '0px'};
    this.creatorDialogRef = this.dialog.open(OfferingEditorDialog, config);
    this.creatorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog');
      // load something here
    });
  }
  
  sendEmail(): void {  
      window.alert("Email notification for new offerings will be send!");
      
      
    }

}
