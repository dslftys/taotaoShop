package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by Victor on 2017/6/3.
 */
public interface PictureService {
    Map uploadPicture(MultipartFile uploadFile);
}
