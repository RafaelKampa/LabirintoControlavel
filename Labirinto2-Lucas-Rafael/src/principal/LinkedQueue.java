package principal;

public class LinkedQueue {
    public Node base;
    public Node top;

    public void add(int element){
        Node newElement = new Node();
        newElement.data = element;
        if(this.base == null){
            this.base = newElement;
        }
        this.top = newElement;
        this.top.next = newElement;
    }
    
    public int remove(){
        this.base = this.base.next;
        return this.base.data;
    }
    
    public void clear(){
        this.top = null;
        this.base=null;
    }
    
    public boolean isEmpty(){
        //return this.base == null && this.top == null ? true : false;
        if(this.top == null && this.base == null){
            return true;
        }
        return false;
    }
    
    public boolean isFull(){
        return false;
    }
}
