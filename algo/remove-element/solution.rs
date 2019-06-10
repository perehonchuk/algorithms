impl Solution {
    pub fn remove_element(nums: &mut Vec<i32>, val: i32) -> i32 {
        let mut done = false;
        let mut i = 0;
        let mut j = nums.len();
        while !done && i < j {
            if nums[i] == val {
                match Solution::find_not(nums, val, i + 1, j) {
                    Some(k) => {
                        nums[i] = nums[k];
                        j = k;
                        i += 1;
                    }
                    None => done = true
                }
            } else {
                i += 1;    
            }
        }
        i as i32
    }

    fn find_not(nums: &Vec<i32>, val: i32, from: usize, to: usize) -> Option<usize> {
        for i in (from..to).rev() {
            if nums[i] != val {
                return Some(i);
            }
        }
        None
    }
}
