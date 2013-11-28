package com.lbi.academy.sling.adapter;

import com.lbi.academy.sling.adapter.model.TestAdaptedClass;
import org.apache.sling.api.resource.Resource;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;

public class TestAdapter implements Adapter<TestAdaptedClass> {

	@Override
	public TestAdaptedClass adapt(Resource resource) {
		TestAdaptedClass testAdaptedClass = new TestAdaptedClass();

		try {
			Node node = resource.adaptTo(Node.class);
			Property testProperty = node.getProperty("testString");

			if(testProperty != null){
				testAdaptedClass.setTestString(testProperty.getString());
			}
		} catch (RepositoryException e) {}

		return testAdaptedClass;
	}
}
