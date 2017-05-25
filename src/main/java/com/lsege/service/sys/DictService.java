package com.lsege.service.sys;

import com.lsege.entity.sys.DictionaryData;

import com.lsege.entity.sys.Dictionary;
import java.util.List;

/**
 * Created by zhanglei on 2017/5/22.
 */
public interface DictService {
    List<Dictionary> selectDictList();
    List<DictionaryData> getDictChild(Long dictValue);
    Long insertDict(DictionaryData dictionaryData);
    Long insertTopDict(Dictionary dictionary);
    Long deldict(Long id);
    Long delTopDict(Long dictValue);
    Long getDictChildTotal(Long dictValue);
    Long getDictTotal();
}
