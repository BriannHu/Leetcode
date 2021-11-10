// MEDIUM - https://leetcode.com/problems/sum-of-two-integers/

public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        int carry = a & b;
        int result = a ^ b;

        while (carry != 0) {
            int shift_carry = carry << 1;
            carry = result & shift_carry;
            result ^= shift_carry;
        }
        return result;
    }

}
