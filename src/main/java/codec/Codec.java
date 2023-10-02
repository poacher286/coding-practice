package codec;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Codec {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        return new String(Base64.getEncoder().encode(longUrl.getBytes(StandardCharsets.UTF_8)));
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return new String(Base64.getDecoder().decode(shortUrl));
    }

    public static void main(String[] args) {

    }
}