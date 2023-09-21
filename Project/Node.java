class Node<T extends Comparable<T>> // tells compiler our incoming T type implements Comparable

{
   T data;
   Node<T> next;

   Node()
  {
    this( null, null );
  }

   Node(T data)
  {
    this( data, null );
  }

  Node(T data, Node<T> next)
  {
    setData( data );
    setNext( next );
  }

   T getData()
  {
    return data;
  }

   Node<T> getNext()
  {
    return next;
  }

  void setData(T data)
  {
     this.data = data;
  }

   void setNext(Node<T> next)
  {
    this.next = next;
  }
  public String toString()
  {
	  return ""+getData();
  } 
	 
} //EOF