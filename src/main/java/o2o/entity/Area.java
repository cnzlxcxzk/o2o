package o2o.entity;


import java.time.LocalDateTime;

public class Area {

    private Long areaId;

    private String areaName;

    private String areadesc;

    private Integer priority;

    private LocalDateTime createTime;

    private LocalDateTime lastEditTime;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreadesc() {
        return areadesc;
    }

    public void setAreadesc(String areadesc) {
        this.areadesc = areadesc;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(LocalDateTime lastEditTime) {
        this.lastEditTime = lastEditTime;
    }




}
