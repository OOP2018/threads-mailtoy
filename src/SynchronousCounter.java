
public class SynchronousCounter extends Counter {
	
	@Override
	 public synchronized void add(int amount) {
		try {
			super.total += amount;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	 }

}
