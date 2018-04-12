package net.sf.ehcache.amqp;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.distribution.EventMessage;

/**
 * Description Here.
 * 
 * @author <a href="mailto:james.r.carr@gmail.com">James R. Carr</a>
 */
public class RemoveAllEventMessage extends AMQEventMessage {

	public RemoveAllEventMessage(Ehcache cache) {
		super(EventMessage.REMOVE_ALL, null, null, cache.getName(), cache.getGuid());
	}

}
