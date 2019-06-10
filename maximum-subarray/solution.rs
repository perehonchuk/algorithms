impl Solution {
    pub fn max_sub_array(mut nums: Vec<i32>) -> i32 {
        if nums.len() == 0 {
            return 0;
        }
        let mut max = nums[0];
        for i in (1..nums.len()) {
            nums[i] = if nums[i - 1] + nums[i] > nums[i] {
                nums[i - 1] + nums[i]
            } else {
                nums[i]
            };
            max = if max < nums[i] {
                nums[i]
            } else {
                max
            };
        }
        max
    }
}
