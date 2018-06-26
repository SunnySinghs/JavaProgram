package threadPrograms;

public class VideoConferenceApp {

	public static void main(String[] args) {
		VideoConference vc = new VideoConference(5);
		new Thread(vc).start();

		for(int i=0; i<5; i++){
			Partcipants pt = new Partcipants(vc, "Partcipants_"+i);
			new Thread(pt).start();
		}

	}
}
