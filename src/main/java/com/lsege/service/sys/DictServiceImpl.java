package com.lsege.service.sys;

import com.lsege.entity.sys.DictionaryData;
import com.lsege.mapper.sys.DictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsege.entity.sys.Dictionary;
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

    @Override
    public Long insertDict(DictionaryData dictionaryData) {
        return dictMapper.insertDict(dictionaryData);
    }

    @Override
    public Long insertTopDict(Dictionary dictionary) {
        return dictMapper.insertTopDict(dictionary);
    }

    @Override
    public Long deldict(Long id) {
        return dictMapper.deldict(id);
    }

    @Override
    public Long delTopDict(Long dictValue) {
        return dictMapper.delTopDict(dictValue);
    }

    @Override
    public Long getDictChildTotal(Long dictValue) {
        return dictMapper.getDictChildTotal(dictValue);
    }

    @Override
    public Long getDictTotal() {
        return dictMapper.getDictTotal();
    }
}
