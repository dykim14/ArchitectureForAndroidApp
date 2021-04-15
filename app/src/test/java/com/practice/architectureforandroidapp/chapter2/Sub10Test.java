package com.practice.architectureforandroidapp.chapter2;

import com.practice.architectureforandroidapp.chapter2.sub10.DaggerMyComponent;
import com.practice.architectureforandroidapp.chapter2.sub10.MyComponent;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class Sub10Test {

    @Test
    public void testObjectIdentity() {
        MyComponent myComponent = DaggerMyComponent.create();
        Object temp1 = myComponent.getObject();
        Object temp2 = myComponent.getObject();
        assertNotNull(temp1);
        assertNotNull(temp2);
        assertSame(temp1, temp2);
    }
}
