package leetcode;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost){
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0){
            return -1;
        }
        
        int tank = 0; // left fuel in the tank
        int index = 0;
        int total = 0; // total = all gas - all cost
        
        for (int i = 0; i < gas.length; i++){
            tank += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (tank < 0){
                index = i+1;
                tank = 0;
            }
        }
        return total < 0 ? -1 : index;
	}
}
