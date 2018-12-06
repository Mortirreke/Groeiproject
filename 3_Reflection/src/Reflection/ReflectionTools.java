package Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author: Quinten Mortier
 **/
public class ReflectionTools {
    public static void classAnalysis(Class aClass){
        System.out.println("Fully qualified name: " + aClass.getName());
        System.out.println("naam superklasse: " + aClass.getSuperclass().getName());
        System.out.println("packagenaam: " + aClass.getPackage().getName());
        System.out.print("interfaces:");
        if (aClass.getInterfaces().length == 0){
            System.out.println(" /");
        } else {
            for (Class aClass1 : aClass.getInterfaces()) {
                System.out.println();
                System.out.println("\t \t- " + aClass1.getName());
            }
        }

        if (aClass.getInterfaces().length == 0){

        }
        System.out.println("constructors:");
        for (Constructor constructor : aClass.getConstructors()) {
            System.out.println("\t \t- "+constructor.getName());
        }

        System.out.println("getters:");
        for (Method method: aClass.getMethods()){
            if (method.getName().startsWith("get")){
                System.out.println("\t \t- "+method.getName());
            }
        }


        System.out.println("setters:");
        for (Method method: aClass.getMethods()){
            if (method.getName().startsWith("set")){
                System.out.println("\t \t- "+method.getName());
            }
        }

        System.out.println("methoden:");
        for (Method method: aClass.getMethods()){
            if (!(method.getName().startsWith("set")|| method.getName().startsWith("get"))){
                System.out.println("\t \t- "+method.getName());
            }
        }
    }


    public static Object runAnnotated(Class aClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object object = aClass.newInstance();
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(CanRun.class) != null){
                method.invoke(object,method.getAnnotation(CanRun.class).value());
            }
        }
        return object;
    }
}
