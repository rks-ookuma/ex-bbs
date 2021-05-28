package com.example.form;

/**
 * コメントを投稿する際に利用されるフォーム.
 *
 * @author takahiro.okuma
 *
 */
public class CommentInsertForm {

	/** コメント者名 */
	private String name;
	/** コメント内容 */
	private String content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CommentInsertForm [name=" + name + ", content=" + content + "]";
	}

}
