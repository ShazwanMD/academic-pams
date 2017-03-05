package my.edu.umk.pams.academic.system.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.system.model.AdEmailQueue;
import my.edu.umk.pams.academic.system.model.AdEmailQueueStatus;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface AdEmailQueueDao extends GenericDao<Long, AdEmailQueue> {

    List<AdEmailQueue> find(AdEmailQueueStatus status);

    List<AdEmailQueue> find(AdEmailQueueStatus... statuses);

}
