package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.form.ArticleInsertForm;
import com.example.form.CommentInsertForm;
import com.example.repository.ArticleRepository;

/**
 * 記事関連の制御をするコントローラークラス.
 *
 * @author takahiro.okuma
 *
 */
@Controller
@Transactional
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleRepository repository;

	@ModelAttribute
	public ArticleInsertForm setUpArticleInsertForm() {
		return new ArticleInsertForm();
	}

	@ModelAttribute
	public CommentInsertForm setUpCommentInsertForm() {
		return new CommentInsertForm();
	}

	/**
	 * 記事一覧および付随したコメントを表示する.
	 *
	 * @param model リクエストスコープ
	 * @return 記事一覧画面
	 */
	@RequestMapping("")
	public String index(Model model) {

		List<Article> articleList = repository.findAll();
		System.out.println(articleList);

		model.addAttribute("articleList", articleList);

		return "board";
	}
}
