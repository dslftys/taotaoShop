package com.taotao.controller;

import com.taotao.service.ItemCatService;
import com.taotao.utils.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Victor on 2017/6/3.
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<TreeNode> getItemCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
        List<TreeNode> list = itemCatService.getItemCatList(parentId);
        return list;
    }

}
