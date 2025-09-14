package com.streamPractice;

import java.time.LocalDate;
import java.time.Period;

/*
    You are given two dates: "2020-05-15" and "2025-09-12".

👉 Write Java 8 code to:

Parse them using LocalDate.

Calculate the difference in years, months, and days between the two dates. */
public class DateTimeApi {

    public static void main(String[] args) {
        // Given dates
        LocalDate startDate = LocalDate.parse("2020-05-15");
        LocalDate endDate = LocalDate.parse("2025-09-12");

        // Calculate difference
        Period difference = Period.between(startDate, endDate);

        System.out.println("Difference: "
            + difference.getYears() + " years, "
            + difference.getMonths() + " months, "
            + difference.getDays() + " days");
    }

}
