package com.interviewPrep.leetcode.easy.majorityelement;

import java.util.HashMap;
import java.util.Map;

public class FirstApproach {

	public static void main(String[] args) {
		
		// int[] nums = {2,2,1,1,1,2,2};
		//int[] nums = {3,2,3};
		int[] nums = {-1,1,1,1,2,1};
		
		FirstApproach fa = new FirstApproach();
		int majElem = fa.majorityElement(nums);
		
		System.out.println(majElem);
	}
	
	public int majorityElement(int[] nums) {
        
		int majElem = nums[0];
		
		// compute the target count that we need to check
		double targetCount = (double)nums.length / 2;
		targetCount = Math.ceil(targetCount);
		
		// initialize a Hashmap - this will store integer and its count
		Map<Integer, Integer> numsCountMap = new HashMap<>();
		
		// Push given integers in it
		for(int i=0; i<nums.length; i++) {

			// if integer is pushed first time then keep value as 1
			if(!numsCountMap.containsKey(nums[i])) {

				numsCountMap.put(nums[i], 1);
			}
			// if integer already present then re-push after count increment
			else if(numsCountMap.containsKey(nums[i])) {
				
				int count = numsCountMap.get(nums[i]);
				count = count+1;
				numsCountMap.put(nums[i], count);
				
				// as soon as an integer with target count is encountered, return with the integer
				if(numsCountMap.get(nums[i]) >= targetCount) {
					
					return nums[i];
				}
			}

		}	
		
		return majElem;
    }
	
}
