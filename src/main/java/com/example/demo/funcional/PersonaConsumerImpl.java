package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonaConsumerImpl implements IPersonaConsumer<String,Integer> {

	private static final Logger LOG = LoggerFactory.getLogger(PersonaConsumerImpl.class);

	@Override
	public void accept(String arg1,Integer arg2) {
		// TODO Auto-generated method stub
		LOG.info("mesaje: " + arg1);
		LOG.info("mesaje2: " + arg2);
	}

}
