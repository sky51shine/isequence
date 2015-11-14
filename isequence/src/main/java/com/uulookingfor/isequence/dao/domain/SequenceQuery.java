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
    // ���к�����
    @Getter @Setter private String name;
    // ����ֵ
    @Getter @Setter private Long value;
    // �޸�ʱ�俪ʼʱ��
    @Getter @Setter private Date gmtModifiedStart;
    // �޸�ʱ�����ʱ��
    @Getter @Setter private Date gmtModifiedEnd;
    // id
    @Getter @Setter private Long id;
    // �Ƿ��ҳ
    @Getter @Setter private boolean paging;
    // ��ʼλ��
    @Getter @Setter private int start;
    // һҳ��С
    @Getter @Setter private int limit;
}

