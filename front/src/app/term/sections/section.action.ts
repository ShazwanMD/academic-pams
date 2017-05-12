import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class SectionActions {

  static FIND_SECTIONS = '[Section] Find Sections';

  findSections(): Action {
    return {
      type: SectionActions.FIND_SECTIONS
    };
  }

  static FIND_SECTIONS_SUCCESS = '[Section] Find Sections Success';
  findSectionsSuccess(sections): Action {
    return {
      type: SectionActions.FIND_SECTIONS_SUCCESS,
      payload: sections
    };
  }

  static FIND_SECTION_BY_CANONICAL_CODE = '[Section] Find Section By Canonical Code';
  findSectionByCanonicalCode(canonical_code): Action {
    return {
      type: SectionActions.FIND_SECTION_BY_CANONICAL_CODE,
      payload: canonical_code
    };
  }

  static FIND_SECTION_BY_CANONICAL_CODE_SUCCESS = '[Section] Find Section By Canonical Code Success';
  findSectionByCanonicalCodeSuccess(section): Action {
    return {
      type: SectionActions.FIND_SECTION_BY_CANONICAL_CODE_SUCCESS,
      payload: section
    };
  }

  static FIND_SECTION_BY_CURRENT = '[Section] Find Section By Current';
  findSectionByCurrent(section): Action {
    return {
      type: SectionActions.FIND_SECTION_BY_CURRENT,
      payload: section
    };
  }

  static FIND_SECTION_BY_CURRENT_SUCCESS = '[Section] Find Section By Current Success';
  findSectionByCurrentSuccess(section): Action {
    return {
      type: SectionActions.FIND_SECTION_BY_CURRENT_SUCCESS,
      payload: section
    };
  }


}
