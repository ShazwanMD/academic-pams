package my.edu.umk.pams.academic.web.module;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.config.TestAppConfiguration;
import my.edu.umk.pams.academic.planner.model.AdCurriculum;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.web.module.planner.controller.PlannerTransformer;
import my.edu.umk.pams.academic.web.module.planner.vo.Course;
import my.edu.umk.pams.academic.web.module.planner.vo.Curriculum;
import my.edu.umk.pams.academic.web.module.planner.vo.Program;
import my.edu.umk.pams.academic.web.module.planner.vo.BundleSubject;
import my.edu.umk.pams.academic.web.module.planner.vo.BundleSubjectPart;
import my.edu.umk.pams.academic.web.module.planner.vo.SingleSubject;
import my.edu.umk.pams.academic.web.module.planner.vo.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
public class JsonInheritanceTest {

    private static final Logger LOG = LoggerFactory.getLogger(JsonInheritanceTest.class);

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private PlannerTransformer plannerTransformer;

    @Autowired
    private Jackson2ObjectMapperBuilder builder;

    private JacksonTester<Curriculum> json;
    private Curriculum curriculum;
    private ObjectMapper mapper;

    @Before
    public void setup() {
        mapper = builder.build(); // Possibly configure the mapper
        JacksonTester.initFields(this, mapper);
    }


    @Test
    public void structuralTest() throws IOException {

        String CURRICULUM_CODE = "SAMPLE_CURRICULUM_FPV-PHD-PDM-CRLM-0001";

        Course course0 = new Course();
        Course course1 = new Course();
        Course course2 = new Course();

        SingleSubject single = new SingleSubject();
        single.setCourse(course0);

        BundleSubject bundle = new BundleSubject();
        BundleSubjectPart part1 = new BundleSubjectPart();
        part1.setCourse(course1);
        BundleSubjectPart part2 = new BundleSubjectPart();
        part2.setCourse(course2);
        bundle.setParts(Arrays.asList(part1, part2));

        List<Subject> subjects = new ArrayList<>();
        subjects.add(single);
        subjects.add(bundle);

        Curriculum curriculum = new Curriculum();
        curriculum.setCode(CURRICULUM_CODE);
        curriculum.setSubjects(subjects);
        curriculum.setProgram(new Program());

//        toJsonPrinter(curriculum);

        String pathExpected = "$.subjects[0].type";
        assertThat(this.json.write(curriculum)).hasJsonPathStringValue(pathExpected);

        String valueExpected = "single";
        assertThat(this.json.write(curriculum)).extractingJsonPathStringValue(pathExpected).isEqualTo(valueExpected);
    }

    @Test
    public void payloadTest() throws IOException {

        List<AdProgram> programEntities = new ArrayList<>();
        List<AdCurriculum> curriculumEntities = new ArrayList<>();

        List<AdFaculty> facultyEntities = plannerService.findFaculties();
        facultyEntities.forEach(f -> programEntities.addAll(f.getPrograms()));
        programEntities.forEach(p -> curriculumEntities.addAll(plannerService.findCurriculums(p)));

        Curriculum curriculum = plannerTransformer.toCurriculumVo(curriculumEntities.get(0));
//        toJsonPrinter(curriculum);
        String pathExpected = "$.program.id";

        try {
            assertThat(this.json.write(curriculum)).hasJsonPathNumberValue(pathExpected);
            assertThat(this.json.write(curriculum)).extractingJsonPathNumberValue(pathExpected).isNotNull();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void toJsonPrinter(Curriculum curriculum) {
        String jsonDataString = null;
        try {
            jsonDataString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(curriculum);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        LOG.debug("The resulting JSON string:\n " +
                "Start of Curriculum \n ===================== \n"
                + jsonDataString
                + "\n ===================== \n End of Curriculum \n");
    }

}
