package com.tensquare.recruit.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.recruit.entity.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 企业(Enterprise)表控制层
 *
 * @author makejava
 * @since 2020-03-14 10:32:29
 */
@RestController
@RequestMapping("enterprise")
@CrossOrigin //跨域
@AllArgsConstructor
public class EnterpriseController {
    /**
     * 服务对象
     */
    private final EnterpriseService enterpriseService;


    @PostMapping()
    public Result insert(@RequestBody Enterprise enterprise) {
        enterpriseService.insert(enterprise);
        return new Result(true, StatusCode.ok, "添加成功");
    }

    @GetMapping
    public Result selectList() {

        return new Result(true, StatusCode.ok, "查询成功", enterpriseService.selectList());
    }

    @GetMapping("{enterpriseId}")
    public Result selectById(@PathVariable String enterpriseId) {
        return new Result(true, StatusCode.ok, "查询成功", enterpriseService.selectById(enterpriseId));
    }

    @PutMapping("{enterpriseId}")
    public Result update(@PathVariable String enterpriseId, @RequestBody Enterprise enterprise) {
        enterprise.setId(enterpriseId);
        enterpriseService.update(enterprise);
        return new Result(true, StatusCode.ok, "更新成功");
    }

    @DeleteMapping("{enterpriseId}")
    public Result deleteById(@PathVariable String enterpriseId) {
        enterpriseService.deleteById(enterpriseId);
        return new Result(true, StatusCode.ok, "删除成功");
    }

    @GetMapping("search/hotlist")
    public Result hotEntList() {
        return new Result(true, StatusCode.ok, "查询成功", enterpriseService.selectHotList());
    }

    @PostMapping("search")
    public Result search(@RequestBody Enterprise enterprise) {
        return new Result(true, StatusCode.ok, "查询成功", enterpriseService.search(enterprise));
    }

    @PostMapping("search/{page}/{size}")
    public Result searchPage(@PathVariable Integer page, @PathVariable Integer size,
                             @RequestBody Enterprise enterprise) {
        Page<Enterprise> enterprisePage = enterpriseService.searchPage(page, size, enterprise);
        PageResult<Enterprise> pageResult = new PageResult<>(enterprisePage.getTotal(), enterprisePage.getRecords());
        return new Result(true, StatusCode.ok, "查询成功", pageResult);
    }
}