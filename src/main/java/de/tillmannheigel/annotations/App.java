package de.tillmannheigel.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App
{

    public static void main( String[] args )
    {
        ControllerForTesting controllerForTesting = new ControllerForTesting();
        try {
            Method method = controllerForTesting.getClass().getMethod("huhu", String.class);
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (Annotation[] annotations:parameterAnnotations) {
                for (Annotation annotation:annotations) {
                    System.out.println(annotation);
                }
            }
            System.out.println("###App methods####");
            Arrays.stream(ControllerForTesting.class.getDeclaredMethods())
                    .forEach(method1 -> System.out.println(printMethod(method1)));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private static String printMethod(Method method){
        return "-" + method.getAnnotatedReturnType().getType()+" "+ method.getName() + printParameterTypes(method.getParameterTypes());
    }

    private static String printParameterTypes(Class<?>[] parameterTypes) {
        String result = "(";
        for (int i = 0; i < parameterTypes.length; i++) {
            result += parameterTypes[i].getName();
            if (i!=parameterTypes.length-1) result += ", ";
        }
        return result+")";
    }
}
