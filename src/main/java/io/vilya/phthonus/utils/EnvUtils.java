package io.vilya.phthonus.utils;

/**
 * @author zhukuanxin
 * @time 2017年3月6日 下午4:25:23
 */
public abstract class EnvUtils {
	
	private static final String CFG_BASE_LINUX = "/icooper/config";
	private static final String CFG_BASE_WINDOWS = System.getProperty("user.home") + "\\scooper";
	
	private EnvUtils() {}
	
	public static String getCfgBase() {
		return isWindows() ? CFG_BASE_WINDOWS : CFG_BASE_LINUX;
	}
	
	private static boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().contains("windows");
	}
	
	
	
}
