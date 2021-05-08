package edu.sjsu.lpython;

import java.util.ArrayList;
import java.util.List;

/**
 * Values in lpython.
 * Evaluating a lpython expression should return a lpython value.
 */

public interface Value {

}

/**
 * Numbers.  Only integers are supported.
 */
class IntVal implements Value {
    private int i;
    public IntVal(int i) { this.i = i; }
    public int toInt() { return this.i; }
    @Override
    public boolean equals(Object that) {
        if (!(that instanceof IntVal)) return false;
        return this.i == ((IntVal) that).i;
    }
    @Override
    public String toString() {
        return "" + this.i;
    }
}
/**
 * Boolean values.
 */
class BoolVal implements Value {
    private boolean boolVal;
    public BoolVal(boolean b) { this.boolVal = b; }
    public boolean toBoolean() { return this.boolVal; }
    @Override
    public boolean equals(Object that) {
        if (!(that instanceof BoolVal)) return false;
        return this.boolVal == ((BoolVal) that).boolVal;
    }
    @Override
    public String toString() {
        return "" + this.boolVal;
    }
}

/**
 * List values. Can contain any data type.
 */
class ListVal implements Value {
    private List<Value> l;
    public ListVal() {this.l = new ArrayList<Value>(); }
    public ListVal(List<Value> l) {this.l = l; }

    public List<Value> getList() {
		return l;
	}
	public Value get(int i) {
    	return l.get(i);
    }
	public Value getSlice(Value start, Value end, Value slice) {
		List<Value> result = new ArrayList<>();
		int i3 = 1;
		if(!(slice instanceof NoneVal))			i3 = ((IntVal) slice).toInt();
		
		if(i3>0) {
			int i1 = 0;
			int i2 = l.size();
			if(!(start instanceof NoneVal))			i1 = ((IntVal) start).toInt();
			if(!(end instanceof NoneVal)) 			i2 = ((IntVal) end).toInt();
			
			for(int i=i1; i<i2; i+=i3) {
				result.add(l.get(i));
			}
		}else if(i3<0) {
			int i1 = l.size()-1;
			int i2 = -1;
			if(!(start instanceof NoneVal))			i1 = ((IntVal) start).toInt();
			if(!(end instanceof NoneVal)) 			i2 = ((IntVal) end).toInt();

			for(int i=i1; i>i2; i+=i3) {
				result.add(l.get(i));
			}
		}else {
			return null;
		}
		
		
		return new ListVal(result);
	}

	@Override
	public boolean equals(Object that) {
		if (!(that instanceof ListVal)) return false;
		List<Value> l1 = this.l;
		List<Value> l2 = ((ListVal) that).getList();
		
		if(l1.size() != l2.size()) return false;
		for(int i = 0; i<l1.size(); i++) {
			if (!l1.get(i).equals(l2.get(i))) return false;
		}
		
		return true;
	}
	@Override
    public String toString() {
        String s = "[";
        for(int i = 0; i<l.size()-1; i++) {
        	s += l.get(i).toString() + ", ";
        }
        s += l.get(l.size()-1).toString() + "]";
        return s;
    }
}

/**
 * None values.
 */
class StringVal implements Value {
	private String s;
	
	
    public StringVal(String s) {
		super();
		this.s = s;
	}
    
	public String getString() {
		return s;
	}
	
	@Override
	public String toString() {
		return s;
	}

	@Override
    public boolean equals(Object that) {
        if (!(that instanceof StringVal)) return false;
        return this.s.equals(((StringVal) that).getString());
    }

}

/**
 * None values.
 */
class NoneVal implements Value {
    @Override
    public boolean equals(Object that) {
        return (that instanceof NoneVal);
    }
    @Override
    public String toString() {
        return "None";
    }
}
