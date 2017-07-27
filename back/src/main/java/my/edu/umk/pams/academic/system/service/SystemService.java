package my.edu.umk.pams.academic.system.service;

import my.edu.umk.pams.academic.system.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface SystemService {


    //====================================================================================================
    // MODULE SUB MODULE
    //====================================================================================================

    AdModule findModuleById(Long id);

    AdSubModule findSubModuleById(Long id);

    AdModule findModuleByCode(String code);

    AdSubModule findSubModuleByCode(String code);

    List<AdModule> findModules();

    List<AdModule> findModules(boolean authorized);

    List<AdModule> findModules(Integer offset, Integer limit);

    List<AdModule> findModules(boolean authorized, Integer offset, Integer limit);

    List<AdSubModule> findSubModules();

    List<AdSubModule> findSubModules(boolean authorized);

    List<AdSubModule> findSubModules(Integer offset, Integer limit);

    List<AdSubModule> findSubModules(AdModule module, Integer offset, Integer limit);

    Integer countModule();

    Integer countSubModule();

    Integer countSubModule(AdModule module);

    void saveModule(AdModule module);

    void updateModule(AdModule module);

    void addSubModule(AdModule module, AdSubModule subModule);

    void updateSubModule(AdModule module, AdSubModule subModule);

    //====================================================================================================
    // AUDIT
    //====================================================================================================

    AdAudit findAuditById(Long id);

    List<AdAudit> findAudits(Integer offset, Integer limit);

    List<AdAudit> findAudits(String filter, Integer offset, Integer limit);

    Integer countAudit();

    Integer countAudit(String filter);

    //====================================================================================================
    // REFERENCE NO
    //====================================================================================================

    AdReferenceNo findReferenceNoById(Long id);

    AdReferenceNo findReferenceNoByCode(String code);

    List<AdReferenceNo> findReferenceNos(Integer offset, Integer limit);

    List<AdReferenceNo> findReferenceNos(String filter, Integer offset, Integer limit);

    Integer countReferenceNo();

    Integer countReferenceNo(String filter);

    String generateReferenceNo(String code);

    String generateFormattedReferenceNo(String code, Map<String, Object> map);

    //====================================================================================================
    // CONFIGURATION
    //====================================================================================================

    AdConfiguration findConfigurationById(Long id);

    AdConfiguration findConfigurationByKey(String key);

    List<AdConfiguration> findConfigurationsByPrefix(String prefix);

    List<AdConfiguration> findConfigurations();

    List<AdConfiguration> findConfigurations(Integer offset, Integer limit);

    List<AdConfiguration> findConfigurations(String filter);

    List<AdConfiguration> findConfigurations(String filter, Integer offset, Integer limit);

    Integer countConfiguration();

    Integer countConfiguration(String filter);

    void saveConfiguration(AdConfiguration config);

    void updateConfiguration(AdConfiguration config);

    void removeConfiguration(AdConfiguration config);

    //====================================================================================================
    // EMAIL
    //====================================================================================================

    AdEmailTemplate findEmailTemplateById(Long id);

    AdEmailTemplate findEmailTemplateByCode(String code);

    List<AdEmailTemplate> findEmailTemplates();

    List<AdEmailTemplate> findEmailTemplates(Integer offset, Integer limit);

    List<AdEmailTemplate> findEmailTemplates(String filter);

    List<AdEmailTemplate> findEmailTemplates(String filter, Integer offset, Integer limit);

    Integer countEmailTemplate();

    Integer countEmailTemplate(String filter);

    void saveEmailTemplate(AdEmailTemplate config);

    void updateEmailTemplate(AdEmailTemplate config);

    void removeEmailTemplate(AdEmailTemplate config);

    // TODO:
    void sendWithAttachment(String email, String s, String s1, String s2, String s3, HashMap<String, Object> vars);


    //====================================================================================================
    // EMAIL QUEUE
    //====================================================================================================

    List<AdEmailQueue> findEmailQueues();

    List<AdEmailQueue> findEmailQueues(AdEmailQueueStatus status);

    List<AdEmailQueue> findEmailQueues(AdEmailQueueStatus status, Integer offset, Integer limit);

    Integer countEmailQueue();

    void saveEmailQueue(AdEmailQueue emailQueue);

    void updateEmailQueue(AdEmailQueue emailQueue);
}
