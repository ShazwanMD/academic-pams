package my.edu.umk.pams.academic.web.module.common.controller;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.web.module.common.vo.GradeCode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PAMS
 */
@Component("commonTransformer")
public class CommonTransformer {

    //====================================================================================================
    // GRADE CODE
    //====================================================================================================

    public GradeCode toGradeCodeVo(AdGradeCode e) {
        GradeCode vo = new GradeCode();
        vo.setId(e.getId());
        vo.setCode(e.getCode());
        vo.setDescription(e.getDescription());
        return vo;
    }

    public List<GradeCode> toGradeCodeVos(List<AdGradeCode> e) {
        List<GradeCode> vos = e.stream()
                .map((e1) -> toGradeCodeVo(e1))
                .collect(Collectors.toList());
        return vos;
    }
}
