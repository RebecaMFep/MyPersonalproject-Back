package dev.rebecamf.myspringmypersonalproject.activities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDto {
    
    private String name;
    private String location;
    private String days;
    private String month;
    private String time;
    private String range;
    private int capacity;
    private String description;
    
  

}
