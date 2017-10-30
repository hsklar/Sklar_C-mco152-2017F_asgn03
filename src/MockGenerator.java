
public class MockGenerator implements IRandomValueGenerator{
	
	private int value;
	private boolean trueFalse;

	public MockGenerator(){
		this.value=0;
		this.trueFalse=false;
	}
	
	public int getValue(int lowest, int highest){
		return value;
	}
	
	public void setValue(int value){
		this.value=value;
	} 
	public boolean getBoolean(double p){
		return trueFalse;
	}
	public void setBoolean(boolean b){
		trueFalse=b;
	}
	
}
