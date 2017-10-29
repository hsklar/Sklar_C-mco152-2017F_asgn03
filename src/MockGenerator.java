
public class MockGenerator implements IRandomValueGenerator{
	
	private int value;

	public MockGenerator(){
		this.value=0;
	}
	
	public int getValue(int lowest, int highest){
		return value;
	}
	
	public void setValue(int value){
		this.value=value;
	}
}
