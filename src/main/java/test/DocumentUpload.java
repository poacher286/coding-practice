package test;

import java.util.List;

public class DocumentUpload {

    public static int minimumChunksRequired(long totalPackets, List<List<Long>> uploadedChunks) {
        // Extract the single uploaded range
        List<Long> uploadedRange = uploadedChunks.get(0);
        long uploadedStart = uploadedRange.get(0);
        long uploadedEnd = uploadedRange.get(1);

        int chunksRequired = 0;

        // Calculate missing ranges before and after the uploaded range
        if (uploadedStart > 1) {
            chunksRequired += calculateChunks(1, uploadedStart - 1);
        }
        if (uploadedEnd < totalPackets) {
            chunksRequired += calculateChunks(uploadedEnd + 1, totalPackets);
        }

        return chunksRequired;
    }

    private static int calculateChunks(long start, long end) {
        int chunks = 0;
        while (start <= end) {
            long largestPowerOfTwo = largestPowerOfTwoInRange(start, end);
            start += largestPowerOfTwo;
            chunks++;
        }
        return chunks;
    }

    private static long largestPowerOfTwoInRange(long start, long end) {
        long largestPowerOfTwo = 1;
        while (largestPowerOfTwo <= (end - start + 1) / 2) {
            largestPowerOfTwo *= 2;
        }
        return largestPowerOfTwo;
    }

    public static void main(String[] args) {
        // Example usage
        List<List<Long>> uploadedChunks = List.of(
            List.of(1L, 3L)  // Example: chunk 1-3 is already uploaded
        );
        long totalPackets = 16;
        
        System.out.println(minimumChunksRequired(totalPackets, uploadedChunks));  // Example output
    }
}
