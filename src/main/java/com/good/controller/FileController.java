package com.good.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by dai on 2017/3/17.
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request,HttpServletResponse response){
        long startTime=System.currentTimeMillis();   //获取开始时间

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(multipartResolver.isMultipart(request)){ //判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            Iterator<String> ite = multiRequest.getFileNames();
            while(ite.hasNext()){
                MultipartFile file = multiRequest.getFile(ite.next());
                if(file!=null){
                    File localFile = new File("D:/"+file.getOriginalFilename());
                    try {
                        file.transferTo(localFile); //将上传文件写到服务器上指定的文件
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("上传文件共使用时间："+(endTime-startTime));

        return "user/success";
    }
}
