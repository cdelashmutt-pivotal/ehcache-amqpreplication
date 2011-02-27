package net.sf.ehcache.amqp;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.distribution.CacheManagerPeerProvider;
import net.sf.ehcache.distribution.CachePeer;
import net.sf.ehcache.distribution.CacheReplicator;
import net.sf.ehcache.distribution.EventMessage;

public class AMQCacheReplicator implements CacheReplicator {
	private final CachePeerLookup cachePeerLookup;
	public AMQCacheReplicator(CachePeerLookup cachePeerLookup){
		this.cachePeerLookup = cachePeerLookup;
	}
	public void notifyElementRemoved(Ehcache cache, Element element)
			throws CacheException {
		AMQEventMessage message = new AMQEventMessage(EventMessage.REMOVE,
				element.getKey(), element, cache.getName());
		sendMessage(cache, message);
	}

	public void notifyElementPut(final Ehcache cache, Element element)
			throws CacheException {
		AMQEventMessage message = new AMQEventMessage(EventMessage.PUT,
				element.getKey(), element, cache.getName());
		sendMessage(cache, message);

	}

	private void sendMessage(final Ehcache cache, AMQEventMessage message) {
		for (CachePeer peer : listRemoteCachePeers(cache)) {
			try {
				peer.send(Arrays.asList(message));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	protected List<CachePeer> listRemoteCachePeers(Ehcache cache) {
		return cachePeerLookup.listRemoteCachePeers(cache);
	}

	public void notifyElementUpdated(Ehcache cache, Element element)
			throws CacheException {
//		throw new CacheException("not yet implemented");
	}

	public void notifyElementExpired(Ehcache cache, Element element) {
		// TODO Auto-generated method stub

	}

	public void notifyElementEvicted(Ehcache cache, Element element) {
		// TODO Auto-generated method stub

	}

	public void notifyRemoveAll(Ehcache cache) {
		AMQEventMessage message = new AMQEventMessage(EventMessage.REMOVE_ALL,
				null, null, cache.getName());
		sendMessage(cache, message);
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public boolean isReplicateUpdatesViaCopy() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean notAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean alive() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return this;
	}

}
