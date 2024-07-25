/*
given two arrays indicating prices for departure flight (D) and return flight (R):
D = [2000, 3000, 2500, 4000, 1000, 4000]
R = [2500, 2000, 3000, 1000, 2000, 3800]
find the cost of the cheapest round trip flight
constraints: the return flight must be at least 1 day after the departure flight
In the example, the cheapest flight would be $3000 ($2000 departure, $1000 return (D[0] and R[3])



// keep track of min from right to left in the R array
R = [1000,1000,1000,1000,2000,3800]

*/ 

import java.util.*;

class FlightsCost {

    public static void main(String args[]) {
        int d[] = {2000, 3000, 2500, 4000, 1000, 4000};
        int r[] = {2500, 2000, 3000, 1000, 2000, 3800};
        System.out.println("Min cost = " + getMinCost(d,r));
    }

    private static int getMinCost(int d[], int r[]) {
        int rmin[] = new int[r.length];
        rmin[r.length-1] = r[r.length-1];
        for(int i=r.length-2; i>=0; i--) {
            rmin[i] = Math.min(r[i], r[i+1]);
        }
        int mincost = Integer.MAX_VALUE;
        for(int i=0; i<d.length; i++) {
            mincost = Math.min(mincost, d[i]+rmin[i]);
        }
        return mincost;
    }


}