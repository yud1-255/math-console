package com.kb.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandResultTest {

    @Before
    public void setUp()  {
    }

    @Test
    public void whenString_returnsEqualString() {
        String expected = "Hello World!";
        CommandResult sut = new CommandResult(expected);
        String actual = sut.getValue().toString();

        assertEquals(expected, actual);
    }
}