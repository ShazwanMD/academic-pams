package my.edu.umk.pams.academic.common.service;

import my.edu.umk.pams.academic.common.model.*;

import java.util.List;

public interface CommonService {

	// ====================================================================================================
	// COUNTRY CODE
	// ====================================================================================================

	AdCountryCode findCountryCodeById(Long id);

	AdCountryCode findCountryCodeByCode(String code);

	List<AdCountryCode> findCountryCodes(String filter, Integer offset, Integer limit);

	Integer countCountryCode(String filter);

	void saveCountryCode(AdCountryCode countryCode);

	void updateCountryCode(AdCountryCode countryCode);

	void removeCountryCode(AdCountryCode countryCode);

	// ====================================================================================================
	// STATE CODE
	// ====================================================================================================

	AdStateCode findStateCodeById(Long id);

	AdStateCode findStateCodeByCode(String code);

	List<AdStateCode> findStateCodes(Integer offset, Integer limit);

	List<AdStateCode> findStateCodes(String filter, Integer offset, Integer limit);

	List<AdStateCode> findStateCodes(AdCountryCode countryCode, Integer offset, Integer limit);

	List<AdStateCode> findStateCodes(String filter, AdCountryCode countryCode, Integer offset, Integer limit);

	Integer countStateCode();

	Integer countStateCode(String filter);

	Integer countStateCode(AdCountryCode countryCode);

	Integer countStateCode(String filter, AdCountryCode countryCode);

	void saveStateCode(AdStateCode stateCode);

	void updateStateCode(AdStateCode stateCode);

	void removeStateCode(AdStateCode stateCode);

	// ====================================================================================================
	// DISTRICT CODE
	// ====================================================================================================

	AdDistrictCode findDistrictCodeById(Long id);

	AdDistrictCode findDistrictCodeByCode(String code);

	List<AdDistrictCode> findDistrictCodes(AdStateCode stateCod, Integer offset, Integer limit);

	List<AdDistrictCode> findDistrictCodes(String filter, AdStateCode stateCode, Integer offset, Integer limit);

	Integer countDistrictCode(AdStateCode stateCode);

	Integer countDistrictCode(String filter, AdStateCode stateCode);

	void saveDistrictCode(AdDistrictCode districtCode);

	void updateDistrictCode(AdDistrictCode districtCode);

	void removeDistrictCode(AdDistrictCode districtCode);

	// ====================================================================================================
	// CITY CODE
	// ====================================================================================================

	AdCityCode findCityCodeById(Long id);

	AdCityCode findCityCodeByCode(String code);

	List<AdCityCode> findCityCodes(AdStateCode stateCode, Integer offset, Integer limit);

	List<AdCityCode> findCityCodes(String filter, AdStateCode stateCode, Integer offset, Integer limit);

	Integer countCityCode(AdStateCode stateCode);

	Integer countCityCode(String filter, AdStateCode stateCode);

	void saveCityCode(AdCityCode cityCode);

	void updateCityCode(AdCityCode cityCode);

	void removeCityCode(AdCityCode cityCode);

	// ====================================================================================================
	// STUDY CENTER CODE
	// ====================================================================================================

	AdStudyCenterCode findStudyCenterCodeById(Long id);

	AdStudyCenterCode findStudyCenterCodeByCode(String code);
	
	AdStudyCenter findStudyCenterByCode(String code);

	List<AdStudyCenterCode> findStudyCenterCodes();

	List<AdStudyCenterCode> findStudyCenterCodes(String filter, Integer offset, Integer limit);

	Integer countStudyCenterCode();

	Integer countStudyCenterCode(String filter);

	void saveStudyCenterCode(AdStudyCenterCode studyCenterCode);
	
	void saveStudyCenter(AdStudyCenter studyCenter);

	void updateStudyCenterCode(AdStudyCenterCode studyCenterCode);

	void removeStudyCenterCode(AdStudyCenterCode studyCenterCode);

	// ====================================================================================================
	// VENUE CODE
	// ====================================================================================================

	AdVenueCode findVenueCodeById(Long id);

	AdVenueCode findVenueCodeByCode(String code);

	List<AdVenueCode> findVenueCodes();

	List<AdVenueCode> findVenueCodes(String filter, Integer offset, Integer limit);

	Integer countVenueCode();

	Integer countVenueCode(String filter);

	void saveVenueCode(AdVenueCode venueCode);

	void updateVenueCode(AdVenueCode venueCode);

	void removeVenueCode(AdVenueCode venueCode);

	// ====================================================================================================
	// BANK CODE
	// ====================================================================================================

	AdBankCode findBankCodeById(Long id);

	AdBankCode findBankCodeByCode(String code);

	List<AdBankCode> findBankCodes();

	List<AdBankCode> findBankCodes(String filter, Integer offset, Integer limit);

	Integer countBankCode();

	Integer countBankCode(String filter);

	void saveBankCode(AdBankCode bankCode);

	void updateBankCode(AdBankCode bankCode);

	void removeBankCode(AdBankCode bankCode);

	// ====================================================================================================
	// FIELD CODE
	// ====================================================================================================

	AdFieldCode findFieldCodeById(Long id);

	AdFieldCode findFieldCodeByCode(String code);

	List<AdFieldCode> findFieldCodes();

	List<AdFieldCode> findFieldCodes(Integer offset, Integer limit);

	List<AdFieldCode> findFieldCodes(String filter, Integer offset, Integer limit);

	Integer countFieldCode();

	Integer countFieldCode(String filter);

	void saveFieldCode(AdFieldCode fieldCode);

	void updateFieldCode(AdFieldCode fieldCode);

	void removeFieldCode(AdFieldCode fieldCode);

	// ====================================================================================================
	// RELIGION CODE
	// ====================================================================================================

	AdReligionCode findReligionCodeById(Long id);

	AdReligionCode findReligionCodeByCode(String code);

	List<AdReligionCode> findReligionCodes();

	List<AdReligionCode> findReligionCodes(String filter, Integer offset, Integer limit);

	Integer countReligionCode();

	Integer countReligionCode(String filter);

	void saveReligionCode(AdReligionCode religionCode);

	void updateReligionCode(AdReligionCode religionCode);

	void removeReligionCode(AdReligionCode religionCode);

	// ====================================================================================================
	// SUBJECT CODE
	// ====================================================================================================

	AdSubjectCode findSubjectCodeById(Long id);

	AdSubjectCode findSubjectCodeByCode(String code);

	List<AdSubjectCode> findSubjectCodes();

	List<AdSubjectCode> findSubjectCodes(Integer offset, Integer limit);

	List<AdSubjectCode> findSubjectCodes(String filter, Integer offset, Integer limit);

	Integer countSubjectCode();

	Integer countSubjectCode(String filter);

	void saveSubjectCode(AdSubjectCode subjectCode);

	void updateSubjectCode(AdSubjectCode subjectCode);

	void removeSubjectCode(AdSubjectCode subjectCode);

	// ====================================================================================================
	// GRADE CODE
	// ====================================================================================================

	AdGradeCode findGradeCodeById(Long id);

	AdGradeCode findGradeCodeByCode(String code);

	List<AdGradeCode> findGradeCodes();

	List<AdGradeCode> findGradeCodes(Integer offset, Integer limit);

	List<AdGradeCode> findGradeCodes(String filter, Integer offset, Integer limit);

	Integer countGradeCode();

	Integer countGradeCode(String filter);

	void saveGradeCode(AdGradeCode gradeCode);

	void updateGradeCode(AdGradeCode gradeCode);

	void removeGradeCode(AdGradeCode gradeCode);

	// ====================================================================================================
	// GENDER CODE
	// ====================================================================================================

	AdGenderCode findGenderCodeById(Long id);

	AdGenderCode findGenderCodeByCode(String code);

	List<AdGenderCode> findGenderCodes();

	List<AdGenderCode> findGenderCodes(String filter, Integer offset, Integer limit);

	Integer countGenderCode();

	Integer countGenderCode(String filter);

	void saveGenderCode(AdGenderCode genderCode);

	void updateGenderCode(AdGenderCode genderCode);

	void removeGenderCode(AdGenderCode genderCode);

	// ====================================================================================================
	// RACE CODE
	// ====================================================================================================

	AdRaceCode findRaceCodeById(Long id);

	AdRaceCode findRaceCodeByCode(String code);

	List<AdRaceCode> findRaceCodes();

	List<AdRaceCode> findRaceCodes(String filter, Integer offset, Integer limit);

	Integer countRaceCode();

	Integer countRaceCode(String filter);

	void saveRaceCode(AdRaceCode raceCode);

	void updateRaceCode(AdRaceCode raceCode);

	void removeRaceCode(AdRaceCode raceCode);

	// ====================================================================================================
	// ETHNICITY CODE
	// ====================================================================================================

	AdEthnicityCode findEthnicityCodeById(Long id);

	AdEthnicityCode findEthnicityCodeByCode(String code);

	List<AdEthnicityCode> findEthnicityCodes();

	List<AdEthnicityCode> findEthnicityCodes(String filter, Integer offset, Integer limit);

	Integer countEthnicityCode();

	Integer countEthnicityCode(String filter);

	void saveEthnicityCode(AdEthnicityCode ethnicityCode);

	void updateEthnicityCode(AdEthnicityCode ethnicityCode);

	void removeEthnicityCode(AdEthnicityCode ethnicityCode);

	// ====================================================================================================
	// MARITAL CODE
	// ====================================================================================================

	AdMaritalCode findMaritalCodeById(Long id);

	AdMaritalCode findMaritalCodeByCode(String code);

	List<AdMaritalCode> findMaritalCodes();

	List<AdMaritalCode> findMaritalCodes(String filter, Integer offset, Integer limit);

	Integer countMaritalCode();

	Integer countMaritalCode(String filter);

	void saveMaritalCode(AdMaritalCode maritalCode);

	void updateMaritalCode(AdMaritalCode maritalCode);

	void removeMaritalCode(AdMaritalCode maritalCode);

	// ====================================================================================================
	// DEPENDENCY CODE
	// ====================================================================================================

	AdDependencyCode findDependencyCodeById(Long id);

	AdDependencyCode findDependencyCodeByCode(String code);

	List<AdDependencyCode> findDependencyCodes();

	List<AdDependencyCode> findDependencyCodes(String filter, Integer offset, Integer limit);

	Integer countDependencyCode();

	Integer countDependencyCode(String filter);

	void saveDependencyCode(AdDependencyCode dependencyCode);

	void updateDependencyCode(AdDependencyCode dependencyCode);

	void removeDependencyCode(AdDependencyCode dependencyCode);

	// ====================================================================================================
	// DISABILITY CODE
	// ====================================================================================================

	AdDisabilityCode findDisabilityCodeById(Long id);

	AdDisabilityCode findDisabilityCodeByCode(String code);

	List<AdDisabilityCode> findDisabilityCodes();

	List<AdDisabilityCode> findDisabilityCodes(String filter, Integer offset, Integer limit);

	Integer countDisabilityCode();

	Integer countDisabilityCode(String filter);

	void saveDisabilityCode(AdDisabilityCode disabilityCode);

	void updateDisabilityCode(AdDisabilityCode disabilityCode);

	void removeDisabilityCode(AdDisabilityCode disabilityCode);

	// ====================================================================================================
	// NATIONALITY CODE
	// ====================================================================================================

	AdNationalityCode findNationalityCodeById(Long id);

	AdNationalityCode findNationalityCodeByCode(String code);

	List<AdNationalityCode> findNationalityCodes();

	List<AdNationalityCode> findNationalityCodes(String filter, Integer offset, Integer limit);

	Integer countNationalityCode();

	Integer countNationalityCode(String filter);

	void saveNationalityCode(AdNationalityCode nationalityCode);

	void updateNationalityCode(AdNationalityCode nationalityCode);

	void removeNationalityCode(AdNationalityCode nationalityCode);

	// ====================================================================================================
	// RESIDENCY CODE
	// ====================================================================================================

	AdResidencyCode findResidencyCodeById(Long id);

	AdResidencyCode findResidencyCodeByCode(String code);

	List<AdResidencyCode> findResidencyCodes();

	List<AdResidencyCode> findResidencyCodes(String filter, Integer offset, Integer limit);

	Integer countResidencyCode();

	Integer countResidencyCode(String filter);

	void saveResidencyCode(AdResidencyCode residencyCode);

	void updateResidencyCode(AdResidencyCode residencyCode);

	void removeResidencyCode(AdResidencyCode residencyCode);

	// ====================================================================================================
	// SCHOOL CODE
	// ====================================================================================================

	AdSchoolCode findSchoolCodeById(Long id);

	AdSchoolCode findSchoolCodeByCode(String code);

	List<AdSchoolCode> findSchoolCodes(String filter, Integer offset, Integer limit);

	Integer countSchoolCode(String filter);

	void saveSchoolCode(AdSchoolCode schoolCode);

	void updateSchoolCode(AdSchoolCode schoolCode);

	void removeSchoolCode(AdSchoolCode schoolCode);

	// ====================================================================================================
	// INVOLVEMENT TYPE CODE
	// ====================================================================================================

	AdInvolvementTypeCode findInvolvementTypeCodeById(Long id);

	AdInvolvementTypeCode findInvolvementTypeCodeByCode(String code);

	List<AdInvolvementTypeCode> findInvolvementTypeCodes();

	List<AdInvolvementTypeCode> findInvolvementTypeCodes(Integer offset, Integer limit);

	List<AdInvolvementTypeCode> findInvolvementTypeCodes(String filter, Integer offset, Integer limit);

	Integer countInvolvementTypeCode();

	Integer countInvolvementTypeCode(String filter);

	void saveInvolvementTypeCode(AdInvolvementTypeCode involvementtypeCode);

	void updateInvolvementTypeCode(AdInvolvementTypeCode involvementtypeCode);

	void removeInvolvementTypeCode(AdInvolvementTypeCode involvementtypeCode);

	// ====================================================================================================
	// INVOLVEMENT LEVEL CODE
	// ====================================================================================================

	AdInvolvementLevelCode findInvolvementLevelCodeById(Long id);

	AdInvolvementLevelCode findInvolvementLevelCodeByCode(String code);

	List<AdInvolvementLevelCode> findInvolvementLevelCodes();

	List<AdInvolvementLevelCode> findInvolvementLevelCodes(Integer offset, Integer limit);

	List<AdInvolvementLevelCode> findInvolvementLevelCodes(String filter, Integer offset, Integer limit);

	Integer countInvolvementLevelCode();

	Integer countInvolvementLevelCode(String filter);

	void saveInvolvementLevelCode(AdInvolvementLevelCode involvementlevelCode);

	void updateInvolvementLevelCode(AdInvolvementLevelCode involvementlevelCode);

	void removeInvolvementLevelCode(AdInvolvementLevelCode involvementlevelCode);

	// ====================================================================================================
	// INVOLVEMENT TITLE CODE
	// ====================================================================================================

	AdInvolvementTitleCode findInvolvementTitleCodeById(Long id);

	AdInvolvementTitleCode findInvolvementTitleCodeByCode(String code);

	List<AdInvolvementTitleCode> findInvolvementTitleCodes();

	List<AdInvolvementTitleCode> findInvolvementTitleCodes(Integer offset, Integer limit);

	List<AdInvolvementTitleCode> findInvolvementTitleCodes(String filter, Integer offset, Integer limit);

	Integer countInvolvementTitleCode();

	Integer countInvolvementTitleCode(String filter);

	void saveInvolvementTitleCode(AdInvolvementTitleCode involvementtitleCode);

	void updateInvolvementTitleCode(AdInvolvementTitleCode involvementtitleCode);

	void removeInvolvementTitleCode(AdInvolvementTitleCode involvementtitleCode);

	// ====================================================================================================
	// EMPLOYMENT FIELD CODE
	// ====================================================================================================

	AdEmploymentFieldCode findEmploymentFieldCodeById(Long id);

	AdEmploymentFieldCode findEmploymentFieldCodeByCode(String code);

	List<AdEmploymentFieldCode> findEmploymentFieldCodes();

	List<AdEmploymentFieldCode> findEmploymentFieldCodes(Integer offset, Integer limit);

	List<AdEmploymentFieldCode> findEmploymentFieldCodes(String filter, Integer offset, Integer limit);

	Integer countEmploymentFieldCode();

	Integer countEmploymentFieldCode(String filter);

	void saveEmploymentFieldCode(AdEmploymentFieldCode employmentfieldCode);

	void updateEmploymentFieldCode(AdEmploymentFieldCode employmentfieldCode);

	void removeEmploymentFieldCode(AdEmploymentFieldCode employmentfieldCode);

	// ====================================================================================================
	// EMPLOYMENT LEVEL CODE
	// ====================================================================================================

	AdEmploymentLevelCode findEmploymentLevelCodeById(Long id);

	AdEmploymentLevelCode findEmploymentLevelCodeByCode(String code);

	List<AdEmploymentLevelCode> findEmploymentLevelCodes();

	List<AdEmploymentLevelCode> findEmploymentLevelCodes(Integer offset, Integer limit);

	List<AdEmploymentLevelCode> findEmploymentLevelCodes(String filter, Integer offset, Integer limit);

	Integer countEmploymentLevelCode();

	Integer countEmploymentLevelCode(String filter);

	void saveEmploymentLevelCode(AdEmploymentLevelCode employmentlevelCode);

	void updateEmploymentLevelCode(AdEmploymentLevelCode employmentlevelCode);

	void removeEmploymentLevelCode(AdEmploymentLevelCode employmentlevelCode);

	// ====================================================================================================
	// EMPLOYMENT SECTOR CODE
	// ====================================================================================================

	AdEmploymentSectorCode findEmploymentSectorCodeById(Long id);

	AdEmploymentSectorCode findEmploymentSectorCodeByCode(String code);

	List<AdEmploymentSectorCode> findEmploymentSectorCodes();

	List<AdEmploymentSectorCode> findEmploymentSectorCodes(Integer offset, Integer limit);

	List<AdEmploymentSectorCode> findEmploymentSectorCodes(String filter, Integer offset, Integer limit);

	Integer countEmploymentSectorCode();

	Integer countEmploymentSectorCode(String filter);

	void saveEmploymentSectorCode(AdEmploymentSectorCode employmentsectorCode);

	void updateEmploymentSectorCode(AdEmploymentSectorCode employmentsectorCode);

	void removeEmploymentSectorCode(AdEmploymentSectorCode employmentsectorCode);


	//====================================================================================================
	// STUDY MODE
	//====================================================================================================

	AdStudyMode findStudyModeById(Long id);

	AdStudyMode findStudyModeByCode(String code);

	List<AdStudyMode> findStudyModes();

	List<AdStudyMode> findStudyModes(String filter, Integer offset, Integer limit);

	Integer countStudyMode();

	Integer countStudyMode(String filter);

	void saveStudyMode(AdStudyMode studyMode);

	void updateStudyMode(AdStudyMode studyMode);

	void removeStudyMode(AdStudyMode studyMode);

}
