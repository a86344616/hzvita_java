package com.example.hzvita.controller;

import com.example.hzvita.utils.FileUploadUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class PictureController {
    @ApiOperation("图片上传")
    @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "File")
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
            //定义要上传文件 的存放路径
            String localPath="D:/git-depository/upload";
            //获得文件名字
            String fileName=file.getOriginalFilename();
            //文件名=localpath+fileName
            File dest = new File(localPath + fileName);
            if(FileUploadUtil.upload(file, localPath, fileName)){
                // 将上传的文件写入到服务器端文件夹
                // 获取当前项目的完整url
                String requestURL = request.getRequestURL().toString();
                // 获取当前项目的请求路径url
                String requestURI = request.getRequestURI();
                // 得到去掉了uri的路径
                String url = requestURL.substring(0, requestURL.length()-requestURI.length() + 1);
                url= localPath+fileName;
                return url;
            }

        return "未知错误";
    }

}
