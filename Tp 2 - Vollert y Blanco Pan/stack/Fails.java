package stack;

public class Fails extends SuperClassOfFailsAndPasses{
	public Object pop(OOStack stack) {
		throw new Error(OOStack.stackEmptyErrorDescription);
	}
	
	public Object top(OOStack stack) {
		throw new Error(OOStack.stackEmptyErrorDescription);
	}
}