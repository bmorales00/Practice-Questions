package com.brianprojects.Leetcode.Stack;

import java.util.*;

public class StackToQueues {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int recent;
    public StackToQueues() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    // Time Complexity: O(1)
    public void push(int x) {
        queue1.add(x);
        recent = x;

    }

    // Time Complexity: O(q.size)
    public int pop() {
        if(queue1.isEmpty()){
            throw new IllegalStateException();
        }
        while(queue1.size() != 1){
            queue2.add(queue1.poll());
        }
        while(!queue2.isEmpty()){
            if(queue2.size() == 1){
                recent = queue2.peek();
            }
            queue1.add(queue2.poll());
        }
        return queue1.poll();
    }

    // Time Complexity: O(1)
    public int top() {
        if(queue1.isEmpty()){
            throw new EmptyStackException();
        }
        return recent;
    }

    // Time Complexity: O(1)
    public boolean empty() {

        return queue1.isEmpty();
    }
}

/*
||||||||||||||||||||||||||| Same Answer just using One Queue |||||||||||||||||||||||||||||||||||||||||||||

     Queue<Integer> queue1;
        int recent;
        public StackToQueues() {
            queue1 = new ArrayDeque<>();
        }

        // Time Complexity: O(1)
        public void push(int x) {
            queue1.add(x);
            recent = x;

        }

        // Time Complexity: O(q.size)
        public int pop() {
            if(queue1.isEmpty()){
                throw new IllegalStateException();
            }
            for(var i = 0; i<queue1.size()-1; i++){
                if(i == queue1.size()-2){
                    recent = queue1.peek();
                }
                queue1.add(queue1.poll());
            }
            return queue1.poll();
        }

        // Time Complexity: O(1)
        public int top() {
            if(queue1.isEmpty()){
                throw new IllegalStateException();
            }
            return recent;
        }

        // Time Complexity: O(1)
        public boolean empty() {

            return queue1.isEmpty();
        }
 */