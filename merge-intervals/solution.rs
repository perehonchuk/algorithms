use std::cmp;
impl Solution {
    pub fn merge(mut intervals: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        intervals.sort_by(|a, b| if a[0] == b[0] {
            a[1].cmp(&b[1])
        } else {
            a[0].cmp(&b[0])
        });
        let mut i = 0;
        let mut j = 1;
        while j < intervals.len() {
            if intervals[i][1] >= intervals[j][0] {
                intervals[i][1] = cmp::max(intervals[i][1], intervals[j][1]);
            } else {
                i += 1;
                intervals[i][0] = intervals[j][0];
                intervals[i][1] = intervals[j][1];
            }
            j += 1;
        }
        intervals.truncate(i+1);
        intervals
    }
}
