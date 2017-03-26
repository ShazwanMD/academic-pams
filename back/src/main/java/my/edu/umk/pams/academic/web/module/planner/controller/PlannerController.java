package my.edu.umk.pams.academic.web.module.planner.controller;

import my.edu.umk.pams.academic.planner.service.PlannerService;
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
@RequestMapping("/api/planner")
public class PlannerController {

    @Autowired
    private PlannerService plannerService;

    @RequestMapping(value = "/dosomething", method = RequestMethod.GET)
    public ResponseEntity<String> findSomething() {
        return new ResponseEntity<String>("something", HttpStatus.OK);
    }
}
