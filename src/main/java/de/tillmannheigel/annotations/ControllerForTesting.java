package de.tillmannheigel.annotations;

public class ControllerForTesting {

    public void huhu(@RequestEnumParam String greet){
        System.out.println(greet);
    }
    public void huhu(
            @RequestEnumParam String greet,
            Integer anotherParamter){
        System.out.println(greet + anotherParamter);
    }
}
