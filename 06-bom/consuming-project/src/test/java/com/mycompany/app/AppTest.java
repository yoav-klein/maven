package com.mycompany.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Foo f = new Foo();
        f.sayFoo();

        Bar b = new Bar();
        b.sayBar();
        assertTrue( true );
    }
}
