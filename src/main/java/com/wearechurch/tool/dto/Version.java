package com.wearechurch.tool.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Version {

	@NotEmpty
	@Pattern(regexp = "^[\\d]+[.][\\d]+[.][\\d]+$")
	private String tag;

	public String getTag() {
		return tag;
	}

	public void setTag(final String tag) {
		this.tag = tag;
	}

}
