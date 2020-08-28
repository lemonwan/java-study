package cn.xinongbest.day01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReflectDemoTest {

    private ReflectDemo rd;

    @Before
    public void init() {
        this.rd = new ReflectDemo();
    }

    @Test
    public void testReflectHandle() throws Exception {
        String s = this.rd.reflectHandle();
        Assert.assertEquals("student study", s);
    }
}
