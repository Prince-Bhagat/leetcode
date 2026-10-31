
type MinStack struct {
    minNode *Node
    head *Node
}


func Constructor() MinStack {
    return MinStack{}
}


func (this *MinStack) Push(value int)  {
        if this.head == nil{
            this.head = &Node{
                value : value,
            }
            this.minNode = this.head
        }else{
            newNode := &Node{
                nextNode : this.head,
                value : value,
            }
            this.head.prevNode = newNode
            this.head = newNode

            if this.minNode == nil{
                this.minNode = newNode
            } else if newNode.value < this.minNode.value { 
                newNode.oldMinNode = this.minNode
                this.minNode = newNode
            } 
        }
}


func (this *MinStack) Pop()  {

    if (this.head == nil){
        return
    }
    if (this.minNode == nil){
        return
    }

    newHead := this.head.nextNode

    if ( this.head == this.minNode ){
        this.minNode = this.minNode.oldMinNode
    }
    this.head = newHead

}


func (this *MinStack) Top() int {

     temp := this.head

    for temp != nil{
        temp = temp.nextNode
    }
    if(this.head !=nil){
        return this.head.value
    }else{
        return -100
    }
    
}


func (this *MinStack) GetMin() int {

    if (this.minNode != nil){
        return this.minNode.value
    }else{
        return -100
    }
    
}


/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(value);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */

 type Node struct{
    prevNode *Node
    nextNode *Node
    oldMinNode *Node
    value int
 }
