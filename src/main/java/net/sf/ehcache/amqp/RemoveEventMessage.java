package net.sf.ehcache.amqp;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.distribution.EventMessage;

/**
 * Description Here.
 *
 * @author <a href="mailto:james.r.carr@gmail.com">James R. Carr</a>
 */
public class RemoveEventMessage extends AMQEventMessage {
	private static final long serialVersionUID = 1L;
	public RemoveEventMessage(Element element, Ehcache cache){
		super(EventMessage.REMOVE , element.getKey(), element, cache.getName(), cache.getGuid());
	}
}
