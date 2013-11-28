package com.lbi.academy.sling.adapter.service;

import org.apache.sling.api.resource.LoginException;

import javax.jcr.RepositoryException;

public interface AdapterService {
	<AdapterType> AdapterType get(String path, Class<AdapterType> type);
}
