package com.faithl.milim.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leosouthey
 * @date 2021/12/31-19:55
 **/
public class Collection {

    /**
     * 将Object转为List<String>
     *
     * @param object 类
     * @return List<String>
     */
    public static List<String> asList(Object object) {
        List<String> list = new ArrayList<>();
        if (object instanceof java.util.Collection) {
            while (((java.util.Collection<?>) object).iterator().hasNext()) {
                list.add(((java.util.Collection<?>) object).iterator().next().toString());
            }
        } else {
            list.add(object.toString());
        }
        return list;
    }

}
