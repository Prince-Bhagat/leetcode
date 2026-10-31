
type MinStack struct {
    minNode *Node
    head *Node
}


func Constructor() MinStack {
    return MinStack{}
}


func (this *MinStack) Push(value int)  {
    // fmt.Println("\nPUSH", value)
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
    // fmt.Printf("\nCurrent Min Node :%d", this.minNode.value)
    // this.print()


}


func (this *MinStack) Pop()  {
    // fmt.Println("\nPOP")
    if (this.head == nil){
        // fmt.Println("No Element in stack")
        return
    }
    if (this.minNode == nil){
        // fmt.Println("No minimum Element")
        return
    }

    newHead := this.head.nextNode

    if ( this.head == this.minNode ){
        this.minNode = this.minNode.oldMinNode
    }
    this.head = newHead
    // this.head.prevNode = nil

    // this.print()
    // this.printMin()
}

func (this * MinStack ) printMin(){
    temp := this.minNode
    fmt.Printf("\nMIN STACK : ")
    for temp != nil{
        fmt.Printf("%d -> ", temp.value)
        temp = temp.oldMinNode
    }
    fmt.Printf("\n")

}
func (this *MinStack) Top() int {
    // fmt.Println("\nTOP")
     temp := this.head
    // fmt.Printf("\nSTACK : ")
    for temp != nil{
        // fmt.Printf("%d -> ", temp.value)
        temp = temp.nextNode
    }
    if(this.head !=nil){
        return this.head.value
    }else{
        return -100
    }
    
}

func(this *MinStack) print(){
    temp := this.head
    fmt.Printf("\nSTACK : ")
    for temp != nil{
        fmt.Printf("%d -> ", temp.value)
        temp = temp.nextNode
    }
    fmt.Printf("\n========================\n")
}
func (this *MinStack) GetMin() int {
    // fmt.Println("\nGET MIN")
    
    if (this.minNode != nil){
        // fmt.Printf("%d", this.minNode.value)
        return this.minNode.value
    }else{
        // fmt.Printf("\n MINIMUM is EMPty")
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
