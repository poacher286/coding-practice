package arryas;

import java.util.ArrayList;
import java.util.List;

/**
 * Along a long library corridor, there is a line of seats and decorative plants. You are given a 0-indexed string corridor of length n consisting of letters 'S' and 'P' where each 'S' represents a seat and each 'P' represents a plant.
 *
 * One room divider has already been installed to the left of index 0, and another to the right of index n - 1. Additional room dividers can be installed. For each position between indices i - 1 and i (1 <= i <= n - 1), at most one divider can be installed.
 *
 * Divide the corridor into non-overlapping sections, where each section has exactly two seats with any number of plants. There may be multiple ways to perform the division. Two ways are different if there is a position with a room divider installed in the first way but not in the second way.
 *
 * Return the number of ways to divide the corridor. Since the answer may be very large, return it modulo 109 + 7. If there is no way, return 0.
 *
 * Input: corridor = "SSPPSPS"
 * Output: 3
 */
public class NoOfWayToDivideLongCorridor {
    public static int numberOfWays(String corridor) {
        int M = 1000000007;
        List<Integer> seatIdx = new ArrayList<>();//idx of seats
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S'){
                seatIdx.add(i);
            }
        }

        if ((seatIdx.size() & 1) == 1 || seatIdx.size() == 0){
            return 0;
        }

        int endIdxPrev = seatIdx.get(1);
        long ans = 1;

        for (int i = 2; i < seatIdx.size(); i += 2) {
            int len = seatIdx.get(i) - endIdxPrev;
            ans = (ans * len) % M;
            endIdxPrev = seatIdx.get(i + 1);
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        String corridor = "PPPPPPPSPPPSPPPPSPPPSPPPPPSPPPSPPSPPSPPPPPSPSPPPPPSPPSPPPPPSPPSPPSPPPSPPPPSPPPPSPPPPPSPSPPPPSPSPPPSPPPPSPPPPPSPSPPSPPPPSPPSPPSPPSPPPSPPSPSPPSSSS";
        System.out.println(numberOfWays(corridor));
    }
}
