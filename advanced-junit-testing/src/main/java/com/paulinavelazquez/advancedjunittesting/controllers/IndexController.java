package com.paulinavelazquez.advancedjunittesting.controllers;

public class IndexController {

    public String index() {
        return "index";
    }

    public String oopsHandlerNotImplemented() {
        return "notimplemented";
    }

    public void exceptionHandler() {
        throw new ValueNotFoundException();
    }
}
