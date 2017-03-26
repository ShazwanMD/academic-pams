package my.edu.umk.pams.academic.web.module.graduation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PAMS
 */
@RestController
@RequestMapping("/api/graduation")
public class GraduationController {

//    @Autowired
//    private GraduationService graduationService;

    @RequestMapping(value = "/dosomething", method = RequestMethod.GET)
    public ResponseEntity<String> findSomething() {
        return new ResponseEntity<String>("something", HttpStatus.OK);
    }
}
