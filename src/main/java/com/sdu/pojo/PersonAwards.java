package com.sdu.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PersonAwards {
    String year;
    List<String> awardList;
}
