package my.edu.umk.pams.academic.web.module.term.controller;

import my.edu.umk.pams.academic.term.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PAMS
 */
@RestController
@RequestMapping("/api/term")
public class TermController {

    @Autowired
    private TermService termService;

    @RequestMapping(value = "/dosomething", method = RequestMethod.GET)
    public ResponseEntity<String> findSomething() {
        return new ResponseEntity<String>("something", HttpStatus.OK);
    }
}
