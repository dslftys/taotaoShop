package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParam;

/**
 * Created by Victor on 2017/6/3.
 */
public interface ItemParamService {
    TaotaoResult getItemParamByCid(long cid);
    TaotaoResult insertItemParam(TbItemParam itemParam);
    TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
}
