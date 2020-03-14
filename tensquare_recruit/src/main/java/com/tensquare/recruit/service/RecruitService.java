package com.tensquare.recruit.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.dto.RecruitDto;
import com.tensquare.recruit.entity.Recruit;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import util.IdWorker;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RecruitService {

    private final IdWorker idWorker;
    private final RecruitDao recruitDao;


    public void insert(Recruit recruit) {
        recruit.setId(idWorker.nextId() + "");
        recruitDao.insert(recruit);
    }

    public List<Recruit> selectList() {
        return recruitDao.selectList(null);
    }

    public Recruit selectById(String recruitId) {
        return recruitDao.selectById(recruitId);
    }

    public void update(Recruit recruit) {
        recruitDao.update(recruit, null);
    }

    public void deleteById(String recruitId) {
        recruitDao.deleteById(recruitId);
    }

    public List<Recruit> newList() {
        QueryWrapper<Recruit> qw = new QueryWrapper<>();
        qw.ne("state", "0");
        qw.orderByDesc("createtime");
        return recruitDao.selectList(qw);
    }

    public List<Recruit> recommend() {
        QueryWrapper<Recruit> qw = new QueryWrapper<>();
        qw.eq("state", "2");
        return recruitDao.selectList(qw);
    }

    public List<Recruit> search(Recruit recruit) {
        return recruitDao.selectList(setWrapper(recruit));
    }

    public Page searchPage(Integer page, Integer size, Recruit recruit) {
        Page<Recruit> recruitPage = new Page<>(page - 1, size);
        return recruitDao.selectPage(recruitPage, setWrapper(recruit));
    }

    private QueryWrapper setWrapper(Recruit recruit) {
        RecruitDto recruitDto = new RecruitDto();
        BeanUtils.copyProperties(recruit, recruitDto);
        QueryWrapper qw = new QueryWrapper();
        qw.like(!StringUtils.isEmpty(recruitDto.getJobname()), "jobname", recruitDto.getJobname());
        return qw;
    }
}
