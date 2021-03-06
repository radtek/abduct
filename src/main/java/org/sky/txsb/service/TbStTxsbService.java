package org.sky.txsb.service;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.util.List;
import org.sky.sys.client.SysCommonMapper;
import org.sky.txsb.client.TbStTxsbMapper;
import org.sky.sys.exception.ServiceException;
import org.sky.txsb.model.TbStTxsb;
import org.sky.txsb.model.TbStTxsbExample;
import org.sky.sys.utils.PageListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.StringUtils;
@Service
public class TbStTxsbService {
	private final Logger logger=Logger.getLogger(TbStTxsbService.class);
	@Autowired
	private TbStTxsbMapper tbsttxsbmapper;
	@Autowired
	private SysCommonMapper syscommonmapper;
	/**
	*分页查询
	**/
	public PageListData getTbStTxsbByPage(TbStTxsbExample ep){
		long totalCount = tbsttxsbmapper.countByExample(ep);
		List list = tbsttxsbmapper.selectByExample(ep);
		PageListData pld = new PageListData();
		pld.setTotal(totalCount);
		pld.setRows(list);
		return pld;
	}
	/**
	*保存列表新增及修改
	**/
	@Transactional
	public void saveTbStTxsb(List<TbStTxsb> addlist,
			List<TbStTxsb> updatelist) throws ServiceException{
		try{
			if(null!=addlist&&addlist.size()>0){
				for(TbStTxsb add:addlist){
					tbsttxsbmapper.insertSelective(add);
				}
			}
			if(null!=updatelist&&updatelist.size()>0){
				for(TbStTxsb update:updatelist){
					tbsttxsbmapper.updateByPrimaryKeySelective(update);
				}
			}
		}catch(Exception e){
			logger.error("保存列表新增及修改执行失败",e);
			if(e.getMessage().contains("的值太大")){
				throw new ServiceException("输入的字段值过长！");
			}
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	*保存添加单个对象
	**/
	@Transactional
	public void saveAddTbStTxsb(TbStTxsb add) throws ServiceException{
		try{
			tbsttxsbmapper.insertSelective(add);
		}catch(Exception e){
			logger.error("保存添加单个对象执行失败",e);
			if(e.getMessage().contains("违反唯一约束条件")){
				throw new ServiceException("违反唯一约束条件");
			}else{
				throw new ServiceException(e.getMessage());
			}
		}
	}
	/**
	*保存新增/编辑单个对象
	**/
	@Transactional
	public void saveAddEditTbStTxsb(TbStTxsb edit) throws ServiceException{
		try{
			Timestamp ts = syscommonmapper.queryTimestamp();
			if(StringUtils.isNull(edit.getId())){
				//新增
				edit.setId(CommonUtils.getUUID(32));
				//edit.setCreater(BspUtils.getLoginUser().getCode());
				edit.setCreateTime(ts);
				//edit.setUpdater(BspUtils.getLoginUser().getCode());
				//edit.setUpdateTime(ts);
				tbsttxsbmapper.insertSelective(edit);
			}else{
				//修改
				//edit.setUpdater(BspUtils.getLoginUser().getCode());
				//edit.setUpdateTime(ts);
				tbsttxsbmapper.updateByPrimaryKeySelective(edit);
			}
		}catch(Exception e){
			logger.error("保存新增/编辑单个对象执行失败",e);
			throw new ServiceException(e.getMessage());
		}
	}
	/**
	*根据主键批量删除对象
	**/
	@Transactional
	public void delTbStTxsbById(List<TbStTxsb> delList){
		for(TbStTxsb del:delList){
			tbsttxsbmapper.deleteByPrimaryKey(del.getId());
		}
	}
	/**
	*根据主键查询对象
	**/
	public TbStTxsb getTbStTxsbById(String id){
		TbStTxsb bean = tbsttxsbmapper.selectByPrimaryKey(id);
		return bean;
	}
}