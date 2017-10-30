
public interface IRandomValueGenerator {
	
	//returns a random value in the given range
	int getValue(int lowest, int highest);
	
	//will return true if a give event actually did happen
	boolean getBoolean(double probability);

}
