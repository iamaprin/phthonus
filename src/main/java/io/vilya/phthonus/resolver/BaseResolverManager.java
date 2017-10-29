package io.vilya.phthonus.resolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.vilya.common.rest.RestResponse;

/**
 * @author zhukuanxin
 * @param <T>
 * @time 2017年9月19日 下午4:53:20
 */
public class BaseResolverManager<T extends IResolver> implements IResolverManager<T> {

    private List<T> resolvers;
    
    public BaseResolverManager() {
        resolvers = new ArrayList<>();
    }
    
    @Override
    public void register(T resolver) {
        resolvers.add(resolver);
        Collections.sort(resolvers);
    }
    
    @Override
    public RestResponse resolve(Object object) {
        for (IResolver resolver : resolvers) {
            if (resolver.isSupport(object)) {
            	return resolver.resolve(object);
            }
        }
		return null;
    }

}
