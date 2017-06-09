package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.dao.TbItemDescMapper;
import com.taotao.dao.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import com.taotao.common.pojo.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Victor on 2017/6/3.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    TbItemMapper tbItemMapper;

    @Autowired
    TbItemDescMapper tbItemDescMapper;
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

    public TaotaoResult createItem(TbItem tbitem,String desc) {
        //item不全2
        //生成商品ID
        long  itemId= IDUtils.genItemId();
        tbitem.setId(itemId);
        //商品的状态
        tbitem.setStatus((byte)1);
        tbitem.setCreated(new Date());
        tbitem.setUpdated(new Date());
        tbItemMapper.insert(tbitem);
        TaotaoResult result=insertItemDesc(itemId,desc);
        if(result.getStatus()!=200){
            throws new Exception();
        }
        return TaotaoResult.ok();
    }
    private  TaotaoResult insertItemDesc(long itemId,String desc){
        TbItemDesc itemDesc=new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        tbItemDescMapper.insert(itemDesc);
        return TaotaoResult.ok();
    }
}
