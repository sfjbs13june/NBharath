package com.bharath.app.process;

import org.springframework.stereotype.Component;

@Component
public class MyCalculator {

    public String addString(String str1,String str2){
        return str1+str2;
    }


    public float averageData(int data1,int data2){
        return (data1+data2)/2;
    }
}
