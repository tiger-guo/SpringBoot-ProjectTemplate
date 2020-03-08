package com.organization.projectName.service;

import java.util.List;

/**
 * @program: springboot-learn-shiyanlou
 * @description:
 * @author: liuguohu
 * @create: 2020-03-07 23:08
 **/

public interface IBaseService<T> {

    /**
     * 保存
     */
    Integer save(T t);

    /**
     * 删除
     */
    void delete(Integer id);

    /**
     * 通过id查询
     */
    T findById(Integer id);

    /**
     * 更新
     */
    void update(T t);

    /**
     * 返回所有信息
     */
    List<T> list();
}
