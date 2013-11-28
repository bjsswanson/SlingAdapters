package com.lbi.academy.sling.adapter;

import org.apache.sling.api.resource.Resource;

public interface Adapter<T> {
	T adapt(Resource resource);
}
