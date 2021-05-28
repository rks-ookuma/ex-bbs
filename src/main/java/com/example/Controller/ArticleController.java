package com.example.Controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.domain.Comment;
import com.example.form.ArticleInsertForm;
import com.example.form.CommentInsertForm;
import com.example.repository.ArticleRepository;
import com.example.repository.CommentRepository;

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
	private ArticleRepository articleRepository;

	@Autowired
	private CommentRepository commentRepository;

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

		List<Article> articleList = articleRepository.findAll();

		model.addAttribute("articleList", articleList);

		return "board";
	}

	/**
	 * 記事を投稿し、記事一覧画面を表示する.
	 *
	 * @param articleInsertForm 記事を投稿する際に利用されるフォーム
	 * @param result            入力値チェックのエラー群
	 * @param model             リクエストスコープ
	 * @return 記事一覧画面
	 */
	@RequestMapping("/insertArticle")
	public String insertArticle(@Validated ArticleInsertForm articleInsertForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index(model);
		}
		Article article = new Article();
		BeanUtils.copyProperties(articleInsertForm, article);
		articleRepository.insert(article);

		return "redirect:/article";
	}

	/**
	 * コメントを投稿し.記事一覧画面を表示する.
	 *
	 * @param commentInsertForm コメントを投稿する際に利用されるフォーム
	 * @param result            入力値チェックのエラー群
	 * @return 記事一覧画面
	 */
	@RequestMapping("/insertComment")
	public String insertComment(@Validated CommentInsertForm commentInsertForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index(model);
		}
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentInsertForm, comment);
		commentRepository.insert(comment);

		return "redirect:/article";
	}

	/**
	 * 記事を削除し、記事一覧画面を表示する.
	 *
	 * @param id 削除したい記事のID
	 * @return 記事一覧画面
	 */
	@RequestMapping("/deleteArticle")
	public String deleteArticle(int id) {
		articleRepository.deleteById(id);
		return "redirect:/article";
	}
}
