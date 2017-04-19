package my.edu.umk.pams.academic.system.service;

import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.system.dao.*;
import my.edu.umk.pams.academic.system.model.*;
import my.edu.umk.pams.academic.util.Util;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author canang technologies
 * @since 1/30/14
 */
@Transactional
@Service("systemService")
public class SystemServiceImpl implements SystemService {

    public static final DateFormat LONG_YEAR_FORMAT = new SimpleDateFormat("yyyy");
    public static final DateFormat SHORT_YEAR_FORMAT = new SimpleDateFormat("yy");
    public static final DateFormat LONG_MONTH_FORMAT = new SimpleDateFormat("MMM");
    public static final DateFormat SHORT_MONTH_FORMAT = new SimpleDateFormat("MM");
    public static final DateFormat LONG_DAY_FORMAT = new SimpleDateFormat("dd");
    public static final DateFormat SHORT_DAY_FORMAT = new SimpleDateFormat("dd");
    public static final DateFormat LONG_HOUR_FORMAT = new SimpleDateFormat("hh");
    public static final DateFormat SHORT_HOUR_FORMAT = new SimpleDateFormat("hh");
    private static final Logger LOG = LoggerFactory.getLogger(SystemServiceImpl.class);

    @Autowired
    private IdentityService identityService;

    @Autowired
    private AdModuleDao moduleDao;

    @Autowired
    private AdSubModuleDao subModuleDao;

    @Autowired
    private AdAuditDao auditDao;

    @Autowired
    private AdReferenceNoDao referenceNoDao;

    @Autowired
    private AdConfigurationDao configurationDao;

    @Autowired
    private AdEmailTemplateDao emailTemplateDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private SecurityService securityService;


    //====================================================================================================
    // MODULE SUBMODULE
    //====================================================================================================

    @Override
    public AdModule findModuleById(Long id) {
        return moduleDao.findById(id);
    }

    @Override
    public AdSubModule findSubModuleById(Long id) {
        return subModuleDao.findById(id);
    }

    @Override
    public AdModule findModuleByCode(String code) {
        return moduleDao.findByCode(code);
    }

    @Override
    public AdSubModule findSubModuleByCode(String code) {
        return subModuleDao.findByCode(code);
    }

    @Override
    public List<AdModule> findModules(boolean authorized) {
        return authorized ?
                moduleDao.findAuthorized(identityService.findSids(Util.getCurrentUser())) :
                moduleDao.find();
    }

    @Override
    public List<AdModule> findModules() {
        return moduleDao.find();
    }

    @Override
    public List<AdModule> findModules(Integer offset, Integer limit) {
        return moduleDao.find(offset, limit);
    }

    @Override
    public List<AdModule> findModules(boolean authorized, Integer offset, Integer limit) {
        return authorized ?
                moduleDao.findAuthorized(identityService.findSids(Util.getCurrentUser()), offset, limit) :
                moduleDao.find(offset, limit);
    }

    @Override
    public List<AdSubModule> findSubModules() {
        return subModuleDao.find();
    }

    @Override
    public List<AdSubModule> findSubModules(boolean authorized) {
        return authorized ?
                subModuleDao.findAuthorized(identityService.findSids(Util.getCurrentUser())) :
                subModuleDao.find();
    }

    @Override
    public List<AdSubModule> findSubModules(Integer offset, Integer limit) {
        return subModuleDao.find(offset, limit);
    }

    @Override
    public List<AdSubModule> findSubModules(AdModule module, Integer offset, Integer limit) {
        return subModuleDao.find(module, offset, limit);
    }

    @Override
    public Integer countModule() {
        return moduleDao.count();
    }

    @Override
    public Integer countSubModule() {
        return subModuleDao.count();
    }

    @Override
    public Integer countSubModule(AdModule module) {
        return subModuleDao.count(module);
    }

    @Override
    public void saveModule(AdModule module) {
        moduleDao.save(module, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateModule(AdModule module) {
        moduleDao.update(module, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addSubModule(AdModule module, AdSubModule subModule) {
        moduleDao.addSubModule(module, subModule, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateSubModule(AdModule module, AdSubModule subModule) {
        moduleDao.updateSubModule(module, subModule, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // AUDIT
    //====================================================================================================

    @Override
    public AdAudit findAuditById(Long id) {
        return auditDao.findById(id);
    }

    @Override
    public List<AdAudit> findAudits(Integer offset, Integer limit) {
        return auditDao.find(offset, limit);
    }

    @Override
    public List<AdAudit> findAudits(String filter, Integer offset, Integer limit) {
        return auditDao.find(filter, offset, limit);
    }

    @Override
    public Integer countAudit() {
        return auditDao.count();
    }

    @Override
    public Integer countAudit(String filter) {
        return auditDao.count(filter);
    }

    //====================================================================================================
    // REFERENCE NO
    //====================================================================================================

    @Override
    public AdReferenceNo findReferenceNoById(Long id) {
        return referenceNoDao.findById(id);
    }

    @Override
    public AdReferenceNo findReferenceNoByCode(String code) {
        return referenceNoDao.findByCode(code);
    }

    @Override
    public List<AdReferenceNo> findReferenceNos(Integer offset, Integer limit) {
        return referenceNoDao.find(offset, limit);
    }

    @Override
    public List<AdReferenceNo> findReferenceNos(String filter, Integer offset, Integer limit) {
        return referenceNoDao.find(filter, offset, limit);
    }

    @Override
    public Integer countReferenceNo() {
        return referenceNoDao.count();
    }

    @Override
    public Integer countReferenceNo(String filter) {
        return referenceNoDao.count(filter);
    }

    @Override
    public String generateReferenceNo(String code) {
        String generatedRefNo = null;
        synchronized (this) {
            AdReferenceNo referenceNo = referenceNoDao.findByCode(code);
            Integer oldValue = referenceNo.getCurrentValue();
            Integer newValue = referenceNo.getCurrentValue() + referenceNo.getIncrementValue();

            // update
            referenceNo.setCurrentValue(newValue);
            referenceNoDao.save(referenceNo, Util.getCurrentUser());
            sessionFactory.getCurrentSession().flush();
            NumberFormat numberFormat = new DecimalFormat(referenceNo.getSequenceFormat());

            // format
            generatedRefNo = referenceNo.getPrefix() + numberFormat.format(oldValue);
        }
        return generatedRefNo;
    }

    public String generateFormattedReferenceNo(String code, Map<String, Object> map) {
        synchronized (this) {
            AdReferenceNo referenceNo = referenceNoDao.findByCode(code);

            // get old and new value
            Integer oldValue = referenceNo.getCurrentValue();
            Integer newValue = referenceNo.getCurrentValue() + referenceNo.getIncrementValue();

            // update
            referenceNo.setCurrentValue(newValue);
            referenceNoDao.save(referenceNo, Util.getCurrentUser());
            sessionFactory.getCurrentSession().flush();

            Date now = new Date();
            NumberFormat numberFormat = new DecimalFormat(referenceNo.getSequenceFormat());
            SpelParserConfiguration configuration = new SpelParserConfiguration(true, true);
            StandardEvaluationContext context = new StandardEvaluationContext(configuration);
            ParserContext templateContext = new TemplateParserContext("{", "}");
            context.setVariable("a", referenceNo.getPrefix());
            context.setVariable("b", LONG_YEAR_FORMAT.format(now));
            context.setVariable("c", SHORT_YEAR_FORMAT.format(now));
            context.setVariable("d", LONG_MONTH_FORMAT.format(now));
            context.setVariable("e", SHORT_MONTH_FORMAT.format(now));
            context.setVariable("f", LONG_DAY_FORMAT.format(now));
            context.setVariable("g", SHORT_DAY_FORMAT.format(now));
            context.setVariable("h", LONG_HOUR_FORMAT.format(now));
            context.setVariable("i", SHORT_HOUR_FORMAT.format(now));
            context.setVariable("j", numberFormat.format(oldValue));

            for (String key : map.keySet()) {
                context.setVariable(key, map.get(key));
            }

            SpelExpressionParser parser = new SpelExpressionParser();
            Expression expression = parser.parseExpression(referenceNo.getReferenceFormat(), templateContext);
            return expression.getValue(context, String.class);
        }
    }


    //====================================================================================================
    // CONFIGURATION
    //====================================================================================================

    @Override
    public AdConfiguration findConfigurationById(Long id) {
        return configurationDao.findById(id);
    }

    @Override
    public AdConfiguration findConfigurationByKey(String key) {
        return configurationDao.findByKey(key);
    }

    @Override
    public List<AdConfiguration> findConfigurationsByPrefix(String prefix) {
        return configurationDao.findByPrefix(prefix);
    }

    @Override
    public List<AdConfiguration> findConfigurations() {
        return configurationDao.find();
    }

    @Override
    public List<AdConfiguration> findConfigurations(Integer offset, Integer limit) {
        return configurationDao.find(offset, limit);
    }

    @Override
    public List<AdConfiguration> findConfigurations(String filter) {
        return configurationDao.find(filter);
    }

    @Override
    public List<AdConfiguration> findConfigurations(String filter, Integer offset, Integer limit) {
        return configurationDao.find(filter, offset, limit);
    }


    @Override
    public Integer countConfiguration() {
        return configurationDao.count();
    }

    @Override
    public Integer countConfiguration(String filter) {
        return configurationDao.count(filter);
    }

    @Override
    public void saveConfiguration(AdConfiguration config) {
        configurationDao.save(config, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateConfiguration(AdConfiguration config) {
        configurationDao.update(config, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeConfiguration(AdConfiguration config) {
        configurationDao.remove(config, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }


    //====================================================================================================
    // EMAIL TEMPLATE
    //====================================================================================================

    @Override
    public AdEmailTemplate findEmailTemplateById(Long id) {
        return emailTemplateDao.findById(id);
    }

    @Override
    public AdEmailTemplate findEmailTemplateByCode(String code) {
        return emailTemplateDao.findByCode(code);
    }

    @Override
    public List<AdEmailTemplate> findEmailTemplates() {
        return emailTemplateDao.find();
    }

    @Override
    public List<AdEmailTemplate> findEmailTemplates(Integer offset, Integer limit) {
        return emailTemplateDao.find(offset, limit);
    }

    @Override
    public List<AdEmailTemplate> findEmailTemplates(String filter) {
        return emailTemplateDao.find(filter);
    }

    @Override
    public List<AdEmailTemplate> findEmailTemplates(String filter, Integer offset, Integer limit) {
        return emailTemplateDao.find(filter, offset, limit);
    }

    @Override
    public Integer countEmailTemplate() {
        return emailTemplateDao.count();
    }

    @Override
    public Integer countEmailTemplate(String filter) {
        return emailTemplateDao.count(filter);
    }

    @Override
    public void saveEmailTemplate(AdEmailTemplate template) {
        emailTemplateDao.save(template, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateEmailTemplate(AdEmailTemplate template) {
        emailTemplateDao.update(template, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeEmailTemplate(AdEmailTemplate template) {
        emailTemplateDao.remove(template, Util.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void sendWithAttachment(String email, String s, String s1, String s2, String s3, HashMap<String, Object> vars) {

    }
}
