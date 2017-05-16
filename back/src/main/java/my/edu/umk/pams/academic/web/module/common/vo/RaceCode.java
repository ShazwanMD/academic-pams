package my.edu.umk.pams.academic.web.module.common.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class RaceCode extends MetaObject {
	private Long id;
	private String code;
	private String descriptionEn;
	private String descriptionMs;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescriptionMs() {
		return descriptionMs;
	}

	public void setDescriptionMs(String descriptionMs) {
		this.descriptionMs = descriptionMs;
	}

	@JsonCreator
	public static RaceCode create(String jsonString) {
		RaceCode o = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			o = mapper.readValue(jsonString, RaceCode.class);
		} catch (IOException e) {
			// handle
		}
		return o;
	}
}
