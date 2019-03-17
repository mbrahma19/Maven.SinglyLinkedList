package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void nullaryConstructorTest(){
        //given
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        //when
        Node<String> head = list.getHead();
        //then
        Assert.assertNull(head);
    }

    @Test
    public void constructorTest(){
        //given
        Integer elementNumber = 10000;
        Node<Integer> expected = new Node<>(elementNumber);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(expected);
        //when
        Node<Integer> actual = list.getHead();
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setHeadWhenListIsOnlyHeadTest(){
        //given
        Node<Integer> expected = new Node<>(10000);
        Node<Integer> first = new Node<>(9124);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(first);
        //when
        list.setHead(expected);
        Node<Integer> actual = list.getHead();
        //then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void setHeadWhenHeadIsNullTest(){
        //given
        Node<Integer> expected = new Node<>(10000);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        //when
        list.setHead(expected);
        Node<Integer> actual = list.getHead();
        //then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void setHeadWhenHeadIsNotNullTest(){
        //given
        Node<Integer> expected = new Node<>(10000);
        Node<Integer> first = new Node<>(9124);
        Integer second = 27236;
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(first);
        //when
        list.add(second);
        list.setHead(expected);
        Node<Integer> actual = list.getHead();
        Integer actualSecondValue = list.getHead().getNext().getData();
        //then
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(second,actualSecondValue);
    }

    @Test
    public void containsNullTest(){
        //given
        Node<Animal> orangutan = new Node<>(new Animal("orangutan"));
        Animal expected = new Animal("lion");
        Animal giraffe = new Animal("giraffe");
        Animal cheetah = new Animal("cheetah");

        SinglyLinkedList<Animal> list = new SinglyLinkedList<>(orangutan);
        //when
        list.add(giraffe);
        list.add(cheetah);
        list.add(expected);
        Boolean actual = list.contains(expected);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void containsElementTest(){
        //given
        Node<Animal> orangutan = new Node<>(new Animal("orangutan"));
        Animal lion = new Animal("lion");
        Animal expected = new Animal("giraffe");
        Animal cheetah = new Animal("cheetah");
        SinglyLinkedList<Animal> list = new SinglyLinkedList<>(orangutan);
        //when
        list.add(cheetah);
        list.add(lion);
        list.add(expected);

        Boolean actual = list.contains(expected);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void doesNotContainElementTest(){
        //given
        Node<Animal> orangutan = new Node<>(new Animal("orangutan"));
        Animal lion = new Animal("lion");
        Animal giraffe = new Animal("giraffe");
        Animal cheetah = new Animal("cheetah");
        Animal expected = new Animal("liar");
        SinglyLinkedList<Animal> list = new SinglyLinkedList<>(orangutan);
        //when
        list.add(cheetah);
        list.add(lion);
        list.add(giraffe);

        Boolean actual = list.contains(expected);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void addTest(){
        Integer expected = 10000;
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(new Node<>(99999));
        //when
        list.add(expected);
        Integer actual = list.get(1).getData();
        //then
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void addAtSize3Test(){
        //given
        Node<Animal> orangutan = new Node<>(new Animal("orangutan"));
        Animal expected = new Animal("lion");
        Animal giraffe = new Animal("giraffe");
        Animal cheetah = new Animal("cheetah");

        SinglyLinkedList<Animal> list = new SinglyLinkedList<>(orangutan);
        //when
        list.add(giraffe);
        list.add(cheetah);
        list.add(expected);
        Animal actual = list.get(3).getData();
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void sizeOfZeroTest(){
        //given
        Integer expected = 0;

        SinglyLinkedList<Animal> list = new SinglyLinkedList<>();
        //when
        Integer actual = list.size();
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void sizeOfFourTest(){
        //given
        Node<Animal> orangutan = new Node<>(new Animal("orangutan"));
        Animal lion = new Animal("lion");
        Animal giraffe = new Animal("giraffe");
        Animal cheetah = new Animal("cheetah");
        Integer expected = 4;

        SinglyLinkedList<Animal> list = new SinglyLinkedList<>(orangutan);
        //when
        list.add(giraffe);
        list.add(cheetah);
        list.add(lion);
        Integer actual = list.size();
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findTest(){
            //given
            Node<Animal> orangutan = new Node<>(new Animal("orangutan"));
            Animal lion = new Animal("lion");
            Animal giraffe = new Animal("giraffe");
            Animal cheetah = new Animal("cheetah");
            Integer expected = 3;

            SinglyLinkedList<Animal> list = new SinglyLinkedList<>(orangutan);
            //when
            list.add(giraffe);
            list.add(cheetah);
            list.add(lion);
            Integer actual = list.find(lion);
            //then
            Assert.assertEquals(expected,actual);
    }

    @Test
    public void findWhenItsTheHeadTest(){
        //given
        Animal orangutanAnimal = new Animal("orangutan");
        Node<Animal> orangutan = new Node<>(orangutanAnimal);
        Animal lion = new Animal("lion");
        Animal giraffe = new Animal("giraffe");
        Animal cheetah = new Animal("cheetah");
        Integer expected = 0;

        SinglyLinkedList<Animal> list = new SinglyLinkedList<>(orangutan);
        //when
        list.add(giraffe);
        list.add(cheetah);
        list.add(lion);
        Integer actual = list.find(orangutanAnimal);
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findWhenItDoesNotExistTest(){
        //given
        Node<Animal> orangutan = new Node<>(new Animal("orangutan"));
        Animal lion = new Animal("lion");
        Animal giraffe = new Animal("giraffe");
        Animal cheetah = new Animal("cheetah");
        Integer expected = -1;

        SinglyLinkedList<Animal> list = new SinglyLinkedList<>(orangutan);
        //when
        list.add(giraffe);
        list.add(cheetah);
        list.add(lion);
        Integer actual = list.find(new Animal("porcupine"));
        //then
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void removeAtTheFrontTest(){
        //given
        Node<Animal> orangutan = new Node<>(new Animal("orangutan"));
        Animal expected = new Animal("lion");
        Animal giraffe = new Animal("giraffe");
        Animal cheetah = new Animal("cheetah");

        SinglyLinkedList<Animal> list = new SinglyLinkedList<>(orangutan);
        //when
        list.add(expected);
        list.add(giraffe);
        list.add(cheetah);
        list.remove(new Animal("orangutan"));
        Animal actual = list.getHead().getData();
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeFromTheMiddleTest(){
        //given
        String first = "First";
        String second = "Second";
        String third = "Third";
        String fourth = "Fourth";
        String fifth = "Fifth";
        String sixth = "Sixth";

        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);
        list.add(fifth);
        list.add(sixth);
        //when
        list.remove(fourth);
        Node<String> actualNext = list.get(2);
        Boolean actual = list.contains(fourth);

        //then
        Assert.assertFalse(actual);
        Assert.assertEquals(actualNext.getNext().getData(),fifth);
    }

    @Test
    public void removeFromTheEnd(){
        //given
        String first = "First";
        String second = "Second";
        String third = "Third";
        String fourth = "Fourth";
        String fifth = "Fifth";
        String sixth = "Sixth";

        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);
        list.add(fifth);
        list.add(sixth);
        //when
        list.remove(sixth);
        Node<String> actualNext = list.get(4);
        Boolean actual = list.contains(sixth);

        //then
        Assert.assertFalse(actual);
        Assert.assertNull(actualNext.getNext());
    }


    @Test
    public void copyTest(){
        //given
        String first = "First";
        String second = "Second";
        String third = "Third";
        String fourth = "Fourth";
        String fifth = "Fifth";
        String sixth = "Sixth";

        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);
        list.add(fifth);
        list.add(sixth);
        //when
        SinglyLinkedList<String> newList = list.copy();


        //then
        for(int i = 0; i < list.size(); i++){
           Assert.assertTrue(newList.get(i).getData().equals(list.get(i).getData()));
        }
    }

    @Test
    public void sortTest(){
        //given

        //when

        //then
    }


}
