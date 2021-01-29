package com.cloud.oss.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    String upLoadFileAvatar(MultipartFile file);
}
