package oops.urlShortner;

public class Main {
    public static void main(String[] args) {
        // Create a simple in-memory URL database
        URLDatabase urlDatabase = new URLDatabase();
        
        // Create the URL shortener service
        URLShortenerService shortenerService = new URLShortenerService(urlDatabase);
        
        // Example long URLs to shorten
        String longUrl1 = "https://www.example.com/long-url-1";
        String longUrl2 = "https://www.example.com/long-url-2";
        
        // Shorten the URLs
        String shortUrl1 = shortenerService.shorten(longUrl1);
        String shortUrl2 = shortenerService.shorten(longUrl2);
        
        // Display the short URLs
        System.out.println("Short URL 1: " + shortUrl1);
        System.out.println("Short URL 2: " + shortUrl2);
        
        // Resolve short URLs to get the original long URLs
        String resolvedLongUrl1 = shortenerService.resolve(shortUrl1);
        String resolvedLongUrl2 = shortenerService.resolve(shortUrl2);
        
        // Display the resolved long URLs
        System.out.println("Resolved Long URL 1: " + resolvedLongUrl1);
        System.out.println("Resolved Long URL 2: " + resolvedLongUrl2);
    }
}
