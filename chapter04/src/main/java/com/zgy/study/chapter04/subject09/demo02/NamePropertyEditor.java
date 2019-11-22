package com.zgy.study.chapter04.subject09.demo02;

import java.beans.PropertyEditorSupport;

/**
 * @author ZGY <br>
 * @date 2019/11/22 17:04 <br>
 * @description NamePropertyEditor <br>
 */
public class NamePropertyEditor extends PropertyEditorSupport {
    /**
     * Sets the property value by parsing a given String.  May raise
     * java.lang.IllegalArgumentException if either the String is
     * badly formatted or if this kind of property can't be expressed
     * as text.
     *
     * @param text The string to be parsed.
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] strings = text.split("\\s");
        setValue(new FullName(strings[0], strings[1]));
    }
}
