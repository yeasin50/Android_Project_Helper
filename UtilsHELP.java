package com.example.sql.UTILS;


import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsHELP {


    public String getIDTYPE(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String datet = sdf.format(new Date());
        return datet;
    };

}
