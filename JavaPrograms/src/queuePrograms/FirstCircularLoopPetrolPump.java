package queuePrograms;

public class FirstCircularLoopPetrolPump {

	static class PetrolPump{
		int petrol, distance;
		public PetrolPump(int petrol, int distance) {
			this.petrol = petrol;
			this.distance = distance;
		}
	}
	
	static int printTour(PetrolPump []arr, int n) {
		int start = 0;
		int end = 1;
		int curr_petrol = arr[start].petrol - arr[start].distance;

		while(start!=end || curr_petrol<0) {
			while(start!=end && curr_petrol<0) {
				curr_petrol -= arr[start].petrol - arr[start].distance;
				start = (start+1)%n;
				if(start == 0)
					return -1;
			}
			curr_petrol += arr[end].petrol - arr[end].distance;
			end = (end+1)%n;
		}
		return start;
	}
	
	public static void main(String[] args) {
		PetrolPump []arr = {new PetrolPump(6, 4),new PetrolPump(3, 6),new PetrolPump(7, 3)};
		int start = printTour(arr, arr.length);
		System.out.println(start == -1 ? "No Solution" : "Start = " + start);
	}
}
