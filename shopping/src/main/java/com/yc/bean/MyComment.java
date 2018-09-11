package com.yc.bean;

import java.security.Timestamp;

public class MyComment {
	private Integer commentid;
	private User user;
	private Goods goods;
	private String content;
	private Timestamp commentime;

	public Integer getCommentid() {
		return commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCommentime() {
		return commentime;
	}

	public void setCommentime(Timestamp commentime) {
		this.commentime = commentime;
	}

	@Override
	public String toString() {
		return "MyComment [commentid=" + commentid + ", user=" + user
				+ ", goods=" + goods + ", content=" + content + ", commentime="
				+ commentime + "]";
	}

}
