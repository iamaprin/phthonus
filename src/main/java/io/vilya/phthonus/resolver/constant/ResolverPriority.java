package io.vilya.phthonus.resolver.constant;

/**
 * @author zhukuanxin
 * @time 2017年9月19日 下午5:22:00
 */
public enum ResolverPriority {

    LOW(0),
    
    MIDDLE(5),
    
    HIGH(10);
    
    private int value;
    
    ResolverPriority(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
}
