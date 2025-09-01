package e_search;

// 정렬된 자료구조를 대상으로만 사용할 수 있음
public class BinarySearch {
    public static void main(String[] args) {
        int target = 9999;
        int[] nums = {1, 3, 5, 10, 113, 5645, target, 23413, 3333333, 5555555};

        int index = binarySearch(nums, target);
        System.out.println(index);
    }

    private static int binarySearch(int[] nums, int target) {
        int lp = 0;
        int rp = nums.length - 1;
        
        while (lp <= rp){
            int center = (lp + rp) /2;
            if (target < nums[center]){
                rp = center-1;
            }
            else if (target == nums[center]){
                return center;
            } else {
                lp = center + 1;
            }
        }
        return -1;
    }
}
