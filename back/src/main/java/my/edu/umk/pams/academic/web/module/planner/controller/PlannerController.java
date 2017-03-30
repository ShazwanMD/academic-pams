package my.edu.umk.pams.academic.web.module.planner.controller;

import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.web.module.planner.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author PAMS
 */
@RestController
@RequestMapping("/api/planner")
public class PlannerController {

    @Autowired
    private PlannerService plannerService;

    //====================================================================================================
    // ACADEMIC SESSION
    //====================================================================================================
    @RequestMapping(value = "/academicSessions", method = RequestMethod.GET)
    public ResponseEntity<List<AcademicSession>> findAcademicSessions() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/faculties/page/{pageNo}", method = RequestMethod.GET)
    public ResponseEntity<List<AcademicSession>> findAcademicSessions(@PathVariable Integer pageNo) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/academicSessions/current", method = RequestMethod.GET)
    public ResponseEntity<AcademicSession> findCurrentAcademicSessions() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/academicSessions/{code}", method = RequestMethod.GET)
    public ResponseEntity<AcademicSession> findAcademicSessionByCode(@PathVariable String code) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/academicSessions/{code}", method = RequestMethod.POST)
    public void updateAcademicSession(@PathVariable String code) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/academicSessions/{code}/activate", method = RequestMethod.POST)
    public void activateAcademicSession(@PathVariable String code) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/academicSessions/{code}/deactivate", method = RequestMethod.POST)
    public void deactivateAcademicSession(@PathVariable String code) {
        throw new UnsupportedOperationException();
    }



    //====================================================================================================
    // FACULTY
    //====================================================================================================

    @RequestMapping(value = "/faculties", method = RequestMethod.GET)
    public ResponseEntity<List<Faculty>> findFaculties() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/faculties/page/{pageNo}", method = RequestMethod.GET)
    public ResponseEntity<List<Faculty>> findFaculties(@PathVariable Integer pageNo) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/faculties/{code}", method = RequestMethod.GET)
    public ResponseEntity<Faculty> findFacultyByCode(@PathVariable String code) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/faculties/{code}/programs", method = RequestMethod.GET)
    public ResponseEntity<List<Program>> findProgramsByFaculty(@PathVariable String code) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/faculties/{code}/courses", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> findCoursesByFaculty(@PathVariable String code) {
        throw new UnsupportedOperationException();
    }

    // business methods

    @RequestMapping(value = "/faculties/create", method = RequestMethod.POST)
    public void createFaculty(@RequestBody Faculty faculty) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/faculties/{code}/update", method = RequestMethod.POST)
    public void updateFaculty(@PathVariable String code, @RequestBody Faculty faculty) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/faculties/{code}/activate", method = RequestMethod.POST)
    public void activateFaculty(@PathVariable String code) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/faculties/{code}/deactivate", method = RequestMethod.POST)
    public void deactivateFaculty(@PathVariable String code) {
        throw new UnsupportedOperationException();
    }

    //====================================================================================================
    // PROGRAM
    //====================================================================================================

    @RequestMapping(value = "/programs", method = RequestMethod.GET)
    public ResponseEntity<List<Program>> findPrograms() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/programs/page/{pageNo}", method = RequestMethod.GET)
    public ResponseEntity<List<Program>> findPrograms(@PathVariable Integer pageNo) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/programs/{code}", method = RequestMethod.GET)
    public ResponseEntity<Program> findProgramByCode(@PathVariable String code) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/programs/{code}/cohorts", method = RequestMethod.GET)
    public ResponseEntity<List<Cohort>> findCohortsByProgram(@PathVariable String code) {
        throw new UnsupportedOperationException();
    }

    // business methods

    @RequestMapping(value = "/programs/create", method = RequestMethod.POST)
    public ResponseEntity<Program> createProgram(@RequestBody Program program) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/programs/{code}/update", method = RequestMethod.POST)
    public ResponseEntity<Program> updateProgram(@PathVariable String code, @RequestBody Program program) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/programs/{code}/activate", method = RequestMethod.POST)
    public ResponseEntity<Program> activateProgram(@PathVariable String code) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/programs/{code}/deactivate", method = RequestMethod.POST)
    public ResponseEntity<Program> deactivateProgram(@PathVariable String code) {
        throw new UnsupportedOperationException();
    }

    //====================================================================================================
    // PROGRAM
    //====================================================================================================

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ResponseEntity<Course> findCourses() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/courses/page/{pageNo}", method = RequestMethod.GET)
    public ResponseEntity<Course> findCourses(@PathVariable Integer pageNo) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/courses/create", method = RequestMethod.POST)
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/courses/{code}/update", method = RequestMethod.POST)
    public ResponseEntity<Course> updateCourse(@PathVariable String code, @RequestBody Course course) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/courses/{code}/activate", method = RequestMethod.POST)
    public ResponseEntity<Course> activateCourse(@PathVariable String code, @RequestBody Course course) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/courses/{code}/deactivate", method = RequestMethod.POST)
    public ResponseEntity<Course> deactivateCourse(@PathVariable String code, @RequestBody Course course) {
        throw new UnsupportedOperationException();
    }
}
