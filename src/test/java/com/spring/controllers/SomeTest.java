package com.spring.controllers;

import org.junit.Test;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
public class SomeTest {

    @Test
    public void testregex() throws Exception {
        System.out.println("answer-88@list.ru".matches("[a-z]+-\\d+@[a-z]+\\.[a-z]+"));
    }

    @Test
    public void testregex2() throws Exception {
        System.out.println("answer-88@list.ru".matches("[a-zA-Z-\\d_$\\+\\.]+@[a-z]+\\.[a-z]+"));
    }
}
