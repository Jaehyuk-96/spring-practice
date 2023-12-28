package kr.co.chunjae.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDTO {

    private int page;       //현재페이지
    private int maxPage;    //전체 페이지 개수
    private int startPage;  //현재 페이지 기준 시작 페이지 값
    private int endPage;    //현재 페이지 기준 마지막 페이지 값
}
