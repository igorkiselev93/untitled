package queue;

// linkQueue.java
// demonstrates queue implemented as double-ended list
// to run this program: C>java LinkQueueApp
////////////////////////////////////////////////////////////////
class Link
   {
   public long dData;                // data item
   public Link next;                 // next link in list
// -------------------------------------------------------------
   public Link(long d)               // constructor
      { dData = d; }
// -------------------------------------------------------------
   public void displayLink()         // display this link
      { System.out.print(dData + " "); }
// -------------------------------------------------------------
   }  // end class Link
////////////////////////////////////////////////////////////////
class SortedList
   {
   private Link first;               // ref to first item
 //  private Link last;                // ref to last item
// -------------------------------------------------------------
   public SortedList()            // constructor
      {
      first = null;                  // no items on list yet
  //    last = null;
      }
// -------------------------------------------------------------
   public boolean isEmpty()          // true if no links
      { return first==null; }
// -------------------------------------------------------------
   public void insertSorted(long dd) // insert at end of list
      {
      Link newLink = new Link(dd);   // make new link
         Link previous = null;            // start at first
         Link current = first;
         while(current != null && dd > current.dData)
         {                             // or key > current,
            previous = current;
            current = current.next;       // go to next item
         }
         if(previous==null)               // at beginning of list
            first = newLink;              // first --> newLink
         else                             // not at beginning
            previous.next = newLink;      // old prev --> newLink
         newLink.next = current;
//      if( isEmpty() )                // if empty list,
//         first = newLink;            // first --> newLink
//      else
//         last.next = newLink;        // old last --> newLink
//      last = newLink;                // newLink <-- last
      }
// -------------------------------------------------------------
   public long deleteFirst()         // delete first link
      {                              // (assumes non-empty list)
      long temp = first.dData;
//      if(first.next == null)         // if only one item
//         last = null;                // null <-- last
      first = first.next;            // first --> old next
      return temp;
      }
// -------------------------------------------------------------
   public void displayList()
      {
      Link current = first;          // start at beginning
      while(current != null)         // until end of list,
         {
         current.displayLink();      // print data
         current = current.next;     // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   }  // end class SortedList
////////////////////////////////////////////////////////////////
class LinkQueue
   {
   private SortedList theList;
//--------------------------------------------------------------
   public LinkQueue()                // constructor
      { theList = new SortedList(); }  // make a 2-ended list
//--------------------------------------------------------------
   public boolean isEmpty()          // true if queue is empty
      { return theList.isEmpty(); }
//--------------------------------------------------------------
   public void insert(long j)        // insert, rear of queue
      { theList.insertSorted(j); }
//--------------------------------------------------------------
   public long remove()              // remove, front of queue
      {  return theList.deleteFirst();  }
//--------------------------------------------------------------
   public void displayQueue()
      {
      System.out.print("Очередь (начало-->конец): ");
      theList.displayList();
      }
//--------------------------------------------------------------
   }  // end class LinkQueue
////////////////////////////////////////////////////////////////
class LinkQueueApp
   {
   public static void main(String[] args)
      {
      LinkQueue theQueue = new LinkQueue();
      theQueue.insert(20);                 // insert items
      theQueue.insert(40);
      theQueue.insert(10);
         theQueue.displayQueue();             // display queue
      theQueue.insert(17);
      theQueue.insert(49);


      theQueue.insert(60);                 // insert items
      theQueue.insert(35);

      theQueue.displayQueue();             // display queue

      theQueue.remove();                   // remove items
      theQueue.remove();

      theQueue.displayQueue();             // display queue
      }  // end main()
   }  // end class LinkQueueApp
////////////////////////////////////////////////////////////////
