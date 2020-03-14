package com.tensquare.base.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.base.dao.LabelDAO;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.dto.LabelDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import util.IdWorker;

import java.util.List;

@Service
@Transactional //??????
public class LabelService {
    final
    LabelDAO labelDAO;

    final
    IdWorker idWorker;

    public LabelService(LabelDAO labelDAO, IdWorker idWorker) {
        this.labelDAO = labelDAO;
        this.idWorker = idWorker;
    }

    public List<Label> selectList() {
        return labelDAO.selectList(null);
    }

    public Label selectById(String id) {
        return labelDAO.selectById(id);
    }

    public void Insert(Label label) {
        label.setId(idWorker.nextId() + ""); //让其生成下一个ID
        labelDAO.insert(label);
    }

    public void update(Label label) {
        labelDAO.updateById(label);  //save既能保存也能更新，如果对象内有id则保存，无id则更新
    }

    public void delById(String id) {
        labelDAO.deleteById(id);
    }

    public List<Label> selectSearch(Label label) {
        return labelDAO.selectList(setWrapper(label));
    }

    /*
      要写分页配置检索，必须在MyBatis-Plus配置类里复写PaginationInterceptor方法
     */
    public Page<Label> selectPage(Label label, Integer page, Integer size) {
        /*
            sql语句中limit是从游标第a行开始，取b条数目。
            这里page-1是因为数据库行数是0开始，
            所以limit对应的页面则是第page页，本页有size条数目。
         */
        Page<Label> labelPage = new Page<Label>(page - 1, size);
        return labelDAO.selectPage(labelPage, setWrapper(label));
    }

    private QueryWrapper setWrapper(Label label) {
        LabelDto labelDto = new LabelDto();
        BeanUtils.copyProperties(label, labelDto);
        QueryWrapper<Label> qw = new QueryWrapper<>();
        /*
          like(boolean condition, R column, Object val);
          第一个参数是判断like条件是否执行的依据，真则执行like，否则不执行;
          第二个参数是表中的列名;
          第三个参数是要对比的值;
         */
        qw.like(!StringUtils.isEmpty(labelDto.getLabelname()),
                "labelname", labelDto.getLabelname());
        return qw;
    }
}
