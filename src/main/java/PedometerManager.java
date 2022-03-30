import java.util.HashMap;
import java.util.Map;

public class PedometerManager implements Comparable<PedometerManager>{
    private Map<Integer, Integer> data = new HashMap<>();
    private int max = 0;

    public int add(int day, int steps){
        if(day <= 0 || steps < 0){
            return max = -1;
        } else {
            int newValue = data.getOrDefault(day, 0) + steps;
            data.put(day, newValue);
                if (max < newValue) {
                    max = newValue;
                }
            return max + 1 - steps;
        }
    }

    public int sum(){
        int sum = 0;
        for (int steps : data.keySet()){
            sum += data.get(steps);
        }
        return sum;
    }

    public int dayUpperLimit(int minSteps){
        int response = 0;
        for (int steps : data.values()){
            if (steps > minSteps){
                response++;
            }
        }
        return response;
    }

    @Override
    public int compareTo(PedometerManager pedometerManager) {
        return sum() - pedometerManager.sum();
    }
}
