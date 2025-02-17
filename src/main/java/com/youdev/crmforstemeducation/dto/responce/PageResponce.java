package com.youdev.crmforstemeducation.dto.responce;

import lombok.Data;

import java.util.List;

@Data
public class PageResponce<T> {
    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private int totalElements;
    private int totalPages;
}
