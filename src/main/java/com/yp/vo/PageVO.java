package com.yp.vo;

import com.yp.entity.Sale;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PageVO {

//"currentPage" : 1,
    private Integer currentPage;
//        "pageSize" : 5,
    private Integer pageSize;
//        "totalCount" : 9,
    private Long totalCount;
//        "totalPage" : 2,
    private Integer totalPage;
//        "list"
    private List<Sale> list;

}
