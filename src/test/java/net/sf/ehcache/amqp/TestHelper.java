package net.sf.ehcache.amqp;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;

/**
 * For now... need to fix mvn test runner ASAP.
 * @author jamescarr
 *
 */
public abstract class TestHelper {
	public static final String SIMPLE_CACHE  = "cacheA";
	public static CacheManager inMemoryCacheManager() {
		Configuration configuration = new Configuration();
		CacheConfiguration cacheConfiguration = new CacheConfiguration();
		cacheConfiguration.setName(SIMPLE_CACHE);
		cacheConfiguration.setMaxElementsInMemory(100);
		configuration.addCache(cacheConfiguration);
		CacheConfiguration defaultConfiguration = new CacheConfiguration();
		defaultConfiguration.setMaxElementsInMemory(100);
		configuration.addDefaultCache(defaultConfiguration);
		return new CacheManager(configuration);
	}
}
