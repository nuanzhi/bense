package com.lsege.controller.sys;

import com.github.pagehelper.PageHelper;
import com.lsege.controller.BaseController;
import com.lsege.entity.JsonResult;
import com.lsege.entity.Page;
import com.lsege.entity.sys.Dictionary;
import com.lsege.entity.sys.DictionaryData;
import com.lsege.service.sys.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public JsonResult getDictChild(Long dictValue,Integer pageNum,Integer pageSize){
        JsonResult jsonResult=new JsonResult();

        if((dictValue+"").equals("0")){
            try{
                PageHelper.startPage(pageNum,pageSize+1);
                List<Dictionary> topmenus=dictService.selectDictList();
                List<DictionaryData> dictionaryDatas=new ArrayList<>();
                Long total=dictService.getDictTotal();
                Long sid=1l;
                for(int i=0;i<topmenus.size();i++){
                    if(topmenus.get(i).getDictValue()!=0){
                        DictionaryData dictionaryData=new DictionaryData();
                        dictionaryData.setDictDataName(topmenus.get(i).getDictName());
                        dictionaryData.setDictDataValue(topmenus.get(i).getDictValue()+"");
                        dictionaryData.setId(sid);
                        dictionaryDatas.add(dictionaryData);
                        sid++;
                    }

                }
                Map<String,Object> maps = new HashMap<>();
                maps.put("topMenus",topmenus);
                maps.put("page",new Page(dictionaryDatas,total,pageSize+1,pageNum));
                jsonResult.setData(maps);
                jsonResult.setSuccess(true);
                jsonResult.setMessage("获取成功");

            }catch (Exception e){
                jsonResult.setSuccess(false);
                jsonResult.setMessage("获取失败");
            }

        }else{
            try{
                PageHelper.startPage(pageNum,pageSize);
                List<DictionaryData> dictionaryDatas=dictService.getDictChild(dictValue);
                List<Dictionary> topmenus=dictService.selectDictList();
                Long total=dictService.getDictChildTotal(dictValue);
                Map<String,Object> maps = new HashMap<>();
                maps.put("topMenus",topmenus);
                maps.put("page",new Page(dictionaryDatas,total,pageSize,pageNum));
                jsonResult.setData(maps);
                jsonResult.setSuccess(true);
                jsonResult.setMessage("获取成功");
            }catch (Exception e){
                jsonResult.setSuccess(false);
                jsonResult.setMessage("获取失败");
            }
        }

        return jsonResult;
    }
    @PostMapping(value="/addMenu")
    public JsonResult addMenu(Long dictValue,String dictDataName,String dictDataValue,Long isfixed){
        JsonResult json=new JsonResult();

        if((dictValue+"").equals("0")){
            Dictionary dictionary=new Dictionary();
            dictionary.setDictName(dictDataName);
            dictionary.setDictValue(Long.valueOf(dictDataValue));
            dictService.insertTopDict(dictionary);
            json.setData(dictionary);
            json.setSuccess(true);
            json.setMessage("添加成功");
        }else{
            DictionaryData dictionaryData=new DictionaryData();
            dictionaryData.setDictValue(dictValue);
            dictionaryData.setDictDataName(dictDataName);
            dictionaryData.setDictDataValue(dictDataValue);
            dictionaryData.setIsFixed(0);
            dictService.insertDict(dictionaryData);
            json.setData(dictionaryData);
            json.setSuccess(true);
            json.setMessage("添加成功");
        }

        return json;
    }
    @PostMapping(value="/deldict")
    public JsonResult deldict(Long id){

        JsonResult json=new JsonResult();
        dictService.deldict(id);
        json.setSuccess(true);
        json.setMessage("删除成功");
        return json;
    }
    @PostMapping(value="/delTopDict")
    public JsonResult delTopDict(Long id,Long delTopDict){
        JsonResult json=new JsonResult();
        dictService.delTopDict(delTopDict);
        json.setSuccess(true);
        json.setMessage("删除成功");
        return json;
    }
}
