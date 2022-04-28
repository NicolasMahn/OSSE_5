package de.hfu;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {


    @Test
    public void testEnqueue() {
        Queue q = new Queue(3);
        q.enqueue(1);
        q.enqueue(2);
        assertEquals(1,q.queue[0]);
        assertEquals(2,q.queue[1]);
        assertEquals(0,q.queue[2]);
    }

    @Test
    public void testEnqueueOverflow() {
        Queue q = new Queue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        assertEquals(1,q.queue[0]);
        assertEquals(2,q.queue[1]);
        assertEquals(4,q.queue[2]);
    }

    @Test
    public void testDequeue1() {
        Queue q = new Queue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1, q.dequeue());
        assertEquals(0,q.queue[0]);
        assertEquals(2,q.queue[1]);
        assertEquals(3,q.queue[2]);
    }

    @Test
    public void testDequeue2() {
        Queue q = new Queue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1, q.dequeue());
        assertEquals(2, q.dequeue());
        assertEquals(0,q.queue[0]);
        assertEquals(0,q.queue[1]);
        assertEquals(3,q.queue[2]);
    }

    @Test
    public void testDequeueEmpty() {
        Queue q = new Queue(3);
        assertEquals(0,q.queue[0]);
        assertEquals(0,q.queue[1]);
        assertEquals(0,q.queue[2]);
        try {
            assertEquals(0, q.dequeue());
            fail();
        } catch (IllegalStateException e) {}

    }

    @Test
    public void testDequeueOverflow() {
        Queue q = new Queue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1, q.dequeue());
        assertEquals(2, q.dequeue());
        assertEquals(3, q.dequeue());
        assertEquals(0,q.queue[0]);
        assertEquals(0,q.queue[1]);
        assertEquals(0,q.queue[2]);
        try {
            assertEquals(0, q.dequeue());
            fail();
        } catch (IllegalStateException e) {}
    }

    @Test
    public void testRingMemory() {
        Queue q = new Queue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1, q.dequeue());
        assertEquals(2, q.dequeue());
        q.enqueue(4);
        assertEquals(4,q.queue[0]);
        assertEquals(0,q.queue[1]);
        assertEquals(3,q.queue[2]);
    }

    @Test
    public void testRingMemoryOverflow() {
        Queue q = new Queue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        assertEquals(1,q.queue[0]);
        assertEquals(2,q.queue[1]);
        assertEquals(4,q.queue[2]);
    }
}
