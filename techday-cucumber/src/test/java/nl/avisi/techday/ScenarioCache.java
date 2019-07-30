package nl.avisi.techday;

import cucumber.api.java.Before;

import java.util.HashMap;
import java.util.Map;

public class ScenarioCache {

    private Map<String, Object> cache = new HashMap<String, Object>();

    public void add(String key, Object value) {
        cache.put(key, value);
    }

    public <T> T get(String key) {
        return (T) cache.get(key);
    }

    @Before
    public void clearCache() {
        cache.clear();
    }

}
