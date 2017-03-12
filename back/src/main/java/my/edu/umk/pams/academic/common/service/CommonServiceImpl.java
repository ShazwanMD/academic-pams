package my.edu.umk.pams.academic.common.service;

import my.edu.umk.pams.academic.common.dao.*;
import my.edu.umk.pams.academic.common.model.*;
import my.edu.umk.pams.academic.util.Util;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("commonService")
public class CommonServiceImpl implements CommonService {

    @Autowired
    private AdCountryCodeDao countryCodeDao;

    @Autowired
    private AdStateCodeDao stateCodeDao;

    @Autowired
    private AdCityCodeDao cityCodeDao;

    @Autowired
    private AdDistrictCodeDao districtCodeDao;

    @Autowired
    private AdFieldCodeDao fieldCodeDao;

    @Autowired
    private AdGradeCodeDao gradeCodeDao;

    @Autowired
    private AdSubjectCodeDao subjectCodeDao;

    @Autowired
    private AdMaritalCodeDao maritalCodeDao;

    @Autowired
    private AdDependencyCodeDao dependencyCodeDao;

    @Autowired
    private AdDisabilityCodeDao disabilityCodeDao;

    @Autowired
    private AdBankCodeDao bankCodeDao;

    @Autowired
    private AdGenderCodeDao genderCodeDao;

    @Autowired
    private AdRaceCodeDao raceCodeDao;

    @Autowired
    private AdEthnicityCodeDao ethnicityCodeDao;

    @Autowired
    private AdNationalityCodeDao nationalityCodeDao;

    @Autowired
    private AdResidencyCodeDao residencyCodeDao;

    @Autowired
    private AdSchoolCodeDao schoolCodeDao;

    @Autowired
    private AdReligionCodeDao religionCodeDao;

    @Autowired
    private AdResidencyCodeDao residenceCodeDao;

    @Autowired
    private AdStudyCenterCodeDao studyCenterCodeDao;

    @Autowired
    private AdVenueCodeDao venueCodeDao;

    @Autowired
    private AdCompetencyCodeDao competencyCodeDao;

    @Autowired
    private AdInvolvementTypeCodeDao involvementTypeCodeDao;

    @Autowired
    private AdInvolvementLevelCodeDao involvementLevelCodeDao;

    @Autowired
    private AdInvolvementTitleCodeDao involvementTitleCodeDao;

    @Autowired
    private AdEmploymentFieldCodeDao employmentFieldCodeDao;

    @Autowired
    private AdEmploymentLevelCodeDao employmentLevelCodeDao;

    @Autowired
    private AdEmploymentSectorCodeDao employmentSectorCodeDao;

    @Autowired
    private SessionFactory sessionFactory;

    //====================================================================================================
    // COUNTRY CODE
    //====================================================================================================


    @Override
    public AdCountryCode findCountryCodeById(Long id) {
        return countryCodeDao.findById(id);
    }

    @Override
    public AdCountryCode findCountryCodeByCode(String code) {
        return countryCodeDao.findByCode(code);
    }

    @Override
    public List<AdCountryCode> findCountryCodes(String filter, Integer offset, Integer limit) {
        return countryCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countCountryCode(String filter) {
        return countryCodeDao.count(filter);
    }


    @Override
    public void saveCountryCode(AdCountryCode countryCode) {
        countryCodeDao.save(countryCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateCountryCode(AdCountryCode countryCode) {
        countryCodeDao.update(countryCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeCountryCode(AdCountryCode countryCode) {
        countryCodeDao.remove(countryCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // STATE CODE
    //====================================================================================================

    @Override
    public AdStateCode findStateCodeById(Long id) {
        return stateCodeDao.findById(id);
    }

    @Override
    public AdStateCode findStateCodeByCode(String code) {
        return stateCodeDao.findByCode(code);
    }

    @Override
    public List<AdStateCode> findStateCodes(Integer offset, Integer limit) {
        return stateCodeDao.find(offset, limit);
    }

    @Override
    public List<AdStateCode> findStateCodes(String filter, Integer offset, Integer limit) {
        return stateCodeDao.find(filter, offset, limit);
    }

    @Override
    public List<AdStateCode> findStateCodes(AdCountryCode countryCode, Integer offset, Integer limit) {
        return stateCodeDao.find(countryCode, offset, limit);
    }

    @Override
    public List<AdStateCode> findStateCodes(String filter, AdCountryCode countryCode, Integer offset, Integer limit) {
        return stateCodeDao.find(filter, countryCode, offset, limit);
    }

    @Override
    public Integer countStateCode() {
        return stateCodeDao.count();
    }

    @Override
    public Integer countStateCode(String filter) {
        return stateCodeDao.count(filter);
    }

    @Override
    public Integer countStateCode(AdCountryCode countryCode) {
        return stateCodeDao.count(countryCode);
    }

    @Override
    public Integer countStateCode(String filter, AdCountryCode countryCode) {
        return stateCodeDao.count(filter, countryCode);
    }

    @Override
    public void saveStateCode(AdStateCode stateCode) {
        stateCodeDao.save(stateCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateStateCode(AdStateCode stateCode) {
        stateCodeDao.update(stateCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeStateCode(AdStateCode stateCode) {
        stateCodeDao.remove(stateCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }


    //====================================================================================================
    // DISTRICT CODE
    //====================================================================================================


    @Override
    public AdDistrictCode findDistrictCodeById(Long id) {
        return districtCodeDao.findById(id);
    }

    @Override
    public AdDistrictCode findDistrictCodeByCode(String code) {
        return districtCodeDao.findByCode(code);
    }

    @Override
    public List<AdDistrictCode> findDistrictCodes(AdStateCode stateCode, Integer offset, Integer limit) {
        return districtCodeDao.find(offset, limit);
    }

    @Override
    public List<AdDistrictCode> findDistrictCodes(String filter, AdStateCode stateCode, Integer offset, Integer limit) {
        return districtCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countDistrictCode(AdStateCode stateCode) {
        return districtCodeDao.count();
    }

    @Override
    public Integer countDistrictCode(String filter, AdStateCode stateCode) {
        return districtCodeDao.count(filter);
    }


    @Override
    public void saveDistrictCode(AdDistrictCode districtCode) {
        districtCodeDao.save(districtCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateDistrictCode(AdDistrictCode districtCode) {
        districtCodeDao.update(districtCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeDistrictCode(AdDistrictCode districtCode) {
        districtCodeDao.remove(districtCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }


    //====================================================================================================
    // CITY CODE
    //====================================================================================================

    @Override
    public AdCityCode findCityCodeById(Long id) {
        return cityCodeDao.findById(id);
    }

    @Override
    public AdCityCode findCityCodeByCode(String code) {
        return cityCodeDao.findByCode(code);
    }

    @Override
    public List<AdCityCode> findCityCodes(AdStateCode stateCode, Integer offset, Integer limit) {
        return cityCodeDao.find(stateCode, offset, limit);
    }

    @Override
    public List<AdCityCode> findCityCodes(String filter, AdStateCode stateCode, Integer offset, Integer limit) {
        return cityCodeDao.find(filter, stateCode, offset, limit);
    }

    @Override
    public Integer countCityCode(AdStateCode stateCode) {
        return cityCodeDao.count(stateCode);
    }

    @Override
    public Integer countCityCode(String filter, AdStateCode stateCode) {
        return cityCodeDao.count(filter, stateCode);
    }

    @Override
    public void saveCityCode(AdCityCode cityCode) {
        cityCodeDao.save(cityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateCityCode(AdCityCode cityCode) {
        cityCodeDao.update(cityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeCityCode(AdCityCode cityCode) {
        cityCodeDao.remove(cityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // SUBJECT CODE
    //====================================================================================================


    @Override
    public AdSubjectCode findSubjectCodeById(Long id) {
        return subjectCodeDao.findById(id);
    }

    @Override
    public AdSubjectCode findSubjectCodeByCode(String code) {
        return subjectCodeDao.findByCode(code);
    }

    @Override
    public List<AdSubjectCode> findSubjectCodes() {
        return subjectCodeDao.find();
    }

    @Override
    public List<AdSubjectCode> findSubjectCodes(Integer offset, Integer limit) {
        return subjectCodeDao.find(offset, limit);
    }

    @Override
    public List<AdSubjectCode> findSubjectCodes(String filter, Integer offset, Integer limit) {
        return subjectCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countSubjectCode() {
        return subjectCodeDao.count();
    }

    @Override
    public Integer countSubjectCode(String filter) {
        return subjectCodeDao.count(filter);
    }

    @Override
    public void saveSubjectCode(AdSubjectCode subjectCode) {
        subjectCodeDao.save(subjectCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateSubjectCode(AdSubjectCode subjectCode) {
        subjectCodeDao.update(subjectCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeSubjectCode(AdSubjectCode subjectCode) {
        subjectCodeDao.remove(subjectCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // GRADE CODE
    //====================================================================================================

    @Override
    public AdGradeCode findGradeCodeById(Long id) {
        return gradeCodeDao.findById(id);
    }

    @Override
    public AdGradeCode findGradeCodeByCode(String code) {
        return gradeCodeDao.findByCode(code);
    }

    @Override
    public List<AdGradeCode> findGradeCodes() {
        return gradeCodeDao.find();
    }

    @Override
    public List<AdGradeCode> findGradeCodes(Integer offset, Integer limit) {
        return gradeCodeDao.find(offset, limit);
    }

    @Override
    public List<AdGradeCode> findGradeCodes(String filter, Integer offset, Integer limit) {
        return gradeCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countGradeCode() {
        return gradeCodeDao.count();
    }

    @Override
    public Integer countGradeCode(String filter) {
        return gradeCodeDao.count(filter);
    }

    @Override
    public void saveGradeCode(AdGradeCode gradeCode) {
        gradeCodeDao.save(gradeCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateGradeCode(AdGradeCode gradeCode) {
        gradeCodeDao.update(gradeCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeGradeCode(AdGradeCode gradeCode) {
        gradeCodeDao.remove(gradeCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // PROGRAM CODE
    //====================================================================================================

    @Override
    public AdFieldCode findFieldCodeById(Long id) {
        return fieldCodeDao.findById(id);
    }

    @Override
    public AdFieldCode findFieldCodeByCode(String code) {
        return fieldCodeDao.findByCode(code);
    }

    @Override
    public List<AdFieldCode> findFieldCodes() {
        return fieldCodeDao.find();
    }

    @Override
    public List<AdFieldCode> findFieldCodes(Integer offset, Integer limit) {
        return fieldCodeDao.find(offset, limit);
    }

    @Override
    public List<AdFieldCode> findFieldCodes(String filter, Integer offset, Integer limit) {
        return fieldCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countFieldCode() {
        return fieldCodeDao.count();
    }

    @Override
    public Integer countFieldCode(String filter) {
        return fieldCodeDao.count(filter);
    }

    @Override
    public void saveFieldCode(AdFieldCode fieldCode) {
        fieldCodeDao.save(fieldCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateFieldCode(AdFieldCode fieldCode) {
        fieldCodeDao.update(fieldCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeFieldCode(AdFieldCode fieldCode) {
        fieldCodeDao.remove(fieldCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // GENDER CODE
    //====================================================================================================
    @Override
    public AdGenderCode findGenderCodeById(Long id) {
        return genderCodeDao.findById(id);
    }

    @Override
    public AdGenderCode findGenderCodeByCode(String code) {
        return genderCodeDao.findByCode(code);
    }

    @Override
    public List<AdGenderCode> findGenderCodes() {
        return genderCodeDao.find();
    }

    @Override
    public List<AdGenderCode> findGenderCodes(String filter, Integer offset, Integer limit) {
        return genderCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countGenderCode() {
        return genderCodeDao.count();
    }

    @Override
    public Integer countGenderCode(String filter) {
        return genderCodeDao.count(filter);
    }

    @Override
    public void saveGenderCode(AdGenderCode genderCode) {
        genderCodeDao.save(genderCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateGenderCode(AdGenderCode genderCode) {
        genderCodeDao.update(genderCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeGenderCode(AdGenderCode genderCode) {
        genderCodeDao.remove(genderCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // RACE CODE
    //====================================================================================================

    @Override
    public AdRaceCode findRaceCodeById(Long id) {
        return raceCodeDao.findById(id);
    }

    @Override
    public AdRaceCode findRaceCodeByCode(String code) {
        return raceCodeDao.findByCode(code);
    }

    @Override
    public List<AdRaceCode> findRaceCodes() {
        return raceCodeDao.find();
    }

    @Override
    public List<AdRaceCode> findRaceCodes(String filter, Integer offset, Integer limit) {
        return raceCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countRaceCode() {
        return raceCodeDao.count();
    }

    @Override
    public Integer countRaceCode(String filter) {
        return raceCodeDao.count(filter);
    }


    @Override
    public void saveRaceCode(AdRaceCode raceCode) {
        raceCodeDao.save(raceCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateRaceCode(AdRaceCode raceCode) {
        raceCodeDao.update(raceCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeRaceCode(AdRaceCode raceCode) {
        raceCodeDao.remove(raceCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // ETHNICITY CODE
    //====================================================================================================

    @Override
    public AdEthnicityCode findEthnicityCodeById(Long id) {
        return ethnicityCodeDao.findById(id);
    }

    @Override
    public AdEthnicityCode findEthnicityCodeByCode(String code) {
        return ethnicityCodeDao.findByCode(code);
    }

    @Override
    public List<AdEthnicityCode> findEthnicityCodes() {
        return ethnicityCodeDao.find();
    }

    @Override
    public List<AdEthnicityCode> findEthnicityCodes(String filter, Integer offset, Integer limit) {
        return ethnicityCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countEthnicityCode() {
        return ethnicityCodeDao.count();
    }

    @Override
    public Integer countEthnicityCode(String filter) {
        return ethnicityCodeDao.count(filter);
    }

    @Override
    public void saveEthnicityCode(AdEthnicityCode ethnicityCode) {
        ethnicityCodeDao.save(ethnicityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateEthnicityCode(AdEthnicityCode ethnicityCode) {
        ethnicityCodeDao.update(ethnicityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeEthnicityCode(AdEthnicityCode ethnicityCode) {
        ethnicityCodeDao.remove(ethnicityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // RELIGION CODE
    //====================================================================================================


    @Override
    public AdReligionCode findReligionCodeById(Long id) {
        return religionCodeDao.findById(id);
    }

    @Override
    public AdReligionCode findReligionCodeByCode(String code) {
        return religionCodeDao.findByCode(code);
    }

    @Override
    public List<AdReligionCode> findReligionCodes() {
        return religionCodeDao.find();
    }

    @Override
    public List<AdReligionCode> findReligionCodes(String filter, Integer offset, Integer limit) {
        return religionCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countReligionCode() {
        return religionCodeDao.count();
    }

    @Override
    public Integer countReligionCode(String filter) {
        return religionCodeDao.count(filter);
    }


    @Override
    public void saveReligionCode(AdReligionCode religionCode) {
        religionCodeDao.save(religionCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateReligionCode(AdReligionCode religionCode) {
        religionCodeDao.update(religionCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeReligionCode(AdReligionCode religionCode) {
        religionCodeDao.remove(religionCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // MARITAL CODE
    //====================================================================================================

    //====================================================================================================
    // DISABILITY CODE
    //====================================================================================================

    @Override
    public AdDisabilityCode findDisabilityCodeById(Long id) {
        return disabilityCodeDao.findById(id);
    }

    @Override
    public AdDisabilityCode findDisabilityCodeByCode(String code) {
        return disabilityCodeDao.findByCode(code);
    }

    @Override
    public List<AdDisabilityCode> findDisabilityCodes() {
        return disabilityCodeDao.find();
    }

    @Override
    public List<AdDisabilityCode> findDisabilityCodes(String filter, Integer offset, Integer limit) {
        return disabilityCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countDisabilityCode() {
        return disabilityCodeDao.count();
    }

    @Override
    public Integer countDisabilityCode(String filter) {
        return disabilityCodeDao.count(filter);
    }


    @Override
    public void saveDisabilityCode(AdDisabilityCode disabilityCode) {
        disabilityCodeDao.save(disabilityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateDisabilityCode(AdDisabilityCode disabilityCode) {
        disabilityCodeDao.update(disabilityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeDisabilityCode(AdDisabilityCode disabilityCode) {
        disabilityCodeDao.remove(disabilityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // NATIONALITY CODE
    //====================================================================================================

    @Override
    public AdNationalityCode findNationalityCodeById(Long id) {
        return nationalityCodeDao.findById(id);
    }

    @Override
    public AdNationalityCode findNationalityCodeByCode(String code) {
        return nationalityCodeDao.findByCode(code);
    }

    @Override
    public List<AdNationalityCode> findNationalityCodes() {
        return nationalityCodeDao.find();
    }

    @Override
    public List<AdNationalityCode> findNationalityCodes(String filter, Integer offset, Integer limit) {
        return nationalityCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countNationalityCode() {
        return nationalityCodeDao.count();
    }

    @Override
    public Integer countNationalityCode(String filter) {
        return nationalityCodeDao.count(filter);
    }


    @Override
    public void saveNationalityCode(AdNationalityCode nationalityCode) {
        nationalityCodeDao.save(nationalityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateNationalityCode(AdNationalityCode nationalityCode) {
        nationalityCodeDao.update(nationalityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeNationalityCode(AdNationalityCode nationalityCode) {
        nationalityCodeDao.remove(nationalityCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }


    //====================================================================================================
    // RESIDENCY CODE
    //====================================================================================================

    @Override
    public AdResidencyCode findResidencyCodeById(Long id) {
        return residencyCodeDao.findById(id);
    }

    @Override
    public AdResidencyCode findResidencyCodeByCode(String code) {
        return residencyCodeDao.findByCode(code);
    }

    @Override
    public List<AdResidencyCode> findResidencyCodes() {
        return residencyCodeDao.find();
    }

    @Override
    public List<AdResidencyCode> findResidencyCodes(String filter, Integer offset, Integer limit) {
        return residencyCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countResidencyCode() {
        return residencyCodeDao.count();
    }

    @Override
    public Integer countResidencyCode(String filter) {
        return residencyCodeDao.count(filter);
    }


    @Override
    public void saveResidencyCode(AdResidencyCode residencyCode) {
        residencyCodeDao.save(residencyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateResidencyCode(AdResidencyCode residencyCode) {
        residencyCodeDao.update(residencyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeResidencyCode(AdResidencyCode residencyCode) {
        residencyCodeDao.remove(residencyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // SCHOOL CODE
    //====================================================================================================

    @Override
    public AdSchoolCode findSchoolCodeById(Long id) {
        return schoolCodeDao.findById(id);
    }

    @Override
    public AdSchoolCode findSchoolCodeByCode(String code) {
        return schoolCodeDao.findByCode(code);
    }

    @Override
    public List<AdSchoolCode> findSchoolCodes(String filter, Integer offset, Integer limit) {
        return schoolCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countSchoolCode(String filter) {
        return schoolCodeDao.count(filter);
    }


    @Override
    public void saveSchoolCode(AdSchoolCode schoolCode) {
        schoolCodeDao.save(schoolCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateSchoolCode(AdSchoolCode schoolCode) {
        schoolCodeDao.update(schoolCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeSchoolCode(AdSchoolCode schoolCode) {
        schoolCodeDao.remove(schoolCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // STUDY CENTER CODE
    //====================================================================================================

    @Override
    public AdStudyCenterCode findStudyCenterCodeById(Long id) {
        return studyCenterCodeDao.findById(id);
    }

    @Override
    public AdStudyCenterCode findStudyCenterCodeByCode(String code) {
        return studyCenterCodeDao.findByCode(code);
    }

    @Override
    public List<AdStudyCenterCode> findStudyCenterCodes() {
        return studyCenterCodeDao.find();
    }

    @Override
    public List<AdStudyCenterCode> findStudyCenterCodes(String filter, Integer offset, Integer limit) {
        return studyCenterCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countStudyCenterCode() {
        return studyCenterCodeDao.count();
    }

    @Override
    public Integer countStudyCenterCode(String filter) {
        return studyCenterCodeDao.count(filter);
    }


    @Override
    public void saveStudyCenterCode(AdStudyCenterCode studyCenterCode) {
        studyCenterCodeDao.save(studyCenterCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateStudyCenterCode(AdStudyCenterCode studyCenterCode) {
        studyCenterCodeDao.update(studyCenterCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeStudyCenterCode(AdStudyCenterCode studyCenterCode) {
        studyCenterCodeDao.remove(studyCenterCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // VENUE CODE
    //====================================================================================================

    @Override
    public AdVenueCode findVenueCodeById(Long id) {
        return venueCodeDao.findById(id);
    }

    @Override
    public AdVenueCode findVenueCodeByCode(String code) {
        return venueCodeDao.findByCode(code);
    }

    @Override
    public List<AdVenueCode> findVenueCodes() {
        return venueCodeDao.find();
    }

    @Override
    public List<AdVenueCode> findVenueCodes(String filter, Integer offset, Integer limit) {
        return venueCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countVenueCode() {
        return venueCodeDao.count();
    }

    @Override
    public Integer countVenueCode(String filter) {
        return venueCodeDao.count(filter);
    }

    @Override
    public void saveVenueCode(AdVenueCode venueCode) {
        venueCodeDao.save(venueCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateVenueCode(AdVenueCode venueCode) {
        venueCodeDao.update(venueCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeVenueCode(AdVenueCode venueCode) {
        venueCodeDao.remove(venueCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // DEPENDENCY CODE
    //====================================================================================================
    @Override
    public AdDependencyCode findDependencyCodeById(Long id) {
        return dependencyCodeDao.findById(id);
    }

    @Override
    public AdDependencyCode findDependencyCodeByCode(String code) {
        return dependencyCodeDao.findByCode(code);
    }

    @Override
    public List<AdDependencyCode> findDependencyCodes() {
        return dependencyCodeDao.find();
    }

    @Override
    public List<AdDependencyCode> findDependencyCodes(String filter, Integer offset, Integer limit) {
        return dependencyCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countDependencyCode() {
        return dependencyCodeDao.count();
    }

    @Override
    public Integer countDependencyCode(String filter) {
        return dependencyCodeDao.count(filter);
    }


    @Override
    public void saveDependencyCode(AdDependencyCode dependencyCode) {
        dependencyCodeDao.save(dependencyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateDependencyCode(AdDependencyCode dependencyCode) {
        dependencyCodeDao.update(dependencyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeDependencyCode(AdDependencyCode dependencyCode) {
        dependencyCodeDao.remove(dependencyCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // BANK CODE
    //====================================================================================================

    @Override
    public AdBankCode findBankCodeById(Long id) {
        return bankCodeDao.findById(id);
    }

    @Override
    public AdBankCode findBankCodeByCode(String code) {
        return bankCodeDao.findByCode(code);
    }

    @Override
    public List<AdBankCode> findBankCodes() {
        return bankCodeDao.find();
    }

    @Override
    public List<AdBankCode> findBankCodes(String filter, Integer offset, Integer limit) {
        return bankCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countBankCode() {
        return bankCodeDao.count();
    }

    @Override
    public Integer countBankCode(String filter) {
        return bankCodeDao.count(filter);
    }


    @Override
    public void saveBankCode(AdBankCode bankCode) {
        bankCodeDao.save(bankCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateBankCode(AdBankCode bankCode) {
        bankCodeDao.update(bankCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeBankCode(AdBankCode bankCode) {
        bankCodeDao.remove(bankCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // MARITAL CODE
    //====================================================================================================

    @Override
    public AdMaritalCode findMaritalCodeById(Long id) {
        return maritalCodeDao.findById(id);
    }

    @Override
    public AdMaritalCode findMaritalCodeByCode(String code) {
        return maritalCodeDao.findByCode(code);
    }

    @Override
    public List<AdMaritalCode> findMaritalCodes() {
        return maritalCodeDao.find();
    }

    @Override
    public List<AdMaritalCode> findMaritalCodes(String filter, Integer offset, Integer limit) {
        return maritalCodeDao.find(filter, offset, limit);
    }

    @Override
    public Integer countMaritalCode() {
        return maritalCodeDao.count();
    }

    @Override
    public Integer countMaritalCode(String filter) {
        return maritalCodeDao.count(filter);
    }

    @Override
    public void saveMaritalCode(AdMaritalCode MaritalCode) {
        maritalCodeDao.save(MaritalCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateMaritalCode(AdMaritalCode MaritalCode) {
        maritalCodeDao.update(MaritalCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeMaritalCode(AdMaritalCode MaritalCode) {
        maritalCodeDao.remove(MaritalCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // INVOLVEMENT TYPE CODE
    //====================================================================================================


    @Override
    public AdInvolvementTypeCode findInvolvementTypeCodeById(Long id) {
        return involvementTypeCodeDao.findById(id);
    }

    @Override
    public AdInvolvementTypeCode findInvolvementTypeCodeByCode(String code) {
        return involvementTypeCodeDao.findByCode(code);
    }

    @Override
    public List<AdInvolvementTypeCode> findInvolvementTypeCodes() {
        return involvementTypeCodeDao.find();
    }

    @Override
    public List<AdInvolvementTypeCode> findInvolvementTypeCodes(Integer offset, Integer limit) {
        return involvementTypeCodeDao.find();
    }

    @Override
    public List<AdInvolvementTypeCode> findInvolvementTypeCodes(String filter, Integer offset, Integer limit) {
        return involvementTypeCodeDao.find();
    }

    @Override
    public Integer countInvolvementTypeCode() {
        return involvementTypeCodeDao.count();
    }

    @Override
    public Integer countInvolvementTypeCode(String filter) {
        return involvementTypeCodeDao.count();
    }

    @Override
    public void saveInvolvementTypeCode(AdInvolvementTypeCode involvementTypeCode) {
        involvementTypeCodeDao.save(involvementTypeCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateInvolvementTypeCode(AdInvolvementTypeCode involvementTypeCode) {
        involvementTypeCodeDao.update(involvementTypeCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeInvolvementTypeCode(AdInvolvementTypeCode involvementTypeCode) {
        involvementTypeCodeDao.remove(involvementTypeCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // INVOLVEMENT LEVEL CODE
    //====================================================================================================

    @Override
    public AdInvolvementLevelCode findInvolvementLevelCodeById(Long id) {
        return involvementLevelCodeDao.findById(id);
    }

    @Override
    public AdInvolvementLevelCode findInvolvementLevelCodeByCode(String code) {
        return involvementLevelCodeDao.findByCode(code);
    }

    @Override
    public List<AdInvolvementLevelCode> findInvolvementLevelCodes() {
        return involvementLevelCodeDao.find();
    }

    @Override
    public List<AdInvolvementLevelCode> findInvolvementLevelCodes(Integer offset, Integer limit) {
        return involvementLevelCodeDao.find();
    }

    @Override
    public List<AdInvolvementLevelCode> findInvolvementLevelCodes(String filter, Integer offset, Integer limit) {
        return involvementLevelCodeDao.find();
    }

    @Override
    public Integer countInvolvementLevelCode() {
        return involvementLevelCodeDao.count();
    }

    @Override
    public Integer countInvolvementLevelCode(String filter) {
        return involvementLevelCodeDao.count();
    }


    @Override
    public void saveInvolvementLevelCode(AdInvolvementLevelCode involvementLevelCode) {
        involvementLevelCodeDao.save(involvementLevelCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateInvolvementLevelCode(AdInvolvementLevelCode involvementLevelCode) {
        involvementLevelCodeDao.update(involvementLevelCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeInvolvementLevelCode(AdInvolvementLevelCode involvementLevelCode) {
        involvementLevelCodeDao.remove(involvementLevelCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // INVOLVEMENT TITLE CODE
    //====================================================================================================

    @Override
    public AdInvolvementTitleCode findInvolvementTitleCodeById(Long id) {
        return involvementTitleCodeDao.findById(id);
    }

    @Override
    public AdInvolvementTitleCode findInvolvementTitleCodeByCode(String code) {
        return involvementTitleCodeDao.findByCode(code);
    }

    @Override
    public List<AdInvolvementTitleCode> findInvolvementTitleCodes() {
        return involvementTitleCodeDao.find();
    }

    @Override
    public List<AdInvolvementTitleCode> findInvolvementTitleCodes(Integer offset, Integer limit) {
        return involvementTitleCodeDao.find();
    }

    @Override
    public List<AdInvolvementTitleCode> findInvolvementTitleCodes(String filter, Integer offset, Integer limit) {
        return involvementTitleCodeDao.find();
    }

    @Override
    public Integer countInvolvementTitleCode() {
        return involvementTitleCodeDao.count();
    }

    @Override
    public Integer countInvolvementTitleCode(String filter) {
        return involvementTitleCodeDao.count();
    }


    @Override
    public void saveInvolvementTitleCode(AdInvolvementTitleCode involvementTitleCode) {
        involvementTitleCodeDao.save(involvementTitleCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateInvolvementTitleCode(AdInvolvementTitleCode involvementTitleCode) {
        involvementTitleCodeDao.update(involvementTitleCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeInvolvementTitleCode(AdInvolvementTitleCode involvementTitleCode) {
        involvementTitleCodeDao.remove(involvementTitleCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // EMPLOYMENT FIELD CODE
    //====================================================================================================


    @Override
    public AdEmploymentFieldCode findEmploymentFieldCodeById(Long id) {
        return employmentFieldCodeDao.findById(id);
    }

    @Override
    public AdEmploymentFieldCode findEmploymentFieldCodeByCode(String code) {
        return employmentFieldCodeDao.findByCode(code);
    }

    @Override
    public List<AdEmploymentFieldCode> findEmploymentFieldCodes() {
        return employmentFieldCodeDao.find();
    }

    @Override
    public List<AdEmploymentFieldCode> findEmploymentFieldCodes(Integer offset, Integer limit) {
        return employmentFieldCodeDao.find();
    }

    @Override
    public List<AdEmploymentFieldCode> findEmploymentFieldCodes(String filter, Integer offset, Integer limit) {
        return employmentFieldCodeDao.find();
    }

    @Override
    public Integer countEmploymentFieldCode() {
        return employmentLevelCodeDao.count();
    }

    @Override
    public Integer countEmploymentFieldCode(String filter) {
        return employmentLevelCodeDao.count();
    }


    @Override
    public void saveEmploymentFieldCode(AdEmploymentFieldCode employmentFieldCode) {
        employmentFieldCodeDao.save(employmentFieldCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateEmploymentFieldCode(AdEmploymentFieldCode employmentFieldCode) {
        employmentFieldCodeDao.update(employmentFieldCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeEmploymentFieldCode(AdEmploymentFieldCode employmentFieldCode) {
        employmentFieldCodeDao.remove(employmentFieldCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // EMPLOYMENT LEVEL CODE
    //====================================================================================================

    @Override
    public AdEmploymentLevelCode findEmploymentLevelCodeById(Long id) {
        return employmentLevelCodeDao.findById(id);
    }

    @Override
    public AdEmploymentLevelCode findEmploymentLevelCodeByCode(String code) {
        return employmentLevelCodeDao.findByCode(code);
    }

    @Override
    public List<AdEmploymentLevelCode> findEmploymentLevelCodes() {
        return employmentLevelCodeDao.find();
    }

    @Override
    public List<AdEmploymentLevelCode> findEmploymentLevelCodes(Integer offset, Integer limit) {
        return employmentLevelCodeDao.find();
    }

    @Override
    public List<AdEmploymentLevelCode> findEmploymentLevelCodes(String filter, Integer offset, Integer limit) {
        return employmentLevelCodeDao.find();
    }

    @Override
    public Integer countEmploymentLevelCode() {
        return employmentLevelCodeDao.count();
    }

    @Override
    public Integer countEmploymentLevelCode(String filter) {
        return employmentLevelCodeDao.count();
    }

    @Override
    public void saveEmploymentLevelCode(AdEmploymentLevelCode employmentLevelCode) {
        employmentLevelCodeDao.save(employmentLevelCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateEmploymentLevelCode(AdEmploymentLevelCode employmentLevelCode) {
        employmentLevelCodeDao.update(employmentLevelCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeEmploymentLevelCode(AdEmploymentLevelCode employmentLevelCode) {
        employmentLevelCodeDao.remove(employmentLevelCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // EMPLOYMENT SECTOR CODE
    //====================================================================================================

    @Override
    public AdEmploymentSectorCode findEmploymentSectorCodeById(Long id) {
        return employmentSectorCodeDao.findById(id);
    }

    @Override
    public AdEmploymentSectorCode findEmploymentSectorCodeByCode(String code) {
        return employmentSectorCodeDao.findByCode(code);
    }

    @Override
    public List<AdEmploymentSectorCode> findEmploymentSectorCodes() {
        return employmentSectorCodeDao.find();
    }

    @Override
    public List<AdEmploymentSectorCode> findEmploymentSectorCodes(Integer offset, Integer limit) {
        return employmentSectorCodeDao.find();
    }

    @Override
    public List<AdEmploymentSectorCode> findEmploymentSectorCodes(String filter, Integer offset, Integer limit) {
        return employmentSectorCodeDao.find();
    }

    @Override
    public Integer countEmploymentSectorCode() {
        return employmentSectorCodeDao.count();
    }

    @Override
    public Integer countEmploymentSectorCode(String filter) {
        return employmentSectorCodeDao.count();
    }

    @Override
    public void saveEmploymentSectorCode(AdEmploymentSectorCode employmentSectorCode) {
        employmentSectorCodeDao.save(employmentSectorCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateEmploymentSectorCode(AdEmploymentSectorCode employmentSectorCode) {
        employmentSectorCodeDao.update(employmentSectorCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeEmploymentSectorCode(AdEmploymentSectorCode employmentSectorCode) {
        employmentSectorCodeDao.remove(employmentSectorCode, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }


    //====================================================================================================
    // INVOLVEMENT TYPE
    //====================================================================================================


}
