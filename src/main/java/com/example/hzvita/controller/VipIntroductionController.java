package com.example.hzvita.controller;

import com.example.hzvita.Dao.VipIntroductionDao;
import com.example.hzvita.bean.VipIntroduction;
import com.example.hzvita.utils.FileUploadUtil;
import com.example.hzvita.utils.JsonUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
@RestController
@RequestMapping("/vipIntroduction")
public class VipIntroductionController {
    @Resource
    VipIntroductionDao vipIntroductionDao;

    @GetMapping("/getAll")
    public List<VipIntroduction> getAll(){
        List<VipIntroduction> vipIntroductionList = vipIntroductionDao.findAll();
        return vipIntroductionList;

    }

    @PostMapping("/add")
    public VipIntroduction add(
            @RequestBody String json
    ){
        VipIntroduction vipIntroduction = null;
        try {
            vipIntroduction = (VipIntroduction) JsonUtils.jsonToObj(new VipIntroduction(),json);
            vipIntroductionDao.save(vipIntroduction);
        }catch (Exception e){
            System.out.println(e);
        }
        return vipIntroduction;
    }





    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id){
        VipIntroduction vipIntroduction = new VipIntroduction();
        vipIntroduction.setId(id);
        vipIntroductionDao.delete(vipIntroduction);
        return "删除成功";
    }
}
