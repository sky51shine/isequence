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
    // ���к�����
    @Getter @Setter private String name;
    // ����ֵ
    @Getter @Setter private Long value;
    // �޸�ʱ��
    @Getter @Setter private Date gmtModified;
    // id
    @Getter @Setter private Long id;
}

