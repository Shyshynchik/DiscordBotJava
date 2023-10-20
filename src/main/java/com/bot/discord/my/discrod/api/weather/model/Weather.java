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
	private Rain rain;
	private Snow snow;
	@JsonProperty("sys")
	private System system;
	private Integer dt;
	private List<WeatherItem> weather;
	private String name;
	private Integer cod;
	private Integer id;
	private String base;
	private Wind wind;

	@Data
	public static class Rain {
		@JsonProperty("1h")
		private Double lastHour;
		@JsonProperty("3h")
		private Double lastThreeHours;
	}

	@Data
	public static class Snow {
		@JsonProperty("1h")
		private Double lastHour;
		@JsonProperty("3h")
		private Double lastThreeHours;
	}

	@Data
	public static class WeatherItem {
		private String icon;
		private String description;
		private String main;
		private Integer id;
	}
	@Data
	public static class System {
		private String country;
		private Long sunrise;
		private Long sunset;
		private Integer id;
		private Integer type;
	}

	@Data
	public static class Wind {
		private Integer deg;
		private Double speed;
		private Integer gust;
	}
	@Data
	public static class Main {
		@JsonProperty("temp")
		private Double temperature;
		@JsonProperty("temp_min")
		private Double temperatureMin;
		private Integer humidity;
		private Integer pressure;
		@JsonProperty("feels_like")
		private Double feelsLike;
		@JsonProperty("temp_max")
		private Double temperatureMax;
	}
	@Data
	public static class Clouds {
		private Integer all;
	}
}