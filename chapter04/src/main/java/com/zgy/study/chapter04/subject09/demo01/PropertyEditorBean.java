package com.zgy.study.chapter04.subject09.demo01;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.InputStreamEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.ResourceEditor;
import org.springframework.validation.DataBinder;

import java.beans.PropertyEditor;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author ZGY <br>
 * @date 2019/11/22 13:55 <br>
 * @description PropertyEditorBean <br>
 */
public class PropertyEditorBean {

    private byte[] bytes;
    private Character character;
    private Class cls;
    private Boolean trueOrFalse;
    private List<String> stringList;
    private Date date;
    private Float floatValue;
    private File file;
    private InputStream stream;
    private Locale locale;
    private Pattern pattern;
    private Properties properties;
    private String trimString;
    private URL url;

    public void setCharacter(Character character) {
        System.out.println("Setting character: " + character);
        this.character = character;
    }

    public void setCls(Class cls) {
        System.out.println("Setting class: " + cls.getName());
        this.cls = cls;
    }

    public void setFile(File file) {
        System.out.println("Setting file: " + file.getName());
        this.file = file;
    }

    public void setLocale(Locale locale) {
        System.out.println("Setting locale: " + locale.getDisplayName());
        this.locale = locale;
    }

    public void setProperties(Properties properties) {
        System.out.println("Loaded " + properties.size() + " properties");
        this.properties = properties;
    }

    public void setUrl(URL url) {
        System.out.println("Setting URL: " + url.toExternalForm());
        this.url = url;
    }

    public void setBytes(byte... bytes) {
        System.out.println("Setting bytes: " + Arrays.toString(bytes));
        this.bytes = bytes;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        System.out.println("Setting Boolean: " + trueOrFalse);
        this.trueOrFalse = trueOrFalse;
    }

    public void setStringList(List<String> stringList) {
        System.out.println("Setting string list with size: "
                + stringList.size());

        this.stringList = stringList;

        for (String string: stringList) {
            System.out.println("String member: " + string);
        }
    }

    public void setDate(Date date) {
        System.out.println("Setting date: " + date);
        this.date = date;
    }

    public void setFloatValue(Float floatValue) {
        System.out.println("Setting float value: " + floatValue);
        this.floatValue = floatValue;
    }

    public void setStream(InputStream stream) {
        System.out.println("Setting stream: " + stream);
        this.stream = stream;
    }

    public void setPattern(Pattern pattern) {
        System.out.println("Setting pattern: " + pattern);
        this.pattern = pattern;
    }

    public void setTrimString(String trimString) {
        System.out.println("Setting trim string: " + trimString);
        this.trimString = trimString;
    }

    public static class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
        /**
         * Register custom {@link PropertyEditor PropertyEditors} with
         * the given {@code PropertyEditorRegistry}.
         * <p>The passed-in registry will usually be a {@link BeanWrapper} or a
         * {@link DataBinder DataBinder}.
         * <p>It is expected that implementations will create brand new
         * {@code PropertyEditors} instances for each invocation of this
         * method (since {@code PropertyEditors} are not threadsafe).
         *
         * @param registry the {@code PropertyEditorRegistry} to register the
         *                 custom {@code PropertyEditors} with
         */
        @Override
        public void registerCustomEditors(PropertyEditorRegistry registry) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            registry.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

            registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));

            registry.registerCustomEditor(InputStream.class,
                    new InputStreamEditor(new ResourceEditor(new FileSystemResourceLoader(), null, true)));
        }
    }
}
