package com.bot.discord.my.discrod.api.weather.model;

import lombok.Data;

@Data
public class CitiGeo{
	private String country;
	private String name;
	private Double lon;
	private String state;
	private Double lat;
}