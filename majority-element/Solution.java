class Solution {
    public int majorityElement(int[] nums) {
        Integer major = null;
        int count = 0;
        for (Integer num: nums) {
            if (count == 0) {
                major = num;
            }
            if (major.equals(num)) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
