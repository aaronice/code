import java.util.HashMap;

/**
* Facilitates dispensing stamps for a postage stamp machine.
*/
public class StampDispenser
{
    private int[] stampDenominations;
    private HashMap<Integer, Integer> hashmap;

    /**
    * Constructs a new StampDispenser that will be able to dispense the given
    * types of stamps.
    *
    * @param stampDenominations The values of the types of stamps that the
    *     machine should have.  Should be sorted in descending order and
    *     contain at least a 1.
    */
    public StampDispenser(int[] stampDenominations)
    {
        this.stampDenominations = stampDenominations;
        this.hashmap = new HashMap<Integer, Integer>();
    }

    /**
    * Returns the minimum number of stamps that the machine can dispense to
    * fill the given request.
    *
    * @param request The total value of the stamps to be dispensed.
    */
    public int calcMinNumStampsToFillRequest(int request)
    {
        if (request <= 0) {
            return 0;
        } else if (request == 1) {
            return 1;
        } else {
            return calculateMin(request);
        }
    }

    private int calculateMin(int target) {
        int count = 0;
        int minCount = Integer.MAX_VALUE;

        if (this.hashmap.get(target) != null) {
            return this.hashmap.get(target);
        } else if (binarySearchStampDenomination(target)) {
            return 1;
        } else {
            for (int denomination : this.stampDenominations) {
                if (denomination > target) {
                    continue;
                }
                count = calculateMin(denomination) +
                calculateMin(target - denomination);
                minCount = Math.min(count, minCount);
            }

            this.hashmap.put(target, minCount);
            return minCount;
        }
    }

    private boolean binarySearchStampDenomination(int target) {
        int start = 0;
        int end = this.stampDenominations.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target <= this.stampDenominations[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (this.stampDenominations[start] == target) {
            return true;
        }
        if (this.stampDenominations[end] == target) {
            return true;
        }
        return false;
    }


    public static void main(String[] args)
    {
        int minNum;
        int input;
        int[] denominations;
        StampDispenser stampDispenser;

        System.out.println("Test Case 1: ");

        input = 18; // Test input number
        denominations = new int[] { 90, 30, 24, 10, 6, 2, 1 };
        stampDispenser = new StampDispenser(denominations);

        for (int d : denominations) {
            System.out.print(d + ", ");
        }
        System.out.println("input parameter: " + input);
        minNum = stampDispenser.calcMinNumStampsToFillRequest(input);
        System.out.println("minimum number of stamps: " + minNum);


        System.out.println("Test Case 2: ");

        input = 20;
        denominations = new int[]{17, 10, 5, 1};
        stampDispenser = new StampDispenser(denominations);

        for (int d : denominations) {
            System.out.print(d + ", ");
        }
        System.out.println("input parameter: " + input);
        minNum = stampDispenser.calcMinNumStampsToFillRequest(input);
        System.out.println("minimum number of stamps: " + minNum);
    }
}
