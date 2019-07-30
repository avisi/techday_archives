package demo;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

public class Main {

    @SuppressWarnings("WhileLoopReplaceableByForEach")
    public static void main(String... arg) throws UnknownHostException {
        // set up mongo client.
        final MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost"));

        // get the db..
        final DB thingsDatabase = mongoClient.getDB("test");
        // get the 'things' collection..
        final DBCollection thingsCollection = thingsDatabase.getCollection("things");


    }
}
