package com.winterchen.controller;

import com.winterchen.model.MedImageDomain;
import com.winterchen.model.ReturnMsg;
import com.winterchen.service.med.MedImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by Administrator on 2017/8/16.
 */
@RestController
@RequestMapping(value = "/med/image")
@Api(value = "图片处理", tags = {"图片处理"})
public class MedImageApiController {

    @Autowired
    private MedImageService medImageService;


    @PostMapping(value = "/resetHeadPortrait", headers = "content-type=multipart/form-data")
    @ApiOperation(value = "文件上传", notes = "文件上传")
    public ReturnMsg<MedImageDomain> filesUpload(@ApiParam(name = "pic", value = "图片", required = true) @RequestParam(name = "pic") MultipartFile pic) {
        if (pic == null) {
            return new ReturnMsg<>(-1,null,"图片不能为空");
        }
        //上传文件
        MedImageDomain medImageDomain = new MedImageDomain();
        try {
            medImageDomain.setContentType(pic.getContentType());
            medImageDomain.setCreateTime(new Timestamp(System.currentTimeMillis()));
            medImageDomain.setImgName(UUID.randomUUID().toString()+pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf(".")));
            medImageDomain.setContent(pic.getBytes());
            medImageService.saveImage(medImageDomain);
        } catch (Exception e) {
            return new ReturnMsg<>(-1,null,"上传失败");
        }
        return new ReturnMsg<>(medImageDomain);
    }

    @ResponseBody
    @GetMapping("/getImage")
    @ApiOperation(value = "图片文件获取", notes = "图片文件获取")
    public void getImage(@RequestParam(name = "id") Long id, HttpServletResponse response){
        try {
            MedImageDomain medImageDomain = medImageService.getImage(id);

            //response.setContentType("image/jpeg");
            response.setContentType(medImageDomain.getContentType());
            response.setCharacterEncoding("UTF-8");
            OutputStream outputSream = response.getOutputStream();
            InputStream in = new ByteArrayInputStream(medImageDomain.getContent());
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = in.read(buf, 0, 1024)) != -1) {
                outputSream.write(buf, 0, len);
            }
            outputSream.flush();
            outputSream.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
