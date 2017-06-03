package com.taotao.service;

import com.taotao.pojo.TbItem;
import com.taotao.common.pojo.EUDataGridResult;

/**
 * Created by Victor on 2017/6/3.
 */
public interface ItemService {
    TbItem getItemById(long itemId);
    EUDataGridResult getItemList(int page, int rows);
}
