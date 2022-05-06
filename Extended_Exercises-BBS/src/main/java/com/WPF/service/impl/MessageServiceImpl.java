package com.WPF.service.impl;

import com.WPF.dao.CommentDao;
import com.WPF.dao.PlateDao;
import com.WPF.dao.PostDao;
import com.WPF.domain.Comment;
import com.WPF.domain.Post;
import com.WPF.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class MessageServiceImpl implements MessageService {
	@Resource
	private PostDao postDao;

	@Resource
	private CommentDao commentDao;
	@Resource
	private PlateDao plateDao;

	@Override
	public Post getPostByPId(String p_id) {
		return postDao.selectPostListByPId(p_id);
	}

	@Override
	public List<Post> getPostListPPId(String p_id) {
		return postDao.selectPostListByPPId(p_id);
	}

	@Override
	public void changePostPBrowseCount(String p_id) {
		postDao.changePostPBrowseCount(p_id);
	}

	@Override
	public void putThumbs(String p_id) {
		postDao.changePostPThumbsCount(p_id);
	}

	@Override
	public List<Comment> getCommentList(String p_id) {
		return commentDao.selectCommentListByPId(p_id);
	}

	@Override
	public int putAComment(Comment comment) {
		return commentDao.insertAComment(comment) * postDao.updatePostPCommentCount(comment) * plateDao.updatePlatePCommentCount(comment);
	}
}
