package com.zubala.rafal.day01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

class Day01Test {

    private Day01 day01;

    @BeforeEach
    void prepare() {
        day01 = new Day01();
    }

    @Test
    void parts() {
        System.out.println(Arrays.toString(day01.parts()));
    }
}