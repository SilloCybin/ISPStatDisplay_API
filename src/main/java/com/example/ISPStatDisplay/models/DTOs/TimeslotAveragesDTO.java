package com.example.ISPStatDisplay.models.DTOs;

public record TimeslotAveragesDTO(String hourOfTheDay,
                                  Number mondayAverage,
                                  Number tuesdayAverage,
                                  Number wednesdayAverage,
                                  Number thursdayAverage,
                                  Number fridayAverage,
                                  Number saturdayAverage,
                                  Number sundayAverage){}
