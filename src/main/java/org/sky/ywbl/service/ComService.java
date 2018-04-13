package org.sky.ywbl.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.ywbl.client.TbStYwbhMapper;
import org.sky.ywbl.model.TbStYwbh;
import org.sky.ywbl.model.TbStYwbhExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @ClassName:  ComService   
 * @Description:TODO(通用Service)   
 * @author: weifx 
 * @date:   2018年4月12日 下午11:15:52   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
@Service
public class ComService {
	private final Logger logger=Logger.getLogger(ComService.class);
	@Autowired
	private TbStYwbhMapper ywbhMapper;
	/**
	 * 获取业务编号
	 * @param szm
	 * @param jgdm
	 * @return
	 */
	public synchronized String getYwbh(String szm,String jgdm) {
		int sxh=0;
		String ywbh="";
		String ny = CommonUtils.getCurrentDate("yyyyMM");
		TbStYwbhExample e = new TbStYwbhExample();
		e.createCriteria().andSzmEqualTo(szm).andJgdmEqualTo(jgdm).andNyEqualTo(ny);
		List<TbStYwbh> list = ywbhMapper.selectByExample(e);
		DecimalFormat df = new DecimalFormat("#0000");
		String userCode = BspUtils.getLoginUser().getCode();
		Date date = CommonUtils.getCurrentDbDate();
		if(list.isEmpty()) {
			sxh=1;
			TbStYwbh bh = new TbStYwbh();
			bh.setId(CommonUtils.getUUID(32));
			bh.setJgdm(jgdm);
			bh.setNy(ny);
			bh.setSxh(sxh);
			bh.setSzm(szm);
			bh.setCreater(userCode);
			bh.setCreateTime(date);
			bh.setUpdater(userCode);
			bh.setUpdateTime(date);
			ywbhMapper.insert(bh);
			ywbh=szm+jgdm+ny+df.format(sxh);
		}else {
			TbStYwbh bh = list.get(0);
			sxh=bh.getSxh()+1;
			bh.setSxh(sxh);
			bh.setUpdater(userCode);
			bh.setUpdateTime(date);
			ywbhMapper.updateByPrimaryKeySelective(bh);
			ywbh=szm+jgdm+ny+df.format(sxh);
		}
		return ywbh;
	}
}