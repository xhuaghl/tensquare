package com.tensquare.recruit.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.recruit.entity.Recruit;
import com.tensquare.recruit.service.RecruitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("recruit")
@AllArgsConstructor
@CrossOrigin
/**
 * 招聘页面控制器
 */
public class RecruitController {

    private final RecruitService recruitService;

    @PostMapping()
    public Result insert(@RequestBody Recruit recruit) {
        recruitService.insert(recruit);
        return new Result(true, StatusCode.ok, "添加成功");
    }

    @GetMapping
    public Result selectList() {
        return new Result(true, StatusCode.ok, "查询成功", recruitService.selectList());
    }

    @GetMapping("{recruitId}")
    public Result selectById(@PathVariable String recruitId) {
        return new Result(true, StatusCode.ok, "查询成功", recruitService.selectById(recruitId));
    }

    @PutMapping("{recruitId}")
    public Result update(@PathVariable String recruitId, @RequestBody Recruit recruit) {
        recruit.setId(recruitId);
        recruitService.update(recruit);
        return new Result(true, StatusCode.ok, "更新成功");
    }

    @DeleteMapping("{recruitId}")
    public Result delectById(@PathVariable String recruitId) {
        recruitService.deleteById(recruitId);
        return new Result(true, StatusCode.ok, "删除成功");
    }

    @GetMapping("search/recommend")
    public Result recommend() {
        return new Result(true, StatusCode.ok, "查询成功", recruitService.recommend());
    }

    @GetMapping("search/newlist")
    public Result newList() {
        return new Result(true, StatusCode.ok, "查询成功", recruitService.newList());
    }

    @PostMapping("search")
    public Result search(@RequestBody Recruit recruit) {
        return new Result(true, StatusCode.ok, "查询成功", recruitService.search(recruit));

    }

    @PostMapping("search/{page}/{size}")
    public Result search(@PathVariable Integer page, @PathVariable Integer size,
                         @RequestBody Recruit recruit) {
        Page<Recruit> recruitPage = recruitService.searchPage(page, size, recruit);
        PageResult<Recruit> pageResult = new PageResult<>(recruitPage.getTotal(), recruitPage.getRecords());
        return new Result(true, StatusCode.ok, "查询成功", pageResult);

    }
}
