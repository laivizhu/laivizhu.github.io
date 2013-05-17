package com.laivi.sic.action.media;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;

import com.laivi.sic.action.basic.ABasicDBAction;
import com.laivi.sic.model.annotation.CheckLogin;
import com.laivi.sic.model.exception.ErrorException;
import com.laivi.sic.model.po.media.Book;
import com.laivi.sic.model.po.media.BookShelf;
import com.laivi.sic.model.po.user.User;
import com.laivi.sic.model.to.Response;
import com.laivi.sic.util.basic.ParamAssert;

@IocBean
@At("/media/bookshelf")
public class BookShelfAction extends ABasicDBAction<BookShelf> {
	
	@At
	@CheckLogin
	public Response add(@Param("::shelf.") final BookShelf bookShelf) throws ErrorException{
		ParamAssert.isTrue(dao.count(BookShelf.class, Cnd.where("bookId","=", bookShelf.getBookId()).and("userId", "=",this.getUserId()))==0,"用户书架已包含该书");
		Book book=dao.fetch(Book.class, bookShelf.getBookId());
		ParamAssert.isTrue(book.getUserId()!=this.getUserId(), "用户是该书的创作者");
		final User user=dao.fetch(User.class, getUserId());
		ParamAssert.isTrue(user.getMoney()>=book.getPrice(), "钱不够，不能加入书架，请先充值！");
		user.setMoney(user.getMoney()-book.getPrice());
		bookShelf.setUserId(getUserId());
		Trans.exec(new Atom(){
			@Override
			public void run() {
				dao.update(user);
				dao.insert(bookShelf);
			}
		});
		
		return success();
	}

	@Override
	public Class<BookShelf> getEntityClass() {
		return BookShelf.class;
	}

}
