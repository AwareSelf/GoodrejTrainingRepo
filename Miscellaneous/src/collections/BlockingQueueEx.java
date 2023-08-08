package collections;
/*
 * ArrayBlockingQueue and LinkedBlockingQueue 
 * in Java Collection are the common implementations of the BlockingQueue interface.

ArrayBlockingQueue: 
ArrayBlockingQueue is a class in Java that implements the BlockingQueue interface. 
ArrayBlockingQueue class and its iterator implement all the optional methods of the Collection 
and Iterator interfaces. 
ArrayBlockingQueue is a bounded BlockingQueue backed by an array. 
Here, bounded means the size of the Queue is finite and fixed. 
Once created, we cannot grow or shrink the size of the Queue. 
If we try to insert an element into a full Queue then it will result in the operation blocking. 
Similarly, if we try to take an element from an empty Queue, then also the operation will be 
blocked. 
ArrayBlockingQueue stores the elements in the Queue internally in the FIFO (first-in-first-out) 
order. The element at the head or front of the Queue is the oldest element of all the elements 
present in this queue. 
The element at the tail of this queue is the newest element of all the elements of this queue. 
The new elements are always inserted at the end or tail of the queue and the retrieval operations 
obtain elements at the head of the queue.

As its name suggests, this queue uses an array internally. 
As a consequence, it's a bounded queue, meaning it has a fixed size.
A simple work queue is an example use case. This scenario is often a low producer-to-consumer 
ratio, where we split time-consuming tasks among multiple workers. 
Since this queue can't grow indefinitely, the size limit acts as a safety threshold if memory 
is an issue.
Speaking of memory, it's important to note that the queue pre-allocates the array. 
While this may improve throughput, it may also consume more memory than necessary. 
For instance, a large-capacity queue may stay empty for long periods of time.

Also, the ArrayBlockingQueue uses a single lock for both put and take operations. 
This ensures no overwrite of entries, at the cost of a performance hit.

LinkedBlockingQueue: 
LinkedBlockingQueue is a class in Java that implements the BlockingQueue 
interface. LinkedBlockingQueue is an optionally-bounded BlockingQueue backed by linked nodes. 
Here, optionally-bounded means the capacity given to LinkedBlockingQueue is bounded, 
otherwise, it will be unbounded. 
The capacity can be given as a parameter to the constructor of LinkedBlockingQueue. 
The capacity, if unspecified, is equal to Integer.MAX_VALUE. 

This queue uses distinct locks for put and take operations. 
As a consequence, both operations can be done in parallel and improve throughput.

Since the LinkedBlockingQueue can be either bounded or unbounded, why would we use the 
ArrayBlockingQueue over this one? LinkedBlockingQueue needs to allocate and deallocate nodes 
every time an item is added or removed from the queue.For this reason, an ArrayBlockingQueue can be a better alternative if the queue grows fast and 
shrinks fast.
LinkedBlockingQueue class and its iterator implement all the optional methods of the Collection 
and Iterator interfaces. 
LinkedBlockingQueue stores the elements in the Queue internally in the FIFO (first-in-first-out) 
order. The element at the head or front of the Queue is the oldest element of all the elements 
present in this queue. The element at the tail of this queue is the newest element of all the 
elements of this queue. The new elements are always inserted at the end or tail of the queue and 
the retrieval operations obtain elements at the head of the queue. 

Linked queues typically have higher throughput than array-based queues but less predictable 
performance in most concurrent applications.

Refer: Using ThreadPoolExecutor and BlockingQueue
https://howtodoinjava.com/java/multi-threading/how-to-use-blockingqueue-and-threadpoolexecutor-in-java/
https://www.baeldung.com/java-concurrent-queues#:~:text=The%20ConcurrentLinkedQueue%20is%20the%20only,Compare%2DAnd%2DSwap).

 */
public class BlockingQueueEx {

}
