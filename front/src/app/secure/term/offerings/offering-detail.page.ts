import {Component, Input, OnInit, ViewContainerRef} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {OfferingUpdateDialog} from './dialog/offering-update.dialog';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs';
import {Offering} from '../../../shared/model/term/offering.interface';
import {OfferingActions} from './offering.action';
import {TermModuleState} from '../index';
import {Section} from '../../../shared/model/term/section.interface';
import {MdDialog, MdDialogConfig, MdDialogRef} from '@angular/material';
import {Assessment} from '../../../shared/model/term/assessment.interface';

@Component({
  selector: 'pams-offering-detail',
  templateUrl: './offering-detail.page.html',
})

export class OfferingDetailPage implements OnInit {

  private OFFERING: string[] = 'termModuleState.offering'.split('.');
  private SECTIONS: string[] = 'termModuleState.offeringSections'.split('.');
  private SECTION: string[] = 'termModuleState.section'.split('.');
  private ASSESSMENTS: string[] = 'termModuleState.offeringAssessments'.split('.');
  private offering$: Observable<Offering>;
  private sections$: Observable<Section[]>;
  private section$: Observable<Section[]>;
  private assessments$: Observable<Assessment[]>;
  private editorDialogRef: MdDialogRef<OfferingUpdateDialog>;

  @Input() offering: Offering;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private actions: OfferingActions,
              private store: Store<TermModuleState>,
              private vcf: ViewContainerRef,
              private dialog: MdDialog) {

    this.offering$ = this.store.select(...this.OFFERING);
    this.sections$ = this.store.select(...this.SECTIONS);
    this.section$ = this.store.select(...this.SECTION);
    this.assessments$ = this.store.select(...this.ASSESSMENTS);
  }

  ngOnInit(): void {
    this.route.params.subscribe((params: { canonicalCode: string }) => {
      let canonicalCode: string = params.canonicalCode;
      this.store.dispatch(this.actions.findOfferingByCanonicalCode(canonicalCode));
    });
  }

  showUpdateDialog(): void {
    console.log('edit offering');
    let config = new MdDialogConfig();
    config.viewContainerRef = this.vcf;
    config.role = 'dialog';
    config.width = '60%';
    config.height = '40%';
    config.position = {top: '0px'};
    this.editorDialogRef = this.dialog.open(OfferingUpdateDialog, config);
    this.editorDialogRef.componentInstance.offering = this.offering;

    // set
    this.editorDialogRef.afterClosed().subscribe((res) => {
      console.log('close dialog update offering');
    });
  }

  filter(): void {

  }

  goBack(route: string): void {
    this.router.navigate(['/offerings']);
  }

  deleteSection(section: Section): void {
    console.log('section: ' + section.canonicalCode);
    this.router.navigate(['/secure/term/offerings']);
    //history.go(0);
    //this.router.navigate(['/secure/term/offerings', this.offering.canonicalCode]);
  }

}

