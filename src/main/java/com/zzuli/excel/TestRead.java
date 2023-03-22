package com.zzuli.excel;

import com.alibaba.excel.EasyExcel;
import org.springframework.security.core.userdetails.User;

public class TestRead {

    public static void main(String[] args) {
        //设置文件名称和路径
        String fileName = "D:\\zzuli.xlsx";
        //调用方法进行读操作
        EasyExcel.read(fileName, User.class,new ExcelListener()).sheet().doRead();
    }
}
