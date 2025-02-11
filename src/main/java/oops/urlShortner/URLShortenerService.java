package oops.urlShortner;

import java.util.Random;

public class URLShortenerService {
    private URLDatabase database;
    private static final String BASE_URL = "https://short.ly/";

    // Constructor
    public URLShortenerService(URLDatabase database) {
        this.database = database;
    }

    // Generate a unique short URL for the given long URL
    public String shorten(String longUrl) {
        String shortUrl = generateShortUrl();
        while (database.exists(shortUrl)) {
            shortUrl = generateShortUrl(); // Ensure uniqueness
        }
        database.save(shortUrl, longUrl);
        return BASE_URL + shortUrl;
    }

    // Retrieve the long URL based on the short URL
    public String resolve(String shortUrl) {
        String shortKey = shortUrl.replace(BASE_URL, "");
        return database.getLongUrl(shortKey);
    }

    // Generate a random 6-character string for the short URL
    private String generateShortUrl() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder shortUrl = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            shortUrl.append(characters.charAt(random.nextInt(characters.length())));
        }
        return shortUrl.toString();
    }
}
