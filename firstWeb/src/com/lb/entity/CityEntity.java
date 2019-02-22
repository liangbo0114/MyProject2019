package com.lb.entity;

/**
 * @ Author     ：LB.
 * @ Date       ：Created in 2019/2/21
 * @ Description：
 * @ Modified By：
 */
public class CityEntity {

    private int id;
    private String name;
    private int pid;
    private boolean isParent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean parent) {
        isParent = parent;
    }
}
