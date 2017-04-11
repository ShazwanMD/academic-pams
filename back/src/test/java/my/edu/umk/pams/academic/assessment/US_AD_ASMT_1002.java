package my.edu.umk.pams.academic.assessment;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tngtech.jgiven.annotation.As;

import my.edu.umk.pams.academic.config.TestAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = TestAppConfiguration.class)
@As("As a student,I want to view student resultsSo that I can know my results.")
public class US_AD_ASMT_1002 {

}
