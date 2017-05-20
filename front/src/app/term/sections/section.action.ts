import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';

@Injectable()
export class SectionActions {

  static FIND_SECTION_BY_CANONICAL_CODE = '[Section] Find Section By Canonical Code';
  findSectionByCanonicalCode(canonicalCode): Action {
    return {
      type: SectionActions.FIND_SECTION_BY_CANONICAL_CODE,
      payload: canonicalCode
    };
  }

  static FIND_SECTION_BY_CANONICAL_CODE_SUCCESS = '[Offering] Find Section By Canonical Code Success';
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

  static FIND_SECTION_BY_ID_SUCCESS = '[Section] Find Section By Id Success';
  findSectionByIdSuccess(section): Action {
    return {
      type: SectionActions.FIND_SECTION_BY_ID_SUCCESS,
      payload: section
    };
  }

  static ADD_SECTION = '[Section] Add Section';

  addSection(section): Action {
    return {
      type: SectionActions.ADD_SECTION,
      payload: {admission:section}
    };
  }

  static ADD_SECTION_SUCCESS = '[Section] Add Section Success';

  addSectionSuccess(message): Action {
    return {
      type: SectionActions.ADD_SECTION_SUCCESS,
      payload: message
    };
  }

}
