// import java.util.*;
//singly linkedlist
public class linkedlist {
    private Node head;

    private Node tail;//if i dont take this then i hv to inster element in O(n) time and nwith tail i insert in O(1) time


    private int size;

    public linkedlist(){
        this.size=0;
    }
    private class Node{

        private int val;

        private Node next;

        public Node(int val){

            this.val=val;
        }

        public Node(int val,Node next){
            this.val=val;
            this.next=next;
            }
        
    }
    //Insertion
    public void InsertAtFirst(int val){
        Node NN=new Node(val);
        NN.next=head;
        head=NN;
        if(tail==null){
            tail=head;
        }
        size+=1;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("END");
    }
    public void insterAtLast(int val){
        if(tail==null){
            InsertAtFirst(val);
            return;
        }
        Node NN=new Node(val);
        tail.next=NN;
        tail=NN;
        size+=1;
    }
    public void insertAtIndex(int val,int index){
        if (index == 0) {
            InsertAtFirst(val);
            return;
        }
        if (index == size) {
            insterAtLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }

    //Deletion
    public int DeletetAtFirst(){
        int val=head.val;
        head=head.next;
        if(head==null) tail=null;
        size--;
        return val;

    }

    public Node get(int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }

    public int DeletetAtLast(){
        if(size<=1){
             return DeletetAtFirst();
           
        }
        Node SecondLastNode=get(size-2);
        int val=tail.val;
        tail=SecondLastNode;
        tail.next=null;
        return val;

    }
     public int DeletetAtIndex(int index){
        if(index==0) return DeletetAtFirst();

        if(index==size-1) return DeletetAtLast();

        Node prev=get(index-1);
        int val=prev.next.val;
        prev.next=prev.next.next;
        return val;
     }

     public Node findNode(int value){
        Node temp=head;
        while(temp!=null){
            if(temp.val==value){
                return temp;
            }
            temp=temp.next;
        }
        return null;
     }
    
}