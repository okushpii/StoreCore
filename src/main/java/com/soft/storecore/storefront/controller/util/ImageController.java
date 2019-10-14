package com.soft.storecore.storefront.controller.util;

import com.soft.storecore.facade.media.ImageFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/image")
public class ImageController {

    @Resource
    private ImageFacade imageFacade;

    @ResponseBody
    @GetMapping("/{imageCode}")
    public byte[] getImage(@PathVariable String imageCode,
                           @RequestParam(required = false) String imageFormat) {
       return imageFacade.findImage(imageCode, imageFormat);
    }
}
