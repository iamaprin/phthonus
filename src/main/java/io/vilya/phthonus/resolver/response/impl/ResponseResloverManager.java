package io.vilya.phthonus.resolver.response.impl;

import org.springframework.stereotype.Component;

import io.vilya.common.rest.RestResponse;
import io.vilya.phthonus.resolver.BaseResolverManager;
import io.vilya.phthonus.resolver.constant.ResolverPriority;
import io.vilya.phthonus.resolver.response.AbstractResponseResolver;

/**
 * @author iamaprin
 * @time 2017年10月29日 下午3:54:23
 */
@Component
public class ResponseResloverManager extends BaseResolverManager<AbstractResponseResolver> {

	public ResponseResloverManager() {
		register(new SimpleResponseResolver());
		register(new ListResponseResolver());
	}
	
	private static class SimpleResponseResolver extends AbstractResponseResolver {

		@Override
		public boolean isSupport(Object object) {
			return true;
		}

		@Override
		public RestResponse resolve(Object object) {
			return new RestResponse().setData(object);
		}

		@Override
		public ResolverPriority getPriority() {
			return ResolverPriority.LOW;
		}
		
	}
	
}
