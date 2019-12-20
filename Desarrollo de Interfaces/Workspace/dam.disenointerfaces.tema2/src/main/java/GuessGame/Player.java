package GuessGame;

public class Player {

	int numberGuessed;
	
	public void guess() {
		numberGuessed = (int) (Math.random() * 10);
		System.out.println("I'm guessing " + numberGuessed);
	}
}
