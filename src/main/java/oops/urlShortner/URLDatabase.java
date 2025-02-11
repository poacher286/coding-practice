package oops.urlShortner;

import java.util.HashMap;
import java.util.Map;

public class URLDatabase {
    private Map<String, String> urlMapping;

    public URLDatabase() {
        this.urlMapping = new HashMap<>();
    }

    // Store the mapping of short URL to long URL
    public void save(String shortUrl, String longUrl) {
        urlMapping.put(shortUrl, longUrl);
    }

    // Retrieve the long URL based on short URL
    public String getLongUrl(String shortUrl) {
        return urlMapping.get(shortUrl);
    }

    // Check if the short URL exists
    public boolean exists(String shortUrl) {
        return urlMapping.containsKey(shortUrl);
    }
}
