package com.WPF.service;

import com.WPF.domain.Comment;
import com.WPF.domain.Post;

import java.util.List;

public interface MessageService {
	Post getPostByPId(String p_id);

	List<Post> getPostListPPId(String p_id);

	void changePostPBrowseCount(String p_id);

	void putThumbs(String p_id);

	List<Comment> getCommentList(String p_id);

	int putAComment(Comment comment);
}
