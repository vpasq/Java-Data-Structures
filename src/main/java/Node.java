

public class Node<E> {
  // Invariant of the IntNode class:
  //   1. The node's element is stored in data.
  //   2. A reference to another node is stored in link.
  //      If there is only One node in the list, or if this is the last node
  //      in the list, or if this is an empty list, than link will have a
  //      null reference.
  private E data;
  private Node<E> link;

  /**
   * Initialize a node with specified initial data and a link to the next node.
   *
   * @param initialData the initial data of this node.
   * @param initialLink a reference to the node after this node. The reference may be
   *                    a null, which indicates that there is no node after this node.
   * @postcondition This new node contains the specified data and a link to the next
   * node.
   */
  public Node(E initialData, Node<E> initialLink) {
    data = initialData;
    link = initialLink;
  }

  /**
   * Accessor method to get the data from this node.
   *
   * @return the data from this node.
   */
  public E getData() {
    return data;
  }

  /**
   * Accessor method to get a reference to the next node after this link.
   *
   * @return a reference to node after this node (or the null reference if
   * there is nothing after this node.
   */
  public Node<E> getLink() {
    return link;
  }


  /**
   * Modification method that sets the data in this node.
   *
   * @param newData the new data to place in this node.
   * @postcondition The data in this node has been set to newData.
   */
  public void setData(E newData) {
    data = newData;
  }

  /**
   * Modification method that sets the reference to next node after this node.
   *
   * @param newLink a reference to the node after this node in the liked list
   *                (or the null reference if there is no node after this node).
   * @postcondition The link to the node after this node has been set to newLink.
   */
  public void setLink(Node<E> newLink) {
    link = newLink;
  }

  /**
   * Modidification method to add a new node after this node.
   *
   * @param element the data to be placed in the new node.
   * @postcondition A new node has been created and place after this
   *                this node. Any other elements that were after this
   *                node are now after the new node.
   */
  public void addNodeAfter(E element) {
    link = new Node<E>(element, link);
  }

  /**
   * Modification method to remove node after this node
   *
   * @precondition This node must not be the tail node of the list
   * @postcondition The node after this node has been removed from the list. If there
   *                were further nodes after that One, they are still present.
   */
  public void removeNodeAfter() {
    link = link.link;
  }

  /**
   * Compute the number of nodes in a link list
   *
   * @param head the head reference for a list link
   * @return the number of nodes in the list with the given head
   */
  public static <E> int listLength(Node<E> head) {
    Node<E> cursor;
    int answer = 0;
    for(cursor = head;  cursor != null; cursor = cursor.link )
      answer += 1;

    return answer;
  }

  /**
   * Search for a particular piece of data in a linked list
   *
   * @param head the head reference for a linked list
   * @param target the piece of data to be searched for.
   * @return the reference to the first node that contains the specified target.
   */
  public static <E> Node<E> listSearch(Node<E>  head, E target) {
    Node<E>  cursor;

    for(cursor = head; cursor != null; cursor = cursor.link) {
      if(target == cursor.getData())
        return cursor;
    }
    return null;
  }

  /**
   * Find a node at a specified position in a linked list.
   *
   * @param head the head reference for a linked list
   * @param position a node number
   * @return a reference to a node at the specified position in the list,
   *         return null if not found.
   * @throws IllegalArgumentException indicated that position is negative
   */
  public static <E> Node<E>  listPosition(Node<E>  head, int position) {
    if (position < 0)
      throw new IllegalArgumentException("position < 0 : Invoked from listPosition()");

    Node<E>  cursor = head;
    for (int i = 1; (i < position && cursor != null); i++) {
      cursor = cursor.link;
    }
    return cursor;
  }

  /**
   * Copy a list.
   *
   * @param source the head reference for a linked list that will be copied.
   * @return the head reference for the copy
   */
  public static <E> Node<E> listCopy(Node<E> source) {
    Node<E>  copyHead;
    Node<E>  copyTail;

    if(source == null)
      return null;

    copyHead = new Node<E>(source.data, null);
    copyTail = copyHead;

    while(source.link != null){
      source = source.link;
      copyTail.addNodeAfter(source.data);
      copyTail = copyTail.link;
    }

    return copyHead;
  }


  /**
   * Copy a list, returning both a head and tail reference.
   *
   * @param source the head reference for the list that will be copied.
   * @return copy of the linked list starting at source. The return value
   *         is an array where the [0] element is the head and the [1]
   *         element is the tail.
   */
  public static <E> Object[] listCopyWithTail(Node<E> source) {
    Node<E>  copyHead;
    Node<E>  copyTail;
    Object[] copyArray = new Object[2];

    if(source == null)
      return null;

    copyHead = new Node<E>(source.data, null);
    copyTail = copyHead;

    while(source.link != null){
      source = source.link;
      copyTail.addNodeAfter(source.data);
      copyTail = copyTail.link;
    }

    copyArray[0] = copyHead;
    copyArray[1] = copyTail;
    return copyArray;
  }

  /**
   * Copy part of a list, providing both a head and tail reference.
   *
   * @precondition start and end are non-null references to nodes on the same list,
   *               with the start node at or before the end node.
   * @param start reference to the start node to be copied
   * @param end reference to the end node to be copied
   * @return an array with element[0] is the head of the copy and
   *         element[1] is the tail of the copy.
   * @throws IllegalArgumentException indicates that start and end do not
   *           satisfy the prcodition.
   */
  public static <E> Object[] listPart(Node<E> start, Node<E>  end) {
    Node<E>  copyHead;
    Node<E>  copyTail;
    Object[] copyArray = new Object[2];

    if (start == null)
      throw new IllegalArgumentException("start is null : Invoked from listPart()");
    if (end == null)
      throw new IllegalArgumentException("end is null : Invoked from listPart()");

    copyHead = new Node<E> (start.data, null);
    copyTail = copyHead;

    while(start != end){
      start = start.link;
      if (start == null)
        throw new IllegalArgumentException("end node was not found on this list");
      copyTail.addNodeAfter(start.data);
      copyTail = copyTail.link;
    }

    copyArray[0] = copyHead;
    copyArray[1] = copyTail;
    return copyArray;
  }

  /**
   * Number of times that the specified number appears in the specified list.
   *
   * @param head the head reference of the list to search
   * @param target the specified number to locate
   * @return the number of times that the specified number appears in the list
   */
  public static <E> int countOccurrences(Node<E> head, E target) {
    int count = 0;
    Node<E>  cursor;

    cursor = listSearch(head, target);
    while (cursor != null) {
      cursor = cursor.link;
      cursor = listSearch(cursor, target);
      count++;
    }

    // another possible implementation
//    for (cursor = head; cursor != null; cursor = cursor.link) {
//      if (cursor.data == target) {
//        count += 1;
//      }
//    }

    // another possible implementation
//    for (cursor = head; cursor != null;  cursor = cursor.link) {
//      cursor = listSearch(cursor, target);
//      if(cursor != null) {
//        count += 1;
//      } else {
//        return count;
//      }
//    }

    // another possible implementation
//    while(head != null) {
//      head = listSearch(head, target);
//      if(head != null) {
//        head = head.link;
//        count += 1;
//      }
//    }
    return count;
  }

  //Todo: refactor this
  /**
   * Compares the data and link instance variables of this linked list starting from
   * this node to the end of the list, to the specified node reference.
   *
   * @param obj the node reference of the list that this node reference is compared to.
   * @return true if the nodes are equal, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {return true;}
    if (obj == null) {return false;}
    if (this.getClass() == obj.getClass()) {
      Node<E>  other = (Node<E> ) obj;
      Node<E>  thisNode = this;
      if(thisNode.data == other.data) {

        if(thisNode.link != null && other.link == null)
          return false;

        if (thisNode.link == null && other.link !=null)
          return false;


        while (thisNode.link != null) {
          thisNode = thisNode.link;
          other = other.link;
          if (thisNode.data != other.data)
            return false;
        }

        return true;
      }

    }
    return false;
  }


  public static void main(String[] args) {
    IntNode list = new IntNode(5, null);
    list.addNodeAfter(2);

    list = list.getLink();
  }



}