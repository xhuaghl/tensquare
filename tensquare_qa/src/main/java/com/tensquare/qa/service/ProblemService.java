package com.tensquare.qa.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.entity.Problem;
import com.tensquare.qa.dto.ProblemDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
public class ProblemService {

    private final ProblemDao problemDao;
    private final IdWorker idWorker;

    public ProblemService(ProblemDao problemDao, IdWorker idWorker) {
        this.problemDao = problemDao;
        this.idWorker = idWorker;
    }


    public void insert(Problem problem) {
        problem.setId(idWorker.nextId() + "");
        problemDao.insert(problem);
    }

    public List<Problem> selectList() {
        return problemDao.selectList(null);
    }

    public Problem selectById(String problemId) {
        return problemDao.selectById(problemId);
    }

    public void update(Problem problem) {
        problemDao.update(problem, null);
    }

    public void deleteById(String problemId) {
        problemDao.deleteById(problemId);
    }

    public List<Problem> search(Problem problem) {
        QueryWrapper<Problem> qw = setSelectWrapper(problem);
        return problemDao.selectList(qw);
    }

    public Page<Problem> selectPage(Integer page, Integer size, Problem problem) {
        QueryWrapper<Problem> qw = setSelectWrapper(problem);
        Page<Problem> problemPage = new Page<>(page - 1, size);
        return problemDao.selectPage(problemPage, qw);
    }

    //设置问题的标题和内容条件控制器
    private QueryWrapper setSelectWrapper(Problem problem) {
        ProblemDto problemDto = new ProblemDto();
        BeanUtils.copyProperties(problem, problemDto);
        QueryWrapper<Problem> qw = new QueryWrapper<>();
        qw.like(!StringUtils.isEmpty(problemDto.getTitle()),
                "title", problemDto.getTitle())
                .like(!StringUtils.isEmpty(problemDto.getContent()),
                        "content", problemDto.getContent());
        return qw;
    }

    public IPage<Problem> newList(Integer page, Integer size, String LabelId) {
        Page<Problem> problemPage = new Page<>(page - 1, size);
        IPage<Problem> problemIPage = problemDao.newList(problemPage, LabelId);
        return problemIPage;
    }

    public Object hotList(Integer page, Integer size, Integer labelId) {
        Page<Problem> problemPage = new Page<>(page - 1, size);
        return problemDao.hotList(problemPage, labelId);
    }


}
