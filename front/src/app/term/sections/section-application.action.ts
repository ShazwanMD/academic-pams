import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class SectionApplicationActions {
    
static ADD_SECTION = '[SectionApplication] Add SectionApplication';

  addSection(section): Action {
    return {
      type: SectionApplicationActions.ADD_SECTION,
      payload: {admission:section}
    };
  }

  static ADD_SECTION_SUCCESS = '[SectionApplication] Add SectionApplication Success';

  addSectionSuccess(message): Action {
    return {
      type: SectionApplicationActions.ADD_SECTION_SUCCESS,
      payload: message
    };
  }


}