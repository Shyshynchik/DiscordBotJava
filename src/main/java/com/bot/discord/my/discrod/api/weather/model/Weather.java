package com.bot.discord.my.discrod.api.weather.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Weather {
	private Integer visibility;
	private Integer timezone;
	private Main main;
	private Clouds clouds;
	private Sys sys;
	private Integer dt;
	private List<WeatherItem> weather;
	private String name;
	private Integer cod;
	private Integer id;
	private String base;
	private Wind wind;

	@Data
	public static class WeatherItem {
		private String icon;
		private String description;
		private String main;
		private Integer id;
	}
	@Data
	public static class Sys {
		private String country;
		private Long sunrise;
		private Long sunset;
		private Integer id;
		private Integer type;
	}

	@Data
	public static class Wind{
		private Integer deg;
		private Double speed;
		private Integer gust;
	}
	@Data
	public static class Main {
		private Double temp;
		@JsonProperty("temp_min")
		private Double tempMin;
		private Integer humidity;
		private Integer pressure;
		@JsonProperty("feels_like")
		private Double feelsLike;
		@JsonProperty("temp_max")
		private Double tempMax;
	}
	@Data
	public static class Clouds {
		private Integer all;
	}
}