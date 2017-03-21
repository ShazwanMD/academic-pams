package my.edu.umk.pams.academic.data;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 * create curriculum for each program
 *
 * @author PAMS
 */
public class CurriculumGenerator extends GeneratorSupport {

    private static final Logger LOG = LoggerFactory.getLogger(CurriculumGenerator.class);
    private static final String SEQUENCE_FORMAT = "000";

    private final String SOURCE_FILE = "data/csv/AD_PRGM.csv";
    private final NumberFormat numberFormat = new DecimalFormat(SEQUENCE_FORMAT);

    private final String TEMPLATE = "INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,\n" +
            "                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,\n" +
            "                     PERIOD, MAX_PERIOD, ORDINAL,\n" +
            "                     C_ID, C_TS, M_ST)\n" +
            "VALUES (NEXTVAL('SQ_AD_CRLM'),\n" +
            "  (SELECT ID\n" +
            "   FROM AD_PRGM\n" +
            "   WHERE CODE = '%1$s'),\n" +
            "  (SELECT CODE\n" +
            "   FROM AD_PRGM\n" +
            "   WHERE CODE = '%1$s') || '%2$s',\n" +
            "  100, 10, 10, 10, 10, 10, 10, 124,\n" +
            "  8, 12, 1,\n" +
            "  1, CURRENT_TIMESTAMP, 1);\n";

    @Test
    @Rollback(false)
    public void loadData() throws IOException {
        FileWriter writer = new FileWriter("src/test/resources/data/AD_CRLM.sql");
        List<String> lines = readSource(SOURCE_FILE);
        int i = 0;
        for (String line : lines) {
            String[] split = line.split(",", -1);
            String formatted = String.format(TEMPLATE, split[0], "/CRLM/0001");
            LOG.debug("formatted: " + formatted);
            writer.write(formatted);
            i++;
        }
        writer.flush();
        writer.close();
    }
}