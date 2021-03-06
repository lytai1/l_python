package edu.sjsu.lpython;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StatementTest {
	
	// for print statement testing
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Before
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@Test
	public void testExpStat() {
		Environment env = new Environment();
		Expression e = new ValueExpr(new IntVal(10));
		Statement es = new ExprStat(e);

		Value v = (Value) es.evaluate(env);
		assertEquals(v, new IntVal(10));	
	}	
	
	@Test
	public void testIfStat() {
		Environment env = new Environment();
		List<Expression> ifs = new ArrayList<>();
		ifs.add(new ValueExpr(new BoolVal(false)));
		ifs.add(new ValueExpr(new BoolVal(false)));
		ifs.add(new ValueExpr(new BoolVal(true)));

		List<Statement> blocks = new ArrayList<>();
		blocks.add(new AssignStat("x", new ValueExpr(new IntVal(1))));
		blocks.add(new AssignStat("x", new ValueExpr(new IntVal(2))));
		blocks.add(new AssignStat("x", new ValueExpr(new IntVal(3))));
		
		Statement elsestat = new AssignStat("x", new ValueExpr(new IntVal(4)));
		
		IfStat is = new IfStat(ifs, blocks, elsestat);
		is.evaluate(env);
	    
		assertEquals(new IntVal(3), env.resolveVar("x"));

		
	}
	
	@Test
	public void testWhileStat() {
		Environment env = new Environment();
	    env.updateVar("x", new IntVal(10));
	    WhileStat we = new WhileStat(new BinOpExpr(Op.GT,
	                  new VarExpr("x"),
	                  new ValueExpr(new IntVal(0))),
	              new AssignStat("x",
	            		 new BinOpExpr(Op.SUBTRACT,
	                              new VarExpr("x"),
	                              new ValueExpr(new IntVal(1)))));
	      we.evaluate(env);
	      assertEquals(new IntVal(0), env.resolveVar("x"));
	}

	@Test
	public void testAssignStat() {
		Environment env = new Environment();
		IntVal inVal = new IntVal(42);
		AssignStat ae = new AssignStat("x", new ValueExpr(inVal));
		IntVal iv = (IntVal) ae.evaluate(env);
		assertEquals(iv, inVal);
		assertEquals(env.resolveVar("x"), inVal);	}
	
	@Test
	public void testAssignStat1() {
		Environment env = new Environment();
		Expression e = new BinOpExpr(Op.ADD, new ValueExpr(new IntVal(3)), new ValueExpr(new IntVal(6)));
		AssignStat ae = new AssignStat("x", e);
		IntVal iv = (IntVal) ae.evaluate(env);
		assertEquals(iv, new IntVal(9));
		assertEquals(env.resolveVar("x"), new IntVal(9));	}

	@Test
	public void testPrintStat() {
		Environment env = new Environment();
		Expression e = new BinOpExpr(Op.ADD, new ValueExpr(new IntVal(3)), new ValueExpr(new IntVal(6)));
		PrintStat ps = new PrintStat(new ExprStat(e));
		ps.evaluate(env);
	    assertEquals(outputStreamCaptor.toString().trim(), "9");
	}
	
	@Test
	public void testSuitStat() {
		Environment env = new Environment();
		AssignStat ae = new AssignStat("x", new ValueExpr(new IntVal(42)));
		AssignStat ae2 = new AssignStat("y", new ValueExpr(new IntVal(32)));
		
		List<Statement> ls = new ArrayList<>();
		ls.add(ae);
		ls.add(ae2);
		
		SuitStat ss = new SuitStat(ls);
		ss.evaluate(env);
		assertEquals(env.resolveVar("x"), new IntVal(42));	
		assertEquals(env.resolveVar("y"), new IntVal(32));			
	}
	


}
