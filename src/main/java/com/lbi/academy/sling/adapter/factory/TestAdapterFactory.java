package com.lbi.academy.sling.adapter.factory;

import com.lbi.academy.sling.adapter.Adapter;
import com.lbi.academy.sling.adapter.TestAdapter;
import com.lbi.academy.sling.adapter.model.TestAdaptedClass;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.adapter.AdapterFactory;
import org.apache.sling.api.resource.Resource;

import java.util.HashMap;
import java.util.Map;

@Component
@Service(value=org.apache.sling.api.adapter.AdapterFactory.class)
@Properties({
		@Property(name = "adaptables", value = {"org.apache.sling.api.resource.Resource"}),
		@Property(name = "adapters", value = {"com.lbi.academy.sling.adapter.model.TestAdaptedClass"})
})
public class TestAdapterFactory implements AdapterFactory {

	private Map<Class, Adapter> adapterMap;

	public TestAdapterFactory(){
		adapterMap = new HashMap<Class, Adapter>();
		adapterMap.put(TestAdaptedClass.class, new TestAdapter());
	}

	public <AdapterType> AdapterType getAdapter(final Object adaptable, Class<AdapterType> type){
		Adapter adapter = adapterMap.get(type);

		if(adapter != null){
			return (AdapterType)adapter.adapt((Resource) adaptable);
		} else {
			return null;
		}
	}
}