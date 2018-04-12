/**
 *  Copyright 2011 James Carr
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package net.sf.ehcache.amqp;

import java.util.Collection;
import java.util.Map;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Status;
import net.sf.ehcache.loader.CacheLoader;

/**
 * A cache loader to retrieve entries from an existing peer
 *
 * @author <a href="mailto:james.r.carr@gmail.com">James R. Carr</a>
 */
public class AMQCacheLoader implements CacheLoader {

	public AMQCacheLoader() {
	}

	public Object load(Object key) throws CacheException {
		return load(key, null);
	}

	public Map loadAll(Collection keys) {
		return loadAll(keys, null);
	}

	public Object load(Object key, Object argument) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map loadAll(Collection keys, Object argument) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
