func twoSum(array []int, target int) []int {
    start:= 0;
	end := len(array)-1

	for start < end {
		sum := array[start] + array[end]
		if(sum < target){
			start++
		}
		if(sum > target){
			end--
		}
		if(sum == target){
			return []int{start +1, end+1}
		}
	}
	return []int{}
}