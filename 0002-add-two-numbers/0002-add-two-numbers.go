/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func NewListNode(val int) *ListNode{
	node := new(ListNode)
	node.Val = val
	return node
}
func addNumber(root1 *ListNode, root2 *ListNode, carry int, )(*ListNode, int){
	

	var newRoot *ListNode
	if root1 != nil || root2 != nil || carry != 0{

		sum := 0
		var next1 *ListNode
		var next2 *ListNode

		if root1 != nil{
			sum += root1.Val
			next1 = root1.Next
		}
		if root2 != nil {
			sum += root2.Val
			next2 = root2.Next
		}
		sum += carry

		carryforward := sum/10
		remainder := sum%10

		newRoot = NewListNode(remainder)
		newRoot.Next, carryforward = addNumber(next1, next2, carryforward)
		return newRoot, carryforward

	}
	return nil, 0

}
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    result, _ := addNumber(l1, l2, 0)
    return result
}