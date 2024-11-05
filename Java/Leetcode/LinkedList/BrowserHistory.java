package com.brianprojects.Leetcode.LinkedList;

public class BrowserHistory {
    private class Node{
        String url;
        Node next;
        Node prev;
        public Node(String url) {
            this.url = url;
        }
    }

    Node current;
    public BrowserHistory(String homepage) {
        this.current = new Node(homepage);
    }

    public void visit(String url) {
        Node node = new Node(url);
        current.next = node;
        node.prev = current;
        current = node;
    }

    public String back(int steps) {
        int i =0;
        while(current.prev != null && i != steps){
            current = current.prev;
            i++;
        }
        return current.url;
    }

    public String forward(int steps) {
        int i =0;
        while(current.next != null && i != steps){
            current = current.next;
            i++;
        }
        return  current.url;
    }

}
