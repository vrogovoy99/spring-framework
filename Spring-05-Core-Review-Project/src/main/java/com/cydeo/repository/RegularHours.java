package com.cydeo.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("REGULARTIME")
public class RegularHours implements HourRepository{
    @Override
    public int getHours() {
        return 40;
    }
}
