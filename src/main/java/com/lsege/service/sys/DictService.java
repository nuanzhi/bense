package com.lsege.service.sys;

import com.lsege.entity.sys.DictionaryData;

import java.util.Dictionary;
import java.util.List;

/**
 * Created by zhanglei on 2017/5/22.
 */
public interface DictService {
    List<Dictionary> selectDictList();
    List<DictionaryData> getDictChild(Long dictValue);
}
