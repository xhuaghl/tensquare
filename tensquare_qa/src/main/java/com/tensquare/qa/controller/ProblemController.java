package com.tensquare.qa.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.qa.entity.Problem;
import com.tensquare.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import jdk.net.SocketFlow;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("problem")
@CrossOrigin
public class ProblemController {
    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    //多表插入
    @PostMapping()
    public Result insert(@RequestBody Problem problem) {
        problemService.insert(problem);
        return new Result(true, StatusCode.ok, "添加成功");
    }

    @GetMapping()
    public Result selectList() {
        return new Result(true, StatusCode.ok, "查询成功", problemService.selectList());
    }

    @GetMapping("{problemId}")
    public Result selectById(@PathVariable String problemId) {
        return new Result(true, StatusCode.ok, "查询成功", problemService.selectById(problemId));
    }

    @PutMapping("{problemId}")
    public Result update(@PathVariable String problemId, @RequestBody Problem problem) {
        problem.setId(problemId);
        problemService.update(problem);
        return new Result(true, StatusCode.ok, "更新成功");
    }

    @DeleteMapping("{problemId}")
    public Result deleteById(@PathVariable String problemId) {
        problemService.deleteById(problemId);
        return new Result(true, StatusCode.ok, "删除成功");
    }

    @PostMapping("search")
    public Result search(@RequestBody Problem problem) {
        return new Result(true, StatusCode.ok, "查询成功", problemService.search(problem));

    }

    @PostMapping("search/{page}/{size}") //问题分页
    public Result selectPage(@PathVariable Integer page, @PathVariable Integer size,
                             @RequestBody Problem problem) {
        Page<Problem> problemPage = problemService.selectPage(page, size, problem);
        PageResult<Problem> pageResult = new PageResult<>(problemPage.getTotal(), problemPage.getRecords());
        return new Result(true, StatusCode.ok, "查询成功", pageResult);
    }

    @GetMapping("newlist/{labelId}/{page}/{size}")
    public Result newList(@PathVariable String labelId, @PathVariable Integer page,
                          @PathVariable Integer size) {
        Page<Problem> problemPage = (Page<Problem>) problemService.newList(page, size, labelId);
        PageResult<Problem> pageResult = new PageResult<>(problemPage.getTotal(), problemPage.getRecords());
        return new Result(true, StatusCode.ok, "查询成功", pageResult);
    }

    @GetMapping("hotlist/{labelId}/{page}/{size}")
    public Result hotList(@PathVariable Integer labelId, @PathVariable Integer page,
                          @PathVariable Integer size){
        Page<Problem> problemPage = (Page<Problem>) problemService.hotList(page, size, labelId);
        PageResult<Problem> pageResult = new PageResult<>(problemPage.getTotal(), problemPage.getRecords());
        return new Result(true, StatusCode.ok, "查询成功", pageResult);
    }

}
