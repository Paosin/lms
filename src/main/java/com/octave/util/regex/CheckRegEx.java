package com.octave.util.regex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Paosin Von Scarlet on 2017/10/12.
 */
public class CheckRegEx {
    public static boolean check(Object object) {
        if (object == null) {
            return false;
        }
        Class<?> clazz = object.getClass();

        Field[] fields = clazz.getDeclaredFields();
        try {

            for (Field field : fields) {
                if (!field.getGenericType().toString().equals("class java.lang.String"))
                    continue;

                RegExAnno anno = field.getAnnotation(RegExAnno.class);

                if (anno == null) {
                    continue;
                }
                String reg = anno.value();
                String type = anno.type().toString();

                if (reg.isEmpty() && type.isEmpty()) {
                    continue;
                }

                Method m = object.getClass().getMethod(getMethodName(field.getName()));
                String val = (String) m.invoke(object);
                Pattern pattern = null;
                if (type.isEmpty())
                    pattern = Pattern.compile(reg);
                else {
                    switch (anno.type()) {
                        case EMAIL:
                            pattern = Pattern.compile("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?");
                            break;
                        case PASSWORD:
                            pattern = Pattern.compile("^[a-zA-Z0-9]{6,10}$");
                            break;
                        case USER_NAME:
                            pattern = Pattern.compile("^[a-zA-Z0-9]{6,10}$");
                            break;
                        case CALL_PHONE:
                            pattern = Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$");
                            break;
                        case NOT_NULL:
                            if (val==null||val.isEmpty()) {
                                StringBuffer sb = new StringBuffer();
                                sb.append(clazz.getName())
                                        .append("--->")
                                        .append(field.getName())
                                        .append(" 不能为空");
                                throw new RegExctption(sb.toString());
                            }
                            continue;
                        default:
                            break;
                    }
                }

                Matcher matcher = pattern.matcher(val);
                if (!matcher.matches()) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(clazz.getName())
                            .append("--->")
                            .append(field.getName())
                            .append(" 正则匹配不通过");
                    throw new RegExctption(sb.toString());
                }
            }
        } catch (NoSuchMethodException |
                IllegalAccessException |
                InvocationTargetException |
                RegExctption e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    private static String getMethodName(String fildeName) {
        char[] charArray = fildeName.toCharArray();
        charArray[0] -= 32;
        return "get" + String.valueOf(charArray);
    }
}
