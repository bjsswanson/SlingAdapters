package com.lbi.academy.sling.adapter.service;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

@Component
@Service(value = com.lbi.academy.sling.adapter.service.AdapterService.class)
public class TestAdapterService implements AdapterService {

	@Reference
	private ResourceResolverFactory resolverFactory;

	public <AdapterType> AdapterType get(String path, Class<AdapterType> type) {
		try {
			ResourceResolver resourceResolver = resolverFactory.getAdministrativeResourceResolver(null);
			if(resourceResolver != null){
				Resource res = resourceResolver.getResource(path);
				if(res != null){
					return res.adaptTo(type);
				}
			}
		} catch (LoginException e) {}

		return null;
	}

	public void setResolverFactory(ResourceResolverFactory resolverFactory) {
		this.resolverFactory = resolverFactory;
	}
}
