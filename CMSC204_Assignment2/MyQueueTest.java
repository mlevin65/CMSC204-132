 
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyQueueTest {
	public MyQueue<String> stringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleQ
	public MyQueue<Double> doubleQ;
	// STUDENT: add variables as needed for your student tests
	public Double g = 2.0, h = 4.0, i = 6.0, j = 8.0, k = 10.0, l = 12.0, m = 14.0;

	@Before
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		//STUDENT: add setup for doubleQ for student tests
		doubleQ = new MyQueue<Double>(6);
		doubleQ.enqueue(g);
		doubleQ.enqueue(h);
		doubleQ.enqueue(i);

	}

	@After
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false,stringQ.isEmpty());
		stringQ.dequeue();
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(true, stringQ.isEmpty());
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}
	
@Test
	public void testDequeueStudent() {
		//Use the doubleQ for student tests
		try {
			assertEquals(g, doubleQ.dequeue());
			assertEquals(h, doubleQ.dequeue());
			assertEquals(i, doubleQ.dequeue());

			doubleQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		} catch (QueueUnderflowException e) {
			assertTrue("This should have caused an QueueuUnderflowException", true);
		} catch (Exception e) {
			assertTrue("This should have caused an QueueUnderflowException", true);
		}

	}
	@Test
	public void testSize() {
		assertEquals(3, stringQ.size());
		stringQ.enqueue(d);
		assertEquals(4, stringQ.size());
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(2, stringQ.size());
	}

	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}
	@Test
	public void testEnqueueStudent() {
		// Use the doubleQ for student tests
		try {
			assertEquals(3, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(j));
			assertEquals(4, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(k));
			assertEquals(5, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(l));
			assertEquals(6, doubleQ.size());

			doubleQ.enqueue(m);
			assertTrue("This should have caused an QueueOverflowException", false);
		} catch (QueueOverflowException e) {
			assertTrue("This should have caused an QueueOverflowException", true);
		} catch (Exception e) {
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	@Test
	public void testIsFull() {
		assertEquals(false, stringQ.isFull());
		stringQ.enqueue(d);
		stringQ.enqueue(e);
		assertEquals(true, stringQ.isFull());
	}

	@Test
	public void testToString() {
		assertEquals("abc", stringQ.toString());
		stringQ.enqueue(d);
		assertEquals("abcd", stringQ.toString());
		stringQ.enqueue(e);
		assertEquals("abcde", stringQ.toString());
	}
	
	@Test
	public void testToStringStudent() throws QueueOverflowException {
		//Use the doubleQ for student tests
		assertEquals("2.04.06.0", doubleQ.toString());
		doubleQ.enqueue(j);
		assertEquals("2.04.06.08.0", doubleQ.toString());
		doubleQ.enqueue(k);
		assertEquals("2.04.06.08.010.0", doubleQ.toString());

	}


	@Test
	public void testToStringDelimiter() {
		assertEquals("a%b%c", stringQ.toString("%"));
		stringQ.enqueue(d);
		assertEquals("a&b&c&d", stringQ.toString("&"));
		stringQ.enqueue(e);
		assertEquals("a/b/c/d/e", stringQ.toString("/"));
	}

	@Test
	public void testFill() {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringQ = new MyQueue<String>(5);
		//fill with an ArrayList
		stringQ.fill(fill);
		assertEquals(3,stringQ.size());
		assertEquals("apple", stringQ.dequeue());
		assertEquals("banana", stringQ.dequeue());
		assertEquals("carrot", stringQ.dequeue());		
	}

}
