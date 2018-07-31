package GeneralTree;

public class Node {
   private Object data;    
   private Node nextNode;
   private Node previousNode;

   public Node( Object element ) { 
      this( element, null ); 
   }

   public Node( Object element, Node node ) {
      data = element;    
      nextNode = node;  
   }

   public Object getData()  { return data; }
   
   public void setData (Object element){
       data = element;
   }

   public Node getNext() { return nextNode; }
   
   public void setNext(Node n) { 
      nextNode = n; 
   }

   public Node getPrevious() { return previousNode; }
   
   public void setPrevious(Node n) { 
      previousNode = n; 
   }
} 
