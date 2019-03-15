package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

    @Test
    public void constructorTestWithBothParameters(){
        //given
        String expected = "Hello";
        Node<String> newNode = new Node(expected);
        //when
        String actual = newNode.getData();
        Node<String> next = newNode.getNext();
        //then
        Assert.assertEquals(expected,actual);
        Assert.assertNull(next);
    }

    @Test
    public void constructorTestWithOneParameters(){
        //given
        Node<String> nextNode = new Node("Hello", null);
        String expected = "Wowza";
        Node<String> newNode = new Node(expected,nextNode);
        //when
        Node<String> nodeNext = newNode.getNext();
        String actual = newNode.getData();
        //then
        Assert.assertEquals(nextNode, nodeNext);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNextNode(){
            //given
            Node<String> nextNode = new Node("Hello", null);
            Node<String> newNode = new Node("Wowza",null);
            //when
            newNode.setNext(nextNode);
            Node<String> nodeNext = newNode.getNext();
            //then
            Assert.assertEquals(nextNode, nodeNext);
    }

    @Test
    public void setElement(){
        //given
        String expected = "HolyMoley";
        Node<String> newNode = new Node("Wowza",null);
        //when
        newNode.setData(expected);
        String actual = newNode.getData();
        //then
        Assert.assertEquals(expected,actual);
    }
}
