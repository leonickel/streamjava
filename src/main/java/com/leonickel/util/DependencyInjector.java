package com.leonickel.util;

import com.google.inject.AbstractModule;
import com.leonickel.service.StreamService;
import com.leonickel.service.impl.StreamServiceImpl;

public class DependencyInjector extends AbstractModule {

	@Override
	protected void configure() {
		//Service and DAO classes
		bind(StreamService.class).to(StreamServiceImpl.class);
	}
}