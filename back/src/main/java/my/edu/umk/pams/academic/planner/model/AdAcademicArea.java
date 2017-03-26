package my.edu.umk.pams.academic.planner.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * Bidang Teknologi
 * <p/>
 * Bidang Sains Gunaan
 * <p/>
 * Bidang Sastera Ikhtisas
 *
 * @author PAMS
 */
public interface AdAcademicArea extends AdMetaObject {

    /**
     * academic area code
     * @return
     */
    String getCode();

    void setCode(String code);

    /**
     * academic area description
     * @return
     */
    String getDescription();

    void setDescription(String description);

}
