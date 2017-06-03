package com.taotao.controller;

import com.taotao.service.PictureService;
import com.taotao.common.pojo.PictureResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Victor on 2017/6/3.
 */
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public PictureResult upload(MultipartFile uploadFile){
        PictureResult result= (PictureResult) pictureService.uploadPicture(uploadFile);
        return result;
    }
}
