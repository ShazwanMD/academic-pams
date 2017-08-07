
import {ChangeDetectionStrategy, Component, Input} from '@angular/core';
import {BundleSubject} from '../../../../shared/model/planner/bundle-subject.interface';

@Component({
  selector: 'pams-bundle-list',
  templateUrl: 'bundle-list.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class BundleListComponent {

  @Input() bundleSubject: BundleSubject;
}
