package com.wz.test;

import com.wz.Temps;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class flect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        Class<Temps> tempsClass = Temps.class;

        System.out.println(tempsClass);
        Class<? extends Temps> temps = new Temps().getClass();
        Constructor<? extends Temps> declaredConstructor1 = temps.getDeclaredConstructor(String.class);
        String name = declaredConstructor1.getName();
        int parameterCount = declaredConstructor1.getParameterCount();


        System.out.println(declaredConstructor1);
        System.out.println(temps);

        Class<?> aClass = Class.forName("com.wz.Temps");
//      Object o = aClass.newInstance();
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        Object o = declaredConstructor.newInstance("1");
        System.out.println(o);

//        Object emp = aClass.newInstance();

//        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
//        Object o = declaredConstructor.newInstance("1");
//        System.out.println(o);

//        Field salary = aClass.getDeclaredField("salary");
//        salary.setAccessible(true);
//       salary.set(emp,12131.2);
//        salary.setAccessible(true);
//        aClass.getDeclaredMethod("");


//        System.out.println(emp);


    }
}
