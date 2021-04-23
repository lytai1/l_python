package edu.sjsu.lpython;

import static org.junit.Assert.*;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;


public class ExpressionTest {


    @Test
    public void testValueExpr() {
        Environment env = new Environment();
        ValueExpr ve = new ValueExpr(new IntVal(3));
        IntVal i = (IntVal) ve.evaluate(env);
        assertEquals(i.toInt(), 3);
    }
    
    @Test
    public void testVarExpr() {
        Environment env = new Environment();
        Value v = new IntVal(3);
        env.updateVar("x", v);
        Expression e = new VarExpr("x");
        assertEquals(e.evaluate(env), v);
    }
    
    @Test
    public void testVarNotFoundExpr() {
        Environment env = new Environment();
        Value v = new IntVal(3);
        env.updateVar("x", v);
        Expression e = new VarExpr("y");
        assertEquals(e.evaluate(env), new NoneVal());
    }
     
    @Test
    public void testBinOpExpr() {
        Environment env = new Environment();
        BinOpExpr boe1 = new BinOpExpr(Op.ADD,
                new ValueExpr(new IntVal(1)),
                new ValueExpr(new IntVal(2)));
        IntVal iv1 = (IntVal) boe1.evaluate(env);
        assertEquals(iv1, new IntVal(3));
        BinOpExpr boe2 = new BinOpExpr(Op.SUBTRACT,
                new ValueExpr(new IntVal(1)),
                new ValueExpr(new IntVal(2)));
        IntVal iv2 = (IntVal) boe2.evaluate(env);
        assertEquals(iv2, new IntVal(-1));
        BinOpExpr boe3 = new BinOpExpr(Op.MULTIPLY,
                new ValueExpr(new IntVal(1)),
                new ValueExpr(new IntVal(2)));
        IntVal iv3 = (IntVal) boe3.evaluate(env);
        assertEquals(iv3, new IntVal(2));
        BinOpExpr boe4 = new BinOpExpr(Op.DIVIDE,
                new ValueExpr(new IntVal(4)),
                new ValueExpr(new IntVal(2)));
        IntVal iv4 = (IntVal) boe4.evaluate(env);
        assertEquals(iv4, new IntVal(2));
        BinOpExpr boe5 = new BinOpExpr(Op.MOD,
                new ValueExpr(new IntVal(1)),
                new ValueExpr(new IntVal(2)));
        IntVal iv5 = (IntVal) boe5.evaluate(env);
        assertEquals(iv5, new IntVal(1));
        BinOpExpr boe6 = new BinOpExpr(Op.GE,
                new ValueExpr(new IntVal(1)),
                new ValueExpr(new IntVal(2)));
        BoolVal iv6 = (BoolVal) boe6.evaluate(env);
        assertEquals(iv6, new BoolVal(false));
        BinOpExpr boe7 = new BinOpExpr(Op.GT,
                new ValueExpr(new IntVal(1)),
                new ValueExpr(new IntVal(2)));
        BoolVal iv7 = (BoolVal) boe7.evaluate(env);
        assertEquals(iv7, new BoolVal(false));
        BinOpExpr boe8 = new BinOpExpr(Op.LE,
                new ValueExpr(new IntVal(1)),
                new ValueExpr(new IntVal(2)));
        BoolVal iv8 = (BoolVal) boe8.evaluate(env);
        assertEquals(iv8, new BoolVal(true));
        BinOpExpr boe9 = new BinOpExpr(Op.LT,
                new ValueExpr(new IntVal(1)),
                new ValueExpr(new IntVal(2)));
        BoolVal iv9 = (BoolVal) boe9.evaluate(env);
        assertEquals(iv9, new BoolVal(true));
        BinOpExpr boe10 = new BinOpExpr(Op.EQ,
                new ValueExpr(new IntVal(1)),
                new ValueExpr(new IntVal(2)));
        BoolVal iv10 = (BoolVal) boe10.evaluate(env);
        assertEquals(iv10, new BoolVal(false));
        BinOpExpr boe11 = new BinOpExpr(Op.LT,
                new ValueExpr(new IntVal(1)),
                new ValueExpr(new IntVal(2)));
        BoolVal iv11 = (BoolVal) boe11.evaluate(env);
        assertEquals(iv11, new BoolVal(true));
        
    }
    
    @Test
    public void testBoolOpExpr() {
    	Environment env = new Environment();
    	BoolOpExpr boe = new BoolOpExpr(BoolOp.AND,
                new ValueExpr(new BoolVal(true)),
                new ValueExpr(new BoolVal(false)));
        BoolVal bv = (BoolVal) boe.evaluate(env);
        assertEquals(bv, new BoolVal(false));
        
        boe = new BoolOpExpr(BoolOp.OR,
                new ValueExpr(new BoolVal(true)),
                new ValueExpr(new BoolVal(false)));
        bv = (BoolVal) boe.evaluate(env);
        assertEquals(bv, new BoolVal(true));
    }
    
    @Test
    public void testNotOpExpr() {
    	Environment env = new Environment();
    	NotOpExpr noe = new NotOpExpr(new ValueExpr(new BoolVal(true)));
        BoolVal bv = (BoolVal) noe.evaluate(env);
        assertEquals(bv, new BoolVal(false));
        
        noe = new NotOpExpr(new ValueExpr(new BoolVal(false)));
        bv = (BoolVal) noe.evaluate(env);
        assertEquals(bv, new BoolVal(true));
    }
    
    @Test
    public void testStringOpExpr() {
    	Environment env = new Environment();
    	StringOpExpr soe = new StringOpExpr(Op.ADD, 
    			new ValueExpr(new StringVal("Hello ")),
    			new ValueExpr(new StringVal("World"))
    			);
    	StringVal sv = (StringVal) soe.evaluate(env);
    	assertEquals(sv.getString(), "Hello World");
        assertEquals(sv, new StringVal("Hello World"));

    }
    
    @Test
    public void testGetListItemExpr() {
        Environment env = new Environment();
        
		List<Value> l = new ArrayList<>();
		l.add(new IntVal(3));
		l.add(new BoolVal(true));
		l.add(new IntVal(5));
		
		Value lst = new ListVal(l); 
		Expression e = new ListGetExpr(new ValueExpr(lst), new ValueExpr(new IntVal(0)));
		assertEquals(e.evaluate(env), new IntVal(3));
    	
    }
    
    @Test
    public void testGetListItemOutOfBoundExpr() {
    	try {
    		Environment env = new Environment();
    		        
			List<Value> l = new ArrayList<>();
			l.add(new IntVal(3));
			l.add(new BoolVal(true));
			l.add(new IntVal(5));
    				
			Value lst = new ListVal(l); 
			Expression e = new ListGetExpr(new ValueExpr(lst), new ValueExpr(new IntVal(3)));
			e.evaluate(env);
			fail();
		 }catch (Exception e) {
			 
		 }

    }

    @Test
    public void testListOpExpr() {
        Environment env = new Environment();
        
		List<Value> l1 = new ArrayList<>();
		l1.add(new IntVal(3));
		l1.add(new BoolVal(true));
		l1.add(new IntVal(5));
		
		List<Value> l2 = new ArrayList<>();
		l2.add(new BoolVal(false));
		l2.add(new BoolVal(true));
		l2.add(new IntVal(6));
		
		ListOpExpr e = new ListOpExpr(Op.ADD, 
				new ValueExpr(new ListVal(l1)),
				new ValueExpr(new ListVal(l2)));
		ListVal l3 = (ListVal) e.evaluate(env);
		
		List<Value> result = new ArrayList<>();
		result.addAll(l1);
		result.addAll(l2);
		
		assertEquals(l3, new ListVal(result));
		
		List<Value> l4 = new ArrayList<>();
		l4.add(new IntVal(3));
		l4.add(new IntVal(6));
		l4.add(new IntVal(9));
		e = new ListOpExpr(Op.ADD, 
				new ValueExpr(new ListVal(l4)),
				new ValueExpr(new IntVal(3)));
		ListVal l5 = (ListVal) e.evaluate(env);
		
		List<Value> l6 = new ArrayList<>();
		l6.add(new IntVal(6));
		l6.add(new IntVal(9));
		l6.add(new IntVal(12));
		
		assertEquals(l5, new ListVal(l6));
    }
    
    @Test
    public void testListSpliceExpr() {
    	Environment env = new Environment();
		List<Value> l1 = new ArrayList<>();
		l1.add(new IntVal(3));
		l1.add(new BoolVal(true));
		l1.add(new BoolVal(false));
		l1.add(new BoolVal(false));
		l1.add(new BoolVal(true));
		l1.add(new IntVal(5));
    	ListSpliceExpr lse =  new ListSpliceExpr(
    			new ValueExpr(new ListVal(l1)),
    			new ValueExpr(new IntVal(1)),
    			new ValueExpr(new IntVal(3)),
    			new ValueExpr(new IntVal(-1))
    			);
    	ListVal lv = (ListVal) lse.evaluate(env);
		List<Value> l2 = new ArrayList<>();
		l2.add(new BoolVal(false));
		l2.add(new BoolVal(true));
    	assertEquals(lv, new ListVal(l2));
    }

}

