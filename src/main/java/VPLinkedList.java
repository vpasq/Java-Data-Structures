

/**
 * VPLinkedList implements a list of elements arranged in some order.
 */
public class VPLinkedList {
  // Invariant of the VPLinkedList class:
  //   1. The first node of the list is stored in head. If this is an
  //      empty list, than head will have a null reference.
  //   2. The last node of the list is stored in tail. If this is an
  //      empty list, than tail and head will be equal.
  private IntNode head;
  private IntNode tail;

  /**
   * Initialize an empty linked list
   *
   * @postcondition Head and tail are both set to the Java default value null.
   */
  public VPLinkedList() {
  }

  /**
   * Initialize a linked list with the specified initialData and initialLink
   *
   * @param initialData the initial data that is stored in the head node.
   * @param initialLink the initial link that is stored in the head node
   *                    (this can be null).
   * @postcondition The initialData and initialLink have been set for the
   * head node. And since there is currently only One node,
   * The tail node is set equal to null.
   */
  public VPLinkedList(int initialData, IntNode initialLink) {
    head = new IntNode(initialData, initialLink);
    tail = head;
  }

  /**
   * Set the first node in this list to the specified data.
   *
   * @param initialData the data for the first node in this list.
   * @postcondition The data for the first node in this list is set to initialData.
   * The link reference for this first node is set to head.
   */
  public void addFirstNode(int initialData) {
    head = new IntNode(initialData, head);
    tail = head;
  }

  /**
   * Accessor method to get the head node from this list.
   *
   * @return the head node from this list.
   */
  public IntNode getHead() {
    return head;
  }

  /**
   * Accessor method to get the tail node from this list.
   *
   * @return the tail node from this list.
   */
  public IntNode getTail() {
    return tail;
  }

  /**
   * Modification method that adds a new head node in this list.
   *
   * @param newData the new data for this head's node.
   * @postcondition The data for this new head node has been set to newData,
   * and the link reference for this new head node has been set
   * to the same node that head refers to.
   */
  public void setNewHead(int newData) {
    head = new IntNode(newData, head);
  }

  /**
   * Modification method that removes the head from this list.
   *
   * @postcondition The head node is removed from the list. If there is only
   * One node in the list, the tail node is set equal to null
   * as well.
   */
  public void removeHead() {
    if (tail == head)
      tail = null;
    head = head.getLink();
  }

  /**
   * Modification method to add a new node after this node.
   *
   * @param element the data to be placed in the new node.
   * @throws NullPointerException indicates selection == null while head != null
   * @postcondition A new node has been created and placed after this
   * node. Any other elements that were after this
   * node are now after the new node. If this is
   * an empty list, add the element as the first element.
   */
  public void addNodeAfter(IntNode selection, int element) {
    if (selection == null && head != null)
      throw new NullPointerException("selection is null && head != null : Invoked from addNodeAfter()");
    if (selection == null) {
      head = new IntNode(element, null);
      tail = head;
    } else
      selection.addNodeAfter(element);

    if (selection != null && selection == tail)
      tail = selection.getLink();

//    System.out.println(getHead().getData());
//    System.out.println(selection.getData());
//    System.out.println(selection.getLink().getData());
//    System.out.println(selection.getLink().getLink());
//    System.out.println("Tail = " + getTail().getData());
  }

  /**
   * Modification method to add a new node after this node.
   *
   * @param data the data to be placed in the new node.
   * @throws NullPointerException Indicates that selection is null.
   * @postcondition A new node has been created and placed after this
   * node. Any other elements that were after this
   * node are now after the new node.
   */
  public void addNodeBefore(IntNode selection, int data) {
    if (selection == null)
      throw new NullPointerException("selection == null : Invoked from addNodeBefore()");

    int selectData = selection.getData();
    int count = getCountByData(selectData);
    IntNode nodeBeforeSelection = null;
    if (count == 0)
      setNewHead(data);
    else {
      nodeBeforeSelection = getNodeByCount(count - 1);
      nodeBeforeSelection.addNodeAfter(data);
    }
  }

  /**
   * Access method to retrieve the number of nodes from the head that the specified
   * data is located in.
   *
   * @param data the data to be located
   * @return the number of nodes from the head that the data is located in,
   * or -1 if the data is not found.
   */
  public int getCountByData(int data) {
    IntNode temp = head;
    int count = 0;
    while (temp != null && temp.getData() != data) {
      if (temp.getLink() == null) { // if next node is null, and data hasn't been found, count will
        return -1;                 // be greater than number of nodes in the list, so return -1
      } else {
        temp = temp.getLink();  // else go to the next node and increment count
        count += 1;
      }
    }
    if (temp == null)  // if the list is empty, return -1
      return -1;
    else
      return count;  // else return the count
  }

  /**
   * Access method to retrieve the node that the specified data is located in.
   *
   * @param count the data to be located
   * @return the node that the data is located in, or null if data is not found.
   * @throws IllegalArgumentException Indicates that count is negative
   */
  public IntNode getNodeByCount(int count) {
    if (count < 0)
      throw new IllegalArgumentException("count < 0 : Invoked from getNodeByCount()");
    IntNode temp = head;
    int i = 0;
    while (temp != null && i < count) {
      if (i != 0 && temp.getLink() == null) { // we're at the last node and data wasn't found
        return null;
      } else {
        temp = temp.getLink();
        i += 1;
      }
    }
    return temp;
  }

  /**
   * Modification method to remove node after selection
   *
   * @postcondition The node after this node has been removed from the list. If there
   * were further nodes after that One, they are still present.
   * If this list only has One node, remove it. If this is an
   * empty list, do nothing.
   */
  public void removeAfter(IntNode selection) {
    if (head != null) {
      if (selection == head && selection.getLink() == null)
        removeHead();

      if (selection.getLink() != null)
        selection.removeNodeAfter();
    }
  }

  //Todo: method not used or tested fully
  public IntNode getNodeByData(int data) {
    IntNode temp = head;
    while (temp.getData() != data && temp.getLink() != null) {
      temp = temp.getLink();
    }
    return temp;
  }

  public static void main(String[] args) {
    IntNode list = new IntNode(1, null);
    list.addNodeAfter(2);

    VPLinkedList list2 = new VPLinkedList(1, null);
    list2.addNodeAfter(list2.getHead(), 2);

    IntNode temp = list2.getHead().getLink();
    for (int i = 3; i <= 100; i++) {
      list2.addNodeAfter(temp, i);
      temp = temp.getLink();
    }

      System.out.println("list = " + IntNode.listLength(temp));


    for (IntNode cursor = list2.getHead(); cursor != null; cursor = cursor.getLink())
      System.out.println(cursor.getData());


  }
}





















