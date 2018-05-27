package threadPrograms;

/*As we mentioned previously, the ReentrantReadWriteLock class has two locks, one for
read operations and one for write operations. The lock used in read operations is obtained
with the readLock() method declared in the ReadWriteLock interface. This lock is an
object that implements the Lock interface, so we can use the lock(), unlock(), and
tryLock() methods. The lock used in write operations is obtained with the writeLock()
method declared in the ReadWriteLock interface. This lock is an object that implements the
Lock interface, so we can use the lock(), unlock(), and tryLock() methods. It is the
responsibility of the programmer to ensure the correct use of these locks, using them with the
same purposes for which they were designed.When you get the read lock of a Lock interface,
you can't modify the value of the variable. Otherwise, you probably will have inconsistency
data errors.*/
public class TestReadWriteLock {
	public static void main(String[] args) {
		PricesInfo pricesInfo=new PricesInfo();
		Reader readers[]=new Reader[5];
		Thread threadsReader[]=new Thread[5];
		for (int i=0; i<5; i++){
			readers[i]=new Reader(pricesInfo);
			threadsReader[i]=new Thread(readers[i]);
		}
		Writer writer=new Writer(pricesInfo);
		Thread threadWriter=new Thread(writer);
		for (int i=0; i<5; i++){
			threadsReader[i].start();
		}
		threadWriter.start();
	}
}
