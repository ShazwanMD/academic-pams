package my.edu.umk.pams.academic.web.module.common.controller;

import my.edu.umk.pams.academic.common.model.AdBankCode;
import my.edu.umk.pams.academic.common.model.AdBankCodeImpl;
import my.edu.umk.pams.academic.common.model.AdCityCode;
import my.edu.umk.pams.academic.common.model.AdCityCodeImpl;
import my.edu.umk.pams.academic.common.model.AdCountryCode;
import my.edu.umk.pams.academic.common.model.AdCountryCodeImpl;
import my.edu.umk.pams.academic.common.model.AdDunCode;
import my.edu.umk.pams.academic.common.model.AdDunCodeImpl;
import my.edu.umk.pams.academic.common.model.AdEthnicityCode;
import my.edu.umk.pams.academic.common.model.AdEthnicityCodeImpl;
import my.edu.umk.pams.academic.common.model.AdGenderCode;
import my.edu.umk.pams.academic.common.model.AdGenderCodeImpl;
import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdGradeCodeImpl;
import my.edu.umk.pams.academic.common.model.AdMaritalCode;
import my.edu.umk.pams.academic.common.model.AdMaritalCodeImpl;
import my.edu.umk.pams.academic.common.model.AdNationalityCode;
import my.edu.umk.pams.academic.common.model.AdNationalityCodeImpl;
import my.edu.umk.pams.academic.common.model.AdParliamentCode;
import my.edu.umk.pams.academic.common.model.AdParliamentCodeImpl;
import my.edu.umk.pams.academic.common.model.AdRaceCode;
import my.edu.umk.pams.academic.common.model.AdRaceCodeImpl;
import my.edu.umk.pams.academic.common.model.AdReligionCode;
import my.edu.umk.pams.academic.common.model.AdReligionCodeImpl;
import my.edu.umk.pams.academic.common.model.AdStateCode;
import my.edu.umk.pams.academic.common.model.AdStateCodeImpl;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.model.AdStudyCenterImpl;
import my.edu.umk.pams.academic.common.model.AdStudyMode;
import my.edu.umk.pams.academic.common.model.AdStudyModeImpl;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.security.integration.AdAutoLoginToken;
import my.edu.umk.pams.academic.web.module.common.vo.BankCode;
import my.edu.umk.pams.academic.web.module.common.vo.CityCode;
import my.edu.umk.pams.academic.web.module.common.vo.CountryCode;
import my.edu.umk.pams.academic.web.module.common.vo.DunCode;
import my.edu.umk.pams.academic.web.module.common.vo.EthnicityCode;
import my.edu.umk.pams.academic.web.module.common.vo.GenderCode;
import my.edu.umk.pams.academic.web.module.common.vo.GradeCode;
import my.edu.umk.pams.academic.web.module.common.vo.MaritalCode;
import my.edu.umk.pams.academic.web.module.common.vo.NationalityCode;
import my.edu.umk.pams.academic.web.module.common.vo.ParliamentCode;
import my.edu.umk.pams.academic.web.module.common.vo.RaceCode;
import my.edu.umk.pams.academic.web.module.common.vo.ReligionCode;
import my.edu.umk.pams.academic.web.module.common.vo.StateCode;
import my.edu.umk.pams.academic.web.module.common.vo.StudyCenter;
import my.edu.umk.pams.academic.web.module.common.vo.StudyMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private CommonTransformer commonTransformer;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    //====================================================================================================
    // STUDY_MODE
    //====================================================================================================

    @RequestMapping(value = "/studyCenters", method = RequestMethod.GET)
    public ResponseEntity<List<StudyCenter>> findStudyCenters() {
            return new ResponseEntity<List<StudyCenter>>(commonTransformer.toStudyCenterVos(
            commonService.findStudyCenters("%",0,Integer.MAX_VALUE)), HttpStatus.OK);
            }

    @RequestMapping(value = "/studyCenters/{code}", method = RequestMethod.GET)
    public ResponseEntity<StudyCenter> findStudyCenterByCode(@PathVariable String code) {
            return new ResponseEntity<StudyCenter>(commonTransformer.toStudyCenterVo(
            commonService.findStudyCenterByCode(code)), HttpStatus.OK);
            }

    @RequestMapping(value = "/studyCenters", method = RequestMethod.POST)
    public ResponseEntity<String> saveStudyCenter(@RequestBody StudyCenter vo) {
            dummyLogin();

            AdStudyCenter studyCenter = new AdStudyCenterImpl();
            studyCenter.setCode(vo.getCode());
           studyCenter.setDescription(vo.getDescription());
            commonService.saveStudyCenter(studyCenter);
            return new ResponseEntity<String>("Success", HttpStatus.OK);
            }

    @RequestMapping(value = "/studyCenters/{code}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateStudyCenter(@PathVariable String code, @RequestBody StudyCenter vo) {
            dummyLogin();

            AdStudyCenter studyCenter = commonService.findStudyCenterById(vo.getId());
            studyCenter.setCode(vo.getCode());
            studyCenter.setDescription(vo.getDescription());
            commonService.updateStudyCenter(studyCenter);
            return new ResponseEntity<String>("Success", HttpStatus.OK);
            }

    @RequestMapping(value = "/studyCenters/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeStudyCenter(@PathVariable String code) {
            dummyLogin();

            AdStudyCenter StudyCenter = commonService.findStudyCenterByCode(code);
            commonService.removeStudyCenter(StudyCenter);
            return new ResponseEntity<String>("Success", HttpStatus.OK);
            }




  //====================================================================================================
  // STUDY_MODE
  //====================================================================================================

  @RequestMapping(value = "/studyModes", method = RequestMethod.GET)
  public ResponseEntity<List<StudyMode>> findStudyModes() {
          return new ResponseEntity<List<StudyMode>>(commonTransformer.toStudyModeVos(
          commonService.findStudyModes("%",0,Integer.MAX_VALUE)), HttpStatus.OK);
          }

  @RequestMapping(value = "/studyModes/{code}", method = RequestMethod.GET)
  public ResponseEntity<StudyMode> findStudyModeByCode(@PathVariable String code) {
          return new ResponseEntity<StudyMode>(commonTransformer.toStudyModeVo(
          commonService.findStudyModeByCode(code)), HttpStatus.OK);
          }

  @RequestMapping(value = "/studyModes", method = RequestMethod.POST)
  public ResponseEntity<String> saveStudyMode(@RequestBody StudyMode vo) {
          dummyLogin();

          AdStudyMode studyMode = new AdStudyModeImpl();
          studyMode.setCode(vo.getCode());
          studyMode.setPrefix(vo.getPrefix());
          studyMode.setDescription(vo.getDescription());
          commonService.saveStudyMode(studyMode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/studyModes/{code}", method = RequestMethod.PUT)
  public ResponseEntity<String> updateStudyMode(@PathVariable String code, @RequestBody StudyMode vo) {
          dummyLogin();

          AdStudyMode studyMode = commonService.findStudyModeById(vo.getId());
          studyMode.setCode(vo.getCode());
          studyMode.setPrefix(vo.getPrefix());
          studyMode.setDescription(vo.getDescription());
          commonService.updateStudyMode(studyMode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/studyModes/{code}", method = RequestMethod.DELETE)
  public ResponseEntity<String> removeStudyMode(@PathVariable String code) {
          dummyLogin();

          AdStudyMode studyMode = commonService.findStudyModeByCode(code);
          commonService.removeStudyMode(studyMode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }



  //====================================================================================================
  // MARITAL_CODE
  //====================================================================================================

  @RequestMapping(value = "/maritalCodes", method = RequestMethod.GET)
  public ResponseEntity<List<MaritalCode>> findMaritalCodes() {
          return new ResponseEntity<List<MaritalCode>>(commonTransformer.toMaritalCodeVos(
          commonService.findMaritalCodes("%",0,Integer.MAX_VALUE)), HttpStatus.OK);
          }

  @RequestMapping(value = "/maritalCodes/{code}", method = RequestMethod.GET)
  public ResponseEntity<MaritalCode> findMaritalCodeByCode(@PathVariable String code) {
          return new ResponseEntity<MaritalCode>(commonTransformer.toMaritalCodeVo(
          commonService.findMaritalCodeByCode(code)), HttpStatus.OK);
          }

  @RequestMapping(value = "/maritalCodes", method = RequestMethod.POST)
  public ResponseEntity<String> saveMaritalCode(@RequestBody MaritalCode vo) {
          dummyLogin();

          AdMaritalCode maritalCode = new AdMaritalCodeImpl();
          maritalCode.setCode(vo.getCode());
          maritalCode.setDescriptionEn(vo.getDescriptionEn());
          maritalCode.setDescriptionMs(vo.getDescriptionMs());
          commonService.saveMaritalCode(maritalCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/maritalCodes/{code}", method = RequestMethod.PUT)
  public ResponseEntity<String> updateMaritalCode(@PathVariable String code, @RequestBody MaritalCode vo) {
          dummyLogin();

          AdMaritalCode maritalCode = commonService.findMaritalCodeById(vo.getId());
          maritalCode.setCode(vo.getCode());
          maritalCode.setDescriptionEn(vo.getDescriptionEn());
          maritalCode.setDescriptionMs(vo.getDescriptionMs());
          commonService.updateMaritalCode(maritalCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/maritalCodes/{code}", method = RequestMethod.DELETE)
  public ResponseEntity<String> removeMaritalCode(@PathVariable String code) {
          dummyLogin();

          AdMaritalCode maritalCode = commonService.findMaritalCodeByCode(code);
          commonService.removeMaritalCode(maritalCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }


  //====================================================================================================
  // DUN_CODE
  //====================================================================================================

  @RequestMapping(value = "/dunCodes", method = RequestMethod.GET)
  public ResponseEntity<List<DunCode>> findDunCodes() {
          return new ResponseEntity<List<DunCode>>(commonTransformer.toDunCodeVos(
          commonService.findDunCodes("%",0,Integer.MAX_VALUE)), HttpStatus.OK);
          }

  @RequestMapping(value = "/dunCodes/{code}", method = RequestMethod.GET)
  public ResponseEntity<DunCode> findDunCodeByCode(@PathVariable String code) {
          return new ResponseEntity<DunCode>(commonTransformer.toDunCodeVo(
          commonService.findDunCodeByCode(code)), HttpStatus.OK);
          }

  @RequestMapping(value = "/dunCodes", method = RequestMethod.POST)
  public ResponseEntity<String> saveDunCode(@RequestBody DunCode vo) {
          dummyLogin();

          AdDunCode dunCode = new AdDunCodeImpl();
          dunCode.setCode(vo.getCode());
          dunCode.setDescription(vo.getDescription());
          
          commonService.saveDunCode(dunCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/dunCodes/{code}", method = RequestMethod.PUT)
  public ResponseEntity<String> updateDunCode(@PathVariable String code, @RequestBody DunCode vo) {
          dummyLogin();

          AdDunCode dunCode = commonService.findDunCodeById(vo.getId());
          dunCode.setCode(vo.getCode());
          dunCode.setDescription(vo.getDescription());
          commonService.updateDunCode(dunCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/dunCodes/{code}", method = RequestMethod.DELETE)
  public ResponseEntity<String> removeDunCode(@PathVariable String code) {
          dummyLogin();

          AdDunCode dunCode = commonService.findDunCodeByCode(code);
          commonService.removeDunCode(dunCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

 
  //====================================================================================================
  // BANK_CODE
  //====================================================================================================

  @RequestMapping(value = "/bankCodes", method = RequestMethod.GET)
  public ResponseEntity<List<BankCode>> findBankCodes() {
          return new ResponseEntity<List<BankCode>>(commonTransformer.toBankCodeVos(
          commonService.findBankCodes("%",0,Integer.MAX_VALUE)), HttpStatus.OK);
          }

  @RequestMapping(value = "/bankCodes/{code}", method = RequestMethod.GET)
  public ResponseEntity<BankCode> findBankCodeByCode(@PathVariable String code) {
          return new ResponseEntity<BankCode>(commonTransformer.toBankCodeVo(
          commonService.findBankCodeByCode(code)), HttpStatus.OK);
          }

  @RequestMapping(value = "/bankCodes", method = RequestMethod.POST)
  public ResponseEntity<String> saveBankCode(@RequestBody BankCode vo) {
          dummyLogin();

         AdBankCode bankCode = new AdBankCodeImpl();
          bankCode.setCode(vo.getCode());
          bankCode.setName(vo.getName());
          commonService.saveBankCode(bankCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/bankCodes/{code}", method = RequestMethod.PUT)
  public ResponseEntity<String> updateBankCode(@PathVariable String code, @RequestBody BankCode vo) {
          dummyLogin();

          AdBankCode bankCode = commonService.findBankCodeById(vo.getId());
          bankCode.setCode(vo.getCode());
          bankCode.setName(vo.getName());
          commonService.updateBankCode(bankCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/bankCodes/{code}", method = RequestMethod.DELETE)
  public ResponseEntity<String> removeBankCode(@PathVariable String code) {
          dummyLogin();

          AdBankCode bankCode = commonService.findBankCodeByCode(code);
          commonService.removeBankCode(bankCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }


  //====================================================================================================
  // CITY_CODE
  //====================================================================================================

  @RequestMapping(value = "/cityCodes", method = RequestMethod.GET)
  public ResponseEntity<List<CityCode>> findCityCodes() {
          return new ResponseEntity<List<CityCode>>(commonTransformer.toCityCodeVos(
          commonService.findCityCodes("%",0,Integer.MAX_VALUE)), HttpStatus.OK);
          }

  @RequestMapping(value = "/cityCodes/{code}", method = RequestMethod.GET)
  public ResponseEntity<CityCode> findCityCodeByCode(@PathVariable String code) {
          return new ResponseEntity<CityCode>(commonTransformer.toCityCodeVo(
          commonService.findCityCodeByCode(code)), HttpStatus.OK);
          }

  @RequestMapping(value = "/cityCodes", method = RequestMethod.POST)
  public ResponseEntity<String> saveCityCode(@RequestBody CityCode vo) {
          dummyLogin();

          AdCityCode cityCode = new AdCityCodeImpl();
          cityCode.setCode(vo.getCode());
          cityCode.setDescription(vo.getDescription());
          commonService.saveCityCode(cityCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/cityCodes/{code}", method = RequestMethod.PUT)
  public ResponseEntity<String> updateCityCode(@PathVariable String code, @RequestBody CityCode vo) {
          dummyLogin();

          AdCityCode cityCode = commonService.findCityCodeById(vo.getId());
          cityCode.setCode(vo.getCode());
          cityCode.setDescription(vo.getDescription());
         
          commonService.updateCityCode(cityCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/cityCodes/{code}", method = RequestMethod.DELETE)
  public ResponseEntity<String> removeCityCode(@PathVariable String code) {
          dummyLogin();

          AdCityCode cityCode = commonService.findCityCodeByCode(code);
          commonService.removeCityCode(cityCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }


//====================================================================================================
// COUNTRY_CODE
//====================================================================================================

@RequestMapping(value = "/countryCodes", method = RequestMethod.GET)
public ResponseEntity<List<CountryCode>> findCountryCodes() {
        return new ResponseEntity<List<CountryCode>>(commonTransformer.toCountryCodeVos(
        commonService.findCountryCodes("%",0,Integer.MAX_VALUE)), HttpStatus.OK);
        }

@RequestMapping(value = "/countryCodes/{code}", method = RequestMethod.GET)
public ResponseEntity<CountryCode> findCountryCodeByCode(@PathVariable String code) {
        return new ResponseEntity<CountryCode>(commonTransformer.toCountryCodeVo(
        commonService.findCountryCodeByCode(code)), HttpStatus.OK);
        }

@RequestMapping(value = "/countryCodes", method = RequestMethod.POST)
public ResponseEntity<String> saveCountryCode(@RequestBody CountryCode vo) {
        dummyLogin();

        AdCountryCode countryCode = new AdCountryCodeImpl();
        countryCode.setCode(vo.getCode());
        countryCode.setDescription(vo.getDescription());
    
        commonService.saveCountryCode(countryCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
        }

@RequestMapping(value = "/countryCodes/{code}", method = RequestMethod.PUT)
public ResponseEntity<String> updateCountryCode(@PathVariable String code, @RequestBody CountryCode vo) {
        dummyLogin();

        AdCountryCode countryCode = commonService.findCountryCodeById(vo.getId());
        countryCode.setCode(vo.getCode());
        countryCode.setDescription(vo.getDescription());
        
        commonService.updateCountryCode(countryCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
        }

@RequestMapping(value = "/countryCodes/{code}", method = RequestMethod.DELETE)
public ResponseEntity<String> removeCountryCode(@PathVariable String code) {
        dummyLogin();

        AdCountryCode countryCode = commonService.findCountryCodeByCode(code);
        commonService.removeCountryCode(countryCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
        }




  //====================================================================================================
  // STATE_CODE
  //====================================================================================================

  @RequestMapping(value = "/stateCodes", method = RequestMethod.GET)
  public ResponseEntity<List<StateCode>> findStateCodes() {
          return new ResponseEntity<List<StateCode>>(commonTransformer.toStateCodeVos(
          commonService.findStateCodes("%",0,Integer.MAX_VALUE)), HttpStatus.OK);
          }

  @RequestMapping(value = "/stateCodes/{code}", method = RequestMethod.GET)
  public ResponseEntity<StateCode> findStateCodeByCode(@PathVariable String code) {
          return new ResponseEntity<StateCode>(commonTransformer.toStateCodeVo(
          commonService.findStateCodeByCode(code)), HttpStatus.OK);
          }

  @RequestMapping(value = "/stateCodes", method = RequestMethod.POST)
  public ResponseEntity<String> saveStateCode(@RequestBody StateCode vo) {
          dummyLogin();

          AdStateCode stateCode = new AdStateCodeImpl();
          stateCode.setCode(vo.getCode());
          stateCode.setDescription(vo.getDescription());
          stateCode.setCountryCode(commonService.findCountryCodeById(vo.getCountryCode().getId()));
          commonService.saveStateCode(stateCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/stateCodes/{code}", method = RequestMethod.PUT)
  public ResponseEntity<String> updateStateCode(@PathVariable String code, @RequestBody StateCode vo) {
          dummyLogin();

          AdStateCode stateCode = commonService.findStateCodeById(vo.getId());
          stateCode.setCode(vo.getCode());
          stateCode.setDescription(vo.getDescription());
          stateCode.setCountryCode(commonService.findCountryCodeById(vo.getCountryCode().getId()));
          commonService.updateStateCode(stateCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/stateCodes/{code}", method = RequestMethod.DELETE)
  public ResponseEntity<String> removeStateCode(@PathVariable String code) {
          dummyLogin();

          AdStateCode stateCode = commonService.findStateCodeByCode(code);
          commonService.removeStateCode(stateCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }


  //====================================================================================================
	// GENDER_CODE
  //====================================================================================================

  @RequestMapping(value = "/genderCodes", method = RequestMethod.GET)
  public ResponseEntity<List<GenderCode>> findGenderCodes() {
          return new ResponseEntity<List<GenderCode>>(commonTransformer.toGenderCodeVos(
          commonService.findGenderCodes("%",0,Integer.MAX_VALUE)), HttpStatus.OK);
          }

  @RequestMapping(value = "/genderCodes/{code}", method = RequestMethod.GET)
  public ResponseEntity<GenderCode> findGenderCodeByCode(@PathVariable String code) {
          return new ResponseEntity<GenderCode>(commonTransformer.toGenderCodeVo(
          commonService.findGenderCodeByCode(code)), HttpStatus.OK);
          }

  @RequestMapping(value = "/genderCodes", method = RequestMethod.POST)
  public ResponseEntity<String> saveGenderCode(@RequestBody GenderCode vo) {
          dummyLogin();

          AdGenderCode genderCode = new AdGenderCodeImpl();
          genderCode.setCode(vo.getCode());
          genderCode.setDescription(vo.getDescription());
          commonService.saveGenderCode(genderCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/genderCodes/{code}", method = RequestMethod.PUT)
  public ResponseEntity<String> updateGenderCode(@PathVariable String code, @RequestBody GenderCode vo) {
          dummyLogin();

          AdGenderCode genderCode = commonService.findGenderCodeById(vo.getId());
          genderCode.setCode(vo.getCode());
          genderCode.setDescription(vo.getDescription());
          commonService.updateGenderCode(genderCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/genderCodes/{code}", method = RequestMethod.DELETE)
  public ResponseEntity<String> removeGenderCode(@PathVariable String code) {
          dummyLogin();

          AdGenderCode genderCode = commonService.findGenderCodeByCode(code);
          commonService.removeGenderCode(genderCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }


  //====================================================================================================
  // RACE_CODE
  //====================================================================================================

  @RequestMapping(value = "/raceCodes", method = RequestMethod.GET)
  public ResponseEntity<List<RaceCode>> findRaceCodes() {
          return new ResponseEntity<List<RaceCode>>(commonTransformer.toRaceCodeVos(
          commonService.findRaceCodes("%",0,Integer.MAX_VALUE)), HttpStatus.OK);
          }

  @RequestMapping(value = "/raceCodes/{code}", method = RequestMethod.GET)
  public ResponseEntity<RaceCode> findRaceCodeByCode(@PathVariable String code) {
          return new ResponseEntity<RaceCode>(commonTransformer.toRaceCodeVo(
          commonService.findRaceCodeByCode(code)), HttpStatus.OK);
          }

  @RequestMapping(value = "/raceCodes", method = RequestMethod.POST)
  public ResponseEntity<String> saveRaceCode(@RequestBody RaceCode vo) {
          dummyLogin();

          AdRaceCode raceCode = new AdRaceCodeImpl();
          raceCode.setCode(vo.getCode());
          raceCode.setDescriptionEn(vo.getDescriptionEn());
          raceCode.setDescriptionMs(vo.getDescriptionMs());
          commonService.saveRaceCode(raceCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/raceCodes/{code}", method = RequestMethod.PUT)
  public ResponseEntity<String> updateRaceCode(@PathVariable String code, @RequestBody RaceCode vo) {
          dummyLogin();

          AdRaceCode raceCode = commonService.findRaceCodeById(vo.getId());
          raceCode.setCode(vo.getCode());
          raceCode.setDescriptionEn(vo.getDescriptionEn());
          raceCode.setDescriptionMs(vo.getDescriptionMs());
          commonService.updateRaceCode(raceCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }

  @RequestMapping(value = "/raceCodes/{code}", method = RequestMethod.DELETE)
  public ResponseEntity<String> removeRaceCode(@PathVariable String code) {
          dummyLogin();

          AdRaceCode raceCode = commonService.findRaceCodeByCode(code);
          commonService.removeRaceCode(raceCode);
          return new ResponseEntity<String>("Success", HttpStatus.OK);
          }
  
  
  

//====================================================================================================
// PARLIAMENT_CODE
//====================================================================================================

@RequestMapping(value = "/parliamentCodes", method = RequestMethod.GET)
public ResponseEntity<List<ParliamentCode>> findParliamentCodes() {
        return new ResponseEntity<List<ParliamentCode>>(commonTransformer.toParliamentCodeVos(
        commonService.findParliamentCodes("%",0,Integer.MAX_VALUE)), HttpStatus.OK);
        }

@RequestMapping(value = "/parliamentCodes/{code}", method = RequestMethod.GET)
public ResponseEntity<ParliamentCode> findParliamentCodeByCode(@PathVariable String code) {
        return new ResponseEntity<ParliamentCode>(commonTransformer.toParliamentCodeVo(
        commonService.findParliamentCodeByCode(code)), HttpStatus.OK);
        }

@RequestMapping(value = "/parliamentCodes", method = RequestMethod.POST)
public ResponseEntity<String> saveParliamentCode(@RequestBody ParliamentCode vo) {
        dummyLogin();

        AdParliamentCode parliamentCode = new AdParliamentCodeImpl();
        parliamentCode.setCode(vo.getCode());
        parliamentCode.setDescription(vo.getDescription());
        commonService.saveParliamentCode(parliamentCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
        }

@RequestMapping(value = "/parliamentCodes/{code}", method = RequestMethod.PUT)
public ResponseEntity<String> updateParliamentCode(@PathVariable String code, @RequestBody ParliamentCode vo) {
        dummyLogin();

        AdParliamentCode parliamentCode = commonService.findParliamentCodeById(vo.getId());
        parliamentCode.setCode(vo.getCode());
        parliamentCode.setDescription(vo.getDescription());
        commonService.updateParliamentCode(parliamentCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
        }

@RequestMapping(value = "/parliamentCodes/{code}", method = RequestMethod.DELETE)
public ResponseEntity<String> removeParliamentCode(@PathVariable String code) {
        dummyLogin();

        AdParliamentCode parliamentCode = commonService.findParliamentCodeByCode(code);
        commonService.removeParliamentCode(parliamentCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
        }



//====================================================================================================
//GRADE_CODE
//====================================================================================================

@RequestMapping(value = "/gradeCodes", method = RequestMethod.GET)
public ResponseEntity<List<GradeCode>> findGradeCodes() {
      return new ResponseEntity<List<GradeCode>>(commonTransformer.toGradeCodeVos(
      commonService.findGradeCodes("%",0,Integer.MAX_VALUE )), HttpStatus.OK);
      }

@RequestMapping(value = "/gradeCodes/{code}", method = RequestMethod.GET)
public ResponseEntity<GradeCode> findGradeCodeByCode(@PathVariable String code) {
      return new ResponseEntity<GradeCode>(commonTransformer.toGradeCodeVo(
      commonService.findGradeCodeByCode(code)), HttpStatus.OK);
      }

@RequestMapping(value = "/gradeCodes", method = RequestMethod.POST)
public ResponseEntity<String> saveGradeCode(@RequestBody GradeCode vo) {
      dummyLogin();

      AdGradeCode gradeCode = new AdGradeCodeImpl();
      gradeCode.setCode(vo.getCode());
      gradeCode.setOrdinal(vo.getOrdinal());
      gradeCode.setDescription(vo.getDescription());
      commonService.saveGradeCode(gradeCode);
      return new ResponseEntity<String>("Success", HttpStatus.OK);
      }

@RequestMapping(value = "/gradeCodes/{code}", method = RequestMethod.PUT)
public ResponseEntity<String> updateGradeCode(@PathVariable String code, @RequestBody GradeCode vo) {
      dummyLogin();

      AdGradeCode gradeCode = commonService.findGradeCodeById(vo.getId());
      gradeCode.setCode(vo.getCode());
      gradeCode.setOrdinal(vo.getOrdinal());
      gradeCode.setDescription(vo.getDescription());
      commonService.updateGradeCode(gradeCode);
      return new ResponseEntity<String>("Success", HttpStatus.OK);
      }

@RequestMapping(value = "/gradeCodes/{code}", method = RequestMethod.DELETE)
public ResponseEntity<String> removeGradeCode(@PathVariable String code) {
      dummyLogin();

      AdGradeCode gradeCode = commonService.findGradeCodeByCode(code);
      commonService.removeGradeCode(gradeCode);
      return new ResponseEntity<String>("Success", HttpStatus.OK);
      }

//====================================================================================================
//RELIGION_CODE
//====================================================================================================

@RequestMapping(value = "/religionCodes", method = RequestMethod.GET)
public ResponseEntity<List<ReligionCode>> findReligionCodes() {
      return new ResponseEntity<List<ReligionCode>>(commonTransformer.toReligionCodeVos(
      commonService.findReligionCodes("%",0,Integer.MAX_VALUE)), HttpStatus.OK);
      }

@RequestMapping(value = "/religionCodes/{code}", method = RequestMethod.GET)
public ResponseEntity<ReligionCode> findReligionCodeByCode(@PathVariable String code) {
      return new ResponseEntity<ReligionCode>(commonTransformer.toReligionCodeVo(
      commonService.findReligionCodeByCode(code)), HttpStatus.OK);
      }

@RequestMapping(value = "/religionCodes", method = RequestMethod.POST)
public ResponseEntity<String> saveReligionCode(@RequestBody ReligionCode vo) {
      dummyLogin();

      AdReligionCode religionCode = new AdReligionCodeImpl();
      religionCode.setCode(vo.getCode());
      religionCode.setDescriptionEn(vo.getDescriptionEn());
      religionCode.setDescriptionMs(vo.getDescriptionMs());
      commonService.saveReligionCode(religionCode);
      return new ResponseEntity<String>("Success", HttpStatus.OK);
      }

@RequestMapping(value = "/religionCodes/{code}", method = RequestMethod.PUT)
public ResponseEntity<String> updateReligionCode(@PathVariable String code, @RequestBody ReligionCode vo) {
      dummyLogin();

      AdReligionCode religionCode = commonService.findReligionCodeById(vo.getId());
      religionCode.setCode(vo.getCode());
      religionCode.setDescriptionEn(vo.getDescriptionEn());
      religionCode.setDescriptionMs(vo.getDescriptionMs());
      commonService.updateReligionCode(religionCode);
      return new ResponseEntity<String>("Success", HttpStatus.OK);
      }

@RequestMapping(value = "/religionCodes/{code}", method = RequestMethod.DELETE)
public ResponseEntity<String> removeReligionCode(@PathVariable String code) {
      dummyLogin();

      AdReligionCode religionCode = commonService.findReligionCodeByCode(code);
      commonService.removeReligionCode(religionCode);
      return new ResponseEntity<String>("Success", HttpStatus.OK);
      }


//====================================================================================================
//NATIONALITY_CODE
//====================================================================================================

@RequestMapping(value = "/nationalityCodes", method = RequestMethod.GET)
public ResponseEntity<List<NationalityCode>> findNationalityCodes() {
      return new ResponseEntity<List<NationalityCode>>(commonTransformer.toNationalityCodeVos(
      commonService.findNationalityCodes("%",0,Integer.MAX_VALUE)), HttpStatus.OK);
      }

@RequestMapping(value = "/nationalityCodes/{code}", method = RequestMethod.GET)
public ResponseEntity<NationalityCode> findNationalityCodeByCode(@PathVariable String code) {
      return new ResponseEntity<NationalityCode>(commonTransformer.toNationalityCodeVo(
      commonService.findNationalityCodeByCode(code)), HttpStatus.OK);
      }

@RequestMapping(value = "/nationalityCodes", method = RequestMethod.POST)
public ResponseEntity<String> saveNationalityCode(@RequestBody NationalityCode vo) {
      dummyLogin();

      AdNationalityCode nationalityCode = new AdNationalityCodeImpl();
      nationalityCode.setCode(vo.getCode());
      nationalityCode.setDescriptionEn(vo.getDescriptionEn());
      nationalityCode.setDescriptionMs(vo.getDescriptionMs());
      commonService.saveNationalityCode(nationalityCode);
      return new ResponseEntity<String>("Success", HttpStatus.OK);
      }

@RequestMapping(value = "/nationalityCodes/{code}", method = RequestMethod.PUT)
public ResponseEntity<String> updateNationalityCode(@PathVariable String code, @RequestBody NationalityCode vo) {
      dummyLogin();

      AdNationalityCode nationalityCode = commonService.findNationalityCodeById(vo.getId());
      nationalityCode.setCode(vo.getCode());
      nationalityCode.setDescriptionEn(vo.getDescriptionEn());
      nationalityCode.setDescriptionMs(vo.getDescriptionMs());
      commonService.updateNationalityCode(nationalityCode);
      return new ResponseEntity<String>("Success", HttpStatus.OK);
      }

@RequestMapping(value = "/nationalityCodes/{code}", method = RequestMethod.DELETE)
public ResponseEntity<String> removeNationalityCode(@PathVariable String code) {
      dummyLogin();

      AdNationalityCode nationalityCode = commonService.findNationalityCodeByCode(code);
      commonService.removeNationalityCode(nationalityCode);
      return new ResponseEntity<String>("Success", HttpStatus.OK);
      }



//====================================================================================================
//ETHNICITY_CODE
//====================================================================================================

@RequestMapping(value = "/ethnicityCodes", method = RequestMethod.GET)
public ResponseEntity<List<EthnicityCode>> findEthnicityCodes() {
      return new ResponseEntity<List<EthnicityCode>>(commonTransformer.toEthnicityCodeVos(
      commonService.findEthnicityCodes("%",0,Integer.MAX_VALUE)), HttpStatus.OK);
      }

@RequestMapping(value = "/ethnicityCodes/{code}", method = RequestMethod.GET)
public ResponseEntity<EthnicityCode> findEthnicityCodeByCode(@PathVariable String code) {
      return new ResponseEntity<EthnicityCode>(commonTransformer.toEthnicityCodeVo(
      commonService.findEthnicityCodeByCode(code)), HttpStatus.OK);
      }

@RequestMapping(value = "/ethnicityCodes", method = RequestMethod.POST)
public ResponseEntity<String> saveEthnicityCode(@RequestBody EthnicityCode vo) {
      dummyLogin();

     AdEthnicityCode ethnicityCode = new AdEthnicityCodeImpl();
      ethnicityCode.setCode(vo.getCode());
      ethnicityCode.setDescriptionEn(vo.getDescriptionEn());
      ethnicityCode.setDescriptionMs(vo.getDescriptionMs());
      commonService.saveEthnicityCode(ethnicityCode);
      return new ResponseEntity<String>("Success", HttpStatus.OK);
      }

@RequestMapping(value = "/ethnicityCodes/{code}", method = RequestMethod.PUT)
public ResponseEntity<String> updateEthnicityCode(@PathVariable String code, @RequestBody EthnicityCode vo) {
      dummyLogin();

      AdEthnicityCode ethnicityCode = commonService.findEthnicityCodeById(vo.getId());
      ethnicityCode.setCode(vo.getCode());
      ethnicityCode.setDescriptionEn(vo.getDescriptionEn());
      ethnicityCode.setDescriptionMs(vo.getDescriptionMs());
      commonService.updateEthnicityCode(ethnicityCode);
      return new ResponseEntity<String>("Success", HttpStatus.OK);
      }

@RequestMapping(value = "/ethnicityCodes/{code}", method = RequestMethod.DELETE)
public ResponseEntity<String> removeEthnicityCode(@PathVariable String code) {
      dummyLogin();

      AdEthnicityCode ethnicityCode = commonService.findEthnicityCodeByCode(code);
      commonService.removeEthnicityCode(ethnicityCode);
      return new ResponseEntity<String>("Success", HttpStatus.OK);
      }










    // ====================================================================================================
    // PRIVATE METHODS
    // ====================================================================================================

    private void dummyLogin() {
        AdAutoLoginToken token = new AdAutoLoginToken("root");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }
}
