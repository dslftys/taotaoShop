package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.dao.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import com.taotao.utils.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Victor on 2017/6/3.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    TbItemMapper tbItemMapper;
    public TbItem getItemById(long itemId) {
        //直接id查询
        //TbItem tbItem=tbItemMapper.selectByPrimaryKey(itemId);
        //条件查询
        TbItemExample tbItemExample=new TbItemExample();
        TbItemExample.Criteria criteria=tbItemExample.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list=tbItemMapper.selectByExample(tbItemExample);
        if(list!=null&&list.size()>0){
            TbItem tbItem=list.get(0);
            return tbItem;
        }
        return null;
    }

    /**
     * 商品列表查询
     * @param page
     * @param rows
     * @return
     */
    public EUDataGridResult getItemList(int page, int rows) {
        //商品列表查询
        TbItemExample tbItemExample=new TbItemExample();
        //分页处理
        PageHelper.startPage(page,rows);
        List<TbItem> list=tbItemMapper.selectByExample(tbItemExample);

        //创建一个返回值对象
        EUDataGridResult result=new EUDataGridResult();
        result.setRows(list);
        //记录总条数
        PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
