package com.goalduo.cheilTrip.board.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDto {
    private int articleNo;
    private String userId;
    private String subject;
    private String content;
    private int hit;
    private String registerTime;
}
