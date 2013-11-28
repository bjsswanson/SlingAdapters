package com.lbi.academy.sling.adapter.service;

import com.lbi.academy.sling.adapter.model.TestAdaptedClass;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Reference;


@Component
@Service(value = com.lbi.academy.sling.adapter.service.RetrieverService.class)
public class TestClassRetrieverService implements RetrieverService<TestAdaptedClass> {

	@Reference
	private AdapterService adapterService;

	@Override
	public String get(String path) {
		TestAdaptedClass testAdaptedClass = adapterService.get(path, TestAdaptedClass.class);
		if(testAdaptedClass != null) {
			return testAdaptedClass.getTestString();
		} else {
			return "";
		}
	}
}
