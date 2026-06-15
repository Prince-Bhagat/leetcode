func twoSum(array []int, target int) []int {
    dictionary := make(map[int]int)

	for i := 0; i < len(array); i++ {
		needed := target - array[i]
		value, isExist := dictionary[array[i]]
		if isExist {
			return []int{value, i}
		} else {
			dictionary[needed] = i
		}
	}
	return []int{}
}