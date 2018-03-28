package queuePrograms;

public class StaticCircularArrayQueue {

	int front, rear, size, capacity;
	int []arr;
	
	public StaticCircularArrayQueue(int capacity) {
		this.capacity = capacity;
		front = this.size = 0;
		rear = capacity-1;
		arr = new int[this.capacity];
	}
	
	boolean isFull(StaticCircularArrayQueue queue) {
		return (queue.size == queue.capacity);
	}
	boolean isEmpty(StaticCircularArrayQueue queue) {
		return (queue.size == 0);
	}
	void enqueue(int item) {
		if(isFull(this)) {
			return;
		}
		this.rear = (this.rear+1)%this.capacity;
		this.arr[this.rear] = item;
		this.size = this.size+1;
		System.out.println(item + " is enqueued.");
	}
	int dequeue() {
		if(isEmpty(this)) {
			return Integer.MIN_VALUE;
		}
		int item = arr[this.front];
		this.front = (this.front+1)%this.capacity;
		this.size = this.size -1;
		return item;
		
	}
	
	int front() {
		if(isEmpty(this)) {
			return Integer.MIN_VALUE;
		}
		return this.arr[this.front];
	}
	
	int rear() {
		if(isFull(this)) {
			return Integer.MIN_VALUE;
		}
		return this.arr[this.rear];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticCircularArrayQueue sc = new StaticCircularArrayQueue(100);
		sc.enqueue(10);
		sc.enqueue(20);
		sc.enqueue(30);
		sc.enqueue(40);
		
		System.out.println("Dequeue element : "+sc.dequeue());
		System.out.println("Front Element is : "+sc.front());
		System.out.println("Rear Element is : "+sc.rear());

	}

}
