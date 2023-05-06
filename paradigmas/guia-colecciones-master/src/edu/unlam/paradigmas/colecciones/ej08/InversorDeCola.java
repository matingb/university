package edu.unlam.paradigmas.colecciones.ej08;

import java.util.Queue;
import java.util.Stack;

public class InversorDeCola {
	public <T> Queue<T> invertirCola(Queue<T> queue) {        
		Stack<T> stack = new Stack<T>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
		return queue;
	}
}
