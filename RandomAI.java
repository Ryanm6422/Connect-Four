package application;
import java.util.Random;

public class RandomAI {
	
	public int randomMove() {
		Random rand = new Random();
		return rand.nextInt(7);
	}
	
}