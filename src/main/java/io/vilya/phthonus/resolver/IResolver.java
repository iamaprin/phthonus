package io.vilya.phthonus.resolver;

import io.vilya.common.rest.RestResponse;
import io.vilya.phthonus.resolver.constant.ResolverPriority;

/**
 * @author zhukuanxin
 * @time 2017年8月31日 上午11:57:43
 */
public interface IResolver extends Comparable<IResolver> {
    
    boolean isSupport(Object object);
    
    RestResponse resolve(Object object);
    
    ResolverPriority getPriority();
    
}
