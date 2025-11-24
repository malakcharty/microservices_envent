package com.community.events.dto.organizer;
import java.io.Serializable;
import java.util.Objects;


public class EventShortDto implements Serializable {

    private final Long id;
    private final String title;
    private final String date;

    public EventShortDto(Long id, String title, String date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventShortDto entity = (EventShortDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.date, entity.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, date);
    }

    @Override
    public String toString() {
        return "EventShortDto(" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ')';
    }
}
