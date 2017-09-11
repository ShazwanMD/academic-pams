import { ChangeDetectionStrategy, Component, Input, OnChanges, SimpleChange, ViewChild } from '@angular/core';
import { OfferingActions } from '../offering.action';
import { Store } from '@ngrx/store';
import { TermModuleState } from '../../index';
import { GradebookMatrix } from '../../../../shared/model/term/gradebook-matrix.interface';
import { TdDataTableComponent } from '@covalent/core';
import { Offering } from '../../../../shared/model/term/offering.interface';
import { Assessment } from '../../../../shared/model/term/assessment.interface';

@Component( {
    selector: 'pams-gradebook',
    templateUrl: './gradebook.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
} )
export class GradebookComponent implements OnChanges {

    @Input() offering: Offering;
    @Input() gradebookMatrices: GradebookMatrix[];
    @Input() assessments: Assessment[];
    @ViewChild( 'dataTable' ) dataTable: TdDataTableComponent;

    columns: any[] = [
        { label: 'Student name', name: 'enrollment.admission.student.name' },
    ];

    constructor( private actions: OfferingActions,
        private store: Store<TermModuleState> ) {
    }

    ngOnChanges( changes: { [propName: string]: SimpleChange } ) {
        if ( changes['gradebookMatrices'] && this.gradebookMatrices ) {
            let a = changes['gradebookMatrices']['currentValue'];
            if ( a.length > 0 ) {
                a.forEach(( i ) => {
                    let b = i['gradebooks'];
                    if ( b.length > 0 ) {
                        for ( let j = 0; j < b.length; j++ ) {
                            this.columns[j + 1] = {
                                label: b[j].assessment.description,
                                name: 'gradebooks.' + j + '.score',
                            };
                        }
                        console.log( this.columns );
                    }
                    console.log( i['gradebooks'] );
                } );

            }
        }
    }

    download(): void {
        this.store.dispatch( this.actions.downloadGradebook( this.offering ) );
    }

    upload( file: File ): void {
        console.log( 'gradebookComponent', file );
        this.store.dispatch( this.actions.uploadGradebook( this.offering, file ) );

    }

}
