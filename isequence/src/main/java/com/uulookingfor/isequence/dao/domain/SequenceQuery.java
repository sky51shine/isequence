package com.uulookingfor.isequence.dao.domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
/**
 * @author suxiong.sx
 */
public class SequenceQuery implements Serializable{
    private static final long serialVersionUID = 1L;
    // 序列号名称
    @Getter @Setter private String name;
    // 最新值
    @Getter @Setter private Long value;
    // 修改时间开始时间
    @Getter @Setter private Date gmtModifiedStart;
    // 修改时间结束时间
    @Getter @Setter private Date gmtModifiedEnd;
    // id
    @Getter @Setter private Long id;
    // 是否分页
    @Getter @Setter private boolean paging;
    // 开始位置
    @Getter @Setter private int start;
    // 一页大小
    @Getter @Setter private int limit;
}

