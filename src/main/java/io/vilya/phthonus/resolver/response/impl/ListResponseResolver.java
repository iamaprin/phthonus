package io.vilya.phthonus.resolver.response.impl;

import java.util.List;

import io.vilya.common.rest.RestListResponse;
import io.vilya.common.rest.RestResponse;
import io.vilya.phthonus.resolver.constant.ResolverPriority;
import io.vilya.phthonus.resolver.response.AbstractResponseResolver;

/**
 * @author iamaprin
 * @time 2017年10月29日 下午3:40:56
 */
public class ListResponseResolver extends AbstractResponseResolver {
	
	@Override
	public boolean isSupport(Object object) {
		return object instanceof List;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public RestResponse resolve(Object object) {
		List<Object> list = (List<Object>) object;
		return new RestListResponse<>(list);
	}
	
	@Override
	public ResolverPriority getPriority() {
		return ResolverPriority.MIDDLE;
	}

}
