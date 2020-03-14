package com.tensquare.base.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/label")
@CrossOrigin //跨域
public class LabelController {

    private final LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping("")
    public Result findAll() {

        return new Result(true, StatusCode.ok, "查询成功", labelService.finAll());
    }

    @GetMapping("{labelId}")
    public Result findById(@PathVariable("labelId") String labelId) {

        return new Result(true, StatusCode.ok, "查询成功", labelService.finById(labelId));
    }

    @PostMapping
    public Result insert(@RequestBody Label label) { //@RequestBody用来获取前端返回的json，将其转成Label对象
        labelService.Insert(label);
        return new Result(true, StatusCode.ok, "添加成功");
    }

    @PutMapping("{labelId}")
    public Result update(@PathVariable("labelId") String labelId, @RequestBody Label label) {
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.ok, "修改成功");
    }

    @DeleteMapping("{labelId}")
    public Result delById(@PathVariable("labelId") String labelId) {
        labelService.delById(labelId);
        return new Result(true, StatusCode.ok, "删除成功");
    }

    @PostMapping("search")
    public Result search(@RequestBody Label label) {
        return new Result(true, StatusCode.ok, "查询成功", labelService.finSearch(label));
    }

    @PostMapping("search/{page}/{size}")
    public Result searchPage(@PathVariable("page") Integer page,
                             @PathVariable("size") Integer size,
                             @RequestBody Label label) {
        Page<Label> pageData = labelService.pageQuery(label, page, size);
        return new Result(true, StatusCode.ok, "查询成功",
                new PageResult<Label>(pageData.getTotal(), pageData.getRecords()));
    }
}
