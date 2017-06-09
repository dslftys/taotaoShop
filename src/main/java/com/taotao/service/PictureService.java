package com.taotao.service;

import com.taotao.common.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by Victor on 2017/6/3.
 */
public interface PictureService {
    PictureResult uploadPicture(MultipartFile uploadFile);
}
