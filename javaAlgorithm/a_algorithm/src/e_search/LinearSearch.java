package e_search;

public class LinearSearch {
    public static void main(String[] args) {
        
        int target = 999;
        int[] nums = {1,2,5,3,7,88,999,22,14,6,19};

        // int index = linearSearch(nums, target);
        int index = sentinelSearch(nums, target); // 보초법
        System.out.println(index);
    }

    private static int sentinelSearch(int[] nums, int target) {
        int lastIndex = nums.length - 1;
        if (nums[lastIndex] == target){
            return lastIndex;
        }
        nums[lastIndex] = target;
        int i = 0;
        while(true){
            // if문은 한 번만 사용할 수 있음
            if (target == nums[i]){
                return i < lastIndex ? i : -1;
            }
        }
    }

    private static int linearSearch(int[] nums, int target) {
        int i = 0;
        while (true){
            if (i == nums.length){
                return -1;
            }
            if (nums[i] == target){
                return i;
            }
            i++;
        }
    }
}
