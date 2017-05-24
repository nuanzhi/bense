package com.lsege.controller.sys;

import com.lsege.controller.BaseController;
import com.lsege.entity.JsonResult;
import com.lsege.entity.sys.DictionaryData;
import com.lsege.service.sys.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Dictionary;
import java.util.List;

/**
 * Created by zhanglei on 2017/5/22.
 */
@RestController
@RequestMapping(value ="/dict")
public class DictController extends BaseController {
    @Autowired
    DictService dictService;
    @GetMapping(value ="/dictList")
    public JsonResult dictList(){
        JsonResult json = new JsonResult();
        List<Dictionary> dict=dictService.selectDictList();
        json.setData(dict);
        json.setSuccess(true);
        json.setMessage("获取成功");
        return json;
    }
    @GetMapping(value ="/getDictChild")
    public JsonResult getDictChild(Long dictValue){
        JsonResult jsonResult=new JsonResult();
        try{
            List<DictionaryData> dictionaryDatas=dictService.getDictChild(dictValue);
            jsonResult.setData(dictionaryDatas);
            jsonResult.setSuccess(true);
            jsonResult.setMessage("获取成功");
        }catch (Exception e){
            jsonResult.setSuccess(false);
            jsonResult.setMessage("获取失败");
        }
        return jsonResult;
    }
    @PostMapping(value="/addMenu")
    public JsonResult addMenu(Long dictValue,String dictDataName,String dictDataValue,String isfixed){
        JsonResult json=new JsonResult();

        if(dictValue.equals(0)){
            System.out.println(dictValue+"！！"+dictDataName+"！！"+dictDataValue+"！！"+isfixed);
        }else{
            System.out.println(dictValue+"**"+dictDataName+"**"+dictDataValue+"**"+isfixed);
        }

        return json;
    }

}
