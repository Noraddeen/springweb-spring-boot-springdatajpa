package com.example.demo.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


//Joinpoint: it's a particular point that intersect during execution of programs happen
//        method execution,
//        constructor call,
//        field assignment

//Pointcut – a regular expression that matches a joinpoint.
@Aspect
@Component
public class MyAspect {

    @After("com.example.demo.AOP.DemoPointCut.StudentRepositoryMethod()")
    public void Valiadte() {

    }


//    @AfterReturning("")
//    @AfterThrowing("")
//    @Before("")
//    @Around("")


}

class DemoPointCut {

    @Pointcut("execution(* com.example.demo.studnet.StudentRepository.*(..))")  // can select signature of methode here
    public void StudentRepositoryMethod() {


    }

    @Pointcut("within(com.example.demo.studnet.StudentService)")   // just class(Type)
    public void StudentServiceMethods() {

    }

    @Pointcut("execution(* *..find*(Long))")  // method only with Long Parameter and it's name start with find
    public void fooMethod() {
    }

    @Pointcut("execution(* *..find*(Long,..))") // method it's first parameter is Long
    public void fooMethod2() {
    }

    @Pointcut("@annotation(com.example.demo.AOP.Loggable)") // method where Loggable annotation beig put on
    public void loggableMethods() {
    }


    @Pointcut("@target(org.springframework.stereotype.Repository)")
    public void repositoryMethods() {
    }

    @Pointcut("execution(* *..create*(Long,..))")
    public void firstLongParamMethods() {
    }

    @Pointcut("repositoryMethods() && firstLongParamMethods()")
    public void entityCreationMethods() {
    }

    // WE ALSO HAVE TARGET , THIS .
}
