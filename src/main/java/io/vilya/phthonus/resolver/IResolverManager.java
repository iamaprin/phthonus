package io.vilya.phthonus.resolver;

import io.vilya.common.rest.RestResponse;

/**
 * @author zhukuanxin
 * @time 2017年9月19日 下午4:48:09
 */
public interface IResolverManager<T extends IResolver> {

    void register(T resolver);
    
    RestResponse resolve(Object object);
    
}
