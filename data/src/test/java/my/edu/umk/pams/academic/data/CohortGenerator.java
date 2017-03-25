package my.edu.umk.pams.academic.data;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * create cohort for each program
 * @author PAMS
 */
public class CohortGenerator extends GeneratorSupport {

    private static final Logger LOG = LoggerFactory.getLogger(CohortGenerator.class);

    private final String SOURCE_FILE = "data/csv/AD_PRGM.csv";

    private final String TEMPLATE = "INSERT INTO AD_CHRT (\n" +
            "  ID,\n" +
            "  PROGRAM_ID,\n" +
            "  CURRICULUM_ID,\n" +
            "  CODE,\n" +
            "  DESCRIPTION,\n" +
            "  CLASSIFICATION,\n" +
            "  C_ID, C_TS, M_ST)\n" +
            "VALUES (\n" +
            "  nextval('SQ_AD_CHRT'),\n" +
            "  (SELECT ID FROM AD_PRGM where code = '%1$s'),\n" +
            "  (SELECT ID FROM AD_CRLM where code = '%1$s' || '/CRLM/0001'),\n" +
            "  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = '%1$s'),\n" +
            "  'COHORT %1$s',\n" +
            "  1,\n" +
            "  1, CURRENT_TIMESTAMP, 1\n" +
            ");\n";

    @Test
    @Rollback(false)
    public void loadData() throws IOException {
        FileWriter writer = new FileWriter("src/test/resources/data/AD_CHRT.sql");
        List<String> lines = readSource(SOURCE_FILE);
        int i = 0;
        for (String line : lines) {
            String[] split = line.split(",", -1);
            String formatted = String.format(TEMPLATE, split[0]);
            LOG.debug("formatted: " + formatted);
            writer.write(formatted);
            i++;
        }
        writer.flush();
        writer.close();
    }
}