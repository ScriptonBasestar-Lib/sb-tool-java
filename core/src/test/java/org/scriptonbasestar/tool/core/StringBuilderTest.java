package org.scriptonbasestar.tool.core;

import org.junit.Test;

public class StringBuilderTest {

    @Test
    public void testsb(){
        StringBuilder sb = new StringBuilder("getName");
        System.out.println(sb.delete(0,3).toString());
        sb.setCharAt(0,Character.toLowerCase(sb.charAt(0)));
        System.out.println(sb.toString());
    }
}
