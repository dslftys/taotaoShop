package com.taotao.service;

import com.taotao.utils.TreeNode;

import java.util.List;

/**
 * Created by Victor on 2017/6/3.
 */
public interface ItemCatService {
    public List<TreeNode> getItemCatList(long parentId);

}
