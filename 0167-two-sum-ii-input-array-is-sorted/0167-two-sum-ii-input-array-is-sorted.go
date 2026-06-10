func twoSum(array []int, target int) []int {
    result := make([]int, 2)

	for i := 0; i< len(array);i++{
		for j:= i+1;j < len(array);j++{
			sum := array[i] + array[j]
			if(sum == target){
				return []int{i+1,j+1}
			}
		}
	}
	return result
}