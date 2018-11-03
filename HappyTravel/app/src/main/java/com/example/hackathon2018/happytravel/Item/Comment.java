package com.example.hackathon2018.happytravel.Item;

import java.io.Serializable;

/**
 * Created by Benix on 3/11/2018.
 */

public class Comment implements Serializable {
    private String cid, t_uid, pid, f_uid, msg, c_level;

    public Comment(String cid, String t_uid, String pid, String f_uid, String msg, String c_level) {
        this.cid = cid;
        this.t_uid = t_uid;
        this.pid = pid;
        this.f_uid = f_uid;
        this.msg = msg;
        this.c_level = c_level;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getT_uid() {
        return t_uid;
    }

    public void setT_uid(String t_uid) {
        this.t_uid = t_uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getF_uid() {
        return f_uid;
    }

    public void setF_uid(String f_uid) {
        this.f_uid = f_uid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getC_level() {
        return c_level;
    }

    public void setC_level(String c_level) {
        this.c_level = c_level;
    }
}
