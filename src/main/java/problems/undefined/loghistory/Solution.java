package problems.undefined.loghistory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
    static int check_log_history(List<String> events) {

        Set<Integer> acquiredLocks = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < events.size(); i++) {

            String[] event = events.get(i).split("");

            String eventName = event[0];
            int eventNumber = (Integer.parseInt(event[1]));

            if ("ACQUIRE".equals(eventName)) {

                if (acquiredLocks.contains(eventNumber)) return i + 1;

                stack.push(eventNumber);
                acquiredLocks.add(eventNumber);

            } else {
                //Release
                if (!acquiredLocks.contains(eventNumber) || stack.peek() != eventNumber) return i + 1;
                stack.pop();
                acquiredLocks.remove(eventNumber);
            }
        }
        return stack.empty() ? 0 : events.size() + 1;
    }
}
