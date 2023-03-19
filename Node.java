package BTLJava;

public class Node {
 private int i;

 private int value;
 private int functionary;
public Node() {
	super();
	this.i = 0;

	this.value = 0;
	this.functionary = 0;
}
public Node(int i,  int value,int functionary) {
	super();
	this.i = i;

	this.value = value;
	this.functionary = functionary;
	
}


public int isFunctionary() {
	return functionary;
}
public void setFunctionary(int functionary) {
	this.functionary = functionary;
}



public int getI() {
	return i;
}
public void setI(int i) {
	this.i = i;
}

public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
@Override
public String toString() {
	return "Node [i=" + i + ", value=" + value + ", functionary=" + functionary + "]";
}
 

}
