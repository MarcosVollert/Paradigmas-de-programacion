package stack;

public class Passes extends SuperClassOfFailsAndPasses{
	
	public Object pop(OOStack stack) {
		return stack.stackArray.remove(stack.size() - 1);
	}
	
	public Object top(OOStack stack) {
		return stack.stackArray.get(stack.size() - 1);
	}
}