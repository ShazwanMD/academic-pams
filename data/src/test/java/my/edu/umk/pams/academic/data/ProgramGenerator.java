package my.edu.umk.pams.academic.data;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author PAMS
 */
public class ProgramGenerator extends GeneratorSupport {

    private static final Logger LOG = LoggerFactory.getLogger(ProgramGenerator.class);
    private static final String SEQUENCE_FORMAT = "000";

    private final String SOURCE_FILE = "data/csv/academic-setup.csv";
    

    private final String TEMPLATE = "INSERT INTO AD_ACDM_YEAR (ID, CODE, DESCRIPTION, YEAR, C_TS, C_ID, M_ST) " +
            "   VALUES (nextval('SQ_AD_ACDM_YEAR'), " +
            "   '%1$s',\n" +
            "   '%2$s',\n" +
            "   '%3$s',\n" +        
            "     CURRENT_TIMESTAMP, 0, 1);\n";

    @Test
    @Rollback(false)
    public void loadData() throws IOException {
        FileWriter writer = new FileWriter("src/test/resources/data/AD_ACDM_YEAR_1.sql");
        List<String> lines = readSource(SOURCE_FILE);
        int i = 0;
        for (String line : lines) {
            String[] split = line.split(",", -1);
            String formatted = String.format(TEMPLATE, split[0], split[1], split[2]/*, split[3]*/);
            LOG.debug("formatted: " + formatted);
            writer.write(formatted);
            i++;
        }
        writer.flush();
        writer.close();
    }
}