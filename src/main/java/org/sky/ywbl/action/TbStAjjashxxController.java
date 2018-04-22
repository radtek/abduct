package org.sky.ywbl.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sky.sys.action.BaseController;
import org.sky.sys.exception.ServiceException;
import org.sky.ywbl.model.TbStAjjashxx;
import org.sky.ywbl.model.TbStAjjashxxExample;
import org.sky.ywbl.model.TbStAjjashxxExample.Criteria;
import org.sky.ywbl.service.TbStAjjashxxService;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.Page;
import org.sky.sys.utils.PageListData;
import org.sky.sys.utils.ResultData;
import org.sky.sys.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
@Controller
public class TbStAjjashxxController extends BaseController{
	@Autowired
	private TbStAjjashxxService tbstajjashxxService;
	
	public TbStAjjashxxController() {
		// TODO Auto-generated constructor stub
	}
	/**
	*显示案件结案审核信息列表页面
	**/
	@RequestMapping(value = "/ywbl/TbStAjjashxx/initTbStAjjashxxListPage", method = { RequestMethod.GET })
	public String initTbStAjjashxxListPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/jash/listtbstajjashxx";
	}
	/**
	 * 案件结案审核信息分页查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ywbl/TbStAjjashxx/getTbStAjjashxxByPage", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStAjjashxxByPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		String filter = request.getParameter("filter");
		Map filterMap = JsonUtils.json2map(filter);
		String sortfield=request.getParameter("sortfield");
		Page p= super.getPage(request);
		TbStAjjashxxExample pote= new TbStAjjashxxExample();
		if(null!=filterMap){
			pote.createCriteria();
			pote.integratedQuery(filterMap);
		}
		if(!StringUtils.isNull(sortfield)){
			pote.setOrderByClause(sortfield);
		}
		pote.setPage(p);
		PageListData pageData = tbstajjashxxService.getTbStAjjashxxByPage(pote);
		return JsonUtils.obj2json(pageData);
	}
	/**
	*显示案件结案审核信息新增页面
	**/
	@RequestMapping(value = "/ywbl/TbStAjjashxx/initAddTbStAjjashxxPage", method = { RequestMethod.GET })
	public String initAddTbStAjjashxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/jash/edittbstajjashxx";
	}
	/**
	*显示案件结案审核信息修改页面
	**/
	@RequestMapping(value = "/ywbl/TbStAjjashxx/initEditTbStAjjashxxPage", method = { RequestMethod.GET })
	public String initEditTbStAjjashxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/jash/edittbstajjashxx";
	}
	/**
	*显示案件结案审核信息详细页面
	**/
	@RequestMapping(value = "/ywbl/TbStAjjashxx/initDetailTbStAjjashxxPage", method = { RequestMethod.GET })
	public String initDetailTbStAjjashxxPage(
			HttpServletRequest request, HttpServletResponse response) {
		return "jsp/ywbl/jash/detailtbstajjashxx";
	}
	/**
	*保存新增/修改案件结案审核信息
	**/
	@RequestMapping(value = "/ywbl/TbStAjjashxx/saveAddEditTbStAjjashxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String saveAddEditTbStAjjashxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			TbStAjjashxx edit = (TbStAjjashxx) getEntityBean(request,TbStAjjashxx.class);
			tbstajjashxxService.saveAddEditTbStAjjashxx(edit);
			rd.setCode(ResultData.code_success);
			rd.setName("保存成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd.setCode(ResultData.code_error);
			rd.setName("保存失败<br>"+e.getMessage());
		}
		return JsonUtils.obj2json(rd);
	}
	/**
	*删除案件结案审核信息
	**/
	@RequestMapping(value = "/ywbl/TbStAjjashxx/delTbStAjjashxx", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody String delTbStAjjashxx(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			String delRows=request.getParameter("delRows");
			List de=JsonUtils.json2list(delRows, TbStAjjashxx.class);
			tbstajjashxxService.delTbStAjjashxxById(de);
			rd.setCode(ResultData.code_success);
			rd.setName("删除成功");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd.setCode(ResultData.code_error);
			rd.setName("删除失败<br>"+e.getMessage());
		}
		return JsonUtils.obj2json(rd);
	}
	/**
	*根据主键查询案件结案审核信息
	**/
	@RequestMapping(value = "/ywbl/TbStAjjashxx/getTbStAjjashxxById", method =RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody String getTbStAjjashxxById(
			HttpServletRequest request, 
			HttpServletResponse response){
		String id = request.getParameter("id");
		TbStAjjashxx bean = tbstajjashxxService.getTbStAjjashxxById(id);
		return JsonUtils.obj2json(bean);
	}
}