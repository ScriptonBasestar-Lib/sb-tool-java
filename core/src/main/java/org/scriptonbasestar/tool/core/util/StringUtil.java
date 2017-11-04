package org.scriptonbasestar.tool.core.util;

public class StringUtil {
    public static final boolean isStartsWith(String source, String ... compares){
        for(String compare : compares){
            if(source.startsWith(compare)){
                return true;
            }
        }
        return false;
    }
}
