package com.kyle.calendarprovider.calendar;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * 日历事件
 * <p>
 * Created by KYLE on 2019/3/4 - 9:53
 */
public class CalendarEvent implements Serializable, Parcelable {

    // ----------------------- 事件属性 -----------------------

    /**
     * 事件在表中的ID
     */
    private long id;
    /**
     * 事件所属日历账户的ID
     */
    private long calID;
    private String title;
    private String description;
    private String eventLocation;
    private int displayColor;
    private int status;
    private long start;
    private long end;
    private String duration;
    private String eventTimeZone;
    private String eventEndTimeZone;
    private int allDay;
    private int accessLevel;
    private int availability;
    private int hasAlarm;
    private String rRule;
    private String rDate;
    private int hasAttendeeData;
    private int lastDate;
    private String organizer;
    private String isOrganizer;
    private Integer isModify;


    // ----------------------------------------------------------------------------------------
    /**
     * 注：此属性不属于CalendarEvent
     * 这里只是为了方便构造方法提供事件提醒时间
     */
    private int advanceTime;
    // ----------------------------------------------------------------------------------------


    // ----------------------- 事件提醒属性 -----------------------
    private List<EventReminders> reminders;

    public CalendarEvent() {
    }

    /**
     * 用于方便添加完整日历事件提供一个构造方法
     *
     * @param title         事件标题
     * @param description   事件描述
     * @param eventLocation 事件地点
     * @param start         事件开始时间
     * @param end           事件结束时间  If is not a repeat event, this param is must need else null
     * @param advanceTime   事件提醒时间{@link AdvanceTime}
     *                      (If you don't need to remind the incoming parameters -2)
     * @param rRule         事件重复规则  {@link RRuleConstant}  {@code null} if dose not need
     */
    public CalendarEvent(String title, String description, String eventLocation,
                         long start, long end, int advanceTime, String rRule) {
        this.title = title;
        this.description = description;
        this.eventLocation = eventLocation;
        this.start = start;
        this.end = end;
        this.advanceTime = advanceTime;
        this.rRule = rRule;
    }

    protected CalendarEvent(Parcel in) {
        id = in.readLong();
        calID = in.readLong();
        title = in.readString();
        description = in.readString();
        eventLocation = in.readString();
        displayColor = in.readInt();
        status = in.readInt();
        start = in.readLong();
        end = in.readLong();
        duration = in.readString();
        eventTimeZone = in.readString();
        eventEndTimeZone = in.readString();
        allDay = in.readInt();
        accessLevel = in.readInt();
        availability = in.readInt();
        hasAlarm = in.readInt();
        rRule = in.readString();
        rDate = in.readString();
        hasAttendeeData = in.readInt();
        lastDate = in.readInt();
        organizer = in.readString();
        isOrganizer = in.readString();
        if (in.readByte() == 0) {
            isModify = null;
        } else {
            isModify = in.readInt();
        }
        advanceTime = in.readInt();
        reminders = in.createTypedArrayList(EventReminders.CREATOR);
    }

    public static final Creator<CalendarEvent> CREATOR = new Creator<CalendarEvent>() {
        @Override
        public CalendarEvent createFromParcel(Parcel in) {
            return new CalendarEvent(in);
        }

        @Override
        public CalendarEvent[] newArray(int size) {
            return new CalendarEvent[size];
        }
    };

    public int getAdvanceTime() {
        return advanceTime;
    }

    public void setAdvanceTime(int advanceTime) {
        this.advanceTime = advanceTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCalID() {
        return calID;
    }

    public void setCalID(long calID) {
        this.calID = calID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public int getDisplayColor() {
        return displayColor;
    }

    public void setDisplayColor(int displayColor) {
        this.displayColor = displayColor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEventTimeZone() {
        return eventTimeZone;
    }

    public void setEventTimeZone(String eventTimeZone) {
        this.eventTimeZone = eventTimeZone;
    }

    public String getEventEndTimeZone() {
        return eventEndTimeZone;
    }

    public void setEventEndTimeZone(String eventEndTimeZone) {
        this.eventEndTimeZone = eventEndTimeZone;
    }

    public int getAllDay() {
        return allDay;
    }

    public void setAllDay(int allDay) {
        this.allDay = allDay;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getHasAlarm() {
        return hasAlarm;
    }

    public void setHasAlarm(int hasAlarm) {
        this.hasAlarm = hasAlarm;
    }

    public String getRRule() {
        return rRule;
    }

    public void setRRule(String rRule) {
        this.rRule = rRule;
    }

    public String getRDate() {
        return rDate;
    }

    public void setRDate(String rDate) {
        this.rDate = rDate;
    }

    public int getHasAttendeeData() {
        return hasAttendeeData;
    }

    public void setHasAttendeeData(int hasAttendeeData) {
        this.hasAttendeeData = hasAttendeeData;
    }

    public int getLastDate() {
        return lastDate;
    }

    public void setLastDate(int lastDate) {
        this.lastDate = lastDate;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getIsOrganizer() {
        return isOrganizer;
    }

    public void setIsOrganizer(String isOrganizer) {
        this.isOrganizer = isOrganizer;
    }

    public List<EventReminders> getReminders() {
        return reminders;
    }

    public void setReminders(List<EventReminders> reminders) {
        this.reminders = reminders;
    }

    public Integer getIsModify() {
        return isModify;
    }

    public void setIsModify(Integer isModify) {
        this.isModify = isModify;
    }

    @NonNull
    @Override
    public String toString() {
        return "CalendarEvent{" +
                "\n id=" + id +
                "\n calID=" + calID +
                "\n title='" + title + '\'' +
                "\n description='" + description + '\'' +
                "\n eventLocation='" + eventLocation + '\'' +
                "\n displayColor=" + displayColor +
                "\n status=" + status +
                "\n start=" + start +
                "\n end=" + end +
                "\n duration='" + duration + '\'' +
                "\n eventTimeZone='" + eventTimeZone + '\'' +
                "\n eventEndTimeZone='" + eventEndTimeZone + '\'' +
                "\n allDay=" + allDay +
                "\n accessLevel=" + accessLevel +
                "\n availability=" + availability +
                "\n hasAlarm=" + hasAlarm +
                "\n rRule='" + rRule + '\'' +
                "\n rDate='" + rDate + '\'' +
                "\n hasAttendeeData=" + hasAttendeeData +
                "\n lastDate=" + lastDate +
                "\n organizer='" + organizer + '\'' +
                "\n isOrganizer='" + isOrganizer + '\'' +
                "\n isModify='" + isModify + '\'' +
                "\n reminders=" + reminders.toString() +
                '}';
    }

    @Override
    public int hashCode() {
        return (int) (id * 37 + calID);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeLong(id);
        dest.writeLong(calID);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(eventLocation);
        dest.writeInt(displayColor);
        dest.writeInt(status);
        dest.writeLong(start);
        dest.writeLong(end);
        dest.writeString(duration);
        dest.writeString(eventTimeZone);
        dest.writeString(eventEndTimeZone);
        dest.writeInt(allDay);
        dest.writeInt(accessLevel);
        dest.writeInt(availability);
        dest.writeInt(hasAlarm);
        dest.writeString(rRule);
        dest.writeString(rDate);
        dest.writeInt(hasAttendeeData);
        dest.writeInt(lastDate);
        dest.writeString(organizer);
        dest.writeString(isOrganizer);
        if (isModify == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(isModify);
        }
        dest.writeInt(advanceTime);
        dest.writeTypedList(reminders);
    }

    /**
     * 事件提醒
     */
    public static class EventReminders implements Serializable,Parcelable {

        // ----------------------- 事件提醒属性 -----------------------
        private long reminderId;
        private long reminderEventID;
        private int reminderMinute;
        private int reminderMethod;

        public EventReminders() {
        }

        protected EventReminders(Parcel in) {
            reminderId = in.readLong();
            reminderEventID = in.readLong();
            reminderMinute = in.readInt();
            reminderMethod = in.readInt();
        }

        public static final Creator<EventReminders> CREATOR = new Creator<EventReminders>() {
            @Override
            public EventReminders createFromParcel(Parcel in) {
                return new EventReminders(in);
            }

            @Override
            public EventReminders[] newArray(int size) {
                return new EventReminders[size];
            }
        };

        public long getReminderId() {
            return reminderId;
        }

        public void setReminderId(long reminderId) {
            this.reminderId = reminderId;
        }

        public long getReminderEventID() {
            return reminderEventID;
        }

        public void setReminderEventID(long reminderEventID) {
            this.reminderEventID = reminderEventID;
        }

        public int getReminderMinute() {
            return reminderMinute;
        }

        public void setReminderMinute(int reminderMinute) {
            this.reminderMinute = reminderMinute;
        }

        public int getReminderMethod() {
            return reminderMethod;
        }

        public void setReminderMethod(int reminderMethod) {
            this.reminderMethod = reminderMethod;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(reminderId);
            dest.writeLong(reminderEventID);
            dest.writeInt(reminderMinute);
            dest.writeInt(reminderMethod);
        }
    }

}
