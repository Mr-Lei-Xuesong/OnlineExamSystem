package com.xihua.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xihua.dao.CommonDao;
import com.xihua.dao.ExamManageDao;
import com.xihua.entity.dto.ExamPaperDTO;
import com.xihua.entity.model.ExamManage;
import com.xihua.service.ExamManageService;
import com.xihua.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:   lxs
 * Date:     2021/12/21 19:15
 * Description: 考试管理业务实现层
 */
@Service
public class ExamMangeServiceImpl implements ExamManageService {

    @Autowired
    private ExamManageDao examManageDao;
    @Autowired
    private CommonDao commonDao;

    @Override
    public JsonResult findExamById(Integer examId) {
        if (ObjectUtil.isNull(examId)) {
            return JsonResult.error("考试编号不能为空");
        }
        ExamManage exam = examManageDao.findExamById(examId);
        return JsonResult.success("查询成功", exam);
    }

    @Transactional
    @Override
    public JsonResult addExamInfo(ExamManage examManage) {
        if (BeanUtil.isEmpty(examManage)) {
            return JsonResult.error("添加的数据为空");
        }
        examManageDao.insert(examManage);
        return JsonResult.success("添加成功", examManage.getExamId());
    }

    @Override
    public JsonResult queryAllExam(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ExamManage> examManages = examManageDao.queryAllExam();
        if (ObjectUtil.isEmpty(examManages)) {
            return JsonResult.error("未查询到数据");
        }
        PageInfo<ExamManage> examManagePageInfo = new PageInfo<>(examManages);
        return JsonResult.success("查询成功", examManagePageInfo);
    }

    @Transactional
    @Override
    public JsonResult updateExam(ExamManage examManage) {
        if (ObjectUtil.isNull(examManage.getExamId())) {
            return JsonResult.error("未指定更新数据");
        }
        int update = examManageDao.updateByPrimaryKeySelective(examManage);
        if (update == 0) {
            return JsonResult.error("修改失败");
        }
        return JsonResult.success("修改成功");
    }

    @Transactional
    @Override
    public JsonResult deleteExam(Integer examId) {
        if (ObjectUtil.isNull(examId)) {
            return JsonResult.error("未指定删除数据");
        }
        int delete = examManageDao.deleteByPrimaryKey(examId);
        if (delete != 0) {
            List<ExamPaperDTO> examPaper = commonDao.findExamPaper(examId);
            if (ObjectUtil.isNotEmpty(examPaper)) {
                int i = commonDao.deleteExamPaper(examId);
            }
            return JsonResult.success("删除成功");
        }
        return JsonResult.error("删除失败");
    }
}
