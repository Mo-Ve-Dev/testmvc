package com.mvctest.testmvc.controller;

public class ApiResponse<T> {
  private String message;
  private T data;

  public ApiResponse(String message, T data) {
    this.message = message;
    this.data = data;
  }

  public ApiResponse(String message) {
    this.message = message;
    this.data = null;
  }

  public T getData() {
    return data;
  }

  public String getMessage() {
    return message;
  }
}
