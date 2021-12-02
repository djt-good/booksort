package com.wz.utils;

import javafx.beans.binding.DoubleBinding;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class ParamUtil {
    public static <T> T toBean(Map <String ,String []> map, Class<T> c){
        try {
            T t = c.newInstance();
            Set<Map.Entry<String, String[]>> entries = map.entrySet();
            for (Map.Entry<String, String[]> entry : entries) {
                //参数名，和 对象t中的属性名一致
                String key = entry.getKey();
                Field f = c.getDeclaredField(key);
                f.setAccessible(true);
                String typeName = f.getAnnotatedType().getType().getTypeName();
                System.out.println(typeName);

                if(typeName.equals("java.util.Date")){
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    Date d = sf.parse(entry.getValue()[0]);
                    f.set(t,d);
                }else if (typeName.equals("double")){
                    double v = Double.parseDouble(entry.getValue()[0]);
                    f.set(t,v);
                }else if(typeName.equals("int")){
                    int i = Integer.parseInt(entry.getValue()[0]);
                    f.set(t,i);
                }else if(typeName.equals("java.lang.String")){
                    f.set(t,entry.getValue()[0]);
                }else if(typeName.equals("java.lang.String[]")){
                    f.set(t,entry.getValue());
                }else {
                    f.set(t,entry.getValue());
                }
            }
            return t;
        }catch (Exception e){
           e.printStackTrace();
        }
        return null;
    }
 }
