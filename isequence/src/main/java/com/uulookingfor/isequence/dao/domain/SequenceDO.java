package com.uulookingfor.isequence.dao.domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
 * @author suxiong.sx
 */
public class SequenceDO implements Serializable{
    private static final long serialVersionUID = 1L;
    // 序列号名称
    @Getter @Setter private String name;
    // 最新值
    @Getter @Setter private Long value;
    // 修改时间
    @Getter @Setter private Date gmtModified;
    // id
    @Getter @Setter private Long id;
}

