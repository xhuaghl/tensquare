package com.tensquare.recruit.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.recruit.dao.EnterpriseDao;
import com.tensquare.recruit.dto.EnterpriseDto;
import com.tensquare.recruit.entity.Enterprise;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import util.IdWorker;

import java.util.List;

/**
 * 企业(TbEnterprise)表服务实现类
 *
 * @author makejava
 * @since 2020-03-14 10:32:28
 */
@Service
@Transactional
@AllArgsConstructor
public class EnterpriseService {

    private final EnterpriseDao enterpriseDao;
    private final IdWorker idWorker;

    public void insert(Enterprise enterprise) {
        enterprise.setId(idWorker.nextId() + "");
        enterpriseDao.insert(enterprise);
    }

    public List<Enterprise> selectList() {
        return enterpriseDao.selectList(null);
    }

    public Enterprise selectById(String enterpriseId) {
        return enterpriseDao.selectById(enterpriseId);
    }

    public void update(Enterprise enterprise) {
        enterpriseDao.update(enterprise, null);
    }

    public void deleteById(String enterpriseId) {
        enterpriseDao.deleteById(enterpriseId);
    }

    public List<Enterprise> selectHotList() {
        QueryWrapper<Enterprise> qw = new QueryWrapper<>();
        qw.eq("ishot", "1");
        return enterpriseDao.selectList(qw);
    }

    public List<Enterprise> search(Enterprise enterprise) {
        return enterpriseDao.selectList(setWrapper(enterprise));
    }

    public Page<Enterprise> searchPage(Integer page, Integer size, Enterprise enterprise) {
        QueryWrapper qw = setWrapper(enterprise);
        Page<Enterprise> enterprisePage = new Page<>(page - 1, size);
        return enterpriseDao.selectPage(enterprisePage, qw);
    }

    private QueryWrapper setWrapper(Enterprise enterprise) {
        EnterpriseDto enterpriseDto = new EnterpriseDto();
        BeanUtils.copyProperties(enterprise, enterpriseDto);
        QueryWrapper<Enterprise> qw = new QueryWrapper<>();
        qw.like(!StringUtils.isEmpty(enterpriseDto.getName()), "name", enterpriseDto.getName())
                .like(!StringUtils.isEmpty(enterpriseDto.getSummary()), "summary", enterpriseDto.getSummary())
                .like(!StringUtils.isEmpty(enterpriseDto.getLabels()), "labels", enterpriseDto.getLabels());
        return qw;
    }


}