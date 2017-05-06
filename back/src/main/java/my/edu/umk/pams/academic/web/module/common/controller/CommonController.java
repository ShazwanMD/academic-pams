package my.edu.umk.pams.academic.web.module.common.controller;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdGradeCodeImpl;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.security.integration.AdAutoLoginToken;
import my.edu.umk.pams.academic.web.module.common.vo.GradeCode;
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
    // COHORT_CODE
    //====================================================================================================

    @RequestMapping(value = "/gradeCodes", method = RequestMethod.GET)
    public ResponseEntity<List<GradeCode>> findGradeCodes() {
        return new ResponseEntity<List<GradeCode>>(commonTransformer.toGradeCodeVos(
                commonService.findGradeCodes()), HttpStatus.OK);
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
        gradeCode.setDescription(vo.getDescription());
        commonService.saveGradeCode(gradeCode);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/gradeCodes/{code}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateGradeCode(@PathVariable String code, @RequestBody GradeCode vo) {
        dummyLogin();

        AdGradeCode gradeCode = commonService.findGradeCodeById(vo.getId());
        gradeCode.setCode(vo.getCode());
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

    // ====================================================================================================
    // PRIVATE METHODS
    // ====================================================================================================

    private void dummyLogin() {
        AdAutoLoginToken token = new AdAutoLoginToken("root");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }
}
