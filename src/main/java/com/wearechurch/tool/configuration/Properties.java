package com.wearechurch.tool.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class Properties {

	@Value("${spring.application.name}")
	private String springApplicationName;

	public String getSpringApplicationName() {
		return springApplicationName;
	}

	public void setSpringApplicationName(final String springApplicationName) {
		this.springApplicationName = springApplicationName;
	}

}
