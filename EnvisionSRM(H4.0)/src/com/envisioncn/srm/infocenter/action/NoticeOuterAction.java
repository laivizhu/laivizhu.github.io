package com.envisioncn.srm.infocenter.action;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.model.type.ResponseType;
import com.envisioncn.srm.basic.util.DateUtil;
import com.envisioncn.srm.basic.util.GsonUtil;
import com.envisioncn.srm.basic.util.ParamAssert;
import com.envisioncn.srm.infocenter.bean.NoticeOuterBean;
import com.envisioncn.srm.infocenter.bean.NoticeTypeBean;
import com.envisioncn.srm.infocenter.service.NoticeOuterService;
import com.envisioncn.srm.infocenter.service.NoticeTypeService;
import com.envisioncn.srm.supplier_basic.bean.SupplierBasic;
import com.envisioncn.srm.supplier_basic.service.SupplierBasicService;
import com.envisioncn.srm.system.bean.DepartmentBean;
import com.envisioncn.srm.system.service.DepartmentService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Copyright Envision
 * 
 * @author WilliamsDing
 * @version 1.0
 * @date 2012-11-22
 * 
 */
@SuppressWarnings("serial")
public class NoticeOuterAction extends ABasicAction<NoticeOuterBean>
{
	private final String savePath = getRealPath("/upload/infocenter/");

	private NoticeOuterService service;
	private NoticeTypeService noticeTypeService;
	private DepartmentService departmentService;
	private SupplierBasicService supplierBasicService;

	private String title;
	private String content;
	private File attachment;
	private String attachmentFileName;
	private long type_id;
	private long department_id;
	private String supplierInputId;

	private String client;

	@SuppressWarnings("unused")
	private InputStream downloadFileInputStream;

	public String list() throws Exception
	{
		String hql = null;
		String hql2 = null;
		/*供应商端list*/
		if ("supplier".equals(client))
		{
			SupplierBasic sb = supplierBasicService.getObject((long) 1191);
			Set<NoticeOuterBean> notices = null;
			try
			{

				notices = sb.getNotices();
				System.out.println(notices);

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

			JsonArray ja = new JsonArray();
			for (NoticeOuterBean notice : notices)
			{
				JsonObject jo = new JsonObject();
				jo.addProperty("id", notice.getId());
				jo.addProperty("title", notice.getTitle().length() > 30 ? notice.getTitle().substring(0, 27) + "..." : notice.getTitle());
				jo.addProperty("type", notice.getNoticeType().getName());
				jo.addProperty("department", notice.getDepartment().getName());
				jo.addProperty("modifyTime", DateUtil.formatDate(notice.getModifyTime()));
				/* 处理附件 */
				String attachment = notice.getAttachment();
				String value = null;
				if (null == attachment || "".equals(attachment))
					value = "";
				else
				{
					if (attachment.length() > 15)
					{
						String[] temp = attachment.split("\\.");
						value = attachment.substring(0, 8) + "~." + temp[temp.length - 1];
					}
					else
						value = attachment;
				}
				jo.addProperty("attachment", value);
				/* 处理供应商信息 */
				ja.add(jo);
			}
			return response(GsonUtil.toJson(ja, notices.size()));
		}
		
		/*采购端list*/
		hql = "from NoticeOuterBean as notice order by notice.modifyTime desc";
		hql2 = "select count(*)" + hql;
		List<NoticeOuterBean> list = service.getObjectListByPage(hql, null, start, limit);
		int recordsCount = service.getPageCount(hql2, null);
		JsonArray ja = new JsonArray();
		for (NoticeOuterBean notice : list)
		{
			JsonObject jo = new JsonObject();
			jo.addProperty("id", notice.getId());
			jo.addProperty("title", notice.getTitle().length() > 30 ? notice.getTitle().substring(0, 27) + "..." : notice.getTitle());
			jo.addProperty("type", notice.getNoticeType().getName());
			jo.addProperty("department", notice.getDepartment().getName());
			jo.addProperty("createTime", DateUtil.formatDate(notice.getCreateTime()));
			jo.addProperty("modifyTime", DateUtil.formatDate(notice.getModifyTime()));
			/* 处理附件 */
			String attachment = notice.getAttachment();
			String value = null;
			if (null == attachment || "".equals(attachment))
				value = "";
			else
			{
				if (attachment.length() > 15)
					value = attachment.substring(0, 8) + "...." + attachment.split("\\.")[1];
				else
					value = attachment;
			}
			jo.addProperty("attachment", value);
			ja.add(jo);
		}
		return response(GsonUtil.toJson(ja, recordsCount));
	}

	public String add() throws Exception
	{
		try
		{
			NoticeOuterBean notice = new NoticeOuterBean();
			notice.setTitle(title);
			notice.setContent(content);
			notice.setNoticeType(noticeTypeService.getObjectById(NoticeTypeBean.class, type_id));
			notice.setDepartment(departmentService.getObjectById(DepartmentBean.class, department_id));
			Date date = new Date(System.currentTimeMillis());
			notice.setCreateTime(date);
			notice.setModifyTime(date);
			/*处理附件*/
			if (null != attachment)
			{
				notice.setAttachment(attachmentFileName);
				File targetFile = new File(savePath + "/" + attachmentFileName);
				attachment.renameTo(targetFile);
			}
			/*处理供应商信息*/
			List<SupplierBasic> suppliers = new ArrayList<SupplierBasic>();
			if (null != supplierInputId && !"".equals(supplierInputId))
			{
				String[] supplierIds = supplierInputId.split(",");
				for(String str: supplierIds)
				{
					SupplierBasic sb = supplierBasicService.getObject(Long.parseLong(str));
					suppliers.add(sb);
				}
			}
			else
			{
				List<SupplierBasic> list = supplierBasicService.getList();
				suppliers = list;
			}
			notice.setSuppliers(suppliers);
			service.addObject(notice);
			return response(ResponseType.HTML, true, "发布成功，转到列表页面!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return response(ResponseType.HTML, false, "发布失败！");
		}
	}

	public String get() throws Exception
	{
		NoticeOuterBean bean = service.getObjectById(NoticeOuterBean.class, id);
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", bean.getId());
		jsonObject.addProperty("title", bean.getTitle());
		jsonObject.addProperty("content", bean.getContent());
		jsonObject.addProperty("createTime", DateUtil.formatDate(bean.getCreateTime()));
		jsonObject.addProperty("modifyTime", DateUtil.formatDate(bean.getModifyTime()));
		jsonObject.addProperty("type", bean.getNoticeType().getName());
		jsonObject.addProperty("department", bean.getDepartment().getName());
		jsonObject.addProperty("attachment", bean.getAttachment() == null ? "" : bean.getAttachment());
		JsonArray ja = new JsonArray();
		for(SupplierBasic sb: bean.getSuppliers())
		{
			JsonObject jo = new JsonObject();
			jo.addProperty("id", sb.getId());
			jo.addProperty("name", sb.getName());
			ja.add(jo);
		}
		
		jsonObject.add("suppliers", ja);
		Gson gson = new Gson();
		return response(gson.toJson(jsonObject));
	}

	public String update() throws Exception
	{
		try
		{
			NoticeOuterBean bean = service.getObjectById(NoticeOuterBean.class, id);
			bean.setTitle(title);
			bean.setContent(content);
			bean.setModifyTime(new Date(System.currentTimeMillis()));
			bean.setNoticeType(noticeTypeService.getObjectById(NoticeTypeBean.class, type_id));
			// bean.setAuthor((UserBean)
			// service.getObjectById(UserBean.class,(long) 1001));// session未设置
			if (null != attachment)
			{
				bean.setAttachment(attachmentFileName);
				File targetFile = new File(savePath + "/" + attachmentFileName);
				attachment.renameTo(targetFile);
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

	public String delete() throws Exception
	{
		try
		{
			ParamAssert.isTrue(id != 0, "删除的公告不存在!");
			NoticeOuterBean notice = service.getObjectById(NoticeOuterBean.class, id);
			notice.setNoticeType(null);
			notice.setDepartment(null);
			String fileName = notice.getAttachment();
			if (null != fileName || !"".equals(fileName))
			{
				File deleteFile = new File(savePath + "/" + fileName);
				deleteFile.delete();
			}
			service.removeObject(notice);
			return response(true, "删除成功！");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return response(false, "删除失败！");
		}
	}

	public String download() throws Exception
	{
		NoticeOuterBean notice = service.getObjectById(NoticeOuterBean.class, id);
		String fileName = notice.getAttachment();
		if (null != fileName && !"".equals(fileName))
			this.setAttachmentFileName(new String(fileName.getBytes(), "ISO8859-1"));
		return "Download";
	}

	public InputStream getDownloadFileInputStream()
	{
		return ServletActionContext.getServletContext().getResourceAsStream("/upload/infocenter/" + attachmentFileName);
	}

	@Resource(name = "NoticeOuterService")
	public void setService(NoticeOuterService service)
	{
		this.service = service;
	}

	@Resource(name = "NoticeTypeService")
	public void setNoticeTypeService(NoticeTypeService noticeTypeService)
	{
		this.noticeTypeService = noticeTypeService;
	}

	@Resource(name = "DepartmentService")
	public void setDepartmentService(DepartmentService departmentService)
	{
		this.departmentService = departmentService;
	}

	@Resource(name = "SupplierBasicService")
	public void setSupplierBasicService(SupplierBasicService supplierBasicService)
	{
		this.supplierBasicService = supplierBasicService;
	}

	public JsonItem getJsonItem(NoticeOuterBean object) throws Exception
	{
		return null;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public File getAttachment()
	{
		return attachment;
	}

	public void setAttachment(File attachment)
	{
		this.attachment = attachment;
	}

	public String getAttachmentFileName()
	{
		return attachmentFileName;
	}

	public void setAttachmentFileName(String attachmentFileName)
	{
		this.attachmentFileName = attachmentFileName;
	}

	public long getType_id()
	{
		return type_id;
	}

	public void setType_id(long type_id)
	{
		this.type_id = type_id;
	}

	public long getDepartment_id()
	{
		return department_id;
	}

	public void setDepartment_id(long department_id)
	{
		this.department_id = department_id;
	}

	public String getSupplierInputId()
	{
		return supplierInputId;
	}

	public void setSupplierInputId(String supplierInputId)
	{
		this.supplierInputId = supplierInputId;
	}

	public String getSavePath()
	{
		return savePath;
	}

	public NoticeOuterService getService()
	{
		return service;
	}

	public NoticeTypeService getNoticeTypeService()
	{
		return noticeTypeService;
	}

	public DepartmentService getDepartmentService()
	{
		return departmentService;
	}

	public void setDownloadFileInputStream(InputStream downloadFileInputStream)
	{
		this.downloadFileInputStream = downloadFileInputStream;
	}

	public String getClient()
	{
		return client;
	}

	public void setClient(String client)
	{
		this.client = client;
	}

}
