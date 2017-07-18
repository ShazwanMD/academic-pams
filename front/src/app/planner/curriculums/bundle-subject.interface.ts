import {BundleSubjectPart} from './bundle-subject-part.interface';
import {Subject} from './subject.interface';
export interface BundleSubject extends Subject {
  parts: BundleSubjectPart[];
}
