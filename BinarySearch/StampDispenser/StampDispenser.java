/**
 * Facilitates dispensing stamps for a postage stamp machine.
 */
public class StampDispenser
{
    private int[] stampDenominations;
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
        }

        int count = 0;
        int remain = request;
        while (true) {
            int reduce = this.findClosestSmallerStampDenomination(remain);
            remain = remain - reduce;
            count++;
            System.out.println("subtract: " + reduce + ", remain: " + remain);

            if (remain == 0) {
                break;
            }
        }
        return count;
    }

    private int findClosestSmallerStampDenomination(int target) {
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
            return this.stampDenominations[start];
        } else if (this.stampDenominations[end] == target) {
            return this.stampDenominations[end];
        } else {
            if (this.stampDenominations[start] < target) {
                return this.stampDenominations[start];
            }
            if (this.stampDenominations[end] < target) {
                return this.stampDenominations[end];
            }
        }
        return 0;
    }

    public static void main(String[] args)
    {
        int[] denominations = { 90, 30, 24, 10, 6, 2, 1 };
        StampDispenser stampDispenser = new StampDispenser(denominations);
        assert stampDispenser.calcMinNumStampsToFillRequest(18) == 3;

        int input = 18; // Default input number

        if (args != null && args.length > 0) {
            input = Integer.parseInt(args[0]);
        }

        System.out.println("input parameter: " + input);
        int minNum = stampDispenser.calcMinNumStampsToFillRequest(input);
        System.out.println("minimum number of stamps: " + minNum);
    }
}
