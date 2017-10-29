package io.vilya.phthonus.config.listener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import io.vilya.phthonus.utils.EnvUtils;

/**
 * @author iamaprin
 * @time 2017年10月12日 上午12:00:27
 */
public class CustomServletContextListener implements ServletContextListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomServletContextListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ServletContext context = sce.getServletContext();
			initConfig(context);
		} catch (Exception e) {
			LOGGER.error(StringUtils.EMPTY, e);
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// nothing
	}
	
	private void initConfig(ServletContext context) throws IOException {
		Resource resource = new ClassPathResource("conf/app.properties");
		Properties properties = new Properties();
		properties.load(resource.getInputStream());
		
		// These configs are in default.properties, may not be null.
		String projectName = properties.getProperty("project.name");
		String configs = properties.getProperty("project.configs");
		// If config home do not exist, it will be created.
		File configHome = new File(EnvUtils.getCfgBase(), projectName);
		if (!configHome.exists()) {
			LOGGER.info("Config home[{}] do not exist, it will be created.", configHome);
			configHome.mkdirs();
		}
		
		for (String configName : configs.split(",")) {
			File dest = new File(configHome, configName);
			if (dest.exists()) {
				continue;
			}
			
			Resource src = new ClassPathResource("conf_template/" + configName);
			if (!src.exists()) {
				LOGGER.error("Config file[{}] do not exist.", configName);
				throw new FileNotFoundException("Config file[" + configName + "] do not exist.");
			}
			
			if (!src.isReadable()) {
				LOGGER.error("Config file[{}] is not readable.", configName);
				throw new IOException("Config file[" + configName + "] is not readable.");
			}
			
			LOGGER.info("Copy file[{}] to {}.", configName, configHome);
			FileUtils.copyFile(src.getFile(), dest);
		}
		
		System.setProperty("config.home", configHome.getPath());
		System.setProperty("project.configs", configs);
	}

}
