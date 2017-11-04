package org.scriptonbasestar.tool.core;

import org.junit.Test;

public class StringCompareTestOnce {
    public static final String[] compares = "Online regex tester, debugger with highlighting for PHP PCRE Python, Golang and JavaScript".split("\\s");
    public static final String source = "regexwgwegewgwe";

    public static boolean compare1(String source, String ... compares){
        for(String compare : compares){
            if(source.startsWith(compare)){
                return true;
            }
        }
        return false;
    }
    public static boolean compare2(String source, String ... compares){
        boolean result = false;
//        boolean result2 = false;
        for(String compare : compares){
            result = source.startsWith(compare);
//            result2 = result;
        }
        if(result){
            return true;
        }else{
            return false;
        }
//        return result? true : false;
    }

    @Test
    public void test1(){
        for(int i=0;i<1000000;i++){
            compare1(source, compares);
        }
    }
    @Test
    public void test2(){
        for(int i=0;i<1000000;i++) {
            compare2(source, compares);
        }
    }
}
