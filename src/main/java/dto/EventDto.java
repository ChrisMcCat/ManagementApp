package dto;

import java.time.LocalDateTime;

public class EventDto {

	private long id;
	private String ip;
	private String type;
	private String link;
	private LocalDateTime time;

	public EventDto(long id, String ip, String type, String link, LocalDateTime time) {
		this.id = id;
		this.ip = ip;
		this.type = type;
		this.link = link;
		this.time = time;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
}
