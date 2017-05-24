package com.lsege.service.sys;

import com.lsege.entity.sys.DictionaryData;
import com.lsege.mapper.sys.DictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.List;

/**
 * Created by zhanglei on 2017/5/22.
 */
@Service
public class DictServiceImpl implements DictService{

    @Autowired
    DictMapper dictMapper;
    @Override
    public List<Dictionary> selectDictList() {
        return dictMapper.selectDictList();
    }

    @Override
    public List<DictionaryData> getDictChild(Long dictValue) {
        return dictMapper.getDictChild(dictValue);
    }
}
