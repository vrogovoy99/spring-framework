package com.cydeo.repository;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("OVERTIME")
public class OvertimeHours implements HourRepository{
    @Override
    public int getHours() {
        return 10;
    }
}
