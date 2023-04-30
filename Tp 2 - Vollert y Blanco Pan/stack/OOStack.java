package stack;

import java.util.ArrayList;
import java.util.List;

public class OOStack {
	static public String stackEmptyErrorDescription = "Stack is empty";
	public List<String> stackArray;
	public List<SuperClassOfFailsAndPasses> estado = new ArrayList<>();
	public SuperClassOfFailsAndPasses superclass;
	public SuperClassOfFailsAndPasses fail = new Fails();
	public SuperClassOfFailsAndPasses pass = new Passes();
	
	public OOStack() {
		stackArray = new ArrayList<String>();
		estado.add(fail);
		superClassAssignation();
	}
	
	public boolean isEmpty() {
		return stackArray.isEmpty();
	}

	public OOStack push(String string) {
		estado.add(pass);
		stackArray.add(string);
		return this;
	}

	public Object pop() {
		superClassAssignation();
		Object poppedObject = superclass.pop(this);
		estado.remove(estado.size() - 1);
		return poppedObject;
	}

	public Object top() {
		superClassAssignation();
		return superclass.top(this);
	}

	public int size() {
		return stackArray.size();
	}
	
	public void superClassAssignation() {
		superclass = estado.get(estado.size() - 1);
	}
	
}