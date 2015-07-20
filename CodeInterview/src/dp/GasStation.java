package dp;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel 
 * from station i to its next station (i+1). You begin the journey with an empty tank 
 * at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, 
 * otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 *
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, total = 0, station = 0;
        for (int i = 0; i < gas.length; i++) {
            int delta = gas[i] - cost[i];
            sum += delta;
            total += delta;
            if (sum < 0) {
                station = i + 1;
                sum = 0;
            }
        }
        return total < 0 ? -1 : station;
    }
}
