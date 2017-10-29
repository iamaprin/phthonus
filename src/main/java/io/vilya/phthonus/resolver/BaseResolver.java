package io.vilya.phthonus.resolver;

import io.vilya.phthonus.resolver.constant.ResolverPriority;

/**
 * @author zhukuanxin
 * @time 2017年8月31日 上午11:59:25
 */
public abstract class BaseResolver implements IResolver {
    
    @Override
    public int compareTo(IResolver o) {
        ResolverPriority tp = getPriority() == null ? ResolverPriority.LOW : getPriority();
        ResolverPriority op = o.getPriority() == null ? ResolverPriority.LOW : o.getPriority();        
        return op.getValue() - tp.getValue();
    }
    
}
