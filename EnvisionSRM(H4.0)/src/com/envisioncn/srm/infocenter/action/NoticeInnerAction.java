package com.envisioncn.srm.infocenter.action;

import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.model.type.ResponseType;
import com.envisioncn.srm.basic.util.DateUtil;
import com.envisioncn.srm.basic.util.GsonUtil;
import com.envisioncn.srm.basic.util.ParamAssert;
import com.envisioncn.srm.infocenter.bean.NoticeInnerBean;
import com.envisioncn.srm.infocenter.bean.NoticeTypeBean;
import com.envisioncn.srm.infocenter.service.NoticeInnerService;
import com.envisioncn.srm.infocenter.service.NoticeTypeService;
import com.envisioncn.srm.system.bean.UserBean;
import com.envisioncn.srm.system.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date 2012-11-17
 * 
 */
@SuppressWarnings("serial")
public class NoticeInnerAction extends ABasicAction<NoticeInnerBean>
{

	private final String SAVE_PATH = getRealPath("/infocenter/upload");

	private NoticeInnerService service;
	private NoticeTypeService noticeTypeService;
	private UserService userService;

	private String title;
	private long type;
	private long user_id;
	private String content;
	private File attchment;
	private String attchmentFileName;
	@SuppressWarnings("unused")
	private InputStream file;

	public String list() throws Exception
	{
		String hql = "";
		Object[] parameters = null;
		if(null != key || !"".equals(key))
			hql = "from NoticeInnerBean as notice";
		else
			hql = "from NoticeInnerBean as notice order by notice.modifyTime desc";
		String hql2 = "select count(*)" + hql;
		int recordsCount = service.getPageCount(hql2, parameters);
		List<NoticeInnerBean> list = service.getObjectListByPage(hql, parameters, start, limit);
		JsonArray ja = new JsonArray();
		for (NoticeInnerBean bean : list)
		{
			JsonObject jo = new JsonObject();
			jo.addProperty("id", bean.getId());
			String title = bean.getTitle();
			if(title.length() > 30)
				jo.addProperty("title", title.substring(0,27)+"...");
			else
				jo.addProperty("title", title);
			jo.addProperty("type", bean.getNoticeType().getName());
			jo.addProperty("author", bean.getAuthor().getName());
			jo.addProperty("modifyTime", DateUtil.formatDate(bean.getModifyTime()));
			String attchment = bean.getAttchment();
			String value = null;
			if(null == attchment || "".equals(attchment))
				value = "";
			else
			{
				if(attchment.length() > 15){
					String[] temp = attchment.split("\\.");
					value = attchment.substring(0, 8) + "~." + temp[temp.length -1];
				}
				else
					value = attchment;
			}
			jo.addProperty("attchment", value);
			ja.add(jo);
		}
		return response(GsonUtil.toJson(ja, recordsCount));
	}

	public String add() throws Exception
	{
		try
		{
			NoticeInnerBean bean = new NoticeInnerBean();
			bean.setTitle(title);
			bean.setContent(content);
			Date date = new Date(System.currentTimeMillis());
			bean.setCreateTime(date);
			bean.setModifyTime(date);
			bean.setNoticeType(noticeTypeService.getObjectById(NoticeTypeBean.class, type));
			bean.setAuthor(userService.getObjectById(UserBean.class, (long) 1001));// session未设置
			if (null != attchment)
			{
				bean.setAttchment(attchmentFileName);
				File saveFile = new File(SAVE_PATH + "/" + attchmentFileName);
				attchment.renameTo(saveFile);
			}
			service.addObject(bean);
			return response(ResponseType.HTML, true, "发布成功,转到列表页面!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return response(ResponseType.HTML, false, "发布失败,转到列表页面！");
		}
	}

	public String delete() throws Exception
	{
		try
		{
			ParamAssert.isTrue(id != 0, "对象不存在");
			NoticeInnerBean bean = service.getObjectById(NoticeInnerBean.class, id);
			bean.setAuthor(null);
			bean.setNoticeType(null);
			if(null != bean.getAttchment() || !("").equals(bean.getAttchment()))
			{
				File deleteFile = new File(SAVE_PATH + "/" + bean.getAttchment());
				deleteFile.delete();
			}
			service.removeObject(bean);
			return response(true, "删除成功！");
		}
		catch (Exception e)
		{
			return response(false, "删除失败！");
		}
	}

	public String update() throws Exception
	{
		try
		{
			NoticeInnerBean bean = (NoticeInnerBean) service.getObjectById(NoticeInnerBean.class, id);
			bean.setTitle(title);
			bean.setContent(content);
			bean.setModifyTime(new Date(System.currentTimeMillis()));
			bean.setNoticeType(noticeTypeService.getObjectById(NoticeTypeBean.class, type));
			bean.setAuthor(userService.getObjectById(UserBean.class, (long) 1001));// session未设置
			if (null != attchment)
			{
				bean.setAttchment(attchmentFileName);
				File saveFile = new File(SAVE_PATH + "/" + attchmentFileName);
				attchment.renameTo(saveFile);
			}
			service.modifyObject(bean);
			return response(ResponseType.HTML, true, "修改成功,转到列表页面!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return response(ResponseType.HTML, false, "修改失败,转到列表页面！");
		}
	}

	public String get() throws Exception
	{
		NoticeInnerBean bean = service.getObjectById(NoticeInnerBean.class, id);
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", bean.getId());
		jsonObject.addProperty("title", bean.getTitle());
		jsonObject.addProperty("content", bean.getContent());
		jsonObject.addProperty("createTime", DateUtil.formatDate(bean.getCreateTime()));
		jsonObject.addProperty("modifyTime", DateUtil.formatDate(bean.getModifyTime()));
		jsonObject.addProperty("author", bean.getAuthor().getName());
		jsonObject.addProperty("type", bean.getNoticeType().getName());
		jsonObject.addProperty("attchment", bean.getAttchment() == null ? "" : bean.getAttchment());
		Gson gson = new Gson();
		return response(ResponseType.JSON, gson.toJson(jsonObject));
	}

	public String download() throws Exception
	{
		NoticeInnerBean bean = service.getObjectById(NoticeInnerBean.class, id);
		String fileName = bean.getAttchment();
		this.setAttchmentFileName(new String(fileName.getBytes(), "ISO8859-1"));
		File downFile = new File(SAVE_PATH + "/" + fileName);
		this.setAttchment(downFile);
		return "Download";
	}

	public InputStream getFile()
	{
		InputStream is = ServletActionContext.getServletContext().getResourceAsStream("/infocenter/upload/" + attchment.getName());
		return is;
	}

	@Resource(name = "NoticeInnerService")
	public void setService(NoticeInnerService service)
	{
		this.service = service;
	}

	@Resource(name = "NoticeTypeService")
	public void setNoticeTypeService(NoticeTypeService noticeTypeService)
	{
		this.noticeTypeService = noticeTypeService;
	}

	@Resource(name = "UserService")
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public long getType()
	{
		return type;
	}

	public void setType(long type)
	{
		this.type = type;
	}

	public long getUser_id()
	{
		return user_id;
	}

	public void setUser_id(long user_id)
	{
		this.user_id = user_id;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public File getAttchment()
	{
		return attchment;
	}

	public void setAttchment(File attchment)
	{
		this.attchment = attchment;
	}

	public String getAttchmentFileName()
	{
		return attchmentFileName;
	}

	public void setAttchmentFileName(String attchmentFileName)
	{
		this.attchmentFileName = attchmentFileName;
	}

	public JsonItem getJsonItem(NoticeInnerBean object) throws Exception
	{
		return null;
	}

}
