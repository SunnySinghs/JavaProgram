package threadPrograms;
/**
 * Thread 1 prints even and Thread 2 prints odd number in java
 * @author Sourabh
 *
 */
public class OddEvenDifferentThreads implements Runnable{
	int i=1;
	@Override
	public void run() {
		while(i<10) {
			synchronized (this) {
				if("Thread1".equals(Thread.currentThread().getName())) {
					//System.out.println("-----Thread1-----"+i);
					if(i%2 == 1) {
						System.out.println(i++ +" "+Thread.currentThread().getName());
						/*try {
							Thread.sleep(10);
						}catch (InterruptedException e) {
							e.printStackTrace();
						}*/
						notify();
					}else {
						try {
							wait();
							System.out.println(i++ +" 111 "+Thread.currentThread().getName());
							notify();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}else {
					//System.out.println("-----Thread2-----"+i);
					if(i%2 == 0) {
						System.out.println(i++ + " "+ Thread.currentThread().getName());
						notify();
					}else {
						try {
							wait();
							System.out.println(i++ + " 222 "+ Thread.currentThread().getName());
							notify();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
