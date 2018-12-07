package org.scriptonbasestar.tool.logging;

import com.mongodb.*;
import lombok.Getter;
import lombok.Setter;

public class MongoDBConnectionSource {

	private volatile DBCollection dbCollection = null;

	@Setter
	private String uri = null;

	@Setter
	private String dbName = null;

	@Setter
	private String collection = null;

	@Getter
	@Setter
	private String hostname = null;

	protected DBCollection getDBCollection() {
		DBCollection dbCollectionHelper = dbCollection;
		if (dbCollectionHelper == null) {
			synchronized (this) {
				dbCollectionHelper = dbCollection;
				if (dbCollectionHelper == null) {
					try {
						final Mongo mongo = new MongoClient(new MongoClientURI(uri));
						dbCollection = mongo.getDB(dbName)
											.getCollection(collection);
						Runtime.getRuntime().addShutdownHook(
							new Thread(new Runnable() {

								@Override
								public void run() {
									mongo.close();
								}
							}, "mongo shutdown"));
					} catch (MongoException mongoException) {
						mongoException.printStackTrace();
					}
//					catch (UnknownHostException unknownHostException) {
//						unknownHostException.printStackTrace();
//					}
				}
			}
		}
		return dbCollection;
	}

}
